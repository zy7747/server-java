package com.example.system.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.entity.DictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {
    //分页
    default PageList<DictEntity> selectPage(DictQueryDTO dict) {
        IPage<DictEntity> pageParams = new Page<>(dict.getPage(), dict.getSize());
        QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();

        if (dict.getDictCode() != null) {
            wrapper.eq("dict_code", dict.getDictCode());
        }

        if (dict.getDictName() != null) {
            wrapper.eq("dict_name", dict.getDictName());
        }

        if (dict.getStatus() != null) {
            wrapper.eq("status", dict.getStatus());
        }

        wrapper.isNull("parent_id");

        wrapper.orderByDesc("create_time");

        return PageList.setPages(selectPage(pageParams, wrapper));
    }

    //列表查询
    default List<DictEntity> selectList(DictQueryDTO dict) {
        QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();
        return selectList(wrapper);
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
        QueryWrapper<DictEntity> wrapperId = new QueryWrapper<>();
        //新建一个要返回的集合
        Map<String, Object> allDictList = new HashMap<>();

        wrapperId.isNull("parent_id");
        //1.拿出所有集合
        List<DictEntity> dictList = selectList(wrapperId);
        //便利所有集合
        dictList.forEach(item -> {
            QueryWrapper<DictEntity> wrapper = new QueryWrapper<>();
            //寻找子集
            wrapper.eq("parent_id", item.getId());

            List<DictEntity> subset = selectList(wrapper);

            subset.forEach(map -> map.setDictType(item.getDictType()));

            allDictList.put(item.getDictCode(), subset);
        });

        return allDictList;
    }
}