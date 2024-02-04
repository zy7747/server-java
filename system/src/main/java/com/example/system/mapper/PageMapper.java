package com.example.system.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.page.PageQueryDTO;
import com.example.system.dal.entity.PageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper extends BaseMapper<PageEntity> {
    default QueryWrapper<PageEntity> search(PageQueryDTO page) {
        QueryWrapper<PageEntity> wrapper = new QueryWrapper<>();

        /* 页面内容 */
        if (page.getMenuId() != null) {
            wrapper.eq("menu_id", page.getMenuId());
        }

        if (!StrUtil.hasBlank(page.getContent())) {
            wrapper.eq("content", page.getContent());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(page.getStatus())) {
            wrapper.eq("status", page.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(page.getRemark())) {
            wrapper.eq("remark", page.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(page.getCreator())) {
            wrapper.eq("creator", page.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(page.getUpdater())) {
            wrapper.eq("updater", page.getUpdater());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<PageEntity> selectPageList(PageQueryDTO page) {
        IPage<PageEntity> pageParams = new Page<>(page.getPage(), page.getSize());
        return PageList.setPages(selectPage(pageParams, search(page)));
    }

    /**
     * 列表查询
     */
    default List<PageEntity> selectList(PageQueryDTO page) {
        return selectList(search(page));
    }
}