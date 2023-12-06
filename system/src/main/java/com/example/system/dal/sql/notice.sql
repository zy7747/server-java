CREATE TABLE `notice`
(
    `id`             BIGINT                                  NOT NULL COMMENT 'id',
    `notice_name`    VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '消息名称',
    `notice_content` VARCHAR(900) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '消息内容',
    `push_module`    VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '推送模块',
    `type`           VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '类型',
    `is_read`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '是否已读',
    `status`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '状态',
    `remark`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '备注',
    `creator`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time`    datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     bit(1)                                  NOT NULL              DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '租户id',
    `version`        TINYINT                                 NOT NULL              DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='消息通知';