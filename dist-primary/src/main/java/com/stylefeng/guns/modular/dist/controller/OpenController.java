package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.annotion.log.StatisticsSocket;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.common.constant.dist.ConfineStatus;
import com.stylefeng.guns.common.constant.tips.DistResult;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.modular.dist.http.request.SubordinateReq;
import com.stylefeng.guns.modular.dist.http.response.SubordinateResp;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;
import com.stylefeng.guns.modular.dist.service.IDisWithdrawRecordService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisMemberInfoVo;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import com.stylefeng.guns.modular.dist.vo.DisWithdrawVo;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统对外开放接口
 * @author  xiaojiang
 */
@Controller
@RequestMapping("/api/v1/")
public class OpenController  {


    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Resource
    private DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    private DisMemberAmountMapper disMemberAmountMapper;

    @Autowired
    private IDisMemberInfoService disMemberInfoService;

    @Resource
    private UserMgrDao userMgrDao;

    @Autowired
    private IDisProfitRecordService disProfitRecordService;

    @Autowired
    private IDisWithdrawRecordService disWithdrawRecordService;


    /**
     * 秘钥
     */
    @Value("${dist.jwt.secret}")
    private  String secret;

    /**
     * 账户
     */
    @Value("${dist.jwt.account}")
    private  String account;

    /**
     * 是否使用秘钥校验
     */
    @Value("${dist.jwt.isUse}")
    protected boolean jwtUse;


    /**
     * 用户登录获取相关用户信息
     * @param userId
     */
    @GetMapping("/getUserInfo")
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    @ResponseBody
    @ApiOperation(value = "查询会员信息")
    @ApiImplicitParam(name="userId",value="用户id",required = true,paramType = "query",dataType = "String")
    public DistResult getUserInfo(String userId){
        logger.info("会员查询->开始查询会员信息:{}",userId);
        DisMemberInfo memberInfoParam=new DisMemberInfo();
        memberInfoParam.setDisUserId(userId);
        DisMemberInfo  memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);
        logger.info("会员查询->开始查询会员账户");
        DisMemberAmount disMemberAmountParam=new DisMemberAmount();
        disMemberAmountParam.setDisUserId(userId);
        DisMemberAmount disMemberAmount=disMemberAmountMapper.selectOne(disMemberAmountParam);

