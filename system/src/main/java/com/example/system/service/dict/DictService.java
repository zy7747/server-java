package com.example.system.service.dict;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.dto.dict.DictSaveDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.vo.dict.DictDetailVO;
import com.example.system.dal.vo.dict.DictListVO;
import com.example.system.dal.vo.dict.DictPageVO;

import java.util.List;

public interface DictService {
    /**
     * 获取列表分页
     *
     * @param dict 分页入参
     * @return 列表分页
     */
    Result<PageList<DictPageVO>> pageService(DictQueryDTO dict);

    /**
     * 获取列表
     *
     * @param dict 入参
     * @return 列表
     */
    Result<List<DictListVO>> listService(DictQueryDTO dict);

    /**
     * 获取列表
     *
     * @return 列表
     */
    Result<Object> dictAllListService();

    /**
     * 获取所有字典集合
     *
     * @param dict 入参
     * @return 列表
     */
    Result<List<DictListVO>> subListService(DictQueryDTO dict);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<DictDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param dictList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<DictEntity>> saveListService(List<DictSaveDTO> dictList);
}
