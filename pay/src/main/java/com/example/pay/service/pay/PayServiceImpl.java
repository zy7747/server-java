package com.example.pay.service.pay;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.pay.convert.PayConvert;
import com.example.pay.dal.dto.pay.PayQueryDTO;
import com.example.pay.dal.dto.pay.PaySaveDTO;
import com.example.pay.dal.entity.PayEntity;
import com.example.pay.mapper.PayMapper;
import com.example.pay.dal.vo.pay.PayDetailVO;
import com.example.pay.dal.vo.pay.PayListVO;
import com.example.pay.dal.vo.pay.PayPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, PayEntity> implements PayService {
    @Resource
    PayMapper payMapper;

    /**
     * 获取列表分页
     *
     * @param pay 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<PayPageVO>> payPageService(PayQueryDTO pay) {
        return Result.success(PayConvert.INSTANCE.page(payMapper.selectPageList(pay)));
    }

    /**
     * 获取列表
     *
     * @param pay 入参
     * @return 列表
     */
    @Override
    public Result<List<PayListVO>> payListService(PayQueryDTO pay) {
        return Result.success(PayConvert.INSTANCE.list(payMapper.selectList(pay)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<PayDetailVO> payDetailService(Long id) {
        return Result.success(PayConvert.INSTANCE.detail(payMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param pay 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<PayEntity>> paySaveListService(List<PaySaveDTO> pay) {
        List<PayEntity> payList = PayConvert.INSTANCE.saveList(pay);
        this.saveOrUpdateBatch(payList);
        return Result.success(payList);
    }
}