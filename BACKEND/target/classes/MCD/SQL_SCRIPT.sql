create table voiture(
    idVoiture int not null primary key ,
    numeroVoiture varchar(100) unique not null,
    marqueVoiture varchar(100) not null
);
create table user(
    idUser int not null ,
    userName varchar(100) not null ,
    password varchar(100) not null
);
create table comment(
    userId int not null ,
    voitureId int not null ,
    value text default null,
    constraint fk_userKey_comment foreign key (userId) references user(idUser),
    constraint fk_carKey_comment foreign key (userId) references user(idUser)
)