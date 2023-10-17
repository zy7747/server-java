CREATE TABLE `job`
(
    `id`               BIGINT                                 NOT NULL COMMENT 'id',
    `job_name`         VARCHAR(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '任务名称',
    `start_time`       datetime                                                     DEFAULT NULL COMMENT '开始时间',
    `execute_count`    TINYINT                                NOT NULL              DEFAULT '0' COMMENT '执行次数',
    `execute_interval` BIGINT                                 NOT NULL              DEFAULT 0 COMMENT '执行间隔',
    `status`           VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`           VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`          VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`          VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time`      datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`      datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`       bit(1)                                 NOT NULL              DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`        INT(10) UNSIGNED                                             DEFAULT NULL COMMENT '租户id',
    `version`          TINYINT                                NOT NULL              DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '定时任务';