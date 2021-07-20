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
 * @since 2021-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("v01_test1")
@ApiModel(value = "V01Test1Entity对象", description = "VIEW")
public class V01Test1Entity extends Model<V01Test1Entity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "值班人id")
    private Long dutyPersonId;

    @ApiModelProperty(value = "岗位类型(scheduling_type) 值班领导 1号岗 2号岗 3号岗")
    private String schedulingType;

    @ApiModelProperty(value = "地市编号 0: 省厅")
    private String cityNo;

    private String name;

    private String mobile;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
