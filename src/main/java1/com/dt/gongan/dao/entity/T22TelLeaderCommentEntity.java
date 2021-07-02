package com.dt.gongan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 电话申请的领导批示
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t22_tel_leader_comment")
@ApiModel(value = "T22TelLeaderCommentEntity对象", description = "电话申请的领导批示")
public class T22TelLeaderCommentEntity extends Model<T22TelLeaderCommentEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "电话数据服务申请单id")
    private Long t19Id;

    @ApiModelProperty(value = "反馈人ID")
    private Long leadUserId;

    @ApiModelProperty(value = "反馈人姓名")
    private String leadUserName;

    @ApiModelProperty(value = "反馈人警号")
    private String leadUserNo;

    @ApiModelProperty(value = "反馈人电话")
    private String leadUserPhone;

    @ApiModelProperty(value = "反馈部门ID")
    private Long leadOrgId;

    @ApiModelProperty(value = "反馈部门")
    private String leadOrgName;

    @ApiModelProperty(value = "反馈意见")
    private String leadComment;

    @ApiModelProperty(value = "反馈时间")
    private String leadCommentTime;

    @ApiModelProperty(value = "反馈附件ids")
    private String leadAttachementIds;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
