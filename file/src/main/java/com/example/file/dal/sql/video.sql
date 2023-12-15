CREATE TABLE `video`
(
    `id`          bigint  NOT NULL COMMENT 'id',
    `parent_id`   bigint                                                        DEFAULT NULL COMMENT '父节点id',
    `video_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频名称',
    `title`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频标题',
    `type`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频分类',
    `region`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频地区',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'url地址',
    `picture`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频图片',
    `video_type`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频类型',
    `profile`     varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '视频简介',
    `label`       varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
    `author`      varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
    `author_id`   bigint                                                        DEFAULT NULL COMMENT '视频创作人id',
    `season`      int                                                           DEFAULT NULL COMMENT '季',
    `episode`     int                                                           DEFAULT NULL COMMENT '集',
    `duration`    int                                                           DEFAULT NULL COMMENT '时长',
    `play_num`    int                                                           DEFAULT NULL COMMENT '播放量',
    `status`      VARCHAR(255) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '状态',
    `remark`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                       DEFAULT NULL COMMENT '备注',
    `creator`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '创建人',
    `updater`     VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '更新人',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)  NOT NULL                                              DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                                        DEFAULT NULL COMMENT '租户id',
    `version`     TINYINT NOT NULL                                              DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='视频';