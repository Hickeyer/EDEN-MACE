package com.distribution.service.impl;

import com.distribution.common.mapper.DisMemberInfoMapper;
import com.distribution.common.model.DisMemberInfo;
import com.distribution.common.util.DateUtils;
import com.distribution.common.util.Page;
import com.distribution.model.LinksVo;
import com.distribution.model.MemberRecordVo;
import com.distribution.model.NodesVo;
import com.distribution.service.DisMemberInfoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangpu on 2017/6/3.
 */
@Service
@Transactional
public class DisMemberInfoServiceImpl implements DisMemberInfoService {

    private int source=1;
    private  int target=0;

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    public void save(DisMemberInfo param) {
        //逻辑判断
        //查询上级是否存在
        if (param.getDisModelId()!=null&&!"".equals(param.getDisModelId())){
            DisMemberInfo parentMemberParam=new DisMemberInfo();
            parentMemberParam.setDisUserId(param.getDisModelId());
            DisMemberInfo parentMember=disMemberInfoMapper.select(parentMemberParam);
            param.setDisLevel(parentMember.getDisLevel()+1);
            param.setDisFullIndex(parentMember.getDisFullIndex()+"."+param.getDisUserId());
        }else {
            param.setDisFullIndex(param.getDisUserId().toString());
            param.setDisLevel(0);
        }
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disMemberInfoMapper.insertSelective(param);
    }

    public List<DisMemberInfo> getMemberList(DisMemberInfo param){
        if(param.getPageNo()!=null&&param.getPageSize()!=null){
            Integer pageStart= Page.getStartOfPage(param.getPageNo(),param.getPageSize());
            param.setPageStart(pageStart);
        }
        List<DisMemberInfo> memberList=disMemberInfoMapper.selectList(param);
        return memberList;
    }

    public String[] getDetaiCanvas(String id){
        String[] returnStr=new String[2];
        //获取当前用户节点
        DisMemberInfo currMember=new DisMemberInfo();
        currMember.setDisUserId(id);
        DisMemberInfo currMemberInfo=disMemberInfoMapper.select(currMember);
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

    public  List<MemberRecordVo> getSource(List<NodesVo> nodelist, List<LinksVo> linkList,List<MemberRecordVo> listParam){
        List<MemberRecordVo> memberRecordVoList=new ArrayList<MemberRecordVo>();
        for(MemberRecordVo memberRecord:listParam){
            DisMemberInfo nextMemberParam=new DisMemberInfo();
            nextMemberParam.setDisModelId(memberRecord.getUserId());
            List<DisMemberInfo> nextMemberList=disMemberInfoMapper.selectValueList(nextMemberParam);
            if(nextMemberList!=null){
                for(DisMemberInfo member:nextMemberList){
                    //判断是否存在下级，如果存在则记录下来
                    DisMemberInfo nextCountMemberParam=new DisMemberInfo();
                    nextCountMemberParam.setDisModelId(member.getDisUserId());
                    int count=disMemberInfoMapper.count(nextCountMemberParam);
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
