package com.example.framework.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.framework.utils.GetHeaderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增时候插入
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", null);
        metaObject.setValue("creator", null);
        strictInsertFill(metaObject, "createTime", Date.class, new Date());
        strictInsertFill(metaObject, "creator", String.class, GetHeaderInfo.getLoginUserId());
    }

    /**
     * 更新数据时候时候插入
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        metaObject.setValue("updateTime", null);
        metaObject.setValue("updater", null);
        strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        strictUpdateFill(metaObject, "updater", String.class, GetHeaderInfo.getLoginUserId());
    }
}