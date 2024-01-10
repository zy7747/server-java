CREATE TABLE `video`
(
    `id`            bigint  NOT NULL COMMENT 'id',
    `parent_id`     bigint                                                         DEFAULT NULL COMMENT '父节点id',
    `video_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '视频名称',
    `title`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '视频标题',
    `type`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   DEFAULT NULL COMMENT '视频分类',
    `region`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   DEFAULT NULL COMMENT '视频地区',
    `save_path`     bigint                                                         DEFAULT NULL COMMENT '视频存储节点',
    `url`           varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'url地址',
    `picture`       varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '视频图片',
    `video_type`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   DEFAULT NULL COMMENT '视频类型',
    `profile`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '视频简介',
    `label`         varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '标签',
    `author`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '作者',
    `season`        int                                                            DEFAULT NULL COMMENT '季',
    `episode`       int                                                            DEFAULT NULL COMMENT '集',
    `play_num`      int                                                            DEFAULT '0' COMMENT '播放量',
    `is_collection` bit(1)  NOT NULL                                               DEFAULT b'0' COMMENT '是否是集合',
    `duration`      datetime                                                       DEFAULT NULL COMMENT '时长',
    `create_year`   datetime                                                       DEFAULT NULL COMMENT '创作年份',
    `status`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '状态',
    `remark`        varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '备注',
    `creator`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   DEFAULT '' COMMENT '创建人',
    `updater`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci   DEFAULT '' COMMENT '更新人',
    `create_time`   datetime                                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                       DEFAULT NULL COMMENT '更新时间',
    `is_deleted`    bit(1)  NOT NULL                                               DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`     bigint                                                         DEFAULT NULL COMMENT '租户id',
    `version`       tinyint NOT NULL                                               DEFAULT '0' COMMENT '乐观锁',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='视频';