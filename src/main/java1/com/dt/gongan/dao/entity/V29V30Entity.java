package com.dt.gongan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("v29_v30")
@ApiModel(value = "V29V30Entity对象", description = "VIEW")
public class V29V30Entity extends Model<V29V30Entity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Long id;

    @ApiModelProperty(value = "自增id")
    private Long t30Id;

    @ApiModelProperty(value = "数据核查令id")
    private Long t29Id;

    @ApiModelProperty(value = "推送到的部门id")
    private Long t30OrgId;

    @ApiModelProperty(value = "机构名称")
    private String t30OrgName;

    private Long t30SignUserId;

    private String t30SignUserName;

    private String t30SignUserMobile;

    @ApiModelProperty(value = "编号")
    private Long t30SignOrgId;

    @ApiModelProperty(value = "机构名称")
    private String t30SignOrgName;

    @ApiModelProperty(value = "机构类型")
    private String t30SignOrgType;

    private Long t30FankuiUserId;

    private String t30FankuiUserName;

    private String t30FankuiUserMobile;

    @ApiModelProperty(value = "编号")
    private Long t30FankuiOrgId;

    @ApiModelProperty(value = "机构名称")
    private String t30FankuiOrgName;

    @ApiModelProperty(value = "机构类型")
    private String t30FankuiOrgType;

    private Long t30TuisongUserId;

    private String t30TuisongUserName;

    private String t30TuisongUserMobile;

    @ApiModelProperty(value = "编号")
    private Long t30TuisongOrgId;

    @ApiModelProperty(value = "机构名称")
    private String t30TuisongOrgName;

    @ApiModelProperty(value = "机构类型")
    private String t30TuisongOrgType;

    @ApiModelProperty(value = "当前状态,待签收、待反馈、完结")
    private String t30SjhcStatus;

    @ApiModelProperty(value = "推送意见")
    private String t30TuisongComment;

    @ApiModelProperty(value = "推送时间")
    private String t30TuisongTime;

    @ApiModelProperty(value = "推送签收时间")
    private String t30TuisongSignTime;

    @ApiModelProperty(value = "签收结果（0签收）")
    private String t30SignStatus;

    @ApiModelProperty(value = "反馈时间")
    private String t30FankuiTime;

    @ApiModelProperty(value = "反馈附件ids")
    private String t30FankuiAttachementIds;

    @ApiModelProperty(value = "签收意见")
    private String t30TurnSignComment;

    @ApiModelProperty(value = "联系人")
    private String t30ContactName;

    @ApiModelProperty(value = "联系电话")
    private String t30ContactMobile;

    @ApiModelProperty(value = "紧急程度")
    private String t30SjhcRequirement;

    @ApiModelProperty(value = "反馈核稿人")
    private String t30FankuiHegaoName;

    @ApiModelProperty(value = "反馈签发人")
    private String t30FankuiQianfaName;

    @ApiModelProperty(value = "反馈数据处理")
    private String t30FankuiShujuChuli;

    @ApiModelProperty(value = "反馈结果量(条)")
    private String t30FankuiJieguoliangTiao;

    @ApiModelProperty(value = "反馈结果量(人)")
    private String t30FankuiJieguoliangRen;

    @ApiModelProperty(value = "反馈单位")
    private String t30FankuiDangwei;

    @ApiModelProperty(value = "反馈组织")
    private String t30FankuiZhuzhi;

    @ApiModelProperty(value = "反馈意见")
    private String t30FankuiYijian;

    @ApiModelProperty(value = "创建时间")
    private String t30CreateTime;

    @ApiModelProperty(value = "更新时间")
    private String t30UpdateTime;

    private Long t29TuisongUserId;

    private String t29TuisongUserName;

    private String t29TuisongUserMobile;

    @ApiModelProperty(value = "编号")
    private Long t29TuisongOrgId;

    @ApiModelProperty(value = "机构名称")
    private String t29TuisongOrgName;

    @ApiModelProperty(value = "机构类型")
    private String t29TuisongOrgType;

    @ApiModelProperty(value = "推送意见")
    private String t29TuisongComment;

    @ApiModelProperty(value = "推送时间")
    private String t29TuisongTime;

    @ApiModelProperty(value = "推送服务主题")
    private String t29TuisongTitle;

    @ApiModelProperty(value = "推送服务内容")
    private String t29TuisongContent;

    @ApiModelProperty(value = "需求主题")
    private String t29Xuqiuzhuti;

    @ApiModelProperty(value = "期号")
    private Long t29Qh;

    @ApiModelProperty(value = "年份")
    private String t29Nf;

    @ApiModelProperty(value = "当前状态：待补充,已推送")
    private String t29SjhcStatus;

    @ApiModelProperty(value = "联系人")
    private String t29Lxr;

    @ApiModelProperty(value = "联系人电话")
    private String t29LxrMobile;

    @ApiModelProperty(value = "紧急程度")
    private String t29SjhcRequirement;

    @ApiModelProperty(value = "服务单号")
    private String t29ServiceNo;

    @ApiModelProperty(value = "类型")
    private String t29SjhcType;

    @ApiModelProperty(value = "附件ids")
    private String t29AttachmentIds;

    @ApiModelProperty(value = "创建时间")
    private String t29CreateTime;

    @ApiModelProperty(value = "更新时间")
    private String t29UpdateTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
