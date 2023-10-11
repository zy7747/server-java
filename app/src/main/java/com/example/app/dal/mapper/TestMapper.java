package com.example.app.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.app.dal.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<UserEntity> {


}
