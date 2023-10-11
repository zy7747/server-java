package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.dict.DictSaveDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.vo.dict.DictDetailVO;
import com.example.system.dal.vo.dict.DictExportVO;
import com.example.system.dal.vo.dict.DictListVO;
import com.example.system.dal.vo.dict.DictPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-11T11:21:34+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class DictConvertImpl implements DictConvert {

    @Override
    public PageList<DictPageVO> page(PageList<DictEntity> dict) {
        if ( dict == null ) {
            return null;
        }

        PageList<DictPageVO> pageList = new PageList<DictPageVO>();

        pageList.setPage( dict.getPage() );
        pageList.setTotal( dict.getTotal() );
        pageList.setSize( dict.getSize() );
        pageList.setList( dictEntityListToDictPageVOList( dict.getList() ) );

        return pageList;
    }

    @Override
    public List<DictListVO> list(List<DictEntity> dict) {
        if ( dict == null ) {
            return null;
        }

        List<DictListVO> list = new ArrayList<DictListVO>( dict.size() );
        for ( DictEntity dictEntity : dict ) {
            list.add( dictEntityToDictListVO( dictEntity ) );
        }

        return list;
    }

    @Override
    public List<DictListVO> dictList(List<DictEntity> dict) {
        if ( dict == null ) {
            return null;
        }

        List<DictListVO> list = new ArrayList<DictListVO>( dict.size() );
        for ( DictEntity dictEntity : dict ) {
            list.add( dictEntityToDictListVO( dictEntity ) );
        }

        return list;
    }

    @Override
    public DictDetailVO detail(DictEntity dict) {
        if ( dict == null ) {
            return null;
        }

        DictDetailVO dictDetailVO = new DictDetailVO();

        dictDetailVO.setId( dict.getId() );
        dictDetailVO.setStatus( dict.getStatus() );
        dictDetailVO.setRemark( dict.getRemark() );
        dictDetailVO.setCreator( dict.getCreator() );
        dictDetailVO.setUpdater( dict.getUpdater() );
        dictDetailVO.setCreateTime( dict.getCreateTime() );
        dictDetailVO.setUpdateTime( dict.getUpdateTime() );
        dictDetailVO.setIsDeleted( dict.getIsDeleted() );
        dictDetailVO.setTenantId( dict.getTenantId() );
        dictDetailVO.setVersion( dict.getVersion() );
        dictDetailVO.setParentId( dict.getParentId() );
        dictDetailVO.setDictName( dict.getDictName() );
        dictDetailVO.setDictCode( dict.getDictCode() );
        dictDetailVO.setDictType( dict.getDictType() );
        dictDetailVO.setLabel( dict.getLabel() );
        dictDetailVO.setValue( dict.getValue() );
        dictDetailVO.setColor( dict.getColor() );
        dictDetailVO.setCss( dict.getCss() );
        dictDetailVO.setSort( dict.getSort() );
        dictDetailVO.setParams( dict.getParams() );

        return dictDetailVO;
    }

    @Override
    public List<DictEntity> saveList(List<DictSaveDTO> dict) {
        if ( dict == null ) {
            return null;
        }

        List<DictEntity> list = new ArrayList<DictEntity>( dict.size() );
        for ( DictSaveDTO dictSaveDTO : dict ) {
            list.add( dictSaveDTOToDictEntity( dictSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<DictExportVO> export(List<DictEntity> dict) {
        if ( dict == null ) {
            return null;
        }

        List<DictExportVO> list = new ArrayList<DictExportVO>( dict.size() );
        for ( DictEntity dictEntity : dict ) {
            list.add( dictEntityToDictExportVO( dictEntity ) );
        }

        return list;
    }

    protected DictPageVO dictEntityToDictPageVO(DictEntity dictEntity) {
        if ( dictEntity == null ) {
            return null;
        }

        DictPageVO dictPageVO = new DictPageVO();

        dictPageVO.setId( dictEntity.getId() );
        dictPageVO.setStatus( dictEntity.getStatus() );
        dictPageVO.setRemark( dictEntity.getRemark() );
        dictPageVO.setCreator( dictEntity.getCreator() );
        dictPageVO.setUpdater( dictEntity.getUpdater() );
        dictPageVO.setCreateTime( dictEntity.getCreateTime() );
        dictPageVO.setUpdateTime( dictEntity.getUpdateTime() );
        dictPageVO.setIsDeleted( dictEntity.getIsDeleted() );
        dictPageVO.setTenantId( dictEntity.getTenantId() );
        dictPageVO.setVersion( dictEntity.getVersion() );
        dictPageVO.setParentId( dictEntity.getParentId() );
        dictPageVO.setDictName( dictEntity.getDictName() );
        dictPageVO.setDictCode( dictEntity.getDictCode() );
        dictPageVO.setDictType( dictEntity.getDictType() );
        dictPageVO.setLabel( dictEntity.getLabel() );
        dictPageVO.setValue( dictEntity.getValue() );
        dictPageVO.setColor( dictEntity.getColor() );
        dictPageVO.setCss( dictEntity.getCss() );
        dictPageVO.setSort( dictEntity.getSort() );
        dictPageVO.setParams( dictEntity.getParams() );

        return dictPageVO;
    }

    protected List<DictPageVO> dictEntityListToDictPageVOList(List<DictEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DictPageVO> list1 = new ArrayList<DictPageVO>( list.size() );
        for ( DictEntity dictEntity : list ) {
            list1.add( dictEntityToDictPageVO( dictEntity ) );
        }

        return list1;
    }

    protected DictListVO dictEntityToDictListVO(DictEntity dictEntity) {
        if ( dictEntity == null ) {
            return null;
        }

        DictListVO dictListVO = new DictListVO();

        dictListVO.setId( dictEntity.getId() );
        dictListVO.setStatus( dictEntity.getStatus() );
        dictListVO.setRemark( dictEntity.getRemark() );
        dictListVO.setCreator( dictEntity.getCreator() );
        dictListVO.setUpdater( dictEntity.getUpdater() );
        dictListVO.setCreateTime( dictEntity.getCreateTime() );
        dictListVO.setUpdateTime( dictEntity.getUpdateTime() );
        dictListVO.setIsDeleted( dictEntity.getIsDeleted() );
        dictListVO.setTenantId( dictEntity.getTenantId() );
        dictListVO.setVersion( dictEntity.getVersion() );
        dictListVO.setParentId( dictEntity.getParentId() );
        dictListVO.setDictName( dictEntity.getDictName() );
        dictListVO.setDictCode( dictEntity.getDictCode() );
        dictListVO.setDictType( dictEntity.getDictType() );
        dictListVO.setLabel( dictEntity.getLabel() );
        dictListVO.setValue( dictEntity.getValue() );
        dictListVO.setColor( dictEntity.getColor() );
        dictListVO.setCss( dictEntity.getCss() );
        dictListVO.setSort( dictEntity.getSort() );
        dictListVO.setParams( dictEntity.getParams() );

        return dictListVO;
    }

    protected DictEntity dictSaveDTOToDictEntity(DictSaveDTO dictSaveDTO) {
        if ( dictSaveDTO == null ) {
            return null;
        }

        DictEntity dictEntity = new DictEntity();

        dictEntity.setId( dictSaveDTO.getId() );
        dictEntity.setStatus( dictSaveDTO.getStatus() );
        dictEntity.setRemark( dictSaveDTO.getRemark() );
        dictEntity.setCreator( dictSaveDTO.getCreator() );
        dictEntity.setUpdater( dictSaveDTO.getUpdater() );
        dictEntity.setCreateTime( dictSaveDTO.getCreateTime() );
        dictEntity.setUpdateTime( dictSaveDTO.getUpdateTime() );
        dictEntity.setIsDeleted( dictSaveDTO.getIsDeleted() );
        dictEntity.setTenantId( dictSaveDTO.getTenantId() );
        dictEntity.setVersion( dictSaveDTO.getVersion() );
        dictEntity.setParentId( dictSaveDTO.getParentId() );
        dictEntity.setDictName( dictSaveDTO.getDictName() );
        dictEntity.setDictCode( dictSaveDTO.getDictCode() );
        dictEntity.setDictType( dictSaveDTO.getDictType() );
        dictEntity.setLabel( dictSaveDTO.getLabel() );
        dictEntity.setValue( dictSaveDTO.getValue() );
        dictEntity.setColor( dictSaveDTO.getColor() );
        dictEntity.setCss( dictSaveDTO.getCss() );
        dictEntity.setSort( dictSaveDTO.getSort() );
        dictEntity.setParams( dictSaveDTO.getParams() );

        return dictEntity;
    }

    protected DictExportVO dictEntityToDictExportVO(DictEntity dictEntity) {
        if ( dictEntity == null ) {
            return null;
        }

        DictExportVO dictExportVO = new DictExportVO();

        dictExportVO.setId( dictEntity.getId() );
        dictExportVO.setStatus( dictEntity.getStatus() );
        dictExportVO.setRemark( dictEntity.getRemark() );
        dictExportVO.setCreator( dictEntity.getCreator() );
        dictExportVO.setUpdater( dictEntity.getUpdater() );
        dictExportVO.setCreateTime( dictEntity.getCreateTime() );
        dictExportVO.setUpdateTime( dictEntity.getUpdateTime() );
        dictExportVO.setIsDeleted( dictEntity.getIsDeleted() );
        dictExportVO.setParentId( dictEntity.getParentId() );
        dictExportVO.setDictName( dictEntity.getDictName() );
        dictExportVO.setDictCode( dictEntity.getDictCode() );
        dictExportVO.setDictType( dictEntity.getDictType() );
        dictExportVO.setLabel( dictEntity.getLabel() );
        dictExportVO.setValue( dictEntity.getValue() );
        dictExportVO.setColor( dictEntity.getColor() );
        dictExportVO.setCss( dictEntity.getCss() );
        dictExportVO.setSort( dictEntity.getSort() );
        dictExportVO.setParams( dictEntity.getParams() );

        return dictExportVO;
    }
}
