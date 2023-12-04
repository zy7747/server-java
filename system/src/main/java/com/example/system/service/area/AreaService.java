package com.example.system.service.area;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.area.AreaQueryDTO;
import com.example.system.dal.dto.area.AreaSaveDTO;
import com.example.system.dal.entity.AreaEntity;
import com.example.system.dal.vo.area.AreaDetailVO;
import com.example.system.dal.vo.area.AreaListVO;
import com.example.system.dal.vo.area.AreaPageVO;

import java.util.List;

public interface AreaService {
    /**
     * 获取列表分页
     *
     * @param area 分页入参
     * @return 列表分页
     */
    Result<PageList<AreaPageVO>> areaPageService(AreaQueryDTO area);

    /**
     * 获取列表
     *
     * @param area 入参
     * @return 列表
     */
    Result<List<AreaListVO>> areaListService(AreaQueryDTO area);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<AreaDetailVO> areaDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param area 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<AreaEntity>> areaSaveListService(List<AreaSaveDTO> area);
}
