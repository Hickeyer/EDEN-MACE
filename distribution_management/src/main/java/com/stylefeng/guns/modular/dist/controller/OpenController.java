package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.tips.DistResult;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;
import com.stylefeng.guns.modular.dist.service.IDisWithdrawRecordService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisMemberInfoVo;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import com.stylefeng.guns.modular.dist.vo.DisWithdrawVo;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统对外开放接口
 */
@Controller
@RequestMapping("/api/v1/")
public class OpenController  {

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisMemberAmountMapper disMemberAmountMapper;

    @Autowired
    IDisMemberInfoService disMemberInfoService;

    @Resource
    UserMgrDao userMgrDao;

    @Autowired
    IDisProfitRecordService disProfitRecordService;

    @Autowired
    IDisWithdrawRecordService disWithdrawRecordService;


    @Value("${dist.jwt.secret}")
    private  String secret;
    @Value("${dist.jwt.account}")
    private  String account;
    @Value("${dist.jwt.isUse}")
    private  boolean jwtUse;



    @GetMapping("/getUserInfo")
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    @ResponseBody
    public DistResult getUserInfo(String userId){

        DisMemberInfo memberInfoParam=new DisMemberInfo();
        memberInfoParam.setDisUserId(userId);
        DisMemberInfo  memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);

        DisMemberAmount disMemberAmountParam=new DisMemberAmount();
        disMemberAmountParam.setDisUserId(userId);
        DisMemberAmount disMemberAmount=disMemberAmountMapper.selectOne(disMemberAmountParam);

        Map<String ,Object> map=new HashMap<>();
        if(memberInfo!=null){
            map.put("member",memberInfo);
            map.put("amount",disMemberAmount);
            DisMemberInfo sss= (DisMemberInfo) map.get("member");
            return DistResult.success(map);
        }else{
            return DistResult.failure("没有此用户");
        }
    }
    /**
     * 新增分销
     */
    @PostMapping(value = "/disMemberInfo/add")
    @ResponseBody
    @ApiOperation(value = "新增会员", notes = "")
    public DistResult add(@RequestBody DisMemberInfoVo memberInfoVo) {
        User user=userMgrDao.getByAccount(memberInfoVo.getDisPlatSuper());
        if(user==null){
            // throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
            return DistResult.failure("平台不存在");
        }
        if(StringUtils.isNotEmpty(memberInfoVo.getDisModelId())){
            DisMemberInfo param= disMemberInfoService.selectListByUserId(memberInfoVo.getDisModelId());
            if(param==null){
                // throw  new BussinessException(BizExceptionEnum.USERMEM_NOT_EXISTED);
                return DistResult.failure("邀请用户不存在");
            }
        }
        DisMemberInfo param= disMemberInfoService.selectListByUserId(memberInfoVo.getDisUserId());
        if(param!=null){
            return DistResult.failure("用户已存在");
            //throw  new BussinessException(BizExceptionEnum.USER_IS_EXISTED);
        }
        if(isAccountVer(memberInfoVo.getSecret())){
            DisMemberInfo memberInfo=new DisMemberInfo();
            BeanUtils.copyProperties(memberInfoVo,memberInfo);
            memberInfo.setDisUserType("0");
            memberInfo.setDisPlatSuper(memberInfoVo.getDisPlatSuper());
            memberInfo.setDisPlatLevel(Integer.parseInt(user.getLevel()));
            memberInfo.setDisPlatFullIndex(user.getFullindex());
            memberInfo.setDisPlatformId(user.getFullindex().split("\\.")[1]);
            memberInfo.setType("0");
            disMemberInfoService.save(memberInfo);
            //disMemberAmountService.save(memberInfo.getDisUserId(),memberInfo.getDisUserName(),memberInfo.getDisPlatformId(),"1");
        }else {
            // throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
            return DistResult.failure("非法访问");
        }
        return DistResult.success();
    }

    /**
     * 新增交易
     */
    @PostMapping(value = "/disProfitRecord/add")
    @ResponseBody
    @ApiOperation(value = "新增交易奖励", notes = "此接口是用于交易奖励的接口，及关注有相关分润的数据")
    public DistResult add(@RequestBody DisProfitRecordVo disProfitRecordVo) {
        //根据直属上级查询到所属平台id
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(disProfitRecordVo.getDisSetUserId());
        if(memberInfo==null){
           // throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
            DistResult.failure("用户不存在！");
        }
        if(isAccountVer(disProfitRecordVo.getSecret())) {
            disProfitRecordVo.setDisPlatformId(memberInfo.getDisPlatformId());
            disProfitRecordService.save(disProfitRecordVo);
        }else {
            //throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
            DistResult.failure("非法访问！");
        }
        return DistResult.success(disProfitRecordVo);
    }
    /**
     * 新增交易
     */
    @PostMapping(value = "/upgrade")
    @ResponseBody
    @ApiOperation(value = "升级奖励", notes = "此接口是用于升级奖励的接口")
    public DistResult upgrade(@RequestBody DisProfitRecordVo disProfitRecordVo) {
        //根据直属上级查询到所属平台id
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(disProfitRecordVo.getDisSetUserId());
        if(memberInfo==null){
           // throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
            DistResult.failure("用户不存在！");
        }
        if(disProfitRecordVo.getUpgradeLevel()==null){
            return DistResult.failure("请提供要升级的等级");
        }
        if(isAccountVer(disProfitRecordVo.getSecret())) {


            disProfitRecordVo.setDisPlatformId(memberInfo.getDisPlatformId());
            disProfitRecordService.save(disProfitRecordVo);

            memberInfo.setDisUserType(disProfitRecordVo.getUpgradeLevel());
            disMemberInfoService.updateLevel(memberInfo);
        }else {
            //throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
            DistResult.failure("非法访问！");
        }
        return DistResult.success(disProfitRecordVo);
    }

    /**
     * 新增提现记录
     */
    @PostMapping(value = "/withdraw")
    @ResponseBody
    @ApiOperation(value = "新增提现接口", notes = "此接口是用用户提现")
    public DistResult withdraw(@RequestBody DisWithdrawVo withdrawVo) {
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(withdrawVo.getUserId());
        if(memberInfo==null){
            //throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
            return DistResult.failure("用户不存在");
        }
        if(isAccountVer(withdrawVo.getSecret())) {
            disWithdrawRecordService.withdrawMoney(withdrawVo.getUserId(),withdrawVo.getAmount(),withdrawVo.getDisProType());
        }else {
            //throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
            return DistResult.failure("非法访问");
        }
        return DistResult.success();
    }
    @GetMapping("/getSign")
    @ResponseBody
    @ApiOperation(value = "获取secret", notes = "获取secret")
    public DistResult getSign() {
        String key= Jwt.sign(account,secret,30L * 24L * 3600L * 1000L);
        return DistResult.success(key);
    }
    public Boolean isAccountVer(String thirdSecret){
        if(!jwtUse){
            return true;
        }
        String acc= Jwt.unsign(thirdSecret,secret,String.class);
        if(acc==null){
            return false;
        }
        if(acc.equals(account)){
            return true;
        }else {
            return  false;
        }

    }
}
