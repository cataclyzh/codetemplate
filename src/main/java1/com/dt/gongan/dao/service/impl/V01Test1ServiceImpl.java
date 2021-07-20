package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.V01Test1Entity;
import com.dt.gongan.dao.mapper.V01Test1Mapper;
import com.dt.gongan.dao.service.V01Test1Service;
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
 * VIEW 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-19
 */
@Slf4j
@Service
public class V01Test1ServiceImpl extends ServiceImpl<V01Test1Mapper, V01Test1Entity> implements V01Test1Service {
    @Override
    public IPage<V01Test1Entity> selectPage(IPage<V01Test1Entity> page, V01Test1Entity v01Test1Entity){
        return page(page, getSelectQueryWrapper(v01Test1Entity));
    }

    @Override
    public List<V01Test1Entity> selectList(V01Test1Entity v01Test1Entity){
        return list(getSelectQueryWrapper(v01Test1Entity));
    }

    @Override
    public void insert(V01Test1Entity o){
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
        public void insert(List<V01Test1Entity> list){
            for(V01Test1Entity o : list){
            insert(o);
        }
    }

    @Override
    public void update(V01Test1Entity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<V01Test1Entity> getSelectQueryWrapper(V01Test1Entity v01Test1Entity){
        QueryWrapper<V01Test1Entity> queryWrapper = new QueryWrapper<>();
        if(v01Test1Entity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //编号 id bigint(20) id Long
        if(v01Test1Entity.getId() != null){
            queryWrapper.eq("id", v01Test1Entity.getId());
        }
        //值班人id duty_person_id bigint(20) dutyPersonId Long
        if(v01Test1Entity.getDutyPersonId() != null){
            queryWrapper.eq("duty_person_id", v01Test1Entity.getDutyPersonId());
        }
        //岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗 scheduling_type varchar(200) schedulingType String
        if(StringUtils.isNotBlank(v01Test1Entity.getSchedulingType())){
            queryWrapper.eq("scheduling_type", v01Test1Entity.getSchedulingType());
        }
        //地市编号 0: 省厅 city_no varchar(100) cityNo String
        if(StringUtils.isNotBlank(v01Test1Entity.getCityNo())){
            queryWrapper.eq("city_no", v01Test1Entity.getCityNo());
        }
        if(StringUtils.isNotBlank(v01Test1Entity.getName())){
            queryWrapper.eq("name", v01Test1Entity.getName());
        }
        if(StringUtils.isNotBlank(v01Test1Entity.getMobile())){
            queryWrapper.eq("mobile", v01Test1Entity.getMobile());
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
        V01Test1Entity o = new V01Test1Entity();

        //编号 id bigint(20) id Long
        o.setId(222L + i);

        //值班人id duty_person_id bigint(20) dutyPersonId Long
        o.setDutyPersonId(222L + i);

        //岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗 scheduling_type varchar(200) schedulingType String
        o.setSchedulingType("schedulingType");

        //地市编号 0: 省厅 city_no varchar(100) cityNo String
        o.setCityNo("cityNo");

        o.setName("name");

        o.setMobile("mobile");

        insert(o);
    }


}
