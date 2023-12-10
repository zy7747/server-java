CREATE TABLE `menu`
(
    `id`          BIGINT                                  NOT NULL COMMENT 'id',
    `parent_id`   BIGINT                                                       DEFAULT NULL COMMENT '父节点id',
    `title`       VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名',
    `name`        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '组件名',
    `path`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '路由路径',
    `type`        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型',
    `component`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '组件',
    `permission`  VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '权限标识',
    `level`       TINYINT COMMENT '层级',
    `sort`        TINYINT                                 NOT NULL COMMENT '排序',
    `visible`     TINYINT COMMENT '是否可见',
    `keep_alive`  TINYINT COMMENT '是否缓存',
    `always_show` TINYINT COMMENT '是否总是显示',
    `icon`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '图标',
    `description` VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '描述',
    `meta`        VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '其他信息',
    `status`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)                                  NOT NULL             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                       DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT                                 NOT NULL             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='菜单';