CREATE TABLE `file`
(
    `id`          bigint                                                        NOT NULL COMMENT 'id',
    `parent_id`   bigint                                                                 DEFAULT NULL COMMENT '父节点id',
    `file_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件名称',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT 'url地址',
    `file_type`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件类型',
    `file_path`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件路径',
    `file_size`   bigint                                                                 DEFAULT NULL COMMENT '文件大小',
    `status`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '状态',
    `remark`      varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '备注',
    `creator`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '创建人',
    `updater`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)                                                        NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                                 DEFAULT NULL COMMENT '租户id',
    `version`     tinyint                                                                DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  ROW_FORMAT = DYNAMIC COMMENT ='文件';