package com.example.system.utils;

import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.mapper.DictMapper;

import javax.annotation.Resource;
import java.util.List;

public class DictUtil {
    @Resource
    DictMapper dictMapper;

    public List<DictEntity> getDictList(String dictCode) {
        DictQueryDTO dict = new DictQueryDTO();

        dict.setDictCode(dictCode);

        return dictMapper.subList(dict);
    }
}
