package com.example.system.service.person;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.PersonConvert;
import com.example.system.dal.dto.person.PersonQueryDTO;
import com.example.system.dal.dto.person.PersonSaveDTO;
import com.example.system.dal.entity.PersonEntity;
import com.example.system.mapper.PersonMapper;
import com.example.system.dal.vo.person.PersonDetailVO;
import com.example.system.dal.vo.person.PersonListVO;
import com.example.system.dal.vo.person.PersonPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonEntity> implements PersonService {
    @Resource
    PersonMapper personMapper;

    /**
     * 获取列表分页
     *
     * @param person 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<PersonPageVO>> personPageService(PersonQueryDTO person) {
        return Result.success(PersonConvert.INSTANCE.page(personMapper.selectPageList(person)));
    }

    /**
     * 获取列表
     *
     * @param person 入参
     * @return 列表
     */
    @Override
    public Result<List<PersonListVO>> personListService(PersonQueryDTO person) {
        return Result.success(PersonConvert.INSTANCE.list(personMapper.selectList(person)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<PersonDetailVO> personDetailService(Long id) {
        return Result.success(PersonConvert.INSTANCE.detail(personMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param person 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<PersonEntity>> personSaveListService(List<PersonSaveDTO> person) {
        List<PersonEntity> personList = PersonConvert.INSTANCE.saveList(person);
        this.saveOrUpdateBatch(personList);
        return Result.success(personList);
    }
}
