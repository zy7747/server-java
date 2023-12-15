package com.example.pay.dal.vo.pay;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "导出")
public class PayExportVO {
    /**
     * id
     */
    @ExcelProperty("id")
    private Long id;
    /**
     * 订单ID
     */
    @ExcelProperty("订单ID")
    private Long orderId;
    /**
     * 支付功能
     */
    @ExcelProperty("支付功能")
    private String payment;
    /**
     * 支付方式
     */
    @ExcelProperty("支付方式")
    private String payWay;
    /**
     * 支付银行卡/支付宝/微信号
     */
    @ExcelProperty("支付银行卡/支付宝/微信号")
    private String cardNum;
    /**
     * 支付用户
     */
    @ExcelProperty("支付用户")
    private Long payUser;
    /**
     * 支付金额
     */
    @ExcelProperty("支付金额")
    private Double payNum;
    /**
     * 支付时间
     */
    @ExcelProperty("支付时间")
    private Date payTime;
    /**
     * 货币
     */
    @ExcelProperty("货币")
    private String currency;

}