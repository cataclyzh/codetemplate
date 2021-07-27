package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.V30V31Entity;
import com.dt.gongan.dao.mapper.V30V31Mapper;
import com.dt.gongan.dao.service.V30V31Service;
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
public class V30V31ServiceImpl extends ServiceImpl<V30V31Mapper, V30V31Entity> implements V30V31Service {
    @Override
    public IPage<V30V31Entity> selectPage(IPage<V30V31Entity> page, V30V31Entity v30V31Entity){
        return page(page, getSelectQueryWrapper(v30V31Entity));
    }

    @Override
    public List<V30V31Entity> selectList(V30V31Entity v30V31Entity){
        return list(getSelectQueryWrapper(v30V31Entity));
    }

    private QueryWrapper<V30V31Entity> getSelectQueryWrapper(V30V31Entity v30V31Entity){
        QueryWrapper<V30V31Entity> queryWrapper = new QueryWrapper<>();
        if(v30V31Entity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        if(v30V31Entity.getId() != null){
            queryWrapper.eq("id", v30V31Entity.getId());
        }
        //自增id t30_id bigint(20) t30Id Long
        if(v30V31Entity.getT30Id() != null){
            queryWrapper.eq("t30_id", v30V31Entity.getT30Id());
        }
        //数据核查令id t29_id bigint(20) t29Id Long
        if(v30V31Entity.getT29Id() != null){
            queryWrapper.eq("t29_id", v30V31Entity.getT29Id());
        }
        //推送到的部门id t30_org_id bigint(20) t30OrgId Long
        if(v30V31Entity.getT30OrgId() != null){
            queryWrapper.eq("t30_org_id", v30V31Entity.getT30OrgId());
        }
        //机构名称 t30_org_name varchar(64) t30OrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30OrgName())){
            queryWrapper.eq("t30_org_name", v30V31Entity.getT30OrgName());
        }
        if(v30V31Entity.getT30SignUserId() != null){
            queryWrapper.eq("t30_sign_user_id", v30V31Entity.getT30SignUserId());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30SignUserName())){
            queryWrapper.eq("t30_sign_user_name", v30V31Entity.getT30SignUserName());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30SignUserMobile())){
            queryWrapper.eq("t30_sign_user_mobile", v30V31Entity.getT30SignUserMobile());
        }
        //编号 t30_sign_org_id bigint(20) t30SignOrgId Long
        if(v30V31Entity.getT30SignOrgId() != null){
            queryWrapper.eq("t30_sign_org_id", v30V31Entity.getT30SignOrgId());
        }
        //机构名称 t30_sign_org_name varchar(64) t30SignOrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30SignOrgName())){
            queryWrapper.eq("t30_sign_org_name", v30V31Entity.getT30SignOrgName());
        }
        //机构类型 t30_sign_org_type varchar(64) t30SignOrgType String
        if(StringUtils.isNotBlank(v30V31Entity.getT30SignOrgType())){
            queryWrapper.eq("t30_sign_org_type", v30V31Entity.getT30SignOrgType());
        }
        if(v30V31Entity.getT30FankuiUserId() != null){
            queryWrapper.eq("t30_fankui_user_id", v30V31Entity.getT30FankuiUserId());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiUserName())){
            queryWrapper.eq("t30_fankui_user_name", v30V31Entity.getT30FankuiUserName());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiUserMobile())){
            queryWrapper.eq("t30_fankui_user_mobile", v30V31Entity.getT30FankuiUserMobile());
        }
        //编号 t30_fankui_org_id bigint(20) t30FankuiOrgId Long
        if(v30V31Entity.getT30FankuiOrgId() != null){
            queryWrapper.eq("t30_fankui_org_id", v30V31Entity.getT30FankuiOrgId());
        }
        //机构名称 t30_fankui_org_name varchar(64) t30FankuiOrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiOrgName())){
            queryWrapper.eq("t30_fankui_org_name", v30V31Entity.getT30FankuiOrgName());
        }
        //机构类型 t30_fankui_org_type varchar(64) t30FankuiOrgType String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiOrgType())){
            queryWrapper.eq("t30_fankui_org_type", v30V31Entity.getT30FankuiOrgType());
        }
        if(v30V31Entity.getT30TuisongUserId() != null){
            queryWrapper.eq("t30_tuisong_user_id", v30V31Entity.getT30TuisongUserId());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongUserName())){
            queryWrapper.eq("t30_tuisong_user_name", v30V31Entity.getT30TuisongUserName());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongUserMobile())){
            queryWrapper.eq("t30_tuisong_user_mobile", v30V31Entity.getT30TuisongUserMobile());
        }
        //编号 t30_tuisong_org_id bigint(20) t30TuisongOrgId Long
        if(v30V31Entity.getT30TuisongOrgId() != null){
            queryWrapper.eq("t30_tuisong_org_id", v30V31Entity.getT30TuisongOrgId());
        }
        //机构名称 t30_tuisong_org_name varchar(64) t30TuisongOrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongOrgName())){
            queryWrapper.eq("t30_tuisong_org_name", v30V31Entity.getT30TuisongOrgName());
        }
        //机构类型 t30_tuisong_org_type varchar(64) t30TuisongOrgType String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongOrgType())){
            queryWrapper.eq("t30_tuisong_org_type", v30V31Entity.getT30TuisongOrgType());
        }
        //当前状态,待签收、待反馈、完结 t30_sjhc_status varchar(100) t30SjhcStatus String
        if(StringUtils.isNotBlank(v30V31Entity.getT30SjhcStatus())){
            queryWrapper.eq("t30_sjhc_status", v30V31Entity.getT30SjhcStatus());
        }
        //推送意见 t30_tuisong_comment varchar(2000) t30TuisongComment String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongComment())){
            queryWrapper.eq("t30_tuisong_comment", v30V31Entity.getT30TuisongComment());
        }
        //推送时间 t30_tuisong_time varchar(20) t30TuisongTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongTime())){
            queryWrapper.eq("t30_tuisong_time", v30V31Entity.getT30TuisongTime());
        }
        //推送签收时间 t30_tuisong_sign_time varchar(300) t30TuisongSignTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TuisongSignTime())){
            queryWrapper.eq("t30_tuisong_sign_time", v30V31Entity.getT30TuisongSignTime());
        }
        //签收结果（0签收） t30_sign_status varchar(300) t30SignStatus String
        if(StringUtils.isNotBlank(v30V31Entity.getT30SignStatus())){
            queryWrapper.eq("t30_sign_status", v30V31Entity.getT30SignStatus());
        }
        //反馈时间 t30_fankui_time varchar(20) t30FankuiTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiTime())){
            queryWrapper.eq("t30_fankui_time", v30V31Entity.getT30FankuiTime());
        }
        //反馈附件ids t30_fankui_attachement_ids varchar(500) t30FankuiAttachementIds String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiAttachementIds())){
            queryWrapper.eq("t30_fankui_attachement_ids", v30V31Entity.getT30FankuiAttachementIds());
        }
        //签收意见 t30_turn_sign_comment varchar(2000) t30TurnSignComment String
        if(StringUtils.isNotBlank(v30V31Entity.getT30TurnSignComment())){
            queryWrapper.eq("t30_turn_sign_comment", v30V31Entity.getT30TurnSignComment());
        }
        //联系人 t30_contact_name varchar(200) t30ContactName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30ContactName())){
            queryWrapper.eq("t30_contact_name", v30V31Entity.getT30ContactName());
        }
        //联系电话 t30_contact_mobile varchar(100) t30ContactMobile String
        if(StringUtils.isNotBlank(v30V31Entity.getT30ContactMobile())){
            queryWrapper.eq("t30_contact_mobile", v30V31Entity.getT30ContactMobile());
        }
        //紧急程度 t30_sjhc_requirement varchar(100) t30SjhcRequirement String
        if(StringUtils.isNotBlank(v30V31Entity.getT30SjhcRequirement())){
            queryWrapper.eq("t30_sjhc_requirement", v30V31Entity.getT30SjhcRequirement());
        }
        //反馈核稿人 t30_fankui_hegao_name varchar(100) t30FankuiHegaoName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiHegaoName())){
            queryWrapper.eq("t30_fankui_hegao_name", v30V31Entity.getT30FankuiHegaoName());
        }
        //反馈签发人 t30_fankui_qianfa_name varchar(100) t30FankuiQianfaName String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiQianfaName())){
            queryWrapper.eq("t30_fankui_qianfa_name", v30V31Entity.getT30FankuiQianfaName());
        }
        //反馈数据处理 t30_fankui_shuju_chuli varchar(100) t30FankuiShujuChuli String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiShujuChuli())){
            queryWrapper.eq("t30_fankui_shuju_chuli", v30V31Entity.getT30FankuiShujuChuli());
        }
        //反馈结果量(条) t30_fankui_jieguoliang_tiao varchar(100) t30FankuiJieguoliangTiao String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiJieguoliangTiao())){
            queryWrapper.eq("t30_fankui_jieguoliang_tiao", v30V31Entity.getT30FankuiJieguoliangTiao());
        }
        //反馈结果量(人) t30_fankui_jieguoliang_ren varchar(100) t30FankuiJieguoliangRen String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiJieguoliangRen())){
            queryWrapper.eq("t30_fankui_jieguoliang_ren", v30V31Entity.getT30FankuiJieguoliangRen());
        }
        //反馈单位 t30_fankui_dangwei varchar(100) t30FankuiDangwei String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiDangwei())){
            queryWrapper.eq("t30_fankui_dangwei", v30V31Entity.getT30FankuiDangwei());
        }
        //反馈组织 t30_fankui_zhuzhi varchar(100) t30FankuiZhuzhi String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiZhuzhi())){
            queryWrapper.eq("t30_fankui_zhuzhi", v30V31Entity.getT30FankuiZhuzhi());
        }
        //反馈意见 t30_fankui_yijian varchar(500) t30FankuiYijian String
        if(StringUtils.isNotBlank(v30V31Entity.getT30FankuiYijian())){
            queryWrapper.eq("t30_fankui_yijian", v30V31Entity.getT30FankuiYijian());
        }
        //创建时间 t30_create_time char(19) t30CreateTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT30CreateTime())){
            queryWrapper.eq("t30_create_time", v30V31Entity.getT30CreateTime());
        }
        //更新时间 t30_update_time char(19) t30UpdateTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT30UpdateTime())){
            queryWrapper.eq("t30_update_time", v30V31Entity.getT30UpdateTime());
        }
        //自增id t31_id bigint(20) t31Id Long
        if(v30V31Entity.getT31Id() != null){
            queryWrapper.eq("t31_id", v30V31Entity.getT31Id());
        }
        if(v30V31Entity.getT31TuisongUserId() != null){
            queryWrapper.eq("t31_tuisong_user_id", v30V31Entity.getT31TuisongUserId());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongUserName())){
            queryWrapper.eq("t31_tuisong_user_name", v30V31Entity.getT31TuisongUserName());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongUserMobile())){
            queryWrapper.eq("t31_tuisong_user_mobile", v30V31Entity.getT31TuisongUserMobile());
        }
        //编号 t31_tuisong_org_id bigint(20) t31TuisongOrgId Long
        if(v30V31Entity.getT31TuisongOrgId() != null){
            queryWrapper.eq("t31_tuisong_org_id", v30V31Entity.getT31TuisongOrgId());
        }
        //机构名称 t31_tuisong_org_name varchar(64) t31TuisongOrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongOrgName())){
            queryWrapper.eq("t31_tuisong_org_name", v30V31Entity.getT31TuisongOrgName());
        }
        //机构类型 t31_tuisong_org_type varchar(64) t31TuisongOrgType String
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongOrgType())){
            queryWrapper.eq("t31_tuisong_org_type", v30V31Entity.getT31TuisongOrgType());
        }
        if(v30V31Entity.getT31FanhuiUserId() != null){
            queryWrapper.eq("t31_fanhui_user_id", v30V31Entity.getT31FanhuiUserId());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiUserName())){
            queryWrapper.eq("t31_fanhui_user_name", v30V31Entity.getT31FanhuiUserName());
        }
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiUserMobile())){
            queryWrapper.eq("t31_fanhui_user_mobile", v30V31Entity.getT31FanhuiUserMobile());
        }
        //编号 t31_fanhui_org_id bigint(20) t31FanhuiOrgId Long
        if(v30V31Entity.getT31FanhuiOrgId() != null){
            queryWrapper.eq("t31_fanhui_org_id", v30V31Entity.getT31FanhuiOrgId());
        }
        //机构名称 t31_fanhui_org_name varchar(64) t31FanhuiOrgName String
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiOrgName())){
            queryWrapper.eq("t31_fanhui_org_name", v30V31Entity.getT31FanhuiOrgName());
        }
        //机构类型 t31_fanhui_org_type varchar(64) t31FanhuiOrgType String
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiOrgType())){
            queryWrapper.eq("t31_fanhui_org_type", v30V31Entity.getT31FanhuiOrgType());
        }
        //记录所处状态,待处理,返回(后续推送签收使用新增加的记录),反馈 t31_record_info_status varchar(100) t31RecordInfoStatus String
        if(StringUtils.isNotBlank(v30V31Entity.getT31RecordInfoStatus())){
            queryWrapper.eq("t31_record_info_status", v30V31Entity.getT31RecordInfoStatus());
        }
        //推送意见 t31_tuisong_comment varchar(2000) t31TuisongComment String
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongComment())){
            queryWrapper.eq("t31_tuisong_comment", v30V31Entity.getT31TuisongComment());
        }
        //推送时间 t31_tuisong_time varchar(20) t31TuisongTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongTime())){
            queryWrapper.eq("t31_tuisong_time", v30V31Entity.getT31TuisongTime());
        }
        //推送附件ids t31_tuisong_attachement_ids varchar(500) t31TuisongAttachementIds String
        if(StringUtils.isNotBlank(v30V31Entity.getT31TuisongAttachementIds())){
            queryWrapper.eq("t31_tuisong_attachement_ids", v30V31Entity.getT31TuisongAttachementIds());
        }
        //退回意见 t31_fanhui_comment varchar(300) t31FanhuiComment String
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiComment())){
            queryWrapper.eq("t31_fanhui_comment", v30V31Entity.getT31FanhuiComment());
        }
        //退回时间 t31_fanhui_time varchar(20) t31FanhuiTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiTime())){
            queryWrapper.eq("t31_fanhui_time", v30V31Entity.getT31FanhuiTime());
        }
        //退回附件ids t31_fanhui_attachement_ids varchar(500) t31FanhuiAttachementIds String
        if(StringUtils.isNotBlank(v30V31Entity.getT31FanhuiAttachementIds())){
            queryWrapper.eq("t31_fanhui_attachement_ids", v30V31Entity.getT31FanhuiAttachementIds());
        }
        //创建时间 t31_create_time char(19) t31CreateTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT31CreateTime())){
            queryWrapper.eq("t31_create_time", v30V31Entity.getT31CreateTime());
        }
        //更新时间 t31_update_time char(19) t31UpdateTime String
        if(StringUtils.isNotBlank(v30V31Entity.getT31UpdateTime())){
            queryWrapper.eq("t31_update_time", v30V31Entity.getT31UpdateTime());
        }
        return queryWrapper;
    }

}
