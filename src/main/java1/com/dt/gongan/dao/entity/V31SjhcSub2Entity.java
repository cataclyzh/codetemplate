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
@TableName("v31_sjhc_sub2")
@ApiModel(value = "V31SjhcSub2Entity对象", description = "VIEW")
public class V31SjhcSub2Entity extends Model<V31SjhcSub2Entity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Long id;

    @ApiModelProperty(value = "t24_sjhc_record id")
    private Long t30Id;

    private Long tuisongUserId;

    private String tuisongUserName;

    private String tuisongUserMobile;

    @ApiModelProperty(value = "编号")
    private Long tuisongOrgId;

    @ApiModelProperty(value = "机构名称")
    private String tuisongOrgName;

    @ApiModelProperty(value = "机构类型")
    private String tuisongOrgType;

    private Long fanhuiUserId;

    private String fanhuiUserName;

    private String fanhuiUserMobile;

    @ApiModelProperty(value = "编号")
    private Long fanhuiOrgId;

    @ApiModelProperty(value = "机构名称")
    private String fanhuiOrgName;

    @ApiModelProperty(value = "机构类型")
    private String fanhuiOrgType;

    @ApiModelProperty(value = "记录所处状态,待处理,返回(后续推送签收使用新增加的记录),反馈")
    private String recordInfoStatus;

    @ApiModelProperty(value = "推送意见")
    private String tuisongComment;

    @ApiModelProperty(value = "推送时间")
    private String tuisongTime;

    @ApiModelProperty(value = "推送附件ids")
    private String tuisongAttachementIds;

    @ApiModelProperty(value = "退回意见")
    private String fanhuiComment;

    @ApiModelProperty(value = "退回时间")
    private String fanhuiTime;

    @ApiModelProperty(value = "退回附件ids")
    private String fanhuiAttachementIds;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
