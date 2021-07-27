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
@TableName("v_user")
@ApiModel(value = "VUserEntity对象", description = "VIEW")
public class VUserEntity extends Model<VUserEntity> {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String mobile;

    @ApiModelProperty(value = "编号")
    private Long orgId;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构类型")
    private String orgType;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
