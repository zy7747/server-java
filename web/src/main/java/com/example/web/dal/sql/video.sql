CREATE TABLE `video`
(
    `id`             BIGINT NOT NULL COMMENT 'id',
    `parent_id`      BIGINT                                                       DEFAULT NULL COMMENT '父节点id',
    `video_name`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频名称',
    `title`          VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频标题',
    `type`           VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频分类',
    `region`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频地区',
    `url`            VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT 'url地址',
    `picture`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频图片',
    `video_type`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频类型',
    `profile`        VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '视频简介',
    `label`          VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '标签',
    `author`         VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '作者名称',
    `season`         TINYINT                                                      DEFAULT NULL COMMENT '季',
    `episode`        TINYINT                                                      DEFAULT NULL COMMENT '集',
    `duration`       TINYINT                                                      DEFAULT NULL COMMENT '时长',
    `stars_num`      TINYINT                                                      DEFAULT NULL COMMENT '点赞量',
    `collection_num` TINYINT                                                      DEFAULT NULL COMMENT '收藏量',
    `play_num`       TINYINT                                                      DEFAULT NULL COMMENT '播放量',
    `status`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`         VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`        VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`        VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_year`    datetime                                                     DEFAULT NULL COMMENT '创作年份',
    `create_time`    datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     bit(1) NOT NULL                                              DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='视频';