package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.pay.PaySaveDTO;
import com.example.system.dal.entity.PayEntity;
import com.example.system.dal.vo.pay.PayDetailVO;
import com.example.system.dal.vo.pay.PayExportVO;
import com.example.system.dal.vo.pay.PayListVO;
import com.example.system.dal.vo.pay.PayPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T22:09:28+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class PayConvertImpl implements PayConvert {

    @Override
    public PageList<PayPageVO> page(PageList<PayEntity> pays) {
        if ( pays == null ) {
            return null;
        }

        PageList<PayPageVO> pageList = new PageList<PayPageVO>();

        pageList.setPage( pays.getPage() );
        pageList.setTotal( pays.getTotal() );
        pageList.setSize( pays.getSize() );
        pageList.setList( payEntityListToPayPageVOList( pays.getList() ) );

        return pageList;
    }

    @Override
    public List<PayListVO> list(List<PayEntity> pays) {
        if ( pays == null ) {
            return null;
        }

        List<PayListVO> list = new ArrayList<PayListVO>( pays.size() );
        for ( PayEntity payEntity : pays ) {
            list.add( payEntityToPayListVO( payEntity ) );
        }

        return list;
    }

    @Override
    public PayDetailVO detail(PayEntity pays) {
        if ( pays == null ) {
            return null;
        }

        PayDetailVO payDetailVO = new PayDetailVO();

        payDetailVO.setId( pays.getId() );
        payDetailVO.setStatus( pays.getStatus() );
        payDetailVO.setRemark( pays.getRemark() );
        payDetailVO.setCreator( pays.getCreator() );
        payDetailVO.setUpdater( pays.getUpdater() );
        payDetailVO.setCreateTime( pays.getCreateTime() );
        payDetailVO.setUpdateTime( pays.getUpdateTime() );
        payDetailVO.setIsDeleted( pays.getIsDeleted() );
        payDetailVO.setTenantId( pays.getTenantId() );
        payDetailVO.setVersion( pays.getVersion() );
        payDetailVO.setOrderId( pays.getOrderId() );
        payDetailVO.setPayment( pays.getPayment() );
        payDetailVO.setPayWay( pays.getPayWay() );
        payDetailVO.setCardNum( pays.getCardNum() );
        payDetailVO.setPayUser( pays.getPayUser() );
        payDetailVO.setPayNum( pays.getPayNum() );
        payDetailVO.setPayTime( pays.getPayTime() );
        payDetailVO.setCurrency( pays.getCurrency() );

        return payDetailVO;
    }

    @Override
    public List<PayEntity> saveList(List<PaySaveDTO> pays) {
        if ( pays == null ) {
            return null;
        }

        List<PayEntity> list = new ArrayList<PayEntity>( pays.size() );
        for ( PaySaveDTO paySaveDTO : pays ) {
            list.add( paySaveDTOToPayEntity( paySaveDTO ) );
        }

        return list;
    }

    @Override
    public List<PayExportVO> export(List<PayEntity> pays) {
        if ( pays == null ) {
            return null;
        }

        List<PayExportVO> list = new ArrayList<PayExportVO>( pays.size() );
        for ( PayEntity payEntity : pays ) {
            list.add( payEntityToPayExportVO( payEntity ) );
        }

        return list;
    }

    @Override
    public List<PaySaveDTO> imports(List<PayExportVO> pays) {
        if ( pays == null ) {
            return null;
        }

        List<PaySaveDTO> list = new ArrayList<PaySaveDTO>( pays.size() );
        for ( PayExportVO payExportVO : pays ) {
            list.add( payExportVOToPaySaveDTO( payExportVO ) );
        }

        return list;
    }

    protected PayPageVO payEntityToPayPageVO(PayEntity payEntity) {
        if ( payEntity == null ) {
            return null;
        }

        PayPageVO payPageVO = new PayPageVO();

        payPageVO.setId( payEntity.getId() );
        payPageVO.setStatus( payEntity.getStatus() );
        payPageVO.setRemark( payEntity.getRemark() );
        payPageVO.setCreator( payEntity.getCreator() );
        payPageVO.setUpdater( payEntity.getUpdater() );
        payPageVO.setCreateTime( payEntity.getCreateTime() );
        payPageVO.setUpdateTime( payEntity.getUpdateTime() );
        payPageVO.setIsDeleted( payEntity.getIsDeleted() );
        payPageVO.setTenantId( payEntity.getTenantId() );
        payPageVO.setVersion( payEntity.getVersion() );
        payPageVO.setOrderId( payEntity.getOrderId() );
        payPageVO.setPayment( payEntity.getPayment() );
        payPageVO.setPayWay( payEntity.getPayWay() );
        payPageVO.setCardNum( payEntity.getCardNum() );
        payPageVO.setPayUser( payEntity.getPayUser() );
        payPageVO.setPayNum( payEntity.getPayNum() );
        payPageVO.setPayTime( payEntity.getPayTime() );
        payPageVO.setCurrency( payEntity.getCurrency() );

        return payPageVO;
    }

    protected List<PayPageVO> payEntityListToPayPageVOList(List<PayEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PayPageVO> list1 = new ArrayList<PayPageVO>( list.size() );
        for ( PayEntity payEntity : list ) {
            list1.add( payEntityToPayPageVO( payEntity ) );
        }

        return list1;
    }

    protected PayListVO payEntityToPayListVO(PayEntity payEntity) {
        if ( payEntity == null ) {
            return null;
        }

        PayListVO payListVO = new PayListVO();

        payListVO.setId( payEntity.getId() );
        payListVO.setStatus( payEntity.getStatus() );
        payListVO.setRemark( payEntity.getRemark() );
        payListVO.setCreator( payEntity.getCreator() );
        payListVO.setUpdater( payEntity.getUpdater() );
        payListVO.setCreateTime( payEntity.getCreateTime() );
        payListVO.setUpdateTime( payEntity.getUpdateTime() );
        payListVO.setIsDeleted( payEntity.getIsDeleted() );
        payListVO.setTenantId( payEntity.getTenantId() );
        payListVO.setVersion( payEntity.getVersion() );
        payListVO.setOrderId( payEntity.getOrderId() );
        payListVO.setPayment( payEntity.getPayment() );
        payListVO.setPayWay( payEntity.getPayWay() );
        payListVO.setCardNum( payEntity.getCardNum() );
        payListVO.setPayUser( payEntity.getPayUser() );
        payListVO.setPayNum( payEntity.getPayNum() );
        payListVO.setPayTime( payEntity.getPayTime() );
        payListVO.setCurrency( payEntity.getCurrency() );

        return payListVO;
    }

    protected PayEntity paySaveDTOToPayEntity(PaySaveDTO paySaveDTO) {
        if ( paySaveDTO == null ) {
            return null;
        }

        PayEntity payEntity = new PayEntity();

        payEntity.setId( paySaveDTO.getId() );
        payEntity.setStatus( paySaveDTO.getStatus() );
        payEntity.setRemark( paySaveDTO.getRemark() );
        payEntity.setCreator( paySaveDTO.getCreator() );
        payEntity.setUpdater( paySaveDTO.getUpdater() );
        payEntity.setCreateTime( paySaveDTO.getCreateTime() );
        payEntity.setUpdateTime( paySaveDTO.getUpdateTime() );
        payEntity.setIsDeleted( paySaveDTO.getIsDeleted() );
        payEntity.setTenantId( paySaveDTO.getTenantId() );
        payEntity.setVersion( paySaveDTO.getVersion() );
        payEntity.setOrderId( paySaveDTO.getOrderId() );
        payEntity.setPayment( paySaveDTO.getPayment() );
        payEntity.setPayWay( paySaveDTO.getPayWay() );
        payEntity.setCardNum( paySaveDTO.getCardNum() );
        payEntity.setPayUser( paySaveDTO.getPayUser() );
        payEntity.setPayNum( paySaveDTO.getPayNum() );
        payEntity.setPayTime( paySaveDTO.getPayTime() );
        payEntity.setCurrency( paySaveDTO.getCurrency() );

        return payEntity;
    }

    protected PayExportVO payEntityToPayExportVO(PayEntity payEntity) {
        if ( payEntity == null ) {
            return null;
        }

        PayExportVO payExportVO = new PayExportVO();

        payExportVO.setId( payEntity.getId() );
        payExportVO.setOrderId( payEntity.getOrderId() );
        payExportVO.setPayment( payEntity.getPayment() );
        payExportVO.setPayWay( payEntity.getPayWay() );
        payExportVO.setCardNum( payEntity.getCardNum() );
        payExportVO.setPayUser( payEntity.getPayUser() );
        payExportVO.setPayNum( payEntity.getPayNum() );
        payExportVO.setPayTime( payEntity.getPayTime() );
        payExportVO.setCurrency( payEntity.getCurrency() );

        return payExportVO;
    }

    protected PaySaveDTO payExportVOToPaySaveDTO(PayExportVO payExportVO) {
        if ( payExportVO == null ) {
            return null;
        }

        PaySaveDTO paySaveDTO = new PaySaveDTO();

        paySaveDTO.setId( payExportVO.getId() );
        paySaveDTO.setOrderId( payExportVO.getOrderId() );
        paySaveDTO.setPayment( payExportVO.getPayment() );
        paySaveDTO.setPayWay( payExportVO.getPayWay() );
        paySaveDTO.setCardNum( payExportVO.getCardNum() );
        paySaveDTO.setPayUser( payExportVO.getPayUser() );
        paySaveDTO.setPayNum( payExportVO.getPayNum() );
        paySaveDTO.setPayTime( payExportVO.getPayTime() );
        paySaveDTO.setCurrency( payExportVO.getCurrency() );

        return paySaveDTO;
    }
}
