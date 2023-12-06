package com.example.system.service.notice;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.notice.NoticeQueryDTO;
import com.example.system.dal.dto.notice.NoticeSaveDTO;
import com.example.system.dal.entity.NoticeEntity;
import com.example.system.dal.vo.notice.NoticeDetailVO;
import com.example.system.dal.vo.notice.NoticeListVO;
import com.example.system.dal.vo.notice.NoticePageVO;

import java.util.List;

public interface NoticeService {
    /**
     * 获取列表分页
     *
     * @param notice 分页入参
     * @return 列表分页
     */
    Result<PageList<NoticePageVO>> noticePageService(NoticeQueryDTO notice);

    /**
     * 获取列表
     *
     * @param notice 入参
     * @return 列表
     */
    Result<List<NoticeListVO>> noticeListService(NoticeQueryDTO notice);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<NoticeDetailVO> noticeDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param notice 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<NoticeEntity>> noticeSaveListService(List<NoticeSaveDTO> notice);
}