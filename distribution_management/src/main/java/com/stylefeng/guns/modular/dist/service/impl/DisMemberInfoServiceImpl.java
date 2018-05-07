package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.core.mutidatesource.DataSourceContextHolder;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisMemberInfoDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.LinksVo;
import com.stylefeng.guns.modular.dist.vo.MemberRecordVo;
import com.stylefeng.guns.modular.dist.vo.NodesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;

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

    @Autowired
    DisMemberInfoDao disMemberInfoDao;

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList() {
        System.out.println(DataSourceContextHolder.getDataSourceType());
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        List<Map<String, Object>> list=disMemberInfoDao.selectList(account);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public DisMemberInfo selectListByUserId(String userId) {
        DisMemberInfo memberInfo= disMemberInfoDao.selectListByUserId(userId);
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
            param.setDisLevel(parentMember.getDisLevel()+1);
            param.setDisFullIndex(parentMember.getDisFullIndex()+"."+param.getDisUserId());
        }else {
            param.setDisFullIndex(param.getDisUserId().toString());
            param.setDisLevel(0);
        }
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disMemberInfoMapper.insert(param);
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
