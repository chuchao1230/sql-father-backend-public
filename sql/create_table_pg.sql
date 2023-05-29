-- 创建库
create database sqlfather;

-- 切换库
\c sqlfather;

-- 用户表
create table if not exists user_info
(
    id           SERIAL  primary key,
    userName     varchar(256)                           null,
    userAccount  varchar(256)                           not null,
    userAvatar   varchar(1024)                          null,
    gender       int                                null,
    userRole     varchar(256) default 'user'            not null ,
    userPassword varchar(512)                           not null,
    createTime   timestamp     default CURRENT_TIMESTAMP not null,
    updateTime   timestamp     default CURRENT_TIMESTAMP not null,
    isDelete     int      default 0                 not null,
    constraint uni_userAccount
        unique (userAccount)
);

-- 词库表
create table if not exists dict
(
    id            SERIAL primary key,
    name          varchar(512)                       null,
    content       text                               null,
    reviewStatus  int      default 0                 not null,
    reviewMessage varchar(512)                       null,
    userId        bigint                             not null,
    createTime    timestamp default CURRENT_TIMESTAMP not null,
    updateTime    timestamp default CURRENT_TIMESTAMP not null,
    isDelete      int  default 0                 not null
);

create index idx_name
    on dict (name);

-- 表信息表
create table if not exists table_info
(
    id            SERIAL primary key,
    name          varchar(512)                       null,
    content       text                               null,
    reviewStatus  int      default 0                 not null,
    reviewMessage varchar(512)                       null,
    userId        bigint                             not null,
    createTime    timestamp default CURRENT_TIMESTAMP not null,
    updateTime    timestamp default CURRENT_TIMESTAMP not null,
    isDelete      int  default 0                 not null
);

create index tab_name
    on table_info (name);

-- 字段信息表
create table if not exists field_info
(
    id            SERIAL primary key,
    name          varchar(512)                       null,
    fieldName     varchar(512)                       null,
    content       text                               null,
    reviewStatus  int      default 0                 not null,
    reviewMessage varchar(512)                       null,
    userId        bigint                             not null,
    createTime    timestamp default CURRENT_TIMESTAMP not null,
    updateTime    timestamp default CURRENT_TIMESTAMP not null,
    isDelete      int  default 0                 not null
);

create index idx_fieldName
    on field_info (fieldName);

create index field_name
    on field_info (name);

-- 举报表
create table if not exists report
(
    id             SERIAL primary key,
    content        text                               not null ,
    type           int                                not null,
    reportedId     bigint                             not null,
    reportedUserId bigint                             not null,
    status         int      default 0                 not null,
    userId         bigint                             not null,
    createTime     timestamp default CURRENT_TIMESTAMP not null,
    updateTime     timestamp default CURRENT_TIMESTAMP not null,
    isDelete       int  default 0                 not null
);