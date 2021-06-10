package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T03DutyEntity;
import com.dt.gongan.dao.mapper.T03DutyMapper;
import com.dt.gongan.dao.service.T03DutyService;
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
 * 值班记录 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@Service
public class T03DutyServiceImpl extends ServiceImpl<T03DutyMapper, T03DutyEntity> implements T03DutyService {
    @Override
    public IPage<T03DutyEntity> selectPage(IPage<T03DutyEntity> page, T03DutyEntity t03DutyEntity){
        return page(page, getSelectQueryWrapper(t03DutyEntity));
    }

    @Override
    public List<T03DutyEntity> selectList(T03DutyEntity t03DutyEntity){
        return list(getSelectQueryWrapper(t03DutyEntity));
    }

    @Override
    public void insert(T03DutyEntity o){
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
        public void insert(List<T03DutyEntity> list){
            for(T03DutyEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T03DutyEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T03DutyEntity> getSelectQueryWrapper(T03DutyEntity t03DutyEntity){
        QueryWrapper<T03DutyEntity> queryWrapper = new QueryWrapper<>();
        if(t03DutyEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        //排班id t01_scheduling_id bigint(20) t01SchedulingId Long
        if(t03DutyEntity.getT01SchedulingId() != null){
            queryWrapper.eq("t01_scheduling_id", t03DutyEntity.getT01SchedulingId());
        }
        //值班人id duty_person_id bigint(20) dutyPersonId Long
        if(t03DutyEntity.getDutyPersonId() != null){
            queryWrapper.eq("duty_person_id", t03DutyEntity.getDutyPersonId());
        }
        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyPersonName())){
            queryWrapper.eq("duty_person_name", t03DutyEntity.getDutyPersonName());
        }
        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyPersonPhone())){
            queryWrapper.eq("duty_person_phone", t03DutyEntity.getDutyPersonPhone());
        }
        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyPersonNo())){
            queryWrapper.eq("duty_person_no", t03DutyEntity.getDutyPersonNo());
        }
        //值班信息 duty_message varchar(2000) dutyMessage String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyMessage())){
            queryWrapper.eq("duty_message", t03DutyEntity.getDutyMessage());
        }
        //记录类型(duty_message_type) duty_message_type varchar(100) dutyMessageType String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyMessageType())){
            queryWrapper.eq("duty_message_type", t03DutyEntity.getDutyMessageType());
        }
        //值班时间 duty_time varchar(100) dutyTime String
        if(StringUtils.isNotBlank(t03DutyEntity.getDutyTime())){
            queryWrapper.eq("duty_time", t03DutyEntity.getDutyTime());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t03DutyEntity.getCreateTime())){
            queryWrapper.eq("create_time", t03DutyEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t03DutyEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t03DutyEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t03DutyEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t03DutyEntity.getDelFlag());
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
        T03DutyEntity o = new T03DutyEntity();

        //自增id id bigint(20) id Long

        //排班id t01_scheduling_id bigint(20) t01SchedulingId Long
        o.setT01SchedulingId(222L + i);

        //值班人id duty_person_id bigint(20) dutyPersonId Long
        o.setDutyPersonId(222L + i);

        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        o.setDutyPersonName("dutyPersonName" + i);

        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        o.setDutyPersonPhone("dutyPersonPhone" + i);

        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        o.setDutyPersonNo("dutyPersonNo" + i);

        //值班信息 duty_message varchar(2000) dutyMessage String
        o.setDutyMessage("dutyMessage" + i);

        //记录类型(duty_message_type) duty_message_type varchar(100) dutyMessageType String
        o.setDutyMessageType("dutyMessageType" + i);

        //值班时间 duty_time varchar(100) dutyTime String
        o.setDutyTime("dutyTime" + i);

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
