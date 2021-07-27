package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.V29V30Entity;
import com.dt.gongan.dao.mapper.V29V30Mapper;
import com.dt.gongan.dao.service.V29V30Service;
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
public class V29V30ServiceImpl extends ServiceImpl<V29V30Mapper, V29V30Entity> implements V29V30Service {
    @Override
    public IPage<V29V30Entity> selectPage(IPage<V29V30Entity> page, V29V30Entity v29V30Entity){
        return page(page, getSelectQueryWrapper(v29V30Entity));
    }

    @Override
    public List<V29V30Entity> selectList(V29V30Entity v29V30Entity){
        return list(getSelectQueryWrapper(v29V30Entity));
    }

    private QueryWrapper<V29V30Entity> getSelectQueryWrapper(V29V30Entity v29V30Entity){
        QueryWrapper<V29V30Entity> queryWrapper = new QueryWrapper<>();
        if(v29V30Entity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        if(v29V30Entity.getId() != null){
            queryWrapper.eq("id", v29V30Entity.getId());
        }
        //自增id t30_id bigint(20) t30Id Long
        if(v29V30Entity.getT30Id() != null){
            queryWrapper.eq("t30_id", v29V30Entity.getT30Id());
        }
        //数据核查令id t29_id bigint(20) t29Id Long
        if(v29V30Entity.getT29Id() != null){
            queryWrapper.eq("t29_id", v29V30Entity.getT29Id());
        }
        //推送到的部门id t30_org_id bigint(20) t30OrgId Long
        if(v29V30Entity.getT30OrgId() != null){
            queryWrapper.eq("t30_org_id", v29V30Entity.getT30OrgId());
        }
        //机构名称 t30_org_name varchar(64) t30OrgName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30OrgName())){
            queryWrapper.eq("t30_org_name", v29V30Entity.getT30OrgName());
        }
        if(v29V30Entity.getT30SignUserId() != null){
            queryWrapper.eq("t30_sign_user_id", v29V30Entity.getT30SignUserId());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30SignUserName())){
            queryWrapper.eq("t30_sign_user_name", v29V30Entity.getT30SignUserName());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30SignUserMobile())){
            queryWrapper.eq("t30_sign_user_mobile", v29V30Entity.getT30SignUserMobile());
        }
        //编号 t30_sign_org_id bigint(20) t30SignOrgId Long
        if(v29V30Entity.getT30SignOrgId() != null){
            queryWrapper.eq("t30_sign_org_id", v29V30Entity.getT30SignOrgId());
        }
        //机构名称 t30_sign_org_name varchar(64) t30SignOrgName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30SignOrgName())){
            queryWrapper.eq("t30_sign_org_name", v29V30Entity.getT30SignOrgName());
        }
        //机构类型 t30_sign_org_type varchar(64) t30SignOrgType String
        if(StringUtils.isNotBlank(v29V30Entity.getT30SignOrgType())){
            queryWrapper.eq("t30_sign_org_type", v29V30Entity.getT30SignOrgType());
        }
        if(v29V30Entity.getT30FankuiUserId() != null){
            queryWrapper.eq("t30_fankui_user_id", v29V30Entity.getT30FankuiUserId());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiUserName())){
            queryWrapper.eq("t30_fankui_user_name", v29V30Entity.getT30FankuiUserName());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiUserMobile())){
            queryWrapper.eq("t30_fankui_user_mobile", v29V30Entity.getT30FankuiUserMobile());
        }
        //编号 t30_fankui_org_id bigint(20) t30FankuiOrgId Long
        if(v29V30Entity.getT30FankuiOrgId() != null){
            queryWrapper.eq("t30_fankui_org_id", v29V30Entity.getT30FankuiOrgId());
        }
        //机构名称 t30_fankui_org_name varchar(64) t30FankuiOrgName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiOrgName())){
            queryWrapper.eq("t30_fankui_org_name", v29V30Entity.getT30FankuiOrgName());
        }
        //机构类型 t30_fankui_org_type varchar(64) t30FankuiOrgType String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiOrgType())){
            queryWrapper.eq("t30_fankui_org_type", v29V30Entity.getT30FankuiOrgType());
        }
        if(v29V30Entity.getT30TuisongUserId() != null){
            queryWrapper.eq("t30_tuisong_user_id", v29V30Entity.getT30TuisongUserId());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongUserName())){
            queryWrapper.eq("t30_tuisong_user_name", v29V30Entity.getT30TuisongUserName());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongUserMobile())){
            queryWrapper.eq("t30_tuisong_user_mobile", v29V30Entity.getT30TuisongUserMobile());
        }
        //编号 t30_tuisong_org_id bigint(20) t30TuisongOrgId Long
        if(v29V30Entity.getT30TuisongOrgId() != null){
            queryWrapper.eq("t30_tuisong_org_id", v29V30Entity.getT30TuisongOrgId());
        }
        //机构名称 t30_tuisong_org_name varchar(64) t30TuisongOrgName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongOrgName())){
            queryWrapper.eq("t30_tuisong_org_name", v29V30Entity.getT30TuisongOrgName());
        }
        //机构类型 t30_tuisong_org_type varchar(64) t30TuisongOrgType String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongOrgType())){
            queryWrapper.eq("t30_tuisong_org_type", v29V30Entity.getT30TuisongOrgType());
        }
        //当前状态,待签收、待反馈、完结 t30_sjhc_status varchar(100) t30SjhcStatus String
        if(StringUtils.isNotBlank(v29V30Entity.getT30SjhcStatus())){
            queryWrapper.eq("t30_sjhc_status", v29V30Entity.getT30SjhcStatus());
        }
        //推送意见 t30_tuisong_comment varchar(2000) t30TuisongComment String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongComment())){
            queryWrapper.eq("t30_tuisong_comment", v29V30Entity.getT30TuisongComment());
        }
        //推送时间 t30_tuisong_time varchar(20) t30TuisongTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongTime())){
            queryWrapper.eq("t30_tuisong_time", v29V30Entity.getT30TuisongTime());
        }
        //推送签收时间 t30_tuisong_sign_time varchar(300) t30TuisongSignTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TuisongSignTime())){
            queryWrapper.eq("t30_tuisong_sign_time", v29V30Entity.getT30TuisongSignTime());
        }
        //签收结果（0签收） t30_sign_status varchar(300) t30SignStatus String
        if(StringUtils.isNotBlank(v29V30Entity.getT30SignStatus())){
            queryWrapper.eq("t30_sign_status", v29V30Entity.getT30SignStatus());
        }
        //反馈时间 t30_fankui_time varchar(20) t30FankuiTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiTime())){
            queryWrapper.eq("t30_fankui_time", v29V30Entity.getT30FankuiTime());
        }
        //反馈附件ids t30_fankui_attachement_ids varchar(500) t30FankuiAttachementIds String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiAttachementIds())){
            queryWrapper.eq("t30_fankui_attachement_ids", v29V30Entity.getT30FankuiAttachementIds());
        }
        //签收意见 t30_turn_sign_comment varchar(2000) t30TurnSignComment String
        if(StringUtils.isNotBlank(v29V30Entity.getT30TurnSignComment())){
            queryWrapper.eq("t30_turn_sign_comment", v29V30Entity.getT30TurnSignComment());
        }
        //联系人 t30_contact_name varchar(200) t30ContactName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30ContactName())){
            queryWrapper.eq("t30_contact_name", v29V30Entity.getT30ContactName());
        }
        //联系电话 t30_contact_mobile varchar(100) t30ContactMobile String
        if(StringUtils.isNotBlank(v29V30Entity.getT30ContactMobile())){
            queryWrapper.eq("t30_contact_mobile", v29V30Entity.getT30ContactMobile());
        }
        //紧急程度 t30_sjhc_requirement varchar(100) t30SjhcRequirement String
        if(StringUtils.isNotBlank(v29V30Entity.getT30SjhcRequirement())){
            queryWrapper.eq("t30_sjhc_requirement", v29V30Entity.getT30SjhcRequirement());
        }
        //反馈核稿人 t30_fankui_hegao_name varchar(100) t30FankuiHegaoName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiHegaoName())){
            queryWrapper.eq("t30_fankui_hegao_name", v29V30Entity.getT30FankuiHegaoName());
        }
        //反馈签发人 t30_fankui_qianfa_name varchar(100) t30FankuiQianfaName String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiQianfaName())){
            queryWrapper.eq("t30_fankui_qianfa_name", v29V30Entity.getT30FankuiQianfaName());
        }
        //反馈数据处理 t30_fankui_shuju_chuli varchar(100) t30FankuiShujuChuli String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiShujuChuli())){
            queryWrapper.eq("t30_fankui_shuju_chuli", v29V30Entity.getT30FankuiShujuChuli());
        }
        //反馈结果量(条) t30_fankui_jieguoliang_tiao varchar(100) t30FankuiJieguoliangTiao String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiJieguoliangTiao())){
            queryWrapper.eq("t30_fankui_jieguoliang_tiao", v29V30Entity.getT30FankuiJieguoliangTiao());
        }
        //反馈结果量(人) t30_fankui_jieguoliang_ren varchar(100) t30FankuiJieguoliangRen String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiJieguoliangRen())){
            queryWrapper.eq("t30_fankui_jieguoliang_ren", v29V30Entity.getT30FankuiJieguoliangRen());
        }
        //反馈单位 t30_fankui_dangwei varchar(100) t30FankuiDangwei String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiDangwei())){
            queryWrapper.eq("t30_fankui_dangwei", v29V30Entity.getT30FankuiDangwei());
        }
        //反馈组织 t30_fankui_zhuzhi varchar(100) t30FankuiZhuzhi String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiZhuzhi())){
            queryWrapper.eq("t30_fankui_zhuzhi", v29V30Entity.getT30FankuiZhuzhi());
        }
        //反馈意见 t30_fankui_yijian varchar(500) t30FankuiYijian String
        if(StringUtils.isNotBlank(v29V30Entity.getT30FankuiYijian())){
            queryWrapper.eq("t30_fankui_yijian", v29V30Entity.getT30FankuiYijian());
        }
        //创建时间 t30_create_time char(19) t30CreateTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT30CreateTime())){
            queryWrapper.eq("t30_create_time", v29V30Entity.getT30CreateTime());
        }
        //更新时间 t30_update_time char(19) t30UpdateTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT30UpdateTime())){
            queryWrapper.eq("t30_update_time", v29V30Entity.getT30UpdateTime());
        }
        if(v29V30Entity.getT29TuisongUserId() != null){
            queryWrapper.eq("t29_tuisong_user_id", v29V30Entity.getT29TuisongUserId());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongUserName())){
            queryWrapper.eq("t29_tuisong_user_name", v29V30Entity.getT29TuisongUserName());
        }
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongUserMobile())){
            queryWrapper.eq("t29_tuisong_user_mobile", v29V30Entity.getT29TuisongUserMobile());
        }
        //编号 t29_tuisong_org_id bigint(20) t29TuisongOrgId Long
        if(v29V30Entity.getT29TuisongOrgId() != null){
            queryWrapper.eq("t29_tuisong_org_id", v29V30Entity.getT29TuisongOrgId());
        }
        //机构名称 t29_tuisong_org_name varchar(64) t29TuisongOrgName String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongOrgName())){
            queryWrapper.eq("t29_tuisong_org_name", v29V30Entity.getT29TuisongOrgName());
        }
        //机构类型 t29_tuisong_org_type varchar(64) t29TuisongOrgType String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongOrgType())){
            queryWrapper.eq("t29_tuisong_org_type", v29V30Entity.getT29TuisongOrgType());
        }
        //推送意见 t29_tuisong_comment varchar(2000) t29TuisongComment String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongComment())){
            queryWrapper.eq("t29_tuisong_comment", v29V30Entity.getT29TuisongComment());
        }
        //推送时间 t29_tuisong_time varchar(200) t29TuisongTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongTime())){
            queryWrapper.eq("t29_tuisong_time", v29V30Entity.getT29TuisongTime());
        }
        //推送服务主题 t29_tuisong_title varchar(500) t29TuisongTitle String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongTitle())){
            queryWrapper.eq("t29_tuisong_title", v29V30Entity.getT29TuisongTitle());
        }
        //推送服务内容 t29_tuisong_content varchar(2000) t29TuisongContent String
        if(StringUtils.isNotBlank(v29V30Entity.getT29TuisongContent())){
            queryWrapper.eq("t29_tuisong_content", v29V30Entity.getT29TuisongContent());
        }
        //需求主题 t29_xuqiuzhuti varchar(500) t29Xuqiuzhuti String
        if(StringUtils.isNotBlank(v29V30Entity.getT29Xuqiuzhuti())){
            queryWrapper.eq("t29_xuqiuzhuti", v29V30Entity.getT29Xuqiuzhuti());
        }
        //期号 t29_qh bigint(20) t29Qh Long
        if(v29V30Entity.getT29Qh() != null){
            queryWrapper.eq("t29_qh", v29V30Entity.getT29Qh());
        }
        //年份 t29_nf varchar(20) t29Nf String
        if(StringUtils.isNotBlank(v29V30Entity.getT29Nf())){
            queryWrapper.eq("t29_nf", v29V30Entity.getT29Nf());
        }
        //当前状态：待补充,已推送 t29_sjhc_status varchar(100) t29SjhcStatus String
        if(StringUtils.isNotBlank(v29V30Entity.getT29SjhcStatus())){
            queryWrapper.eq("t29_sjhc_status", v29V30Entity.getT29SjhcStatus());
        }
        //联系人 t29_lxr varchar(100) t29Lxr String
        if(StringUtils.isNotBlank(v29V30Entity.getT29Lxr())){
            queryWrapper.eq("t29_lxr", v29V30Entity.getT29Lxr());
        }
        //联系人电话 t29_lxr_mobile varchar(100) t29LxrMobile String
        if(StringUtils.isNotBlank(v29V30Entity.getT29LxrMobile())){
            queryWrapper.eq("t29_lxr_mobile", v29V30Entity.getT29LxrMobile());
        }
        //紧急程度 t29_sjhc_requirement varchar(100) t29SjhcRequirement String
        if(StringUtils.isNotBlank(v29V30Entity.getT29SjhcRequirement())){
            queryWrapper.eq("t29_sjhc_requirement", v29V30Entity.getT29SjhcRequirement());
        }
        //服务单号 t29_service_no varchar(200) t29ServiceNo String
        if(StringUtils.isNotBlank(v29V30Entity.getT29ServiceNo())){
            queryWrapper.eq("t29_service_no", v29V30Entity.getT29ServiceNo());
        }
        //类型 t29_sjhc_type varchar(500) t29SjhcType String
        if(StringUtils.isNotBlank(v29V30Entity.getT29SjhcType())){
            queryWrapper.eq("t29_sjhc_type", v29V30Entity.getT29SjhcType());
        }
        //附件ids t29_attachment_ids varchar(500) t29AttachmentIds String
        if(StringUtils.isNotBlank(v29V30Entity.getT29AttachmentIds())){
            queryWrapper.eq("t29_attachment_ids", v29V30Entity.getT29AttachmentIds());
        }
        //创建时间 t29_create_time char(19) t29CreateTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT29CreateTime())){
            queryWrapper.eq("t29_create_time", v29V30Entity.getT29CreateTime());
        }
        //更新时间 t29_update_time char(19) t29UpdateTime String
        if(StringUtils.isNotBlank(v29V30Entity.getT29UpdateTime())){
            queryWrapper.eq("t29_update_time", v29V30Entity.getT29UpdateTime());
        }
        return queryWrapper;
    }

}
