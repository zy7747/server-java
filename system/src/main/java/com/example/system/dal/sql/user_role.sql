CREATE TABLE `user_role`
(
    `user_id` BIGINT NOT NULL COMMENT '用户id',
    `role_id` BIGINT NOT NULL COMMENT '角色id'
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色关联表'