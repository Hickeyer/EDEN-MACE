package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.ProRankTypeStatus;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.dao.SysDicMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.core.mutidatesource.DataSourceContextHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisMemberInfoDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.service.IDisSysIntegralRecordService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.LinksVo;
import com.stylefeng.guns.modular.dist.vo.MemberRecordVo;
import com.stylefeng.guns.modular.dist.vo.NodesVo;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;

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

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String account) {

        List<Map<String, Object>> list=disMemberInfoDao.selectList(account);
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
    public void save(DisMemberInfo param) {
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
        disMemberInfoMapper.insert(param);
        disMemberAmountService.save(param.getDisUserId(),param.getDisUserName(),"0");
        disSysIntegralRecordService.saveMember(ProRankTypeStatus.TWO_STATUS.getStatus(),new BigDecimal(0),param);
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
