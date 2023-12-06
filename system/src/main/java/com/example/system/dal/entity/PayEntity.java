package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName(value = "pay")
@ApiModel(value = "支付功能")
@EqualsAndHashCode(callSuper = true)
public class PayEntity extends BaseParamsEntity {

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    /**
     * 支付功能
     */
    @ApiModelProperty(value = "支付功能")
    private String payment;
    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String payWay;
    /**
     * 支付银行卡/支付宝/微信号
     */
    @ApiModelProperty(value = "支付银行卡/支付宝/微信号")
    private String cardNum;
    /**
     * 支付用户
     */
    @ApiModelProperty(value = "支付用户")
    private Long payUser;
    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    private Double payNum;
    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    private Date payTime;
    /**
     * 货币
     */
    @ApiModelProperty(value = "货币")
    private String currency;

}