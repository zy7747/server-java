CREATE TABLE `user_permission`
(
    `user_id`       bigint NOT NULL COMMENT '用户id',
    `permission_id` bigint NOT NULL COMMENT '权限id'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户权限关联表';