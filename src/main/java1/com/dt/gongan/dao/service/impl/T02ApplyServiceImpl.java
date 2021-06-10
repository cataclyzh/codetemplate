package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T02ApplyEntity;
import com.dt.gongan.dao.mapper.T02ApplyMapper;
import com.dt.gongan.dao.service.T02ApplyService;
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
 * 申请记录 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@Service
public class T02ApplyServiceImpl extends ServiceImpl<T02ApplyMapper, T02ApplyEntity> implements T02ApplyService {
    @Override
    public IPage<T02ApplyEntity> selectPage(IPage<T02ApplyEntity> page, T02ApplyEntity t02ApplyEntity){
        return page(page, getSelectQueryWrapper(t02ApplyEntity));
    }

    @Override
    public List<T02ApplyEntity> selectList(T02ApplyEntity t02ApplyEntity){
        return list(getSelectQueryWrapper(t02ApplyEntity));
    }

    @Override
    public void insert(T02ApplyEntity o){
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
        public void insert(List<T02ApplyEntity> list){
            for(T02ApplyEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T02ApplyEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T02ApplyEntity> getSelectQueryWrapper(T02ApplyEntity t02ApplyEntity){
        QueryWrapper<T02ApplyEntity> queryWrapper = new QueryWrapper<>();
        if(t02ApplyEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //编号 id bigint(20) id Long
        //申请单号 apply_no varchar(200) applyNo String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyNo())){
            queryWrapper.eq("apply_no", t02ApplyEntity.getApplyNo());
        }
        //申请人id apply_person_id bigint(20) applyPersonId Long
        if(t02ApplyEntity.getApplyPersonId() != null){
            queryWrapper.eq("apply_person_id", t02ApplyEntity.getApplyPersonId());
        }
        //申请人名称 apply_person_name varchar(200) applyPersonName String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyPersonName())){
            queryWrapper.eq("apply_person_name", t02ApplyEntity.getApplyPersonName());
        }
        //申请人电话 apply_person_phone varchar(200) applyPersonPhone String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyPersonPhone())){
            queryWrapper.eq("apply_person_phone", t02ApplyEntity.getApplyPersonPhone());
        }
        //申请人警号 apply_person_no varchar(200) applyPersonNo String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyPersonNo())){
            queryWrapper.eq("apply_person_no", t02ApplyEntity.getApplyPersonNo());
        }
        //值班人id duty_person_id bigint(20) dutyPersonId Long
        if(t02ApplyEntity.getDutyPersonId() != null){
            queryWrapper.eq("duty_person_id", t02ApplyEntity.getDutyPersonId());
        }
        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        if(StringUtils.isNotBlank(t02ApplyEntity.getDutyPersonName())){
            queryWrapper.eq("duty_person_name", t02ApplyEntity.getDutyPersonName());
        }
        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        if(StringUtils.isNotBlank(t02ApplyEntity.getDutyPersonPhone())){
            queryWrapper.eq("duty_person_phone", t02ApplyEntity.getDutyPersonPhone());
        }
        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        if(StringUtils.isNotBlank(t02ApplyEntity.getDutyPersonNo())){
            queryWrapper.eq("duty_person_no", t02ApplyEntity.getDutyPersonNo());
        }
        //处理人id handle_person_id bigint(20) handlePersonId Long
        if(t02ApplyEntity.getHandlePersonId() != null){
            queryWrapper.eq("handle_person_id", t02ApplyEntity.getHandlePersonId());
        }
        //处理人名称 handle_person_name varchar(200) handlePersonName String
        if(StringUtils.isNotBlank(t02ApplyEntity.getHandlePersonName())){
            queryWrapper.eq("handle_person_name", t02ApplyEntity.getHandlePersonName());
        }
        //处理人电话 handle_person_phone varchar(200) handlePersonPhone String
        if(StringUtils.isNotBlank(t02ApplyEntity.getHandlePersonPhone())){
            queryWrapper.eq("handle_person_phone", t02ApplyEntity.getHandlePersonPhone());
        }
        //处理人警号 handle_person_no varchar(200) handlePersonNo String
        if(StringUtils.isNotBlank(t02ApplyEntity.getHandlePersonNo())){
            queryWrapper.eq("handle_person_no", t02ApplyEntity.getHandlePersonNo());
        }
        //需求人员id requirement_person_id bigint(20) requirementPersonId Long
        if(t02ApplyEntity.getRequirementPersonId() != null){
            queryWrapper.eq("requirement_person_id", t02ApplyEntity.getRequirementPersonId());
        }
        //需求人名称 requirement_person_name varchar(200) requirementPersonName String
        if(StringUtils.isNotBlank(t02ApplyEntity.getRequirementPersonName())){
            queryWrapper.eq("requirement_person_name", t02ApplyEntity.getRequirementPersonName());
        }
        //需求人电话 requirement_person_phone varchar(200) requirementPersonPhone String
        if(StringUtils.isNotBlank(t02ApplyEntity.getRequirementPersonPhone())){
            queryWrapper.eq("requirement_person_phone", t02ApplyEntity.getRequirementPersonPhone());
        }
        //需求人警号 requirement_person_no varchar(200) requirementPersonNo String
        if(StringUtils.isNotBlank(t02ApplyEntity.getRequirementPersonNo())){
            queryWrapper.eq("requirement_person_no", t02ApplyEntity.getRequirementPersonNo());
        }
        //申请主题 apply_theme varchar(500) applyTheme String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyTheme())){
            queryWrapper.eq("apply_theme", t02ApplyEntity.getApplyTheme());
        }
        //申请内容 apply_message varchar(2000) applyMessage String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyMessage())){
            queryWrapper.eq("apply_message", t02ApplyEntity.getApplyMessage());
        }
        //申请类型 apply_type varchar(100) applyType String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyType())){
            queryWrapper.eq("apply_type", t02ApplyEntity.getApplyType());
        }
        //发布时间 publish_time varchar(100) publishTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getPublishTime())){
            queryWrapper.eq("publish_time", t02ApplyEntity.getPublishTime());
        }
        //发布备注 publish_comment varchar(2000) publishComment String
        if(StringUtils.isNotBlank(t02ApplyEntity.getPublishComment())){
            queryWrapper.eq("publish_comment", t02ApplyEntity.getPublishComment());
        }
        //处理备注 process_type varchar(100) processType String
        if(StringUtils.isNotBlank(t02ApplyEntity.getProcessType())){
            queryWrapper.eq("process_type", t02ApplyEntity.getProcessType());
        }
        //处理时间 process_time varchar(100) processTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getProcessTime())){
            queryWrapper.eq("process_time", t02ApplyEntity.getProcessTime());
        }
        //转发备注 forward_type varchar(100) forwardType String
        if(StringUtils.isNotBlank(t02ApplyEntity.getForwardType())){
            queryWrapper.eq("forward_type", t02ApplyEntity.getForwardType());
        }
        //转发时间 forward_time varchar(100) forwardTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getForwardTime())){
            queryWrapper.eq("forward_time", t02ApplyEntity.getForwardTime());
        }
        //当前状态,申请,转发,完结 apply_status varchar(100) applyStatus String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyStatus())){
            queryWrapper.eq("apply_status", t02ApplyEntity.getApplyStatus());
        }
        //申请来源,平台,电话 apply_from varchar(200) applyFrom String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyFrom())){
            queryWrapper.eq("apply_from", t02ApplyEntity.getApplyFrom());
        }
        //申请时间 apply_time varchar(200) applyTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getApplyTime())){
            queryWrapper.eq("apply_time", t02ApplyEntity.getApplyTime());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getCreateTime())){
            queryWrapper.eq("create_time", t02ApplyEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t02ApplyEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t02ApplyEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t02ApplyEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t02ApplyEntity.getDelFlag());
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
        T02ApplyEntity o = new T02ApplyEntity();

        //编号 id bigint(20) id Long

        //申请单号 apply_no varchar(200) applyNo String
        o.setApplyNo("applyNo" + i);

        //申请人id apply_person_id bigint(20) applyPersonId Long
        o.setApplyPersonId(222L + i);

        //申请人名称 apply_person_name varchar(200) applyPersonName String
        o.setApplyPersonName("applyPersonName" + i);

        //申请人电话 apply_person_phone varchar(200) applyPersonPhone String
        o.setApplyPersonPhone("applyPersonPhone" + i);

        //申请人警号 apply_person_no varchar(200) applyPersonNo String
        o.setApplyPersonNo("applyPersonNo" + i);

        //值班人id duty_person_id bigint(20) dutyPersonId Long
        o.setDutyPersonId(222L + i);

        //值班人名称 duty_person_name varchar(200) dutyPersonName String
        o.setDutyPersonName("dutyPersonName" + i);

        //值班人电话 duty_person_phone varchar(200) dutyPersonPhone String
        o.setDutyPersonPhone("dutyPersonPhone" + i);

        //值班人警号 duty_person_no varchar(200) dutyPersonNo String
        o.setDutyPersonNo("dutyPersonNo" + i);

        //处理人id handle_person_id bigint(20) handlePersonId Long
        o.setHandlePersonId(222L + i);

        //处理人名称 handle_person_name varchar(200) handlePersonName String
        o.setHandlePersonName("handlePersonName" + i);

        //处理人电话 handle_person_phone varchar(200) handlePersonPhone String
        o.setHandlePersonPhone("handlePersonPhone" + i);

        //处理人警号 handle_person_no varchar(200) handlePersonNo String
        o.setHandlePersonNo("handlePersonNo" + i);

        //需求人员id requirement_person_id bigint(20) requirementPersonId Long
        o.setRequirementPersonId(222L + i);

        //需求人名称 requirement_person_name varchar(200) requirementPersonName String
        o.setRequirementPersonName("requirementPersonName" + i);

        //需求人电话 requirement_person_phone varchar(200) requirementPersonPhone String
        o.setRequirementPersonPhone("requirementPersonPhone" + i);

        //需求人警号 requirement_person_no varchar(200) requirementPersonNo String
        o.setRequirementPersonNo("requirementPersonNo" + i);

        //申请主题 apply_theme varchar(500) applyTheme String
        o.setApplyTheme("applyTheme" + i);

        //申请内容 apply_message varchar(2000) applyMessage String
        o.setApplyMessage("applyMessage" + i);

        //申请类型 apply_type varchar(100) applyType String
        o.setApplyType("applyType" + i);

        //发布时间 publish_time varchar(100) publishTime String
        o.setPublishTime("publishTime" + i);

        //发布备注 publish_comment varchar(2000) publishComment String
        o.setPublishComment("publishComment" + i);

        //处理备注 process_type varchar(100) processType String
        o.setProcessType("processType" + i);

        //处理时间 process_time varchar(100) processTime String
        o.setProcessTime("processTime" + i);

        //转发备注 forward_type varchar(100) forwardType String
        o.setForwardType("forwardType" + i);

        //转发时间 forward_time varchar(100) forwardTime String
        o.setForwardTime("forwardTime" + i);

        //当前状态,申请,转发,完结 apply_status varchar(100) applyStatus String
        o.setApplyStatus("applyStatus" + i);

        //申请来源,平台,电话 apply_from varchar(200) applyFrom String
        o.setApplyFrom("applyFrom" + i);

        //申请时间 apply_time varchar(200) applyTime String
        o.setApplyTime("applyTime" + i);

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
