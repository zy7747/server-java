CREATE TABLE `audio`
(
    `id`             BIGINT  NOT NULL COMMENT 'id',
    `audio_name`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频名称',
    `title`          VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频标题',
    `type`           VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频分类',
    `region`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频地区',
    `url`            VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT 'url地址',
    `picture`        VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频图片',
    `video_type`     VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频类型',
    `profile`        VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '音频简介',
    `label`          VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '标签',
    `singer`         VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '歌手名称',
    `lyricist`       VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '作词',
    `composing`      VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '作曲',
    `lyrics`         TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci        DEFAULT NULL COMMENT '歌词',
    `duration`       INT                                                          DEFAULT NULL COMMENT '时长',
    `stars_num`      INT                                                          DEFAULT NULL COMMENT '点赞量',
    `collection_num` INT                                                          DEFAULT NULL COMMENT '收藏量',
    `play_num`       INT                                                          DEFAULT NULL COMMENT '播放量',
    `status`         VARCHAR(255) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '状态',
    `remark`         VARCHAR(512) COLLATE utf8mb4_unicode_ci                      DEFAULT NULL COMMENT '备注',
    `creator`        VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人',
    `updater`        VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人',
    `create_year`    datetime                                                     DEFAULT NULL COMMENT '创作年份',
    `create_time`    datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     bit(1)  NOT NULL                                             DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`      INT(10) UNSIGNED                                             DEFAULT NULL COMMENT '租户id',
    `version`        TINYINT NOT NULL                                             DEFAULT 0 COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '音频';