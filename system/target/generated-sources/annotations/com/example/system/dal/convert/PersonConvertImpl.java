package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.person.PersonSaveDTO;
import com.example.system.dal.entity.PersonEntity;
import com.example.system.dal.vo.person.PersonDetailVO;
import com.example.system.dal.vo.person.PersonExportVO;
import com.example.system.dal.vo.person.PersonListVO;
import com.example.system.dal.vo.person.PersonPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-06T08:03:26+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class PersonConvertImpl implements PersonConvert {

    @Override
    public PageList<PersonPageVO> page(PageList<PersonEntity> persons) {
        if ( persons == null ) {
            return null;
        }

        PageList<PersonPageVO> pageList = new PageList<PersonPageVO>();

        pageList.setPage( persons.getPage() );
        pageList.setTotal( persons.getTotal() );
        pageList.setSize( persons.getSize() );
        pageList.setList( personEntityListToPersonPageVOList( persons.getList() ) );

        return pageList;
    }

    @Override
    public List<PersonListVO> list(List<PersonEntity> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonListVO> list = new ArrayList<PersonListVO>( persons.size() );
        for ( PersonEntity personEntity : persons ) {
            list.add( personEntityToPersonListVO( personEntity ) );
        }

        return list;
    }

    @Override
    public PersonDetailVO detail(PersonEntity persons) {
        if ( persons == null ) {
            return null;
        }

        PersonDetailVO personDetailVO = new PersonDetailVO();

        personDetailVO.setId( persons.getId() );
        personDetailVO.setStatus( persons.getStatus() );
        personDetailVO.setRemark( persons.getRemark() );
        personDetailVO.setCreator( persons.getCreator() );
        personDetailVO.setUpdater( persons.getUpdater() );
        personDetailVO.setCreateTime( persons.getCreateTime() );
        personDetailVO.setUpdateTime( persons.getUpdateTime() );
        personDetailVO.setIsDeleted( persons.getIsDeleted() );
        personDetailVO.setTenantId( persons.getTenantId() );
        personDetailVO.setVersion( persons.getVersion() );
        personDetailVO.setUserId( persons.getUserId() );
        personDetailVO.setPhoto( persons.getPhoto() );
        personDetailVO.setName( persons.getName() );
        personDetailVO.setSex( persons.getSex() );
        personDetailVO.setProfession( persons.getProfession() );
        personDetailVO.setNation( persons.getNation() );
        personDetailVO.setOrigin( persons.getOrigin() );
        personDetailVO.setAddress( persons.getAddress() );
        personDetailVO.setDegree( persons.getDegree() );
        personDetailVO.setHeight( persons.getHeight() );
        personDetailVO.setWeight( persons.getWeight() );
        personDetailVO.setHobby( persons.getHobby() );
        personDetailVO.setAge( persons.getAge() );
        personDetailVO.setIdCard( persons.getIdCard() );
        personDetailVO.setPhone( persons.getPhone() );
        personDetailVO.setEmail( persons.getEmail() );
        personDetailVO.setBirthDate( persons.getBirthDate() );

        return personDetailVO;
    }

    @Override
    public List<PersonEntity> saveList(List<PersonSaveDTO> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( persons.size() );
        for ( PersonSaveDTO personSaveDTO : persons ) {
            list.add( personSaveDTOToPersonEntity( personSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<PersonExportVO> export(List<PersonEntity> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonExportVO> list = new ArrayList<PersonExportVO>( persons.size() );
        for ( PersonEntity personEntity : persons ) {
            list.add( personEntityToPersonExportVO( personEntity ) );
        }

        return list;
    }

    @Override
    public List<PersonSaveDTO> imports(List<PersonExportVO> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonSaveDTO> list = new ArrayList<PersonSaveDTO>( persons.size() );
        for ( PersonExportVO personExportVO : persons ) {
            list.add( personExportVOToPersonSaveDTO( personExportVO ) );
        }

        return list;
    }

    protected PersonPageVO personEntityToPersonPageVO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonPageVO personPageVO = new PersonPageVO();

        personPageVO.setId( personEntity.getId() );
        personPageVO.setStatus( personEntity.getStatus() );
        personPageVO.setRemark( personEntity.getRemark() );
        personPageVO.setCreator( personEntity.getCreator() );
        personPageVO.setUpdater( personEntity.getUpdater() );
        personPageVO.setCreateTime( personEntity.getCreateTime() );
        personPageVO.setUpdateTime( personEntity.getUpdateTime() );
        personPageVO.setIsDeleted( personEntity.getIsDeleted() );
        personPageVO.setTenantId( personEntity.getTenantId() );
        personPageVO.setVersion( personEntity.getVersion() );
        personPageVO.setUserId( personEntity.getUserId() );
        personPageVO.setPhoto( personEntity.getPhoto() );
        personPageVO.setName( personEntity.getName() );
        personPageVO.setSex( personEntity.getSex() );
        personPageVO.setProfession( personEntity.getProfession() );
        personPageVO.setNation( personEntity.getNation() );
        personPageVO.setOrigin( personEntity.getOrigin() );
        personPageVO.setAddress( personEntity.getAddress() );
        personPageVO.setDegree( personEntity.getDegree() );
        personPageVO.setHeight( personEntity.getHeight() );
        personPageVO.setWeight( personEntity.getWeight() );
        personPageVO.setHobby( personEntity.getHobby() );
        personPageVO.setAge( personEntity.getAge() );
        personPageVO.setIdCard( personEntity.getIdCard() );
        personPageVO.setPhone( personEntity.getPhone() );
        personPageVO.setEmail( personEntity.getEmail() );
        personPageVO.setBirthDate( personEntity.getBirthDate() );

        return personPageVO;
    }

    protected List<PersonPageVO> personEntityListToPersonPageVOList(List<PersonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonPageVO> list1 = new ArrayList<PersonPageVO>( list.size() );
        for ( PersonEntity personEntity : list ) {
            list1.add( personEntityToPersonPageVO( personEntity ) );
        }

        return list1;
    }

    protected PersonListVO personEntityToPersonListVO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonListVO personListVO = new PersonListVO();

        personListVO.setId( personEntity.getId() );
        personListVO.setStatus( personEntity.getStatus() );
        personListVO.setRemark( personEntity.getRemark() );
        personListVO.setCreator( personEntity.getCreator() );
        personListVO.setUpdater( personEntity.getUpdater() );
        personListVO.setCreateTime( personEntity.getCreateTime() );
        personListVO.setUpdateTime( personEntity.getUpdateTime() );
        personListVO.setIsDeleted( personEntity.getIsDeleted() );
        personListVO.setTenantId( personEntity.getTenantId() );
        personListVO.setVersion( personEntity.getVersion() );
        personListVO.setUserId( personEntity.getUserId() );
        personListVO.setPhoto( personEntity.getPhoto() );
        personListVO.setName( personEntity.getName() );
        personListVO.setSex( personEntity.getSex() );
        personListVO.setProfession( personEntity.getProfession() );
        personListVO.setNation( personEntity.getNation() );
        personListVO.setOrigin( personEntity.getOrigin() );
        personListVO.setAddress( personEntity.getAddress() );
        personListVO.setDegree( personEntity.getDegree() );
        personListVO.setHeight( personEntity.getHeight() );
        personListVO.setWeight( personEntity.getWeight() );
        personListVO.setHobby( personEntity.getHobby() );
        personListVO.setAge( personEntity.getAge() );
        personListVO.setIdCard( personEntity.getIdCard() );
        personListVO.setPhone( personEntity.getPhone() );
        personListVO.setEmail( personEntity.getEmail() );
        personListVO.setBirthDate( personEntity.getBirthDate() );

        return personListVO;
    }

    protected PersonEntity personSaveDTOToPersonEntity(PersonSaveDTO personSaveDTO) {
        if ( personSaveDTO == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( personSaveDTO.getId() );
        personEntity.setStatus( personSaveDTO.getStatus() );
        personEntity.setRemark( personSaveDTO.getRemark() );
        personEntity.setCreator( personSaveDTO.getCreator() );
        personEntity.setUpdater( personSaveDTO.getUpdater() );
        personEntity.setCreateTime( personSaveDTO.getCreateTime() );
        personEntity.setUpdateTime( personSaveDTO.getUpdateTime() );
        personEntity.setIsDeleted( personSaveDTO.getIsDeleted() );
        personEntity.setTenantId( personSaveDTO.getTenantId() );
        personEntity.setVersion( personSaveDTO.getVersion() );
        personEntity.setUserId( personSaveDTO.getUserId() );
        personEntity.setPhoto( personSaveDTO.getPhoto() );
        personEntity.setName( personSaveDTO.getName() );
        personEntity.setSex( personSaveDTO.getSex() );
        personEntity.setProfession( personSaveDTO.getProfession() );
        personEntity.setNation( personSaveDTO.getNation() );
        personEntity.setOrigin( personSaveDTO.getOrigin() );
        personEntity.setAddress( personSaveDTO.getAddress() );
        personEntity.setDegree( personSaveDTO.getDegree() );
        personEntity.setHeight( personSaveDTO.getHeight() );
        personEntity.setWeight( personSaveDTO.getWeight() );
        personEntity.setHobby( personSaveDTO.getHobby() );
        personEntity.setAge( personSaveDTO.getAge() );
        personEntity.setIdCard( personSaveDTO.getIdCard() );
        personEntity.setPhone( personSaveDTO.getPhone() );
        personEntity.setEmail( personSaveDTO.getEmail() );
        personEntity.setBirthDate( personSaveDTO.getBirthDate() );

        return personEntity;
    }

    protected PersonExportVO personEntityToPersonExportVO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonExportVO personExportVO = new PersonExportVO();

        personExportVO.setUserId( personEntity.getUserId() );
        personExportVO.setPhoto( personEntity.getPhoto() );
        personExportVO.setName( personEntity.getName() );
        personExportVO.setSex( personEntity.getSex() );
        personExportVO.setProfession( personEntity.getProfession() );
        personExportVO.setNation( personEntity.getNation() );
        personExportVO.setOrigin( personEntity.getOrigin() );
        personExportVO.setAddress( personEntity.getAddress() );
        personExportVO.setDegree( personEntity.getDegree() );
        personExportVO.setHeight( personEntity.getHeight() );
        personExportVO.setWeight( personEntity.getWeight() );
        personExportVO.setHobby( personEntity.getHobby() );
        personExportVO.setAge( personEntity.getAge() );
        personExportVO.setIdCard( personEntity.getIdCard() );
        personExportVO.setPhone( personEntity.getPhone() );
        personExportVO.setEmail( personEntity.getEmail() );
        personExportVO.setBirthDate( personEntity.getBirthDate() );

        return personExportVO;
    }

    protected PersonSaveDTO personExportVOToPersonSaveDTO(PersonExportVO personExportVO) {
        if ( personExportVO == null ) {
            return null;
        }

        PersonSaveDTO personSaveDTO = new PersonSaveDTO();

        personSaveDTO.setUserId( personExportVO.getUserId() );
        personSaveDTO.setPhoto( personExportVO.getPhoto() );
        personSaveDTO.setName( personExportVO.getName() );
        personSaveDTO.setSex( personExportVO.getSex() );
        personSaveDTO.setProfession( personExportVO.getProfession() );
        personSaveDTO.setNation( personExportVO.getNation() );
        personSaveDTO.setOrigin( personExportVO.getOrigin() );
        personSaveDTO.setAddress( personExportVO.getAddress() );
        personSaveDTO.setDegree( personExportVO.getDegree() );
        personSaveDTO.setHeight( personExportVO.getHeight() );
        personSaveDTO.setWeight( personExportVO.getWeight() );
        personSaveDTO.setHobby( personExportVO.getHobby() );
        personSaveDTO.setAge( personExportVO.getAge() );
        personSaveDTO.setIdCard( personExportVO.getIdCard() );
        personSaveDTO.setPhone( personExportVO.getPhone() );
        personSaveDTO.setEmail( personExportVO.getEmail() );
        personSaveDTO.setBirthDate( personExportVO.getBirthDate() );

        return personSaveDTO;
    }
}
