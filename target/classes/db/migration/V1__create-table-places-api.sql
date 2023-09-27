CREATE TABLE places (

    id bigint auto_increment,
    name varchar(200) not null,
    city varchar(200) not null,
    state varchar(4) not null,
    created_at DATETIME not null,
    updated_at DATETIME,
    status tinyint not null,
    primary key(id)
);
