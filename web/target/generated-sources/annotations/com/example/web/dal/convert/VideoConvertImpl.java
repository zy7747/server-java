package com.example.web.dal.convert;

import com.example.framework.common.PageList;
import com.example.web.dal.dto.video.VideoSaveDTO;
import com.example.web.dal.entity.VideoEntity;
import com.example.web.dal.vo.video.VideoDetailVO;
import com.example.web.dal.vo.video.VideoExportVO;
import com.example.web.dal.vo.video.VideoListVO;
import com.example.web.dal.vo.video.VideoPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-11T11:21:30+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class VideoConvertImpl implements VideoConvert {

    @Override
    public PageList<VideoPageVO> page(PageList<VideoEntity> videos) {
        if ( videos == null ) {
            return null;
        }

        PageList<VideoPageVO> pageList = new PageList<VideoPageVO>();

        pageList.setPage( videos.getPage() );
        pageList.setTotal( videos.getTotal() );
        pageList.setSize( videos.getSize() );
        pageList.setList( videoEntityListToVideoPageVOList( videos.getList() ) );

        return pageList;
    }

    @Override
    public List<VideoListVO> list(List<VideoEntity> videos) {
        if ( videos == null ) {
            return null;
        }

        List<VideoListVO> list = new ArrayList<VideoListVO>( videos.size() );
        for ( VideoEntity videoEntity : videos ) {
            list.add( videoEntityToVideoListVO( videoEntity ) );
        }

        return list;
    }

    @Override
    public VideoDetailVO detail(VideoEntity videos) {
        if ( videos == null ) {
            return null;
        }

        VideoDetailVO videoDetailVO = new VideoDetailVO();

        videoDetailVO.setId( videos.getId() );
        videoDetailVO.setStatus( videos.getStatus() );
        videoDetailVO.setRemark( videos.getRemark() );
        videoDetailVO.setCreator( videos.getCreator() );
        videoDetailVO.setUpdater( videos.getUpdater() );
        videoDetailVO.setCreateTime( videos.getCreateTime() );
        videoDetailVO.setUpdateTime( videos.getUpdateTime() );
        videoDetailVO.setIsDeleted( videos.getIsDeleted() );
        videoDetailVO.setTenantId( videos.getTenantId() );
        videoDetailVO.setVersion( videos.getVersion() );
        videoDetailVO.setParentId( videos.getParentId() );
        videoDetailVO.setVideoName( videos.getVideoName() );
        videoDetailVO.setTitle( videos.getTitle() );
        videoDetailVO.setType( videos.getType() );
        videoDetailVO.setRegion( videos.getRegion() );
        videoDetailVO.setUrl( videos.getUrl() );
        videoDetailVO.setPicture( videos.getPicture() );
        videoDetailVO.setVideoType( videos.getVideoType() );
        videoDetailVO.setProfile( videos.getProfile() );
        videoDetailVO.setLabel( videos.getLabel() );
        videoDetailVO.setAuthor( videos.getAuthor() );
        videoDetailVO.setSeason( videos.getSeason() );
        videoDetailVO.setEpisode( videos.getEpisode() );
        videoDetailVO.setDuration( videos.getDuration() );
        videoDetailVO.setStarsNum( videos.getStarsNum() );
        videoDetailVO.setCollectionNum( videos.getCollectionNum() );
        videoDetailVO.setPlayNum( videos.getPlayNum() );
        videoDetailVO.setCreateYear( videos.getCreateYear() );

        return videoDetailVO;
    }

    @Override
    public List<VideoEntity> saveList(List<VideoSaveDTO> videos) {
        if ( videos == null ) {
            return null;
        }

        List<VideoEntity> list = new ArrayList<VideoEntity>( videos.size() );
        for ( VideoSaveDTO videoSaveDTO : videos ) {
            list.add( videoSaveDTOToVideoEntity( videoSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<VideoExportVO> export(List<VideoEntity> videos) {
        if ( videos == null ) {
            return null;
        }

        List<VideoExportVO> list = new ArrayList<VideoExportVO>( videos.size() );
        for ( VideoEntity videoEntity : videos ) {
            list.add( videoEntityToVideoExportVO( videoEntity ) );
        }

        return list;
    }

    protected VideoPageVO videoEntityToVideoPageVO(VideoEntity videoEntity) {
        if ( videoEntity == null ) {
            return null;
        }

        VideoPageVO videoPageVO = new VideoPageVO();

        videoPageVO.setId( videoEntity.getId() );
        videoPageVO.setStatus( videoEntity.getStatus() );
        videoPageVO.setRemark( videoEntity.getRemark() );
        videoPageVO.setCreator( videoEntity.getCreator() );
        videoPageVO.setUpdater( videoEntity.getUpdater() );
        videoPageVO.setCreateTime( videoEntity.getCreateTime() );
        videoPageVO.setUpdateTime( videoEntity.getUpdateTime() );
        videoPageVO.setIsDeleted( videoEntity.getIsDeleted() );
        videoPageVO.setTenantId( videoEntity.getTenantId() );
        videoPageVO.setVersion( videoEntity.getVersion() );
        videoPageVO.setParentId( videoEntity.getParentId() );
        videoPageVO.setVideoName( videoEntity.getVideoName() );
        videoPageVO.setTitle( videoEntity.getTitle() );
        videoPageVO.setType( videoEntity.getType() );
        videoPageVO.setRegion( videoEntity.getRegion() );
        videoPageVO.setUrl( videoEntity.getUrl() );
        videoPageVO.setPicture( videoEntity.getPicture() );
        videoPageVO.setVideoType( videoEntity.getVideoType() );
        videoPageVO.setProfile( videoEntity.getProfile() );
        videoPageVO.setLabel( videoEntity.getLabel() );
        videoPageVO.setAuthor( videoEntity.getAuthor() );
        videoPageVO.setSeason( videoEntity.getSeason() );
        videoPageVO.setEpisode( videoEntity.getEpisode() );
        videoPageVO.setDuration( videoEntity.getDuration() );
        videoPageVO.setStarsNum( videoEntity.getStarsNum() );
        videoPageVO.setCollectionNum( videoEntity.getCollectionNum() );
        videoPageVO.setPlayNum( videoEntity.getPlayNum() );
        videoPageVO.setCreateYear( videoEntity.getCreateYear() );

        return videoPageVO;
    }

    protected List<VideoPageVO> videoEntityListToVideoPageVOList(List<VideoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoPageVO> list1 = new ArrayList<VideoPageVO>( list.size() );
        for ( VideoEntity videoEntity : list ) {
            list1.add( videoEntityToVideoPageVO( videoEntity ) );
        }

        return list1;
    }

    protected VideoListVO videoEntityToVideoListVO(VideoEntity videoEntity) {
        if ( videoEntity == null ) {
            return null;
        }

        VideoListVO videoListVO = new VideoListVO();

        videoListVO.setId( videoEntity.getId() );
        videoListVO.setStatus( videoEntity.getStatus() );
        videoListVO.setRemark( videoEntity.getRemark() );
        videoListVO.setCreator( videoEntity.getCreator() );
        videoListVO.setUpdater( videoEntity.getUpdater() );
        videoListVO.setCreateTime( videoEntity.getCreateTime() );
        videoListVO.setUpdateTime( videoEntity.getUpdateTime() );
        videoListVO.setIsDeleted( videoEntity.getIsDeleted() );
        videoListVO.setTenantId( videoEntity.getTenantId() );
        videoListVO.setVersion( videoEntity.getVersion() );
        videoListVO.setParentId( videoEntity.getParentId() );
        videoListVO.setVideoName( videoEntity.getVideoName() );
        videoListVO.setTitle( videoEntity.getTitle() );
        videoListVO.setType( videoEntity.getType() );
        videoListVO.setRegion( videoEntity.getRegion() );
        videoListVO.setUrl( videoEntity.getUrl() );
        videoListVO.setPicture( videoEntity.getPicture() );
        videoListVO.setVideoType( videoEntity.getVideoType() );
        videoListVO.setProfile( videoEntity.getProfile() );
        videoListVO.setLabel( videoEntity.getLabel() );
        videoListVO.setAuthor( videoEntity.getAuthor() );
        videoListVO.setSeason( videoEntity.getSeason() );
        videoListVO.setEpisode( videoEntity.getEpisode() );
        videoListVO.setDuration( videoEntity.getDuration() );
        videoListVO.setStarsNum( videoEntity.getStarsNum() );
        videoListVO.setCollectionNum( videoEntity.getCollectionNum() );
        videoListVO.setPlayNum( videoEntity.getPlayNum() );
        videoListVO.setCreateYear( videoEntity.getCreateYear() );

        return videoListVO;
    }

    protected VideoEntity videoSaveDTOToVideoEntity(VideoSaveDTO videoSaveDTO) {
        if ( videoSaveDTO == null ) {
            return null;
        }

        VideoEntity videoEntity = new VideoEntity();

        videoEntity.setId( videoSaveDTO.getId() );
        videoEntity.setStatus( videoSaveDTO.getStatus() );
        videoEntity.setRemark( videoSaveDTO.getRemark() );
        videoEntity.setCreator( videoSaveDTO.getCreator() );
        videoEntity.setUpdater( videoSaveDTO.getUpdater() );
        videoEntity.setCreateTime( videoSaveDTO.getCreateTime() );
        videoEntity.setUpdateTime( videoSaveDTO.getUpdateTime() );
        videoEntity.setIsDeleted( videoSaveDTO.getIsDeleted() );
        videoEntity.setTenantId( videoSaveDTO.getTenantId() );
        videoEntity.setVersion( videoSaveDTO.getVersion() );
        videoEntity.setParentId( videoSaveDTO.getParentId() );
        videoEntity.setVideoName( videoSaveDTO.getVideoName() );
        videoEntity.setTitle( videoSaveDTO.getTitle() );
        videoEntity.setType( videoSaveDTO.getType() );
        videoEntity.setRegion( videoSaveDTO.getRegion() );
        videoEntity.setUrl( videoSaveDTO.getUrl() );
        videoEntity.setPicture( videoSaveDTO.getPicture() );
        videoEntity.setVideoType( videoSaveDTO.getVideoType() );
        videoEntity.setProfile( videoSaveDTO.getProfile() );
        videoEntity.setLabel( videoSaveDTO.getLabel() );
        videoEntity.setSeason( videoSaveDTO.getSeason() );
        videoEntity.setEpisode( videoSaveDTO.getEpisode() );
        videoEntity.setDuration( videoSaveDTO.getDuration() );
        videoEntity.setStarsNum( videoSaveDTO.getStarsNum() );
        videoEntity.setCollectionNum( videoSaveDTO.getCollectionNum() );
        videoEntity.setPlayNum( videoSaveDTO.getPlayNum() );
        videoEntity.setAuthor( videoSaveDTO.getAuthor() );
        videoEntity.setCreateYear( videoSaveDTO.getCreateYear() );

        return videoEntity;
    }

    protected VideoExportVO videoEntityToVideoExportVO(VideoEntity videoEntity) {
        if ( videoEntity == null ) {
            return null;
        }

        VideoExportVO videoExportVO = new VideoExportVO();

        videoExportVO.setId( videoEntity.getId() );
        videoExportVO.setStatus( videoEntity.getStatus() );
        videoExportVO.setRemark( videoEntity.getRemark() );
        videoExportVO.setCreator( videoEntity.getCreator() );
        videoExportVO.setUpdater( videoEntity.getUpdater() );
        videoExportVO.setCreateTime( videoEntity.getCreateTime() );
        videoExportVO.setUpdateTime( videoEntity.getUpdateTime() );
        videoExportVO.setIsDeleted( videoEntity.getIsDeleted() );
        videoExportVO.setVideoName( videoEntity.getVideoName() );
        videoExportVO.setTitle( videoEntity.getTitle() );
        videoExportVO.setType( videoEntity.getType() );
        videoExportVO.setRegion( videoEntity.getRegion() );
        videoExportVO.setUrl( videoEntity.getUrl() );
        videoExportVO.setPicture( videoEntity.getPicture() );
        videoExportVO.setVideoType( videoEntity.getVideoType() );
        videoExportVO.setProfile( videoEntity.getProfile() );
        videoExportVO.setLabel( videoEntity.getLabel() );
        videoExportVO.setAuthor( videoEntity.getAuthor() );
        videoExportVO.setSeason( videoEntity.getSeason() );
        videoExportVO.setEpisode( videoEntity.getEpisode() );
        videoExportVO.setDuration( videoEntity.getDuration() );
        videoExportVO.setStarsNum( videoEntity.getStarsNum() );
        videoExportVO.setCollectionNum( videoEntity.getCollectionNum() );
        videoExportVO.setPlayNum( videoEntity.getPlayNum() );

        return videoExportVO;
    }
}