CREATE TABLE `role_menu`
(
    `role_id` BIGINT NOT NULL COMMENT '角色id',
    `menu_id` BIGINT NOT NULL COMMENT '菜单id'
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '角色菜单关联表'