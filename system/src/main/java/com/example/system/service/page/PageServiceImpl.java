package com.example.system.service.page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.PageConvert;
import com.example.system.dal.dto.page.PageQueryDTO;
import com.example.system.dal.dto.page.PageSaveDTO;
import com.example.system.dal.entity.PageEntity;
import com.example.system.mapper.PageMapper;
import com.example.system.dal.vo.page.PageDetailVO;
import com.example.system.dal.vo.page.PageListVO;
import com.example.system.dal.vo.page.PagePageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, PageEntity> implements PageService {
    @Resource
    PageMapper pageMapper;

    /**
     * 获取列表分页
     *
     * @param page 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<PagePageVO>> pagePageService(PageQueryDTO page) {
        return Result.success(PageConvert.INSTANCE.page(pageMapper.selectPageList(page)));
    }

    /**
     * 获取列表
     *
     * @param page 入参
     * @return 列表
     */
    @Override
    public Result<List<PageListVO>> pageListService(PageQueryDTO page) {
        return Result.success(PageConvert.INSTANCE.list(pageMapper.selectList(page)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<PageDetailVO> pageDetailService(Long id) {
        return Result.success(PageConvert.INSTANCE.detail(pageMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param page 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<PageEntity>> pageSaveListService(List<PageSaveDTO> page) {
        List<PageEntity> pageList = PageConvert.INSTANCE.saveList(page);
        this.saveOrUpdateBatch(pageList);
        return Result.success(pageList);
    }
}