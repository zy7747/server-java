CREATE TABLE `user`
(
    `id`          BIGINT                                  NOT NULL COMMENT 'id',
    `uid`         BIGINT                                                       DEFAULT NULL COMMENT '用户id',
    `phone`       VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '电话号码',
    `email`       VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '电子邮箱',
    `account`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '账号',
    `password`    VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `user`        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
    `name`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '真实姓名',
    `id_card`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '身份证号码',
    `avatar`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '头像',
    `sex`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '性别',
    `user_type`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '用户类型',
    `age`         TINYINT                                                      DEFAULT NULL COMMENT '年龄',
    `birth_date`  datetime                                                     DEFAULT NULL COMMENT '出生日期',
    `status`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)                                  NOT NULL             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   BIGINT                                                       DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT                                 NOT NULL             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户'