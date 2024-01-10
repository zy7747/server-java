CREATE TABLE `audio`
(
    `id`          bigint  NOT NULL COMMENT 'id',
    `audio_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频名称',
    `title`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频标题',
    `type`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '音频分类',
    `save_path`   bigint                                                        DEFAULT NULL COMMENT '音频存储节点',
    `region`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频地区',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'url地址',
    `picture`     varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频图片',
    `audio_type`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '音频类型',
    `profile`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '音频简介',
    `label`       varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
    `singer`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '歌手名称',
    `lyricist`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '作词',
    `composing`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '作曲',
    `lyrics`      text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '歌词',
    `duration`    int                                                           DEFAULT NULL COMMENT '时长',
    `play_num`    int                                                           DEFAULT '0' COMMENT '播放量',
    `status`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
    `remark`      varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
    `creator`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '创建人',
    `updater`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '更新人',
    `create_year` datetime                                                      DEFAULT NULL COMMENT '创作年份',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `is_deleted`  bit(1)  NOT NULL                                              DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   int unsigned                                                  DEFAULT NULL COMMENT '租户id',
    `version`     tinyint NOT NULL                                              DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='音频';