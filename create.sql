create database blog;
use blog;
create table `blog_user` (
    `id` bigint(20) auto_increment comment '自增主键',
    `uid` bigint(20) not null unique comment '用户id',
    `user_name` varchar(64) not null unique comment '用户名',
    `password` varchar(256) not null default '123456' comment '用户密码',
    `avatar` varchar(64)  comment '用户头像',
    `create_time` datetime default current_timestamp comment '创建时间',
    `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
    `is_deleted` int(4) not null default 0 comment '是否删除',
    primary key (`id`),
    index `idx_user_name` (`user_name`),
    index `idx_uid` (`uid`)
);