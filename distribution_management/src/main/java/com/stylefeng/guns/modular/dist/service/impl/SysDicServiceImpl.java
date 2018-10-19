package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.SysDicMapper;
import com.stylefeng.guns.common.persistence.dao.SysDicTypeMapper;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.common.persistence.model.SysDicType;
import com.stylefeng.guns.common.util.PinYinUtil;
import com.stylefeng.guns.modular.system.dao.SysDicDao;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.stylefeng.guns.common.constant.factory.MutiStrFactory.*;

@Service
@Transactional
public class SysDicServiceImpl implements ISysDicService {


    @Resource
    SysDicTypeMapper sysDicTypeMapper;

    @Resource
    SysDicMapper sysDicMapper;

    @Resource
    SysDicDao sysDicDao;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void addDict(String dictName,String disTypeNo, String dictValues) {
        String typeNo="";
        if(StringUtils.isNotEmpty(disTypeNo)){
           typeNo=disTypeNo;
        }else {
            typeNo= PinYinUtil.getFullSpell(dictName);
        }
        //判断有没有该字典
        List<SysDicType> dicts = sysDicTypeMapper.selectList(new EntityWrapper<SysDicType>().eq("dic_type_no", typeNo));
        if(dicts != null && dicts.size() > 0){
            throw new BussinessException(BizExceptionEnum.DICT_EXISTED);
        }

        //解析dictValues
        List<Map<String, String>> items = parseThreeKeyValue(dictValues);

        //添加字典
        SysDicType dicType=new SysDicType();
        dicType.setDicTypeName(dictName);
        dicType.setDicTypeNo(typeNo);
        dicType.setSystemNo("pc");
        this.sysDicTypeMapper.insert(dicType);

        //添加字典条目
        for (Map<String, String> item : items) {
            String num = item.get(MUTI_STR_KEY);
            String name = item.get(MUTI_STR_VALUE);
            String notes = item.get(MUTI_STR_NOTES);
            SysDic sysDic=new SysDic();
            sysDic.setDicTypeNo(typeNo);
            sysDic.setDicNo(num);
            sysDic.setDicValue(name);
            sysDic.setDicNotes(notes);
            if("disUserType".equals(name)){
                sysDic.setDicOrder(Integer.parseInt(typeNo));
            }
            this.sysDicMapper.insert(sysDic);
        }
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void editDict(Integer dictId, String dictName,String disTypeNo, String dicts) {
        //删除之前的字典
        this.delteDict(dictId);

        //重新添加新的字典
        this.addDict(dictName,disTypeNo,dicts);
    }
    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void delteDict(Integer dictId) {

        SysDicType dict = sysDicTypeMapper.selectById(dictId);
        //删除这个字典的子词典
        Wrapper<SysDic> dicEntityWrapper = new EntityWrapper<>();
        dicEntityWrapper = dicEntityWrapper.eq("dic_type_no", dict.getDicTypeNo());
        sysDicMapper.delete(dicEntityWrapper);

        //删除这个词典

        sysDicTypeMapper.deleteById(dictId);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectListByCode(String code) {
        List<Map<String, Object>> list=  sysDicDao.selectListByCode(code);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public Map<String, Object> selectListByCodeNo(String code, String no) {
        return sysDicDao.selectListByCodeNo(code,no);
    }

    /**
     * 根据前缀计算订单号
     * @param codeNo
     * @return
     */
    @Override
    public synchronized String getOrderNo(String codeNo) {
        String orderNo="";
        SysDic param=new SysDic();
        param.setDicNo(codeNo);
        param.setDicTypeNo("orderPrefix");
        SysDic sysDic=sysDicMapper.selectOne(param);
        SimpleDateFormat sdff = new SimpleDateFormat("yyyyMMddHHmmss");
        String snow = sdff.format(new Date()).substring(7,14);
        orderNo=sysDic.getDicValue()+snow;
        for(int i=0;i<4;i++){
            Random random = new Random();
            orderNo +=  String.valueOf(random.nextInt(10));
        }
        return orderNo;
    }


}
