package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.*;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.modular.dist.dao.DisProfitRecordDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.service.IDisSysIntegralRecordService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 交易Dao
 *
 * @author huangpu
 * @Date 2018-04-06 12:19:23
 */
@Service
@Transactional
public class DisProfitRecordServiceImpl implements IDisProfitRecordService {


    @Resource
    DisProfitRecordDao disProfitRecordDao;

    @Resource
    DisProfitParamMapper disProfiParamMapper;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisProfitRecordMapper disProfitRecordMapper;

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Autowired
    ISysDicService sysDicService;

    @Autowired
    IDisSysIntegralRecordService disSysIntegralRecordService;

    @Resource
    DisTradeRecordMapper disTradeRecordMapper;

    @Resource
    DisUpgradeRecordMapper disUpgradeRecordMapper;

    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String account) {
        List<Map<String, Object>> list=disProfitRecordDao.selectList(account);
        return list;
    }

    /**
     *  根据分润形式设置获取分润
     *  1、根据平台获取设置所有分润列表
     *  2、根据平台和id获取发起交易人员信息
     *  3、根据发起交易人员信息获取上级人员信息
     *  4、根据分润列表和上级人员信息进行匹配，进行分润
     *  5、计算平台分润
     *  6、计算积分
     *  7、记录交易金额/升级信息
     * @param param
     */
    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public void save(DisProfitRecordVo param) {
        //根据所属上级和用户id查询会员信息
        DisMemberInfo memberInfoParam=new DisMemberInfo();
        memberInfoParam.setDisUserId(param.getDisSetUserId());
        DisMemberInfo memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);
        saveMember(param,memberInfo);
        savePlat(param,memberInfo);
        saveAdmin(param,memberInfo);
        disSysIntegralRecordService.saveMember(param.getDisProType(),param.getDisAmount(),memberInfo);
        if(ProTypeStatus.ZERO_STATUS.getStatus().equals(param.getDisProType())){
            //记录交易金额
            saveTradeRecord(param);
        }else if(ProTypeStatus.ONE_STATUS.getStatus().equals(param.getDisProType())){
            //记录升级接口
            saveVerticalLevel(memberInfo.getDisUserType(),param.getUpgradeLevel(),param.getDisSetUserId());
        }
    }

    public  void saveVerticalLevel(String beforeLevel,String afterLevel,String userId){
        DisUpgradeRecord upgradeRecord=new DisUpgradeRecord();
        upgradeRecord.setBeforeUpgradeLevel(beforeLevel);
        upgradeRecord.setAfterUpgradeLevel(afterLevel);
        upgradeRecord.setUpgradeTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        upgradeRecord.setDisUserId(userId);
        int differ=UserTypeStatus.getMethod(afterLevel).getOrder()-
                UserTypeStatus.getMethod(beforeLevel).getOrder();
        upgradeRecord.setLevelDiffer(String.valueOf(differ));
        disUpgradeRecordMapper.insert(upgradeRecord);
    }
    public  void saveTradeRecord(DisProfitRecordVo param){
        DisTradeRecord tradeRecord=new DisTradeRecord();
        tradeRecord.setDisUserId(param.getDisSetUserId());
        tradeRecord.setTradeAmount(param.getDisAmount());
        tradeRecord.setTradeNum(param.getOrderId());
        tradeRecord.setTradeTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disTradeRecordMapper.insert(tradeRecord);
    }
    public void saveMember(DisProfitRecordVo param,DisMemberInfo memberInfo){

        //dis_pro_type可以是交易分润 上下级分润等等
        //根据平台id和平台属性查询对应的分润信息，如交易分润，开始计算交易分润对应的数据
        //对会员级别的数据进行分润分配，并且加入到余额中去
        //对平台级别的数据进行分润分配，并且加入到余额中去
        Wrapper<DisProfitParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id",param.getDisPlatformId())
                .eq("dis_pro_type",param.getDisProType());
        List<DisProfitParam> profiParamList=disProfiParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            if(memberInfo==null){
                return ;
            }
            String levelInfo[]=memberInfo.getDisFullIndex().split("\\.");
            for (DisProfitParam disProfiParam:profiParamList){
                Integer level=Integer.parseInt(disProfiParam.getDisProLevel());
                if(level<=levelInfo.length-1){
                    //如果等级不对也无需计算分润
                    String userId= levelInfo[levelInfo.length-(level+1)];
                    DisMemberInfo subMemberParam=new DisMemberInfo();
                    subMemberParam.setDisUserId(userId);
                    DisMemberInfo subMember=disMemberInfoMapper.selectOne(subMemberParam);
                    //如果用户的用户类型和分润的用户类型不一样则不能分配分润，跳转到下一个，继续执行
                    if(!subMember.getDisUserType().equals(disProfiParam.getDisUserType())){
                        continue;
                    }
                    //先设置会员分润
                    DisProfitRecord record=new DisProfitRecord();
                    record.setDisPlatformId(memberInfo.getDisPlatformId());
                    record.setDisUserType(disProfiParam.getDisUserType());
                    record.setDisSetUserId(param.getDisSetUserId());
                    record.setDisNote(param.getNote());
                    record.setDisOrderId(param.getOrderId());
                    record.setDisProType(param.getDisProType());
                    BigDecimal value=new BigDecimal(disProfiParam.getDisProValue());
                    BigDecimal newAmount=new BigDecimal(0);
                    String accountType="";
                    if(ProModelStatus.ZERO_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                        newAmount=param.getDisAmount().multiply(value);
                        //accountType="trade";
                    }else if(ProModelStatus.ONE_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                        newAmount=value;
                        //accountType="level";
                    }
                    accountType = ProTypeStatus.getMethod(disProfiParam.getDisProType()).getCode();
                    record.setDisAmount(newAmount);
                    record.setDisGetUserId(userId);
                    record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setIsDelete("N");
                    record.setType("0");
                    record.setProfitNum(sysDicService.getOrderNo("profit"));
                    disProfitRecordMapper.insert(record);

                    //增加会员金额信息
                    disMemberAmountService.addMoney(userId,newAmount,accountType,memberInfo.getDisUserId(), IdentityStatus.USER_STATUS.getStatus());
                }
            }
        }
    }

    /**
     * 计算平台分润
     * @param param
     * @param memberInfo
     */
    public  void  savePlat(DisProfitRecordVo param,DisMemberInfo memberInfo){
        Wrapper<DisProfitParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id",param.getDisPlatformId())
                .eq("dis_user_type","10000");
        List<DisProfitParam> profiParamList=disProfiParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            String levelInfo[]=memberInfo.getDisPlatFullIndex().split("\\.");
            profiParamList.forEach((DisProfitParam disProfiParam) ->{
                Integer level=Integer.parseInt(disProfiParam.getDisProLevel());
                if(level<=levelInfo.length-1) {
                    String userId = levelInfo[level];
                    if(!userId.equals(SystemUser.ADMIN_INFO.getInfo())){
                        //设置分润
                        DisProfitRecord record = new DisProfitRecord();
                        record.setDisUserType(disProfiParam.getDisUserType());
                        record.setDisSetUserId(param.getDisSetUserId());
                        record.setDisNote(param.getNote());
                        record.setDisOrderId(param.getOrderId());
                        record.setDisProType(param.getDisProType());
                        BigDecimal value = new BigDecimal(disProfiParam.getDisProValue());
                        BigDecimal newAmount=new BigDecimal(0);
                        String accountType="";
                        if(ProModelStatus.ZERO_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                            newAmount=param.getDisAmount().multiply(value);
                            //accountType="trade";
                        }else if(ProModelStatus.ONE_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                            newAmount=value;
                            //accountType="level";
                        }
                        accountType = ProTypeStatus.getMethod(disProfiParam.getDisProType()).getCode();
                        record.setDisAmount(newAmount);
                        record.setDisGetUserId(userId);
                        record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                        record.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                        record.setIsDelete("N");
                        record.setType("1");
                        record.setProfitNum(sysDicService.getOrderNo("profit"));
                        disProfitRecordMapper.insert(record);

                        //增加平台金额信息
                        disMemberAmountService.addMoney(userId,newAmount,accountType,memberInfo.getDisUserId(),IdentityStatus.PLAT_STATUS.getStatus());
                    }

                }
            });
        }
    }

    /**
     * 计算admin平台分润
     * @param param
     * @param memberInfo
     */
    public  void  saveAdmin(DisProfitRecordVo param,DisMemberInfo memberInfo){
        Wrapper<DisProfitParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id","admin")
                .eq("dis_user_type","10000");
        List<DisProfitParam> profiParamList=disProfiParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            String levelInfo[]=memberInfo.getDisPlatFullIndex().split("\\.");
            profiParamList.forEach((DisProfitParam disProfiParam) ->{
                Integer level=Integer.parseInt(disProfiParam.getDisProLevel());
                if(level<=levelInfo.length-1) {
                    String userId = "admin";
                    //设置分润
                    DisProfitRecord record = new DisProfitRecord();
                    record.setDisUserType(disProfiParam.getDisUserType());
                    record.setDisSetUserId(param.getDisSetUserId());
                    record.setDisNote(param.getNote());
                    record.setDisOrderId(param.getOrderId());
                    record.setDisProType(param.getDisProType());
                    BigDecimal value = new BigDecimal(disProfiParam.getDisProValue());
                    BigDecimal newAmount=new BigDecimal(0);
                    String accountType="";
                    if(ProModelStatus.ZERO_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                        newAmount=param.getDisAmount().multiply(value);
                        //accountType="trade";
                    }else if(ProModelStatus.ONE_STATUS.getStatus().equals(disProfiParam.getDisProMode())){
                        newAmount=value;
                        //accountType="level";
                    }
                    accountType = ProTypeStatus.getMethod(disProfiParam.getDisProType()).getCode();
                    record.setDisAmount(newAmount);
                    record.setDisGetUserId(userId);
                    record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setIsDelete("N");
                    record.setType("1");
                    record.setProfitNum(sysDicService.getOrderNo("profit"));
                    disProfitRecordMapper.insert(record);

                    //增加平台金额信息
                    disMemberAmountService.addMoney(userId,newAmount,accountType,memberInfo.getDisUserId(),IdentityStatus.PLAT_STATUS.getStatus());
                }
            });
        }
    }
}
