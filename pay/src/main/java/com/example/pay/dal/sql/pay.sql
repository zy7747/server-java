CREATE TABLE `pay`
(
    `id`          bigint                                                        NOT NULL COMMENT 'id',
    `order_id`    bigint                                                        NOT NULL COMMENT '订单ID',
    `payment`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付功能',
    `pay_way`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付方式',
    `card_num`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付银行卡/支付宝/微信号',
    `pay_user`    bigint                                                        NOT NULL COMMENT '支付用户',
    `pay_num`     decimal(10, 0)                                                NOT NULL COMMENT '支付金额',
    `pay_time`    datetime                                                      NOT NULL COMMENT '支付时间',
    `currency`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT '' COMMENT '货币',
    `status`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                                DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                                DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                               DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                               DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)                                                        NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                                 DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT                                                       NOT NULL DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='支付功能';