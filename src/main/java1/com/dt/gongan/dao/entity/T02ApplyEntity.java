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
 * 申请记录
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t02_apply")
@ApiModel(value = "T02ApplyEntity对象", description = "申请记录")
public class T02ApplyEntity extends Model<T02ApplyEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申请单号")
    private String applyNo;

    @ApiModelProperty(value = "申请人id")
    private Long applyPersonId;

    @ApiModelProperty(value = "申请人名称")
    private String applyPersonName;

    @ApiModelProperty(value = "申请人电话")
    private String applyPersonPhone;

    @ApiModelProperty(value = "申请人警号")
    private String applyPersonNo;

    @ApiModelProperty(value = "值班人id")
    private Long dutyPersonId;

    @ApiModelProperty(value = "值班人名称")
    private String dutyPersonName;

    @ApiModelProperty(value = "值班人电话")
    private String dutyPersonPhone;

    @ApiModelProperty(value = "值班人警号")
    private String dutyPersonNo;

    @ApiModelProperty(value = "处理人id")
    private Long handlePersonId;

    @ApiModelProperty(value = "处理人名称")
    private String handlePersonName;

    @ApiModelProperty(value = "处理人电话")
    private String handlePersonPhone;

    @ApiModelProperty(value = "处理人警号")
    private String handlePersonNo;

    @ApiModelProperty(value = "需求人员id")
    private Long requirementPersonId;

    @ApiModelProperty(value = "需求人名称")
    private String requirementPersonName;

    @ApiModelProperty(value = "需求人电话")
    private String requirementPersonPhone;

    @ApiModelProperty(value = "需求人警号")
    private String requirementPersonNo;

    @ApiModelProperty(value = "申请主题")
    private String applyTheme;

    @ApiModelProperty(value = "申请内容")
    private String applyMessage;

    @ApiModelProperty(value = "申请类型")
    private String applyType;

    @ApiModelProperty(value = "发布时间")
    private String publishTime;

    @ApiModelProperty(value = "发布备注")
    private String publishComment;

    @ApiModelProperty(value = "处理备注")
    private String processType;

    @ApiModelProperty(value = "处理时间")
    private String processTime;

    @ApiModelProperty(value = "转发备注")
    private String forwardType;

    @ApiModelProperty(value = "转发时间")
    private String forwardTime;

    @ApiModelProperty(value = "当前状态,申请,转发,完结")
    private String applyStatus;

    @ApiModelProperty(value = "申请来源,平台,电话")
    private String applyFrom;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

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
