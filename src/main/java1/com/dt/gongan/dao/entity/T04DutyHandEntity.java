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
 * 交班记录
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t04_duty_hand")
@ApiModel(value = "T04DutyHandEntity对象", description = "交班记录")
public class T04DutyHandEntity extends Model<T04DutyHandEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long orgId;

    @ApiModelProperty(value = "排班id")
    private Long t01SchedulingId;

    @ApiModelProperty(value = "值班人id")
    private Long dutyPersonId;

    @ApiModelProperty(value = "值班人名称")
    private String dutyPersonName;

    @ApiModelProperty(value = "值班人电话")
    private String dutyPersonPhone;

    @ApiModelProperty(value = "值班人警号")
    private String dutyPersonNo;

    @ApiModelProperty(value = "交班人id")
    private Long handPersonId;

    @ApiModelProperty(value = "交班人名称")
    private String handPersonName;

    @ApiModelProperty(value = "交班人电话")
    private String handPersonPhone;

    @ApiModelProperty(value = "交班人警号")
    private String handPersonNo;

    @ApiModelProperty(value = "值班信息")
    private String dutyMessage;

    @ApiModelProperty(value = "交班状态,0:未确认,1:确认")
    private String dutyStatus;

    @ApiModelProperty(value = "值班时间")
    private String dutyTime;

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
