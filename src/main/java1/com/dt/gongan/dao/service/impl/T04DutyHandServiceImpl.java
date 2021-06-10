package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T04DutyHandEntity;
import com.dt.gongan.dao.mapper.T04DutyHandMapper;
import com.dt.gongan.dao.service.T04DutyHandService;
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
 * 交班记录 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@Service
public class T04DutyHandServiceImpl extends ServiceImpl<T04DutyHandMapper, T04DutyHandEntity> implements T04DutyHandService {
    @Override
    public IPage<T04DutyHandEntity> selectPage(IPage<T04DutyHandEntity> page, T04DutyHandEntity t04DutyHandEntity){
        return page(page, getSelectQueryWrapper(t04DutyHandEntity));
    }

    @Override
    public List<T04DutyHandEntity> selectList(T04DutyHandEntity t04DutyHandEntity){
        return list(getSelectQueryWrapper(t04DutyHandEntity));
    }

    @Override
    public void insert(T04DutyHandEntity o){
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
        public void insert(List<T04DutyHandEntity> list){
            for(T04DutyHandEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T04DutyHandEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T04DutyHandEntity> getSelectQueryWrapper(T04DutyHandEntity t04DutyHandEntity){
        QueryWrapper<T04DutyHandEntity> queryWrapper = new QueryWrapper<>();
        if(t04DutyHandEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        //部门id org_id bigint(20) orgId Long
        if(t04DutyHandEntity.getOrgId() != null){
            queryWrapper.eq("org_id", t04DutyHandEntity.getOrgId());
        }
        //排班id t01_scheduling_id bigint(20) t01SchedulingId Long
        if(t04DutyHandEntity.getT01SchedulingId() != null){
            queryWrapper.eq("t01_scheduling_id", t04DutyHandEntity.getT01SchedulingId());
        }
        //值班人id duty_person_id bigint(20) dutyPersonId Long
        if(t04DutyHandEntity.getDutyPersonId() != null){
            queryWrapper.eq("duty_person_id", t04DutyHandEntity.getDutyPersonId());
        }
        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyPersonName())){
            queryWrapper.eq("duty_person_name", t04DutyHandEntity.getDutyPersonName());
        }
        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyPersonPhone())){
            queryWrapper.eq("duty_person_phone", t04DutyHandEntity.getDutyPersonPhone());
        }
        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyPersonNo())){
            queryWrapper.eq("duty_person_no", t04DutyHandEntity.getDutyPersonNo());
        }
        //交班人id hand_person_id bigint(20) handPersonId Long
        if(t04DutyHandEntity.getHandPersonId() != null){
            queryWrapper.eq("hand_person_id", t04DutyHandEntity.getHandPersonId());
        }
        //交班人名称 hand_person_name varchar(200) handPersonName String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getHandPersonName())){
            queryWrapper.eq("hand_person_name", t04DutyHandEntity.getHandPersonName());
        }
        //交班人电话 hand_person_phone varchar(200) handPersonPhone String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getHandPersonPhone())){
            queryWrapper.eq("hand_person_phone", t04DutyHandEntity.getHandPersonPhone());
        }
        //交班人警号 hand_person_no varchar(200) handPersonNo String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getHandPersonNo())){
            queryWrapper.eq("hand_person_no", t04DutyHandEntity.getHandPersonNo());
        }
        //值班信息 duty_message varchar(2000) dutyMessage String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyMessage())){
            queryWrapper.eq("duty_message", t04DutyHandEntity.getDutyMessage());
        }
        //交班状态,0:未确认,1:确认 duty_status varchar(2000) dutyStatus String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyStatus())){
            queryWrapper.eq("duty_status", t04DutyHandEntity.getDutyStatus());
        }
        //值班时间 duty_time varchar(100) dutyTime String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDutyTime())){
            queryWrapper.eq("duty_time", t04DutyHandEntity.getDutyTime());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getCreateTime())){
            queryWrapper.eq("create_time", t04DutyHandEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t04DutyHandEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t04DutyHandEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t04DutyHandEntity.getDelFlag());
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
        T04DutyHandEntity o = new T04DutyHandEntity();

        //自增id id bigint(20) id Long

        //部门id org_id bigint(20) orgId Long
        o.setOrgId(222L + i);

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

        //交班人id hand_person_id bigint(20) handPersonId Long
        o.setHandPersonId(222L + i);

        //交班人名称 hand_person_name varchar(200) handPersonName String
        o.setHandPersonName("handPersonName" + i);

        //交班人电话 hand_person_phone varchar(200) handPersonPhone String
        o.setHandPersonPhone("handPersonPhone" + i);

        //交班人警号 hand_person_no varchar(200) handPersonNo String
        o.setHandPersonNo("handPersonNo" + i);

        //值班信息 duty_message varchar(2000) dutyMessage String
        o.setDutyMessage("dutyMessage" + i);

        //交班状态,0:未确认,1:确认 duty_status varchar(2000) dutyStatus String
        o.setDutyStatus("dutyStatus" + i);

        //值班时间 duty_time varchar(100) dutyTime String
        o.setDutyTime("dutyTime" + i);

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
