package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T05CaseEntity;
import com.dt.gongan.dao.mapper.T05CaseMapper;
import com.dt.gongan.dao.service.T05CaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.dt.core.tools.MyDateUtil;

/**
 * <p>
 * 战果案例填报 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@Service
public class T05CaseServiceImpl extends ServiceImpl<T05CaseMapper, T05CaseEntity> implements T05CaseService {
    @Override
    public IPage<T05CaseEntity> selectPage(IPage<T05CaseEntity> page, T05CaseEntity t05CaseEntity){
        return page(page, getSelectQueryWrapper(t05CaseEntity));
    }

    @Override
    public List<T05CaseEntity> selectList(T05CaseEntity t05CaseEntity){
        return list(getSelectQueryWrapper(t05CaseEntity));
    }

    @Override
    public void insert(T05CaseEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isBlank(o.getUpdateTime())){
            o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        }
        save(o);
    }

    @Override
        public void insert(List<T05CaseEntity> list){
            for(T05CaseEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T05CaseEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T05CaseEntity> getSelectQueryWrapper(T05CaseEntity t05CaseEntity){
        QueryWrapper<T05CaseEntity> queryWrapper = new QueryWrapper<>();
        if(t05CaseEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        //填报人id person_id bigint(20) personId Long
        if(t05CaseEntity.getPersonId() != null){
            queryWrapper.eq("person_id", t05CaseEntity.getPersonId());
        }
        //填报人名称 person_name varchar(200) personName String
        if(StringUtils.isNotBlank(t05CaseEntity.getPersonName())){
            queryWrapper.eq("person_name", t05CaseEntity.getPersonName());
        }
        //填报人电话 person_phone varchar(200) personPhone String
        if(StringUtils.isNotBlank(t05CaseEntity.getPersonPhone())){
            queryWrapper.eq("person_phone", t05CaseEntity.getPersonPhone());
        }
        //填报人警号 person_no varchar(200) personNo String
        if(StringUtils.isNotBlank(t05CaseEntity.getPersonNo())){
            queryWrapper.eq("person_no", t05CaseEntity.getPersonNo());
        }
        //标题 case_title varchar(500) caseTitle String
        if(StringUtils.isNotBlank(t05CaseEntity.getCaseTitle())){
            queryWrapper.eq("case_title", t05CaseEntity.getCaseTitle());
        }
        //内容 case_content varchar(3000) caseContent String
        if(StringUtils.isNotBlank(t05CaseEntity.getCaseContent())){
            queryWrapper.eq("case_content", t05CaseEntity.getCaseContent());
        }
        //时间 case_time varchar(100) caseTime String
        if(StringUtils.isNotBlank(t05CaseEntity.getCaseTime())){
            queryWrapper.eq("case_time", t05CaseEntity.getCaseTime());
        }
        //类型,0:重大案例, 1:战果 case_type varchar(100) caseType String
        if(StringUtils.isNotBlank(t05CaseEntity.getCaseType())){
            queryWrapper.eq("case_type", t05CaseEntity.getCaseType());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t05CaseEntity.getCreateTime())){
            queryWrapper.eq("create_time", t05CaseEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t05CaseEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t05CaseEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t05CaseEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t05CaseEntity.getDelFlag());
        }
        queryWrapper.orderByDesc("update_time");
        return queryWrapper;
    }

    @Override
    public void addTestData(){
        for(int i=0; i<30; i++){
            addOneTestData(i);
        }
    }

    private void addOneTestData(int i) {
        T05CaseEntity o = new T05CaseEntity();

        //自增id id bigint(20) id Long

        //填报人id person_id bigint(20) personId Long
        o.setPersonId(222L + i);

        //填报人名称 person_name varchar(200) personName String
        o.setPersonName("personName" + i);

        //填报人电话 person_phone varchar(200) personPhone String
        o.setPersonPhone("personPhone" + i);

        //填报人警号 person_no varchar(200) personNo String
        o.setPersonNo("personNo" + i);

        //标题 case_title varchar(500) caseTitle String
        o.setCaseTitle("caseTitle" + i);

        //内容 case_content varchar(3000) caseContent String
        o.setCaseContent("caseContent" + i);

        //时间 case_time varchar(100) caseTime String
        o.setCaseTime("caseTime" + i);

        //类型,0:重大案例, 1:战果 case_type varchar(100) caseType String
        o.setCaseType("caseType" + i);

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
