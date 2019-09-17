create table if not exists Users(
id bigint primary key auto_increment,
username varchar(50) not null,
password varchar(150) not null
);