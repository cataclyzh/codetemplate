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
 * 排班信息
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t01_scheduling")
@ApiModel(value = "T01SchedulingEntity对象", description = "排班信息")
public class T01SchedulingEntity extends Model<T01SchedulingEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "值班人id")
    private Long dutyPersonId;

    @ApiModelProperty(value = "值班人名称")
    private String dutyPersonName;

    @ApiModelProperty(value = "值班人电话")
    private String dutyPersonPhone;

    @ApiModelProperty(value = "值班人警号")
    private String dutyPersonNo;

    @ApiModelProperty(value = "排班日期 2021-06-08")
    private String schedulingDay;

    @ApiModelProperty(value = "上下午标志")
    private Integer schedulingAm;

    @ApiModelProperty(value = "地市编号 0: 省厅")
    private String cityNo;

    @ApiModelProperty(value = "岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗")
    private String schedulingType;

    @ApiModelProperty(value = "排班状态(scheduling_status) 未开始, 值班中, 值班结束")
    private String schedulingStatus;

    @ApiModelProperty(value = "结束标志 0 未结束 1 结束")
    private String schedulingFinishFlag;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
