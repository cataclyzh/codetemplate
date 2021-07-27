package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.V31SjhcSub2Entity;
import com.dt.gongan.dao.mapper.V31SjhcSub2Mapper;
import com.dt.gongan.dao.service.V31SjhcSub2Service;
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
 * @since 2021-07-26
 */
@Slf4j
@Service
public class V31SjhcSub2ServiceImpl extends ServiceImpl<V31SjhcSub2Mapper, V31SjhcSub2Entity> implements V31SjhcSub2Service {
    @Override
    public IPage<V31SjhcSub2Entity> selectPage(IPage<V31SjhcSub2Entity> page, V31SjhcSub2Entity v31SjhcSub2Entity){
        return page(page, getSelectQueryWrapper(v31SjhcSub2Entity));
    }

    @Override
    public List<V31SjhcSub2Entity> selectList(V31SjhcSub2Entity v31SjhcSub2Entity){
        return list(getSelectQueryWrapper(v31SjhcSub2Entity));
    }

    private QueryWrapper<V31SjhcSub2Entity> getSelectQueryWrapper(V31SjhcSub2Entity v31SjhcSub2Entity){
        QueryWrapper<V31SjhcSub2Entity> queryWrapper = new QueryWrapper<>();
        if(v31SjhcSub2Entity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        if(v31SjhcSub2Entity.getId() != null){
            queryWrapper.eq("id", v31SjhcSub2Entity.getId());
        }
        //t24_sjhc_record id t30_id bigint(20) t30Id Long
        if(v31SjhcSub2Entity.getT30Id() != null){
            queryWrapper.eq("t30_id", v31SjhcSub2Entity.getT30Id());
        }
        if(v31SjhcSub2Entity.getTuisongUserId() != null){
            queryWrapper.eq("tuisong_user_id", v31SjhcSub2Entity.getTuisongUserId());
        }
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongUserName())){
            queryWrapper.eq("tuisong_user_name", v31SjhcSub2Entity.getTuisongUserName());
        }
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongUserMobile())){
            queryWrapper.eq("tuisong_user_mobile", v31SjhcSub2Entity.getTuisongUserMobile());
        }
        //编号 tuisong_org_id bigint(20) tuisongOrgId Long
        if(v31SjhcSub2Entity.getTuisongOrgId() != null){
            queryWrapper.eq("tuisong_org_id", v31SjhcSub2Entity.getTuisongOrgId());
        }
        //机构名称 tuisong_org_name varchar(64) tuisongOrgName String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongOrgName())){
            queryWrapper.eq("tuisong_org_name", v31SjhcSub2Entity.getTuisongOrgName());
        }
        //机构类型 tuisong_org_type varchar(64) tuisongOrgType String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongOrgType())){
            queryWrapper.eq("tuisong_org_type", v31SjhcSub2Entity.getTuisongOrgType());
        }
        if(v31SjhcSub2Entity.getFanhuiUserId() != null){
            queryWrapper.eq("fanhui_user_id", v31SjhcSub2Entity.getFanhuiUserId());
        }
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiUserName())){
            queryWrapper.eq("fanhui_user_name", v31SjhcSub2Entity.getFanhuiUserName());
        }
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiUserMobile())){
            queryWrapper.eq("fanhui_user_mobile", v31SjhcSub2Entity.getFanhuiUserMobile());
        }
        //编号 fanhui_org_id bigint(20) fanhuiOrgId Long
        if(v31SjhcSub2Entity.getFanhuiOrgId() != null){
            queryWrapper.eq("fanhui_org_id", v31SjhcSub2Entity.getFanhuiOrgId());
        }
        //机构名称 fanhui_org_name varchar(64) fanhuiOrgName String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiOrgName())){
            queryWrapper.eq("fanhui_org_name", v31SjhcSub2Entity.getFanhuiOrgName());
        }
        //机构类型 fanhui_org_type varchar(64) fanhuiOrgType String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiOrgType())){
            queryWrapper.eq("fanhui_org_type", v31SjhcSub2Entity.getFanhuiOrgType());
        }
        //记录所处状态,待处理,返回(后续推送签收使用新增加的记录),反馈 record_info_status varchar(100) recordInfoStatus String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getRecordInfoStatus())){
            queryWrapper.eq("record_info_status", v31SjhcSub2Entity.getRecordInfoStatus());
        }
        //推送意见 tuisong_comment varchar(2000) tuisongComment String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongComment())){
            queryWrapper.eq("tuisong_comment", v31SjhcSub2Entity.getTuisongComment());
        }
        //推送时间 tuisong_time varchar(20) tuisongTime String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongTime())){
            queryWrapper.eq("tuisong_time", v31SjhcSub2Entity.getTuisongTime());
        }
        //推送附件ids tuisong_attachement_ids varchar(500) tuisongAttachementIds String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getTuisongAttachementIds())){
            queryWrapper.eq("tuisong_attachement_ids", v31SjhcSub2Entity.getTuisongAttachementIds());
        }
        //退回意见 fanhui_comment varchar(300) fanhuiComment String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiComment())){
            queryWrapper.eq("fanhui_comment", v31SjhcSub2Entity.getFanhuiComment());
        }
        //退回时间 fanhui_time varchar(20) fanhuiTime String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiTime())){
            queryWrapper.eq("fanhui_time", v31SjhcSub2Entity.getFanhuiTime());
        }
        //退回附件ids fanhui_attachement_ids varchar(500) fanhuiAttachementIds String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getFanhuiAttachementIds())){
            queryWrapper.eq("fanhui_attachement_ids", v31SjhcSub2Entity.getFanhuiAttachementIds());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getCreateTime())){
            queryWrapper.eq("create_time", v31SjhcSub2Entity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(v31SjhcSub2Entity.getUpdateTime())){
            queryWrapper.eq("update_time", v31SjhcSub2Entity.getUpdateTime());
        }
        return queryWrapper;
    }

}
