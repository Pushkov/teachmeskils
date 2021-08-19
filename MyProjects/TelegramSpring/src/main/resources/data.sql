DROP TABLE IF EXISTS CITYS;

create table CITYS
(
    ID   BIGINT auto_increment,
    NAME VARCHAR default 255,
    constraint CITYS_PK
        primary key (ID)
);

DROP TABLE IF EXISTS PLACES;

create table PLACES
(
    ID      BIGINT auto_increment,
    NAME    VARCHAR default 255,
    CITY_ID BIGINT,
    GRADE   VARCHAR default 255,
    constraint PLACES_PK
        primary key (ID),
    foreign key (CITY_ID) references CITYS (ID)
);


-- INSERTING INITIAL DATA **********************************************************************************************
INSERT INTO CITYS
    (NAME)
VALUES ('минск'),
       ('киев'),
       ('москва'),
       ('жлобин');


INSERT INTO PLACES
    (NAME, CITY_ID, GRADE)
VALUES ('Национальная Библиотека', 1, 'GOOD'),
       ('Магазин "Вино-Пиво"', 1, 'BAD'),
       ('Крещатик', 2, 'GOOD'),
       ('Свалка за Крещатиком', 2, 'BAD'),
       ('Красная площадь', 3, 'GOOD'),
       ('ЦУМ', 3, 'BAD'),
       ('Аквапарк', 4, 'GOOD'),
       ('Рынок', 4, 'BAD');



