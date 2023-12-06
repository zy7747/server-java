package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.pay.PayQueryDTO;
import com.example.system.dal.entity.PayEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper extends BaseMapper<PayEntity> {
    default QueryWrapper<PayEntity> search(PayQueryDTO pay) {
        QueryWrapper<PayEntity> wrapper = new QueryWrapper<>();

        /* 支付功能 */
        if (!StrUtil.hasBlank(pay.getPayment())) {
            wrapper.eq("payment", pay.getPayment());
        }
        /* 支付方式 */
        if (!StrUtil.hasBlank(pay.getPayWay())) {
            wrapper.eq("pay_way", pay.getPayWay());
        }
        /* 支付银行卡/支付宝/微信号 */
        if (!StrUtil.hasBlank(pay.getCardNum())) {
            wrapper.eq("card_num", pay.getCardNum());
        }
        /* 货币 */
        if (!StrUtil.hasBlank(pay.getCurrency())) {
            wrapper.eq("currency", pay.getCurrency());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(pay.getStatus())) {
            wrapper.eq("status", pay.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(pay.getRemark())) {
            wrapper.eq("remark", pay.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(pay.getCreator())) {
            wrapper.eq("creator", pay.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(pay.getUpdater())) {
            wrapper.eq("updater", pay.getUpdater());
        }

        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<PayEntity> selectPageList(PayQueryDTO pay) {
        IPage<PayEntity> pageParams = new Page<>(pay.getPage(), pay.getSize());
        return PageList.setPages(selectPage(pageParams, search(pay)));
    }

    /**
     * 列表查询
     */
    default List<PayEntity> selectList(PayQueryDTO pay) {
        return selectList(search(pay));
    }
}