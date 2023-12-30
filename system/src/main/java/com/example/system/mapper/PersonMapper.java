package com.example.system.mapper;

//mapper

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.person.PersonQueryDTO;
import com.example.system.dal.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<PersonEntity> {
    default QueryWrapper<PersonEntity> search(PersonQueryDTO person) {
        QueryWrapper<PersonEntity> wrapper = new QueryWrapper<>();

        /* 照片 */
        if (!StrUtil.hasBlank(person.getPhoto())) {
            wrapper.eq("photo", person.getPhoto());
        }
        /* 姓名 */
        if (!StrUtil.hasBlank(person.getName())) {
            wrapper.eq("name", person.getName());
        }
        /* 性别 */
        if (!StrUtil.hasBlank(person.getSex())) {
            wrapper.eq("sex", person.getSex());
        }
        /* 职业 */
        if (!StrUtil.hasBlank(person.getProfession())) {
            wrapper.eq("profession", person.getProfession());
        }
        /* 国家 */
        if (!StrUtil.hasBlank(person.getNation())) {
            wrapper.eq("nation", person.getNation());
        }
        /* 籍贯 */
        if (!StrUtil.hasBlank(person.getOrigin())) {
            wrapper.eq("origin", person.getOrigin());
        }
        /* 住址 */
        if (!StrUtil.hasBlank(person.getAddress())) {
            wrapper.eq("address", person.getAddress());
        }
        /* 最高学历 */
        if (!StrUtil.hasBlank(person.getDegree())) {
            wrapper.eq("degree", person.getDegree());
        }
        /* 身高 */
        if (!StrUtil.hasBlank(person.getHeight())) {
            wrapper.eq("height", person.getHeight());
        }
        /* 体重 */
        if (!StrUtil.hasBlank(person.getWeight())) {
            wrapper.eq("weight", person.getWeight());
        }
        /* 爱好 */
        if (!StrUtil.hasBlank(person.getHobby())) {
            wrapper.eq("hobby", person.getHobby());
        }

        /* 身份证号码 */
        if (!StrUtil.hasBlank(person.getIdCard())) {
            wrapper.eq("id_card", person.getIdCard());
        }
        /* 电话号码 */
        if (!StrUtil.hasBlank(person.getPhone())) {
            wrapper.eq("phone", person.getPhone());
        }
        /* 电子邮箱 */
        if (!StrUtil.hasBlank(person.getEmail())) {
            wrapper.eq("email", person.getEmail());
        }

        /* 状态 */
        if (!StrUtil.hasBlank(person.getStatus())) {
            wrapper.eq("status", person.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(person.getRemark())) {
            wrapper.eq("remark", person.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(person.getCreator())) {
            wrapper.eq("creator", person.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(person.getUpdater())) {
            wrapper.eq("updater", person.getUpdater());
        }

        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<PersonEntity> selectPageList(PersonQueryDTO person) {
        IPage<PersonEntity> pageParams = new Page<>(person.getPage(), person.getSize());
        return PageList.setPages(selectPage(pageParams, search(person)));
    }

    /**
     * 列表查询
     */
    default List<PersonEntity> selectList(PersonQueryDTO person) {
        return selectList(search(person));
    }

}
