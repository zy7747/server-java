package com.example.pay.convert;

import com.example.framework.common.PageList;
import com.example.pay.dal.dto.pay.PaySaveDTO;
import com.example.pay.dal.vo.pay.PayPageVO;
import com.example.pay.dal.entity.PayEntity;
import com.example.pay.dal.vo.pay.PayDetailVO;
import com.example.pay.dal.vo.pay.PayExportVO;
import com.example.pay.dal.vo.pay.PayListVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PayConvert {
    PayConvert INSTANCE = Mappers.getMapper(PayConvert.class);

    PageList<PayPageVO> page(PageList<PayEntity> pays);

    List<PayListVO> list(List<PayEntity> pays);

    PayDetailVO detail(PayEntity pays);

    List<PayEntity> saveList(List<PaySaveDTO> pays);

    List<PayExportVO> export(List<PayEntity> pays);

    List<PaySaveDTO> imports(List<PayExportVO> pays);
}