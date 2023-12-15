package com.example.system.service.area;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.AreaConvert;
import com.example.system.dal.dto.area.AreaQueryDTO;
import com.example.system.dal.dto.area.AreaSaveDTO;
import com.example.system.dal.entity.AreaEntity;
import com.example.system.mapper.AreaMapper;
import com.example.system.dal.vo.area.AreaDetailVO;
import com.example.system.dal.vo.area.AreaListVO;
import com.example.system.dal.vo.area.AreaPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaEntity> implements AreaService {
    @Resource
    AreaMapper areaMapper;

    /**
     * 获取列表分页
     *
     * @param area 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<AreaPageVO>> areaPageService(AreaQueryDTO area) {
        return Result.success(AreaConvert.INSTANCE.page(areaMapper.selectPageList(area)));
    }

    /**
     * 获取列表
     *
     * @param area 入参
     * @return 列表
     */
    @Override
    public Result<List<AreaListVO>> areaListService(AreaQueryDTO area) {
        return Result.success(AreaConvert.INSTANCE.list(areaMapper.selectList(area)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<AreaDetailVO> areaDetailService(Long id) {
        return Result.success(AreaConvert.INSTANCE.detail(areaMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param area 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<AreaEntity>> areaSaveListService(List<AreaSaveDTO> area) {
        List<AreaEntity> areaList = AreaConvert.INSTANCE.saveList(area);
        this.saveOrUpdateBatch(areaList);
        return Result.success(areaList);
    }
}
