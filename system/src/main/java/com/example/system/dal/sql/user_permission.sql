CREATE TABLE `permission`
(
    `user_id`         bigint NOT NULL COMMENT '用户id',
    `permission_id`   bigint NOT NULL COMMENT '权限id',
    `create_time`     datetime        DEFAULT NULL COMMENT '创建时间',
    `expiration_time` datetime        DEFAULT NULL COMMENT '失效时间',
    `is_invalidation` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否失效'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户权限关联表';