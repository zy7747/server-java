CREATE TABLE `operation_log`
(
    `id`            BIGINT                                  NOT NULL COMMENT 'id',
    `title`         VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
    `module`        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作模块',
    `content`       VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '操作内容',
    `type`          VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '操作类型',
    `operate_ip`    VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '操作IP',
    `operate_place` VARCHAR(32) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '操作地',
    `time`          TINYINT                                                      DEFAULT 0 COMMENT '耗时',
    `error_msg`     VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '错误信息',
    `status`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`        VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`       VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`       VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time`   datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`    bit(1)                                  NOT NULL             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`     bigint                                                       DEFAULT NULL COMMENT '租户id',
    `version`       TINYINT                                 NOT NULL             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志';