package com.example.system.service.person;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.person.PersonQueryDTO;
import com.example.system.dal.dto.person.PersonSaveDTO;
import com.example.system.dal.entity.PersonEntity;
import com.example.system.dal.vo.person.PersonDetailVO;
import com.example.system.dal.vo.person.PersonListVO;
import com.example.system.dal.vo.person.PersonPageVO;

import java.util.List;

public interface PersonService {
    /**
     * 获取列表分页
     *
     * @param person 分页入参
     * @return 列表分页
     */
    Result<PageList<PersonPageVO>> personPageService(PersonQueryDTO person);

    /**
     * 获取列表
     *
     * @param person 入参
     * @return 列表
     */
    Result<List<PersonListVO>> personListService(PersonQueryDTO person);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<PersonDetailVO> personDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param person 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<PersonEntity>> personSaveListService(List<PersonSaveDTO> person);
}
