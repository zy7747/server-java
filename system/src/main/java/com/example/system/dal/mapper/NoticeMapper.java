package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.notice.NoticeQueryDTO;
import com.example.system.dal.entity.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<NoticeEntity> {
    default QueryWrapper<NoticeEntity> search(NoticeQueryDTO notice) {
        QueryWrapper<NoticeEntity> wrapper = new QueryWrapper<>();

        /* 消息名称 */
        if (!StrUtil.hasBlank(notice.getNoticeName())) {
            wrapper.eq("notice_name", notice.getNoticeName());
        }
        /* 消息内容 */
        if (!StrUtil.hasBlank(notice.getNoticeContent())) {
            wrapper.eq("notice_content", notice.getNoticeContent());
        }
        /* 推送模块 */
        if (!StrUtil.hasBlank(notice.getNoticeContent())) {
            wrapper.eq("push_module", notice.getPushModule());
        }
        /* 类型 */
        if (!StrUtil.hasBlank(notice.getType())) {
            wrapper.eq("type", notice.getType());
        }
        /* 接收人 */
        if (!StrUtil.hasBlank(notice.getReceiver())) {
            wrapper.eq("receiver", notice.getReceiver()).or(i -> i.eq("receiver", "all"));
        }
        /* 是否已读 */
        if (!StrUtil.hasBlank(notice.getIsRead())) {
            wrapper.eq("is_read", notice.getIsRead());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(notice.getStatus())) {
            wrapper.eq("status", notice.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(notice.getRemark())) {
            wrapper.eq("remark", notice.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(notice.getCreator())) {
            wrapper.eq("creator", notice.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(notice.getUpdater())) {
            wrapper.eq("updater", notice.getUpdater());
        }

        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<NoticeEntity> selectPageList(NoticeQueryDTO notice) {
        IPage<NoticeEntity> pageParams = new Page<>(notice.getPage(), notice.getSize());
        return PageList.setPages(selectPage(pageParams, search(notice)));
    }

    /**
     * 列表查询
     */
    default List<NoticeEntity> selectList(NoticeQueryDTO notice) {
        return selectList(search(notice));
    }
}