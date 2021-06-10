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
 * 战果案例填报
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t05_case")
@ApiModel(value = "T05CaseEntity对象", description = "战果案例填报")
public class T05CaseEntity extends Model<T05CaseEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "填报人id")
    private Long personId;

    @ApiModelProperty(value = "填报人名称")
    private String personName;

    @ApiModelProperty(value = "填报人电话")
    private String personPhone;

    @ApiModelProperty(value = "填报人警号")
    private String personNo;

    @ApiModelProperty(value = "标题")
    private String caseTitle;

    @ApiModelProperty(value = "内容")
    private String caseContent;

    @ApiModelProperty(value = "时间")
    private String caseTime;

    @ApiModelProperty(value = "类型,0:重大案例, 1:战果")
    private String caseType;

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
