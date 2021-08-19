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
VALUES ('Минск'),
       ('Киев'),
       ('Москва'),
       ('Жлобин');


INSERT INTO PLACES
    (NAME, CITY_ID, GRADE)
VALUES ('1', 1, 'GOOD'),
       ('2', 2, 'BAD'),
       ('4', 4, 'GOOD'),
       ('3', 3, 'BAD');



