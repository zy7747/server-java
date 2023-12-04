package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.entity.DictEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {
    default QueryWrapper<DictEntity> search(DictQueryDTO dict) {
        QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();

        /* 字典名称 */
        if (!StrUtil.hasBlank(dict.getDictName())) {
            wrapper.eq("dict_name", dict.getDictName());
        }
        /* 字典编码 */
        if (!StrUtil.hasBlank(dict.getDictCode())) {
            wrapper.eq("dict_code", dict.getDictCode());
        }
        /* 字典类型 */
        if (!StrUtil.hasBlank(dict.getDictType())) {
            wrapper.eq("dict_type", dict.getDictType());
        }
        /* 名 */
        if (!StrUtil.hasBlank(dict.getLabel())) {
            wrapper.eq("label", dict.getLabel());
        }
        /* 值 */
        if (!StrUtil.hasBlank(dict.getValue())) {
            wrapper.eq("value", dict.getValue());
        }
        /* 自定义颜色 */
        if (!StrUtil.hasBlank(dict.getColor())) {
            wrapper.eq("color", dict.getColor());
        }
        /* 自定义CSS样式 */
        if (!StrUtil.hasBlank(dict.getCss())) {
            wrapper.eq("css", dict.getCss());
        }
        /* 其他参数 */
        if (!StrUtil.hasBlank(dict.getParams())) {
            wrapper.eq("params", dict.getParams());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(dict.getStatus())) {
            wrapper.eq("status", dict.getStatus());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    //分页
    default PageList<DictEntity> selectPage(DictQueryDTO dict) {
        IPage<DictEntity> pageParams = new Page<>(dict.getPage(), dict.getSize());

        return PageList.setPages(selectPage(pageParams, search(dict).isNull("parent_id")));
    }

    //列表查询
    default List<DictEntity> selectList(DictQueryDTO dict) {
        return selectList(search(dict));
    }

    //子集列表查询
    default List<DictEntity> subList(DictQueryDTO dict) {
        QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();
        if (dict.getParentId() != null) {
            wrapper.eq("parent_id", dict.getParentId());
        }

        if (dict.getDictCode() != null) {
            QueryWrapper<DictEntity> wrapperId = new QueryWrapper<>();

            wrapperId.eq("dict_code", dict.getDictCode());

            if (selectOne(wrapperId).getId() != null) {
                wrapper.eq("parent_id", selectOne(wrapperId).getId());
            }
        }

        wrapper.orderByAsc("sort");

        return selectList(wrapper);
    }

    //  查询所有字典列表返回前端
    default Object selectAllDictList() {
        QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();

        wrapper.orderByAsc("sort");

        //新建一个要返回的集合
        Map<String, Object> allDictList = new HashMap<>();

        //1.拿出所有集合
        List<DictEntity> dictList = selectList(wrapper);

        //便利所有集合
        dictList.forEach(item -> {

            if (item.getParentId() == null) {
                List<DictEntity> subset = new ArrayList<>();

                dictList.forEach(dictItem -> {
                    if (item.getId().equals(dictItem.getParentId())) {
                        dictItem.setDictType(item.getDictType());
                        subset.add(dictItem);
                    }
                });

                allDictList.put(item.getDictCode(), subset);
            }
        });

        return allDictList;
    }

    @Delete("DELETE FROM dict WHERE is_deleted = 1")
    void clearDict();
}