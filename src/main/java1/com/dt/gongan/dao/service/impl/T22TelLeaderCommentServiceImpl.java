package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T22TelLeaderCommentEntity;
import com.dt.gongan.dao.mapper.T22TelLeaderCommentMapper;
import com.dt.gongan.dao.service.T22TelLeaderCommentService;
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
 * 电话申请的领导批示 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-02
 */
@Slf4j
@Service
public class T22TelLeaderCommentServiceImpl extends ServiceImpl<T22TelLeaderCommentMapper, T22TelLeaderCommentEntity> implements T22TelLeaderCommentService {
    @Override
    public IPage<T22TelLeaderCommentEntity> selectPage(IPage<T22TelLeaderCommentEntity> page, T22TelLeaderCommentEntity t22TelLeaderCommentEntity){
        return page(page, getSelectQueryWrapper(t22TelLeaderCommentEntity));
    }

    @Override
    public List<T22TelLeaderCommentEntity> selectList(T22TelLeaderCommentEntity t22TelLeaderCommentEntity){
        return list(getSelectQueryWrapper(t22TelLeaderCommentEntity));
    }

    @Override
    public void insert(T22TelLeaderCommentEntity o){
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
        public void insert(List<T22TelLeaderCommentEntity> list){
            for(T22TelLeaderCommentEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T22TelLeaderCommentEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T22TelLeaderCommentEntity> getSelectQueryWrapper(T22TelLeaderCommentEntity t22TelLeaderCommentEntity){
        QueryWrapper<T22TelLeaderCommentEntity> queryWrapper = new QueryWrapper<>();
        if(t22TelLeaderCommentEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        //电话数据服务申请单id t19_id bigint(20) t19Id Long
        if(t22TelLeaderCommentEntity.getT19Id() != null){
            queryWrapper.eq("t19_id", t22TelLeaderCommentEntity.getT19Id());
        }
        //反馈人ID lead_user_id bigint(20) leadUserId Long
        if(t22TelLeaderCommentEntity.getLeadUserId() != null){
            queryWrapper.eq("lead_user_id", t22TelLeaderCommentEntity.getLeadUserId());
        }
        //反馈人姓名 lead_user_name varchar(300) leadUserName String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadUserName())){
            queryWrapper.eq("lead_user_name", t22TelLeaderCommentEntity.getLeadUserName());
        }
        //反馈人警号 lead_user_no varchar(255) leadUserNo String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadUserNo())){
            queryWrapper.eq("lead_user_no", t22TelLeaderCommentEntity.getLeadUserNo());
        }
        //反馈人电话 lead_user_phone varchar(255) leadUserPhone String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadUserPhone())){
            queryWrapper.eq("lead_user_phone", t22TelLeaderCommentEntity.getLeadUserPhone());
        }
        //反馈部门ID lead_org_id bigint(20) leadOrgId Long
        if(t22TelLeaderCommentEntity.getLeadOrgId() != null){
            queryWrapper.eq("lead_org_id", t22TelLeaderCommentEntity.getLeadOrgId());
        }
        //反馈部门 lead_org_name varchar(255) leadOrgName String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadOrgName())){
            queryWrapper.eq("lead_org_name", t22TelLeaderCommentEntity.getLeadOrgName());
        }
        //反馈意见 lead_comment varchar(2000) leadComment String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadComment())){
            queryWrapper.eq("lead_comment", t22TelLeaderCommentEntity.getLeadComment());
        }
        //反馈时间 lead_comment_time varchar(20) leadCommentTime String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadCommentTime())){
            queryWrapper.eq("lead_comment_time", t22TelLeaderCommentEntity.getLeadCommentTime());
        }
        //反馈附件ids lead_attachement_ids varchar(500) leadAttachementIds String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getLeadAttachementIds())){
            queryWrapper.eq("lead_attachement_ids", t22TelLeaderCommentEntity.getLeadAttachementIds());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getCreateTime())){
            queryWrapper.eq("create_time", t22TelLeaderCommentEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t22TelLeaderCommentEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t22TelLeaderCommentEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t22TelLeaderCommentEntity.getDelFlag());
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
        T22TelLeaderCommentEntity o = new T22TelLeaderCommentEntity();

        //自增id id bigint(20) id Long

        //电话数据服务申请单id t19_id bigint(20) t19Id Long
        o.setT19Id(222L + i);

        //反馈人ID lead_user_id bigint(20) leadUserId Long
        o.setLeadUserId(222L + i);

        //反馈人姓名 lead_user_name varchar(300) leadUserName String
        o.setLeadUserName("leadUserName");

        //反馈人警号 lead_user_no varchar(255) leadUserNo String
        o.setLeadUserNo("leadUserNo");

        //反馈人电话 lead_user_phone varchar(255) leadUserPhone String
        o.setLeadUserPhone("leadUserPhone");

        //反馈部门ID lead_org_id bigint(20) leadOrgId Long
        o.setLeadOrgId(222L + i);

        //反馈部门 lead_org_name varchar(255) leadOrgName String
        o.setLeadOrgName("leadOrgName");

        //反馈意见 lead_comment varchar(2000) leadComment String
        o.setLeadComment("leadComment");

        //反馈时间 lead_comment_time varchar(20) leadCommentTime String
        o.setLeadCommentTime("leadCommentTime");

        //反馈附件ids lead_attachement_ids varchar(500) leadAttachementIds String
        o.setLeadAttachementIds("leadAttachementIds");

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
