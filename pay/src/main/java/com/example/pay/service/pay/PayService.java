package com.example.pay.service.pay;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.pay.dal.dto.pay.PayQueryDTO;
import com.example.pay.dal.dto.pay.PaySaveDTO;
import com.example.pay.dal.entity.PayEntity;
import com.example.pay.dal.vo.pay.PayDetailVO;
import com.example.pay.dal.vo.pay.PayListVO;
import com.example.pay.dal.vo.pay.PayPageVO;

import java.util.List;

public interface PayService {
    /**
     * 获取列表分页
     *
     * @param pay 分页入参
     * @return 列表分页
     */
    Result<PageList<PayPageVO>> payPageService(PayQueryDTO pay);

    /**
     * 获取列表
     *
     * @param pay 入参
     * @return 列表
     */
    Result<List<PayListVO>> payListService(PayQueryDTO pay);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<PayDetailVO> payDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param pay 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<PayEntity>> paySaveListService(List<PaySaveDTO> pay);
}