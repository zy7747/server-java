package com.example.system.service.notice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.dal.dto.SendMessageDTO;

import com.example.framework.service.WebSocketService;
import com.example.system.convert.NoticeConvert;
import com.example.system.dal.dto.notice.NoticeQueryDTO;
import com.example.system.dal.dto.notice.NoticeSaveDTO;
import com.example.system.dal.entity.NoticeEntity;
import com.example.system.mapper.NoticeMapper;
import com.example.system.dal.vo.notice.NoticeDetailVO;
import com.example.system.dal.vo.notice.NoticeListVO;
import com.example.system.dal.vo.notice.NoticePageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;

    @Resource
    WebSocketService webSocketService;

    /**
     * 获取列表分页
     *
     * @param notice 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<NoticePageVO>> noticePageService(NoticeQueryDTO notice) {
        return Result.success(NoticeConvert.INSTANCE.page(noticeMapper.selectPageList(notice)));
    }

    /**
     * 获取列表
     *
     * @param notice 入参
     * @return 列表
     */
    @Override
    public Result<List<NoticeListVO>> noticeListService(NoticeQueryDTO notice) {
        return Result.success(NoticeConvert.INSTANCE.list(noticeMapper.selectList(notice)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<NoticeDetailVO> noticeDetailService(Long id) {
        return Result.success(NoticeConvert.INSTANCE.detail(noticeMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param notice 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<NoticeEntity>> noticeSaveListService(List<NoticeSaveDTO> notice) {
        List<NoticeEntity> noticeList = NoticeConvert.INSTANCE.saveList(notice);
        this.saveOrUpdateBatch(noticeList);

        noticeList.forEach(item -> {
            SendMessageDTO message = new SendMessageDTO();
            message.setMessage("推送消息");

            if (!item.getReceiver().equals("all")) {
                message.setUserId(item.getReceiver());
                webSocketService.sendOneMessage(message);
            } else {
                webSocketService.batchSendInfo(message);
            }

        });


        return Result.success(noticeList);
    }
}