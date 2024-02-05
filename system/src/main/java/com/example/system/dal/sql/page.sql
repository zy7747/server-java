CREATE TABLE `page`
(
    `id`          BIGINT  NOT NULL COMMENT 'id',
    `menu_id`     BIGINT                                                       DEFAULT NULL COMMENT '页面id',
    `title`       VARCHAR(64) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '标题',
    `api`         VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '接口',
    `permission`  VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '权限',
    `content`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '页面内容',
    `status`      VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)  NOT NULL                                             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                       DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT NOT NULL                                             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='页面配置';