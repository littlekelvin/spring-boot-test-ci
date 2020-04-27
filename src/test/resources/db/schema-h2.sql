-- auto-generated definition
create table m_author
(
    id               bigint auto_increment
        primary key,
    create_by        varchar(255) null,
    create_date      datetime(3)  null,
    last_update_by   varchar(255) null,
    last_update_date datetime     null,
    age              int          null,
    gender           varchar(255) null,
    name             varchar(32)  not null
);

-- auto-generated definition
create table m_post
(
    id               bigint auto_increment
        primary key,
    create_by        varchar(255) null,
    create_date      datetime(3)  null,
    last_update_by   varchar(255) null,
    last_update_date datetime     null,
    body             varchar(255) null,
    title            varchar(255) null,
    author_id        bigint       null,
    constraint FKp1hw0ofp49x20h8yjt7fg5j0p
        foreign key (author_id) references m_author (id)
);

-- auto-generated definition
create table m_user
(
    id               bigint auto_increment
        primary key,
    create_by        varchar(255) null,
    create_date      datetime(3)  null,
    last_update_by   varchar(255) null,
    last_update_date datetime     null,
    birth_day        datetime(3)  null,
    password         varchar(255) null,
    role             int          null,
    username         varchar(255) null
);
