package com.example.system.service.dict;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.convert.DictConvert;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.dto.dict.DictSaveDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.mapper.DictMapper;
import com.example.system.dal.vo.dict.DictDetailVO;
import com.example.system.dal.vo.dict.DictListVO;
import com.example.system.dal.vo.dict.DictPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity> implements DictService {
    @Resource
    DictMapper dictMapper;

    /**
     * 获取列表分页
     *
     * @param dict 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<DictPageVO>> pageService(DictQueryDTO dict) {
        return Result.success(DictConvert.INSTANCE.page(dictMapper.selectPage(dict)));
    }

    /**
     * 获取列表
     *
     * @param dict 查询参数
     * @return 列表
     */
    @Override
    public Result<List<DictListVO>> listService(DictQueryDTO dict) {
        return Result.success(DictConvert.INSTANCE.list(dictMapper.selectList(dict)));
    }

    /**
     * 获取列表
     *
     * @return 列表
     */
    @Override
    public Result<Object> dictAllListService() {
        return Result.success(dictMapper.selectAllDictList());
    }

    /**
     * 获取列表
     *
     * @param dict 查询参数
     * @return 列表
     */
    @Override
    public Result<List<DictListVO>> subListService(DictQueryDTO dict) {
        return Result.success(DictConvert.INSTANCE.dictList(dictMapper.subList(dict)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<DictDetailVO> detailService(Long id) {
        return Result.success(DictConvert.INSTANCE.detail(dictMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param dict 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<DictEntity>> saveListService(List<DictSaveDTO> dict) {
        List<DictEntity> dictList = DictConvert.INSTANCE.saveList(dict);
        this.saveOrUpdateBatch(dictList);
        return Result.success(dictList);
    }
}
