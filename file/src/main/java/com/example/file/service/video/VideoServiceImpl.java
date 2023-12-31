package com.example.file.service.video;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.file.convert.VideoConvert;
import com.example.file.dal.dto.video.HotVideoListQueryDTO;
import com.example.file.dal.dto.video.VideoQueryDTO;
import com.example.file.dal.dto.video.VideoSaveDTO;
import com.example.file.dal.vo.video.VideoDetailVO;
import com.example.file.mapper.VideoMapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.file.dal.entity.VideoEntity;
import com.example.file.dal.vo.video.VideoListVO;
import com.example.file.dal.vo.video.VideoPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@DS("file")
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, VideoEntity> implements VideoService {
    @Resource
    VideoMapper videoMapper;

    /**
     * 获取列表分页
     *
     * @param video 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<VideoPageVO>> pageService(VideoQueryDTO video) {
        return Result.success(VideoConvert.INSTANCE.page(videoMapper.selectPage(video)));
    }

    /**
     * 获取列表
     *
     * @param video 查询参数
     * @return 列表
     */
    @Override
    public Result<List<VideoListVO>> listService(VideoQueryDTO video) {
        return Result.success(VideoConvert.INSTANCE.list(videoMapper.selectList(video)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<VideoDetailVO> detailService(Long id) {

        VideoDetailVO videoInfo = VideoConvert.INSTANCE.detail(videoMapper.selectById(id));

        if (videoInfo.getIsCollection() == 0) {
            videoInfo.setVideoList(videoMapper.selectSortVideo(id));
        } else {
            videoInfo.setVideoList(videoMapper.selectVideoList(id));
        }


        return Result.success(videoInfo);
    }

    /**
     * 批量新增/修改
     *
     * @param video 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<VideoEntity>> saveListService(List<VideoSaveDTO> video) {
        List<VideoEntity> videoList = VideoConvert.INSTANCE.saveList(video);

        this.saveOrUpdateBatch(videoList);

        return Result.success(videoList);
    }

    /**
     * 记录播放量
     *
     * @param video 记录播放量
     * @return 播放量
     */
    @Override
    public Result<VideoEntity> playNumService(VideoEntity video) {
        VideoEntity videoInfo = videoMapper.selectById(video.getId());

        videoInfo.setPlayNum(videoInfo.getPlayNum() + 1);

        videoMapper.updateById(videoInfo);

        return Result.success(videoInfo);
    }


    /**
     * 热门视频查询
     *
     * @return 返回热门视频列表
     */
    @Override
    public Result<HotVideoListQueryDTO> hotVideoService() {
        VideoQueryDTO video = new VideoQueryDTO();
        //4.从大到小排序
        video.setSortWay("playNum");

        //1.查询出所有视频
        List<VideoEntity> videoList = videoMapper.selectList(video);

        //2.创建要返回的参数类型
        HotVideoListQueryDTO hv = new HotVideoListQueryDTO();

        //3.创建对象
        ArrayList<Object> all = new ArrayList<>();
        ArrayList<Object> anime = new ArrayList<>();
        ArrayList<Object> movie = new ArrayList<>();
        ArrayList<Object> Variety = new ArrayList<>();
        ArrayList<Object> tv = new ArrayList<>();
        ArrayList<Object> original = new ArrayList<>();
        ArrayList<Object> shorts = new ArrayList<>();


        //5.取播出各自放量前十的视频
        videoList.forEach(i -> {
            if (i.getType().equals("anime") && anime.size() < 10) {
                anime.add(i);
            } else if (i.getType().equals("movie") && movie.size() < 10) {
                movie.add(i);
            } else if (i.getType().equals("variety") && Variety.size() < 10) {
                Variety.add(i);
            } else if (i.getType().equals("tv") && tv.size() < 10) {
                tv.add(i);
            } else if (i.getType().equals("original") && original.size() < 10) {
                original.add(i);
            } else if (i.getType().equals("shorts") && shorts.size() < 10) {
                shorts.add(i);
            }

            if (all.size() < 10) {
                all.add(i);
            }
        });

        //6.将数据放入指定栏位
        hv.getAll().put("title", "全部热门");
        hv.getAll().put("videoList", all);

        hv.getAnime().put("title", "动漫");
        hv.getAnime().put("videoList", anime);

        hv.getMovie().put("title", "电影");
        hv.getMovie().put("videoList", movie);

        hv.getVariety().put("title", "综艺");
        hv.getVariety().put("videoList", Variety);

        hv.getTv().put("title", "电视剧");
        hv.getTv().put("videoList", tv);

        hv.getOriginal().put("title", "原创视频");
        hv.getOriginal().put("videoList", original);

        hv.getShorts().put("title", "短视频");
        hv.getShorts().put("videoList", shorts);


        return Result.success(hv);
    }
}