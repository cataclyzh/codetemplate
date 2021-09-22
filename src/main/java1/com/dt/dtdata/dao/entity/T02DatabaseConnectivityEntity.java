package com.dt.dtdata.dao.entity;

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
 * 
 * </p>
 *
 * @author 铠甲
 * @since 2021-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t02_database_connectivity")
@ApiModel(value = "T02DatabaseConnectivityEntity对象", description = "")
public class T02DatabaseConnectivityEntity extends Model<T02DatabaseConnectivityEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "数据库id")
    private Long databaseId;

    @ApiModelProperty(value = "可连接标志, 0:可连接, 1:不可连接")
    private Integer connFlag;

    @ApiModelProperty(value = "记录时间点")
    private String createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
