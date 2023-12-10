package com.example.app.dal.convert;

import com.example.app.dal.dto.audio.AudioSaveDTO;
import com.example.app.dal.entity.AudioEntity;
import com.example.app.dal.vo.audio.AudioDetailVO;
import com.example.app.dal.vo.audio.AudioExportVO;
import com.example.app.dal.vo.audio.AudioListVO;
import com.example.app.dal.vo.audio.AudioPageVO;
import com.example.framework.common.PageList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T22:09:33+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class AudioConvertImpl implements AudioConvert {

    @Override
    public PageList<AudioPageVO> page(PageList<AudioEntity> audios) {
        if ( audios == null ) {
            return null;
        }

        PageList<AudioPageVO> pageList = new PageList<AudioPageVO>();

        pageList.setPage( audios.getPage() );
        pageList.setTotal( audios.getTotal() );
        pageList.setSize( audios.getSize() );
        pageList.setList( audioEntityListToAudioPageVOList( audios.getList() ) );

        return pageList;
    }

    @Override
    public List<AudioListVO> list(List<AudioEntity> audios) {
        if ( audios == null ) {
            return null;
        }

        List<AudioListVO> list = new ArrayList<AudioListVO>( audios.size() );
        for ( AudioEntity audioEntity : audios ) {
            list.add( audioEntityToAudioListVO( audioEntity ) );
        }

        return list;
    }

    @Override
    public AudioDetailVO detail(AudioEntity audios) {
        if ( audios == null ) {
            return null;
        }

        AudioDetailVO audioDetailVO = new AudioDetailVO();

        audioDetailVO.setId( audios.getId() );
        audioDetailVO.setStatus( audios.getStatus() );
        audioDetailVO.setRemark( audios.getRemark() );
        audioDetailVO.setCreator( audios.getCreator() );
        audioDetailVO.setUpdater( audios.getUpdater() );
        audioDetailVO.setCreateTime( audios.getCreateTime() );
        audioDetailVO.setUpdateTime( audios.getUpdateTime() );
        audioDetailVO.setIsDeleted( audios.getIsDeleted() );
        audioDetailVO.setTenantId( audios.getTenantId() );
        audioDetailVO.setVersion( audios.getVersion() );
        audioDetailVO.setAudioName( audios.getAudioName() );
        audioDetailVO.setTitle( audios.getTitle() );
        audioDetailVO.setType( audios.getType() );
        audioDetailVO.setRegion( audios.getRegion() );
        audioDetailVO.setUrl( audios.getUrl() );
        audioDetailVO.setPicture( audios.getPicture() );
        audioDetailVO.setVideoType( audios.getVideoType() );
        audioDetailVO.setProfile( audios.getProfile() );
        audioDetailVO.setLabel( audios.getLabel() );
        audioDetailVO.setSinger( audios.getSinger() );
        audioDetailVO.setLyricist( audios.getLyricist() );
        audioDetailVO.setComposing( audios.getComposing() );
        audioDetailVO.setLyrics( audios.getLyrics() );
        audioDetailVO.setDuration( audios.getDuration() );
        audioDetailVO.setPlayNum( audios.getPlayNum() );
        audioDetailVO.setCreateYear( audios.getCreateYear() );

        return audioDetailVO;
    }

    @Override
    public List<AudioEntity> saveList(List<AudioSaveDTO> audios) {
        if ( audios == null ) {
            return null;
        }

        List<AudioEntity> list = new ArrayList<AudioEntity>( audios.size() );
        for ( AudioSaveDTO audioSaveDTO : audios ) {
            list.add( audioSaveDTOToAudioEntity( audioSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<AudioExportVO> export(List<AudioEntity> audios) {
        if ( audios == null ) {
            return null;
        }

        List<AudioExportVO> list = new ArrayList<AudioExportVO>( audios.size() );
        for ( AudioEntity audioEntity : audios ) {
            list.add( audioEntityToAudioExportVO( audioEntity ) );
        }

        return list;
    }

    protected AudioPageVO audioEntityToAudioPageVO(AudioEntity audioEntity) {
        if ( audioEntity == null ) {
            return null;
        }

        AudioPageVO audioPageVO = new AudioPageVO();

        audioPageVO.setId( audioEntity.getId() );
        audioPageVO.setStatus( audioEntity.getStatus() );
        audioPageVO.setRemark( audioEntity.getRemark() );
        audioPageVO.setCreator( audioEntity.getCreator() );
        audioPageVO.setUpdater( audioEntity.getUpdater() );
        audioPageVO.setCreateTime( audioEntity.getCreateTime() );
        audioPageVO.setUpdateTime( audioEntity.getUpdateTime() );
        audioPageVO.setIsDeleted( audioEntity.getIsDeleted() );
        audioPageVO.setTenantId( audioEntity.getTenantId() );
        audioPageVO.setVersion( audioEntity.getVersion() );
        audioPageVO.setAudioName( audioEntity.getAudioName() );
        audioPageVO.setTitle( audioEntity.getTitle() );
        audioPageVO.setType( audioEntity.getType() );
        audioPageVO.setRegion( audioEntity.getRegion() );
        audioPageVO.setUrl( audioEntity.getUrl() );
        audioPageVO.setPicture( audioEntity.getPicture() );
        audioPageVO.setVideoType( audioEntity.getVideoType() );
        audioPageVO.setProfile( audioEntity.getProfile() );
        audioPageVO.setLabel( audioEntity.getLabel() );
        audioPageVO.setSinger( audioEntity.getSinger() );
        audioPageVO.setLyricist( audioEntity.getLyricist() );
        audioPageVO.setComposing( audioEntity.getComposing() );
        audioPageVO.setLyrics( audioEntity.getLyrics() );
        audioPageVO.setDuration( audioEntity.getDuration() );
        audioPageVO.setPlayNum( audioEntity.getPlayNum() );
        audioPageVO.setCreateYear( audioEntity.getCreateYear() );

        return audioPageVO;
    }

    protected List<AudioPageVO> audioEntityListToAudioPageVOList(List<AudioEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AudioPageVO> list1 = new ArrayList<AudioPageVO>( list.size() );
        for ( AudioEntity audioEntity : list ) {
            list1.add( audioEntityToAudioPageVO( audioEntity ) );
        }

        return list1;
    }

    protected AudioListVO audioEntityToAudioListVO(AudioEntity audioEntity) {
        if ( audioEntity == null ) {
            return null;
        }

        AudioListVO audioListVO = new AudioListVO();

        audioListVO.setId( audioEntity.getId() );
        audioListVO.setStatus( audioEntity.getStatus() );
        audioListVO.setRemark( audioEntity.getRemark() );
        audioListVO.setCreator( audioEntity.getCreator() );
        audioListVO.setUpdater( audioEntity.getUpdater() );
        audioListVO.setCreateTime( audioEntity.getCreateTime() );
        audioListVO.setUpdateTime( audioEntity.getUpdateTime() );
        audioListVO.setIsDeleted( audioEntity.getIsDeleted() );
        audioListVO.setTenantId( audioEntity.getTenantId() );
        audioListVO.setVersion( audioEntity.getVersion() );
        audioListVO.setAudioName( audioEntity.getAudioName() );
        audioListVO.setTitle( audioEntity.getTitle() );
        audioListVO.setType( audioEntity.getType() );
        audioListVO.setRegion( audioEntity.getRegion() );
        audioListVO.setUrl( audioEntity.getUrl() );
        audioListVO.setPicture( audioEntity.getPicture() );
        audioListVO.setVideoType( audioEntity.getVideoType() );
        audioListVO.setProfile( audioEntity.getProfile() );
        audioListVO.setLabel( audioEntity.getLabel() );
        audioListVO.setSinger( audioEntity.getSinger() );
        audioListVO.setLyricist( audioEntity.getLyricist() );
        audioListVO.setComposing( audioEntity.getComposing() );
        audioListVO.setLyrics( audioEntity.getLyrics() );
        audioListVO.setDuration( audioEntity.getDuration() );
        audioListVO.setPlayNum( audioEntity.getPlayNum() );
        audioListVO.setCreateYear( audioEntity.getCreateYear() );

        return audioListVO;
    }

    protected AudioEntity audioSaveDTOToAudioEntity(AudioSaveDTO audioSaveDTO) {
        if ( audioSaveDTO == null ) {
            return null;
        }

        AudioEntity audioEntity = new AudioEntity();

        audioEntity.setId( audioSaveDTO.getId() );
        audioEntity.setStatus( audioSaveDTO.getStatus() );
        audioEntity.setRemark( audioSaveDTO.getRemark() );
        audioEntity.setCreator( audioSaveDTO.getCreator() );
        audioEntity.setUpdater( audioSaveDTO.getUpdater() );
        audioEntity.setCreateTime( audioSaveDTO.getCreateTime() );
        audioEntity.setUpdateTime( audioSaveDTO.getUpdateTime() );
        audioEntity.setIsDeleted( audioSaveDTO.getIsDeleted() );
        audioEntity.setTenantId( audioSaveDTO.getTenantId() );
        audioEntity.setVersion( audioSaveDTO.getVersion() );
        audioEntity.setAudioName( audioSaveDTO.getAudioName() );
        audioEntity.setTitle( audioSaveDTO.getTitle() );
        audioEntity.setType( audioSaveDTO.getType() );
        audioEntity.setRegion( audioSaveDTO.getRegion() );
        audioEntity.setUrl( audioSaveDTO.getUrl() );
        audioEntity.setPicture( audioSaveDTO.getPicture() );
        audioEntity.setVideoType( audioSaveDTO.getVideoType() );
        audioEntity.setProfile( audioSaveDTO.getProfile() );
        audioEntity.setLabel( audioSaveDTO.getLabel() );
        audioEntity.setSinger( audioSaveDTO.getSinger() );
        audioEntity.setLyricist( audioSaveDTO.getLyricist() );
        audioEntity.setComposing( audioSaveDTO.getComposing() );
        audioEntity.setLyrics( audioSaveDTO.getLyrics() );
        audioEntity.setDuration( audioSaveDTO.getDuration() );
        audioEntity.setPlayNum( audioSaveDTO.getPlayNum() );
        audioEntity.setCreateYear( audioSaveDTO.getCreateYear() );

        return audioEntity;
    }

    protected AudioExportVO audioEntityToAudioExportVO(AudioEntity audioEntity) {
        if ( audioEntity == null ) {
            return null;
        }

        AudioExportVO audioExportVO = new AudioExportVO();

        audioExportVO.setAudioName( audioEntity.getAudioName() );
        audioExportVO.setTitle( audioEntity.getTitle() );
        audioExportVO.setType( audioEntity.getType() );
        audioExportVO.setRegion( audioEntity.getRegion() );
        audioExportVO.setUrl( audioEntity.getUrl() );
        audioExportVO.setPicture( audioEntity.getPicture() );
        audioExportVO.setVideoType( audioEntity.getVideoType() );
        audioExportVO.setProfile( audioEntity.getProfile() );
        audioExportVO.setLabel( audioEntity.getLabel() );
        audioExportVO.setSinger( audioEntity.getSinger() );
        audioExportVO.setLyricist( audioEntity.getLyricist() );
        audioExportVO.setComposing( audioEntity.getComposing() );
        audioExportVO.setLyrics( audioEntity.getLyrics() );
        audioExportVO.setDuration( audioEntity.getDuration() );
        audioExportVO.setPlayNum( audioEntity.getPlayNum() );

        return audioExportVO;
    }
}
