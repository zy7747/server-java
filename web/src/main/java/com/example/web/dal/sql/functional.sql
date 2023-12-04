CREATE TABLE `functional`
(
    `id`              bigint                                                        NOT NULL COMMENT 'id',
    `parent_id`       bigint                                                                 DEFAULT NULL COMMENT '父节点id',
    `functional_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '功能名称',
    `describe`        text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '功能描述',
    `is_Pay`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否需要付费',
    `status`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
    `remark`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '备注',
    `creator`         varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '创建人',
    `updater`         varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '更新人',
    `create_time`     datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `is_deleted`      bit(1)                                                        NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`       bigint                                                                 DEFAULT NULL COMMENT '租户id',
    `version`         tinyint                                                                DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='功能';