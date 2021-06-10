package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T01SchedulingEntity;
import com.dt.gongan.dao.mapper.T01SchedulingMapper;
import com.dt.gongan.dao.service.T01SchedulingService;
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
 * 排班信息 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@Service
public class T01SchedulingServiceImpl extends ServiceImpl<T01SchedulingMapper, T01SchedulingEntity> implements T01SchedulingService {
    @Override
    public IPage<T01SchedulingEntity> selectPage(IPage<T01SchedulingEntity> page, T01SchedulingEntity t01SchedulingEntity){
        return page(page, getSelectQueryWrapper(t01SchedulingEntity));
    }

    @Override
    public List<T01SchedulingEntity> selectList(T01SchedulingEntity t01SchedulingEntity){
        return list(getSelectQueryWrapper(t01SchedulingEntity));
    }

    @Override
    public void insert(T01SchedulingEntity o){
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
        public void insert(List<T01SchedulingEntity> list){
            for(T01SchedulingEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T01SchedulingEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T01SchedulingEntity> getSelectQueryWrapper(T01SchedulingEntity t01SchedulingEntity){
        QueryWrapper<T01SchedulingEntity> queryWrapper = new QueryWrapper<>();
        if(t01SchedulingEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //编号 id bigint(20) id Long
        //值班人id duty_person_id bigint(20) dutyPersonId Long
        if(t01SchedulingEntity.getDutyPersonId() != null){
            queryWrapper.eq("duty_person_id", t01SchedulingEntity.getDutyPersonId());
        }
        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getDutyPersonName())){
            queryWrapper.eq("duty_person_name", t01SchedulingEntity.getDutyPersonName());
        }
        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getDutyPersonPhone())){
            queryWrapper.eq("duty_person_phone", t01SchedulingEntity.getDutyPersonPhone());
        }
        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getDutyPersonNo())){
            queryWrapper.eq("duty_person_no", t01SchedulingEntity.getDutyPersonNo());
        }
        //排班日期 2021-06-08 scheduling_day varchar(100) schedulingDay String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getSchedulingDay())){
            queryWrapper.eq("scheduling_day", t01SchedulingEntity.getSchedulingDay());
        }
        //上下午标志 scheduling_am int(11) schedulingAm Integer
        if(t01SchedulingEntity.getSchedulingAm() != null){
            queryWrapper.eq("scheduling_am", t01SchedulingEntity.getSchedulingAm());
        }
        //地市编号 0: 省厅 city_no varchar(100) cityNo String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getCityNo())){
            queryWrapper.eq("city_no", t01SchedulingEntity.getCityNo());
        }
        //岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗 scheduling_type varchar(200) schedulingType String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getSchedulingType())){
            queryWrapper.eq("scheduling_type", t01SchedulingEntity.getSchedulingType());
        }
        //排班状态(scheduling_status) 未开始, 值班中, 值班结束 scheduling_status varchar(100) schedulingStatus String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getSchedulingStatus())){
            queryWrapper.eq("scheduling_status", t01SchedulingEntity.getSchedulingStatus());
        }
        //结束标志 0 未结束 1 结束 scheduling_finish_flag varchar(100) schedulingFinishFlag String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getSchedulingFinishFlag())){
            queryWrapper.eq("scheduling_finish_flag", t01SchedulingEntity.getSchedulingFinishFlag());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t01SchedulingEntity.getDelFlag());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getCreateTime())){
            queryWrapper.eq("create_time", t01SchedulingEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t01SchedulingEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t01SchedulingEntity.getUpdateTime());
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
        T01SchedulingEntity o = new T01SchedulingEntity();

        //编号 id bigint(20) id Long

        //值班人id duty_person_id bigint(20) dutyPersonId Long
        o.setDutyPersonId(222L + i);

        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        o.setDutyPersonName("dutyPersonName" + i);

        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        o.setDutyPersonPhone("dutyPersonPhone" + i);

        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        o.setDutyPersonNo("dutyPersonNo" + i);

        //排班日期 2021-06-08 scheduling_day varchar(100) schedulingDay String
        o.setSchedulingDay("schedulingDay" + i);

        //上下午标志 scheduling_am int(11) schedulingAm Integer
        o.setSchedulingAm(111 + i);

        //地市编号 0: 省厅 city_no varchar(100) cityNo String
        o.setCityNo("cityNo" + i);

        //岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗 scheduling_type varchar(200) schedulingType String
        o.setSchedulingType("schedulingType" + i);

        //排班状态(scheduling_status) 未开始, 值班中, 值班结束 scheduling_status varchar(100) schedulingStatus String
        o.setSchedulingStatus("schedulingStatus" + i);

        //结束标志 0 未结束 1 结束 scheduling_finish_flag varchar(100) schedulingFinishFlag String
        o.setSchedulingFinishFlag("schedulingFinishFlag" + i);

        //删除标记 del_flag char(1) delFlag String

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        insert(o);
    }


}
