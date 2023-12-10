CREATE TABLE `area`
(
    `id`          BIGINT  NOT NULL COMMENT 'id',
    `parent_id`   BIGINT                                                       DEFAULT NULL COMMENT '父节点id',
    `area_name`   VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '名称',
    `address`     VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '地址',
    `other_name`  VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '别称',
    `type`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '区域类型',
    `code`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '区域编码',
    `axis`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '坐标',
    `acreage`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '面积',
    `population`  VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '人口',
    `climate`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '气候',
    `capital`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '首都',
    `sort`        TINYINT                                                      DEFAULT NULL COMMENT '排序',
    `level`       TINYINT                                                      DEFAULT NULL COMMENT '层级',
    `icon`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '地区图标',
    `description` VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '描述',
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
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='地区';