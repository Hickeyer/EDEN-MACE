package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.dao.SysDicMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.modular.dist.dao.DisMemberInfoDao;
import com.stylefeng.guns.modular.dist.http.request.SubordinateReq;
import com.stylefeng.guns.modular.dist.http.response.SubordinateResp;
import com.stylefeng.guns.modular.dist.service.*;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.*;
import com.stylefeng.guns.modular.dist.wapper.MemberWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分销Dao
 *
 * @author huangpu
 * @Date 2018-04-05 21:49:44
 */
@Service
public class DisMemberInfoServiceImpl implements IDisMemberInfoService {


    private int source=1;
    private  int target=0;

    @Resource
    DisMemberInfoDao disMemberInfoDao;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Autowired
    ISysDicService sysDicService;

    @Resource
    SysDicMapper sysDicMapper;

    @Autowired
    IDisSysIntegralRecordService disSysIntegralRecordService;

    @Autowired
    IDisProfitRecordService disProfitRecordService;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public  List<Map<String, Object>> selectList(String account,String disUserId,String disModelId) {
        List<Map<String, Object>> list=disMemberInfoDao.selectList(account,disUserId,disModelId);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public DisMemberInfo selectListByUserId(String userId) {
        DisMemberInfo disMemberInfo=new DisMemberInfo();
        disMemberInfo.setDisUserId(userId);
        DisMemberInfo memberInfo= disMemberInfoMapper.selectOne(disMemberInfo);
        return memberInfo;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public String[] getDetaiCanvas(String id) {
        String[] returnStr=new String[2];
        //获取当前用户节点
        DisMemberInfo currMember=new DisMemberInfo();
        currMember.setDisUserId(id);
        DisMemberInfo currMemberInfo=disMemberInfoMapper.selectOne(currMember);
        List<NodesVo> nodelist=new ArrayList<NodesVo>();
        List<LinksVo> linkList=new ArrayList<LinksVo>();
        source=1;
        target=0;

        if (currMemberInfo!=null){
            List<MemberRecordVo> firstList=new ArrayList<MemberRecordVo>();
            MemberRecordVo first=new MemberRecordVo();
            first.setUserId(currMemberInfo.getDisUserId());
            first.setSourceId(0);
            first.setListId(-1);
            firstList.add(first);
            NodesVo node2=new NodesVo();
            node2.setName(currMemberInfo.getDisUserName());
            node2.setCategory(currMemberInfo.getDisUserType());
            node2.setShapeType("rectangle");
            node2.setValue("1");
            nodelist.add(node2);
            List<MemberRecordVo>  memberRecordVoList=getSource(nodelist,linkList,firstList);
            while(memberRecordVoList.size()!=0){
                System.out.println(memberRecordVoList.size()==0);
                memberRecordVoList=getSource(nodelist,linkList,memberRecordVoList);
            }
        }
        Gson gson=new Gson();

        returnStr[0]=  gson.toJson(nodelist).toString();
        returnStr[1]=gson.toJson(linkList).toString();
        System.out.println(returnStr);
        return returnStr;
    }

    /**
     * 增加平台属性
     * @param param
     */
    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DisMemberInfo param) throws Exception {
        //逻辑判断
        //查询上级是否存在
        if (param.getDisModelId()!=null&&!"".equals(param.getDisModelId())){
            DisMemberInfo parentMemberParam=new DisMemberInfo();
            parentMemberParam.setDisUserId(param.getDisModelId());
            DisMemberInfo parentMember=disMemberInfoMapper.selectOne(parentMemberParam);

            //级别限制 主要对dislevel和 disfullindex进行限制
            SysDic dicParam=new SysDic();
            dicParam.setDicTypeNo("maxLevel");
            SysDic dis=sysDicMapper.selectOne(dicParam);
            if(dis!=null){
                Integer maxLevel=Integer.parseInt(dis.getDicNo());
                Integer factLevel=parentMember.getDisLevel()+1;
                if(factLevel>=maxLevel){
                    //截取
                    param.setDisLevel(maxLevel);
                    String[] indexArr=parentMember.getDisFullIndex().split("\\.");
                    String fullIndex="";
                    //取倒数最大值-1位数据
                    int indexSize=indexArr.length;
                    for(int i=maxLevel-1;i>0;i--){
                        fullIndex+=indexArr[indexSize-i]+".";
                    }
                    param.setDisFullIndex(fullIndex+param.getDisUserId());
                }else{
                    //正常执行
                    param.setDisLevel(parentMember.getDisLevel()+1);
                    param.setDisFullIndex(parentMember.getDisFullIndex()+"."+param.getDisUserId());
                }
            }else{
                param.setDisLevel(parentMember.getDisLevel()+1);
                param.setDisFullIndex(parentMember.getDisFullIndex()+"."+param.getDisUserId());
            }
        }else {
            param.setDisFullIndex(param.getDisUserId().toString());
            param.setDisLevel(0);
        }
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        //初始化会员表
        disMemberInfoMapper.insert(param);
        //初始化账户表
        disMemberAmountService.save(param.getDisUserId(),param.getDisUserName(),"0");
        //初始化积分表
        disSysIntegralRecordService.saveIntegral(AccountTypeStatus.TWO_STATUS.getStatus(),new BigDecimal(0),param);
        //生成邀请奖励
        DisProfitRecordVo recordVo = new DisProfitRecordVo();
        recordVo.setAccountType(AccountTypeStatus.TWO_STATUS.getStatus());
        disProfitRecordService.generatorAllRecord(recordVo,param);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void saveAgent(DisMemberInfo param) {
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disMemberInfoMapper.insert(param);
        disMemberAmountService.save(param.getDisUserId(),param.getDisUserName(),"1");
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void updateLevel(DisMemberInfo param) {
        disMemberInfoMapper.updateAllColumnById(param);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<SubordinateResp> getSubordinateInfo(SubordinateReq req) {
        DisMemberInfo param=new DisMemberInfo();
        param.setDisUserId(req.getMemberId());
        DisMemberInfo memberInfo=disMemberInfoMapper.selectOne(param);
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.like("dis_full_index",memberInfo.getDisFullIndex()+"%")
        .or().like("dis_full_index",memberInfo.getDisUserId()+"%");
        List<DisMemberInfo> mapList = disMemberInfoMapper.selectList(wrapper);
        List<SubordinateResp> list = new ArrayList<>();
        if(mapList != null){
            for (DisMemberInfo map :mapList){
                //自己不算自己的下级会员
                if(map.getDisUserId().equals(req.getMemberId())){
                    continue;
                }
                SubordinateResp resp = new SubordinateResp();
                resp.setMemberId(map.getDisUserId());
                resp.setMemberName(map.getDisUserName());
                list.add(resp);
            }
        }
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void saveNoOperate(DisMemberInfo param) {
        disMemberInfoMapper.insert(param);

        //初始化账户表
        disMemberAmountService.save(param.getDisUserId(),param.getDisUserName(),"0");
        //初始化积分表
        try {
            disSysIntegralRecordService.saveIntegral(AccountTypeStatus.TWO_STATUS.getStatus(),new BigDecimal(0),param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public String getTreeList(String memmberId) {
        //查询当前用户
        DisMemberInfo curParam = new DisMemberInfo();
        curParam.setDisUserId(memmberId);
        DisMemberInfo memberInfo = disMemberInfoMapper.selectOne(curParam);
        MemberTreeVo vos = new MemberTreeVo();
        vos.setName(memberInfo.getDisUserName());
        vos.setChildren(this.getAgentList(memmberId));
        Gson gson = new Gson();
        System.out.println(gson.toJson(vos));
        return gson.toJson(vos);
    }

    /**
     * 查询用户下的所有的用户关系
     * @param userId
     * @return
     */
    private List<MemberTreeVo> getMemberVoList(String userId){
        MemberTreeVo memberTreeVo = new MemberTreeVo();
        List<MemberTreeVo> memberTreeVos = new ArrayList<>();
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.eq("dis_model_id",userId)
                .eq("type", IdentityStatus.USER_STATUS.getStatus());
        List<DisMemberInfo> list = disMemberInfoMapper.selectList(wrapper);
        if(list != null&& list.size()>0){
            for (DisMemberInfo memberInfo:list){
                MemberTreeVo vos = new MemberTreeVo();
                List<MemberTreeVo> children =  this.getMemberVoList(memberInfo.getDisUserId());
                if(children != null){
                    vos.setName(memberInfo.getDisUserName());
                    vos.setChildren(children);
                }else{
                    vos.setName(memberInfo.getDisUserName());
                }
                memberTreeVos.add(vos);
            }
        }else{
            return null;
        }
        return memberTreeVos;
    }


    private List<MemberTreeVo> getAgentList(String userId){
        List<MemberTreeVo> memberTreeVos = new ArrayList<>();
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.eq("dis_plat_super",userId)
        .eq("type", IdentityStatus.PLAT_STATUS.getStatus());
        List<DisMemberInfo> list = disMemberInfoMapper.selectList(wrapper);
        if(list != null&& list.size()>0){
            for (DisMemberInfo memberInfo:list){
                MemberTreeVo vos = new MemberTreeVo();
                List<MemberTreeVo> children =  this.getAgentList(memberInfo.getDisUserId());
                MemberTreeVo memberTreeVo = getAgentAndMemberList(memberInfo);

                if(children != null){
                    vos.setName(memberInfo.getDisUserName());
                }else{
                    vos.setName(memberInfo.getDisUserName());
                    children = new ArrayList<>();
                }
                children.add(memberTreeVo);
                vos.setChildren(children);
                memberTreeVos.add(vos);

            }
        }else{
            return null;
        }
        return memberTreeVos;
    }
    public MemberTreeVo getAgentAndMemberList(DisMemberInfo memberInfo){
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.eq("dis_platform_id",memberInfo.getDisUserId())
                .eq("dis_plat_super",memberInfo.getDisUserId())
                .isNull("dis_model_id");
        List<DisMemberInfo> memberInfoList = disMemberInfoMapper.selectList(wrapper);
        List<MemberTreeVo> voList = new ArrayList<>();
        for (DisMemberInfo disMemberInfo : memberInfoList) {
            List<MemberTreeVo> treeMembers = this.getMemberVoList(disMemberInfo.getDisUserId());
            MemberTreeVo vo = new MemberTreeVo();
            vo.setName(disMemberInfo.getDisUserName());
            vo.setChildren(treeMembers);
            voList.add(vo);
        }
        MemberTreeVo treeVo = new MemberTreeVo();
        treeVo.setName("会员分支");
        treeVo.setChildren(voList);
        return treeVo;
    }


    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public  List<MemberRecordVo> getSource(List<NodesVo> nodelist, List<LinksVo> linkList,List<MemberRecordVo> listParam){
        List<MemberRecordVo> memberRecordVoList=new ArrayList<MemberRecordVo>();
        for(MemberRecordVo memberRecord:listParam){
            Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
            wrapper.eq("dis_model_id",memberRecord.getUserId());
            List<DisMemberInfo> nextMemberList=disMemberInfoMapper.selectList(wrapper);
            if(nextMemberList!=null){
                for(DisMemberInfo member:nextMemberList){
                    //判断是否存在下级，如果存在则记录下来
                    Wrapper<DisMemberInfo> nextCountMemberParam=new EntityWrapper();
                    nextCountMemberParam.eq("dis_model_id",member.getDisUserId());
                    int count=disMemberInfoMapper.selectCount(nextCountMemberParam);
                    if(count>0){
                        MemberRecordVo vo=new MemberRecordVo();
                        vo.setListId(source);
                        vo.setSourceId(source);
                        vo.setUserId(member.getDisUserId());
                        memberRecordVoList.add(vo);
                    }
                    NodesVo node2=new NodesVo();
                    node2.setName(member.getDisUserName());
                    node2.setCategory(member.getDisUserType());
                    node2.setShapeType("rectangle");
                    node2.setValue("1");
                    nodelist.add(node2);
                    LinksVo linksVo2=new LinksVo();
                    linksVo2.setSource(source);
                    linksVo2.setTarget(memberRecord.getSourceId());
                    linksVo2.setWeight("1");
                    linkList.add(linksVo2);
                    source++;
                }
            }
        }

        return  memberRecordVoList;
    }
}