        Map<String ,Object> map=new HashMap<>(2);
        if(memberInfo!=null){
            map.put("member",memberInfo);
            map.put("amount",disMemberAmount);
            logger.info("会员查询->查询结束");
            return DistResult.success(map);
        }else{
            logger.info("会员查询->查询结束，未查到信息");
            return DistResult.failure("没有此用户");
        }
    }
    /**
     * 邀请会员，调用此接口
     */
    @PostMapping(value = "/memberAdd")
    @ResponseBody
    @ApiOperation(value = "新增会员")
    @StatisticsSocket
    public DistResult inviteMember(@RequestBody DisMemberInfoVo memberInfoVo) throws Exception {
        logger.info("新增会员->开始进入新增会员");
        if(!isAccountVer(memberInfoVo.getSecret())){
            return DistResult.failure("非法访问");
        }
        String superPlatId;
        if(StringUtils.isNotEmpty(memberInfoVo.getDisModelId())){
            DisMemberInfo param= disMemberInfoService.selectListByUserId(memberInfoVo.getDisModelId());
            if(param==null){
                return DistResult.failure("邀请用户不存在");
            }else {
                if(param.getConfineStatus() == ConfineStatus.ONE_STAUTS.getStatus()){
                    //会员被禁止邀请请会员
                    memberInfoVo.setDisModelId(null);
                }
                superPlatId=param.getDisPlatformId();
            }
        }else {
            superPlatId = memberInfoVo.getDisPlatformId();
        }
        User user=userMgrDao.getByAccount(superPlatId);
        if(user==null){
            return DistResult.failure("代理商不存在");
        }

        if(verifyMember(memberInfoVo.getDisUserId())){
            return DistResult.failure("用户已存在");
        }
        DisMemberInfo memberInfo=new DisMemberInfo();
        BeanUtils.copyProperties(memberInfoVo,memberInfo);
        memberInfo.setDisUserType("0");
        memberInfo.setDisPlatSuper(user.getAccount());
        memberInfo.setDisPlatLevel(Integer.parseInt(user.getLevel()));
        memberInfo.setDisPlatFullIndex(user.getFullindex());
        String[]  platArr = user.getFullindex().split("\\.");
        memberInfo.setDisPlatformId(platArr[1]);
        memberInfo.setType("0");
        disMemberInfoService.save(memberInfo);
        logger.info("新增会员->新增会员结束");
        return DistResult.success();
    }

    /**
     * 会员交易后调用此接口
     */
    @PostMapping(value = "/trade")
    @ResponseBody
    @ApiOperation(value = "新增交易奖励", notes = "此接口是用于交易奖励的接口，及关注有相关分润的数据")
    @StatisticsSocket
    public DistResult tradeOrder(@RequestBody DisProfitRecordVo disProfitRecordVo) throws Exception {
        // 交易奖励
        disProfitRecordVo.setAccountType(AccountTypeStatus.ZERO_STATUS.getStatus());
        logger.info("订单交易->开始订单交易");
        if(!isAccountVer(disProfitRecordVo.getSecret())) {
           return   DistResult.failure("非法访问！");
        }
        // 查询交易人是否存在
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(disProfitRecordVo.getDisSetUserId());
        if(memberInfo==null){
           return  DistResult.failure("用户不存在！");
        }
        disProfitRecordVo.setAccountType(AccountTypeStatus.ZERO_STATUS.getStatus());
        disProfitRecordVo.setDisPlatformId(memberInfo.getDisPlatformId());
        disProfitRecordService.save(disProfitRecordVo);
        logger.info("订单交易->订单交易结束");
        return DistResult.success(disProfitRecordVo);
    }
    /**
     * 会员升级后调用此接口，相关联的数据会产生分润
     * 垂直升级，即会员通过付费进行升级
     */
    @PostMapping(value = "/upgrade")
    @ResponseBody
    @ApiOperation(value = "升级奖励", notes = "此接口是用于升级奖励的接口")
    @StatisticsSocket
    public DistResult upgradeLevel(@RequestBody DisProfitRecordVo disProfitRecordVo) throws Exception {
        disProfitRecordVo.setAccountType(AccountTypeStatus.ONE_STATUS.getStatus());
        logger.info("用户升级->开始升级,入参{}",disProfitRecordVo.toString());
        if(!isAccountVer(disProfitRecordVo.getSecret())) {
            return   DistResult.failure("非法访问！");
        }
        //根据直属上级查询到所属平台id
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(disProfitRecordVo.getDisSetUserId());
        if(memberInfo==null){
            return DistResult.failure("用户不存在！");
        }
        if(disProfitRecordVo.getUpgradeLevel()==null){
            return DistResult.failure("请提供要升级的等级");
        }
        disProfitRecordVo.setDisPlatformId(memberInfo.getDisPlatformId());
        disProfitRecordService.save(disProfitRecordVo);

        memberInfo.setDisUserType(disProfitRecordVo.getUpgradeLevel());
        disMemberInfoService.updateLevel(memberInfo);
        logger.info("用户升级->升级结束");
        return DistResult.success(disProfitRecordVo);
    }

    /**
     *  用户查询他发展的会员
     */
    @PostMapping(value = "/subordinate")
    @ResponseBody
    @ApiOperation(value = "会员直属下级会员", notes = "此接口是查询会员直属下级会员")
    public DistResult subordinateMember(@RequestBody  SubordinateReq subordinateReq) {
        logger.info("会员下级->开始查询");
        if(!isAccountVer(subordinateReq.getSecret())) {
            return   DistResult.failure("非法访问！");
        }
        if(!verifyMember(subordinateReq.getMemberId())){
            return DistResult.failure("用户校验失败");
        }
        List<SubordinateResp> list = disMemberInfoService.getSubordinateInfo(subordinateReq);
        logger.info("会员下级->查询结束");
        return DistResult.success(list);
    }

    /**
     * 用户提现，针对用户界面对某一账户进行提现
     * @param withdrawVo
     */
    @PostMapping(value = "/withdraw")
    @ResponseBody
    @ApiOperation(value = "新增提现接口", notes = "此接口是用用户提现")
    @StatisticsSocket
    public DistResult withdraw(@RequestBody DisWithdrawVo withdrawVo) {
        logger.info("会员提现->开始提现,入参信息:{}",withdrawVo.toString());
        if(!isAccountVer(withdrawVo.getSecret())) {
            return   DistResult.failure("非法访问！");
        }
        if(!verifyMember(withdrawVo.getUserId())){
            return DistResult.failure("用户校验失败");
        }
        if(isAccountVer(withdrawVo.getSecret())) {
            disWithdrawRecordService.withdrawMoney(withdrawVo.getUserId(),withdrawVo.getAmount(),withdrawVo.getAccountType());
        }else {
            return DistResult.failure("非法访问");
        }
        logger.info("会员体现->提现结束");
        return DistResult.success();
    }

    /**
     * 获取调用接口授权码
     * @return DistResult
     */
    @GetMapping("/getSign")
    @ResponseBody
    @ApiOperation(value = "获取secret", notes = "获取secret")
    public DistResult getSign() {
        String key= Jwt.sign(account,secret,30L * 24L * 3600L * 1000L);
        return DistResult.success(key);
    }

    /**
     * jwt校验
     * @param thirdSecret
     * @return
     */
    private Boolean isAccountVer(String thirdSecret) {
        if (!jwtUse) {
            return true;
        }
        String acc = Jwt.unsign(thirdSecret, secret, String.class);
        return acc != null && acc.equals(account);
    }

    /**
     * 校验用户是否存在或者被限制使用等
     * 原则上可以支持每个代理商下的用户可以重名
     * 但是为了以后的扩展这里设置不可以重名
     * 如果需要重名，系统需要修改提现的部分，需要增加平台
     * @param userId
     * @return boolean
     */
    private Boolean verifyMember(String userId){
        logger.info("会员校验->开始校验:{}",userId);
        Boolean verify =true ;
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(userId);
        if(memberInfo==null){
            verify =false;
        }
        logger.info("会员校验->会员校验结束:{}",verify);
        return verify;
    }
}
