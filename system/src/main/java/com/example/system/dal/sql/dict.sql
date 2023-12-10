CREATE TABLE `dict`
(
    `id`          BIGINT  NOT NULL COMMENT 'id',
    `parent_id`   BIGINT                                                       DEFAULT NULL COMMENT '父节点id',
    `dict_name`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '字典名称',
    `dict_code`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '字典编码',
    `dict_type`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '字典类型',
    `label`       VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '名',
    `value`       VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '值',
    `color`       VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '自定义颜色',
    `css`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '自定义CSS样式',
    `sort`        TINYINT                                                      DEFAULT NULL COMMENT '排序',
    `params`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '其他参数',
    `status`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)  NOT NULL                                             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                       DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT NOT NULL                                             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '字典'