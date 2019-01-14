create table person
(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  primary key(id)
);

INSERT INTO PERSON (id, name, location, birth_date) VALUES (10001, 'Hubert', 'Poznan', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) VALUES (10002, 'Adam', 'Koszalin', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) VALUES (10003, 'Bartek', 'Wroclaw', sysdate());
