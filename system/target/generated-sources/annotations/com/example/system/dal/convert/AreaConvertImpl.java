package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.area.AreaSaveDTO;
import com.example.system.dal.entity.AreaEntity;
import com.example.system.dal.vo.area.AreaDetailVO;
import com.example.system.dal.vo.area.AreaExportVO;
import com.example.system.dal.vo.area.AreaListVO;
import com.example.system.dal.vo.area.AreaPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-06T08:03:26+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class AreaConvertImpl implements AreaConvert {

    @Override
    public PageList<AreaPageVO> page(PageList<AreaEntity> areas) {
        if ( areas == null ) {
            return null;
        }

        PageList<AreaPageVO> pageList = new PageList<AreaPageVO>();

        pageList.setPage( areas.getPage() );
        pageList.setTotal( areas.getTotal() );
        pageList.setSize( areas.getSize() );
        pageList.setList( areaEntityListToAreaPageVOList( areas.getList() ) );

        return pageList;
    }

    @Override
    public List<AreaListVO> list(List<AreaEntity> areas) {
        if ( areas == null ) {
            return null;
        }

        List<AreaListVO> list = new ArrayList<AreaListVO>( areas.size() );
        for ( AreaEntity areaEntity : areas ) {
            list.add( areaEntityToAreaListVO( areaEntity ) );
        }

        return list;
    }

    @Override
    public AreaDetailVO detail(AreaEntity areas) {
        if ( areas == null ) {
            return null;
        }

        AreaDetailVO areaDetailVO = new AreaDetailVO();

        areaDetailVO.setId( areas.getId() );
        areaDetailVO.setStatus( areas.getStatus() );
        areaDetailVO.setRemark( areas.getRemark() );
        areaDetailVO.setCreator( areas.getCreator() );
        areaDetailVO.setUpdater( areas.getUpdater() );
        areaDetailVO.setCreateTime( areas.getCreateTime() );
        areaDetailVO.setUpdateTime( areas.getUpdateTime() );
        areaDetailVO.setIsDeleted( areas.getIsDeleted() );
        areaDetailVO.setTenantId( areas.getTenantId() );
        areaDetailVO.setVersion( areas.getVersion() );
        areaDetailVO.setParentId( areas.getParentId() );
        areaDetailVO.setAreaName( areas.getAreaName() );
        areaDetailVO.setAddress( areas.getAddress() );
        areaDetailVO.setOtherName( areas.getOtherName() );
        areaDetailVO.setType( areas.getType() );
        areaDetailVO.setCode( areas.getCode() );
        areaDetailVO.setAxis( areas.getAxis() );
        areaDetailVO.setAcreage( areas.getAcreage() );
        areaDetailVO.setPopulation( areas.getPopulation() );
        areaDetailVO.setClimate( areas.getClimate() );
        areaDetailVO.setCapital( areas.getCapital() );
        areaDetailVO.setSort( areas.getSort() );
        areaDetailVO.setLevel( areas.getLevel() );
        areaDetailVO.setIcon( areas.getIcon() );
        areaDetailVO.setDescription( areas.getDescription() );

        return areaDetailVO;
    }

    @Override
    public List<AreaEntity> saveList(List<AreaSaveDTO> areas) {
        if ( areas == null ) {
            return null;
        }

        List<AreaEntity> list = new ArrayList<AreaEntity>( areas.size() );
        for ( AreaSaveDTO areaSaveDTO : areas ) {
            list.add( areaSaveDTOToAreaEntity( areaSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<AreaExportVO> export(List<AreaEntity> areas) {
        if ( areas == null ) {
            return null;
        }

        List<AreaExportVO> list = new ArrayList<AreaExportVO>( areas.size() );
        for ( AreaEntity areaEntity : areas ) {
            list.add( areaEntityToAreaExportVO( areaEntity ) );
        }

        return list;
    }

    protected AreaPageVO areaEntityToAreaPageVO(AreaEntity areaEntity) {
        if ( areaEntity == null ) {
            return null;
        }

        AreaPageVO areaPageVO = new AreaPageVO();

        areaPageVO.setId( areaEntity.getId() );
        areaPageVO.setStatus( areaEntity.getStatus() );
        areaPageVO.setRemark( areaEntity.getRemark() );
        areaPageVO.setCreator( areaEntity.getCreator() );
        areaPageVO.setUpdater( areaEntity.getUpdater() );
        areaPageVO.setCreateTime( areaEntity.getCreateTime() );
        areaPageVO.setUpdateTime( areaEntity.getUpdateTime() );
        areaPageVO.setIsDeleted( areaEntity.getIsDeleted() );
        areaPageVO.setTenantId( areaEntity.getTenantId() );
        areaPageVO.setVersion( areaEntity.getVersion() );
        areaPageVO.setParentId( areaEntity.getParentId() );
        areaPageVO.setAreaName( areaEntity.getAreaName() );
        areaPageVO.setAddress( areaEntity.getAddress() );
        areaPageVO.setOtherName( areaEntity.getOtherName() );
        areaPageVO.setType( areaEntity.getType() );
        areaPageVO.setCode( areaEntity.getCode() );
        areaPageVO.setAxis( areaEntity.getAxis() );
        areaPageVO.setAcreage( areaEntity.getAcreage() );
        areaPageVO.setPopulation( areaEntity.getPopulation() );
        areaPageVO.setClimate( areaEntity.getClimate() );
        areaPageVO.setCapital( areaEntity.getCapital() );
        areaPageVO.setSort( areaEntity.getSort() );
        areaPageVO.setLevel( areaEntity.getLevel() );
        areaPageVO.setIcon( areaEntity.getIcon() );
        areaPageVO.setDescription( areaEntity.getDescription() );

        return areaPageVO;
    }

    protected List<AreaPageVO> areaEntityListToAreaPageVOList(List<AreaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AreaPageVO> list1 = new ArrayList<AreaPageVO>( list.size() );
        for ( AreaEntity areaEntity : list ) {
            list1.add( areaEntityToAreaPageVO( areaEntity ) );
        }

        return list1;
    }

    protected AreaListVO areaEntityToAreaListVO(AreaEntity areaEntity) {
        if ( areaEntity == null ) {
            return null;
        }

        AreaListVO areaListVO = new AreaListVO();

        areaListVO.setId( areaEntity.getId() );
        areaListVO.setStatus( areaEntity.getStatus() );
        areaListVO.setRemark( areaEntity.getRemark() );
        areaListVO.setCreator( areaEntity.getCreator() );
        areaListVO.setUpdater( areaEntity.getUpdater() );
        areaListVO.setCreateTime( areaEntity.getCreateTime() );
        areaListVO.setUpdateTime( areaEntity.getUpdateTime() );
        areaListVO.setIsDeleted( areaEntity.getIsDeleted() );
        areaListVO.setTenantId( areaEntity.getTenantId() );
        areaListVO.setVersion( areaEntity.getVersion() );
        areaListVO.setParentId( areaEntity.getParentId() );
        areaListVO.setAreaName( areaEntity.getAreaName() );
        areaListVO.setAddress( areaEntity.getAddress() );
        areaListVO.setOtherName( areaEntity.getOtherName() );
        areaListVO.setType( areaEntity.getType() );
        areaListVO.setCode( areaEntity.getCode() );
        areaListVO.setAxis( areaEntity.getAxis() );
        areaListVO.setAcreage( areaEntity.getAcreage() );
        areaListVO.setPopulation( areaEntity.getPopulation() );
        areaListVO.setClimate( areaEntity.getClimate() );
        areaListVO.setCapital( areaEntity.getCapital() );
        areaListVO.setSort( areaEntity.getSort() );
        areaListVO.setLevel( areaEntity.getLevel() );
        areaListVO.setIcon( areaEntity.getIcon() );
        areaListVO.setDescription( areaEntity.getDescription() );

        return areaListVO;
    }

    protected AreaEntity areaSaveDTOToAreaEntity(AreaSaveDTO areaSaveDTO) {
        if ( areaSaveDTO == null ) {
            return null;
        }

        AreaEntity areaEntity = new AreaEntity();

        areaEntity.setId( areaSaveDTO.getId() );
        areaEntity.setStatus( areaSaveDTO.getStatus() );
        areaEntity.setRemark( areaSaveDTO.getRemark() );
        areaEntity.setCreator( areaSaveDTO.getCreator() );
        areaEntity.setUpdater( areaSaveDTO.getUpdater() );
        areaEntity.setCreateTime( areaSaveDTO.getCreateTime() );
        areaEntity.setUpdateTime( areaSaveDTO.getUpdateTime() );
        areaEntity.setIsDeleted( areaSaveDTO.getIsDeleted() );
        areaEntity.setTenantId( areaSaveDTO.getTenantId() );
        areaEntity.setVersion( areaSaveDTO.getVersion() );
        areaEntity.setParentId( areaSaveDTO.getParentId() );
        areaEntity.setAreaName( areaSaveDTO.getAreaName() );
        areaEntity.setAddress( areaSaveDTO.getAddress() );
        areaEntity.setOtherName( areaSaveDTO.getOtherName() );
        areaEntity.setType( areaSaveDTO.getType() );
        areaEntity.setCode( areaSaveDTO.getCode() );
        areaEntity.setAxis( areaSaveDTO.getAxis() );
        areaEntity.setAcreage( areaSaveDTO.getAcreage() );
        areaEntity.setPopulation( areaSaveDTO.getPopulation() );
        areaEntity.setClimate( areaSaveDTO.getClimate() );
        areaEntity.setCapital( areaSaveDTO.getCapital() );
        areaEntity.setSort( areaSaveDTO.getSort() );
        areaEntity.setLevel( areaSaveDTO.getLevel() );
        areaEntity.setIcon( areaSaveDTO.getIcon() );
        areaEntity.setDescription( areaSaveDTO.getDescription() );

        return areaEntity;
    }

    protected AreaExportVO areaEntityToAreaExportVO(AreaEntity areaEntity) {
        if ( areaEntity == null ) {
            return null;
        }

        AreaExportVO areaExportVO = new AreaExportVO();

        areaExportVO.setParentId( areaEntity.getParentId() );
        areaExportVO.setAreaName( areaEntity.getAreaName() );
        areaExportVO.setAddress( areaEntity.getAddress() );
        areaExportVO.setOtherName( areaEntity.getOtherName() );
        areaExportVO.setType( areaEntity.getType() );
        areaExportVO.setCode( areaEntity.getCode() );
        areaExportVO.setAxis( areaEntity.getAxis() );
        areaExportVO.setAcreage( areaEntity.getAcreage() );
        areaExportVO.setPopulation( areaEntity.getPopulation() );
        areaExportVO.setClimate( areaEntity.getClimate() );
        areaExportVO.setCapital( areaEntity.getCapital() );
        areaExportVO.setSort( areaEntity.getSort() );
        areaExportVO.setLevel( areaEntity.getLevel() );
        areaExportVO.setIcon( areaEntity.getIcon() );
        areaExportVO.setDescription( areaEntity.getDescription() );

        return areaExportVO;
    }
}
