package com.example.system.utils;

import com.example.framework.utils.SpringUtils;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.mapper.DictMapper;

import java.util.List;

public class DictUtil {

    public static List<DictEntity> getDictList(String dictCode) {
        DictMapper dictMapper = SpringUtils.getBean(DictMapper.class);

        DictQueryDTO dict = new DictQueryDTO();

        dict.setDictCode(dictCode);

        return dictMapper.subList(dict);
    }

    public static String translate(List<DictEntity> dictList, String value) {
        DictEntity dict = dictList.stream().filter(item -> item.getValue().equals(value)).findFirst().orElse(null);

        assert dict != null;
        return dict.getLabel();
    }

}
