CREATE TABLE `log`
(
    `id`              BIGINT                                 NOT NULL COMMENT 'id',
    `operate`         VARCHAR(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作',
    `operate_content` VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '操作内容',
    `remark`          VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `operator`        VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `operate_time`    datetime                                                     DEFAULT NULL COMMENT '操作时间',
    `is_deleted`      bit(1)                                 NOT NULL              DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`       INT(10) UNSIGNED                                             DEFAULT NULL COMMENT '租户id',
    `version`         TINYINT                                NOT NULL              DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '日志';