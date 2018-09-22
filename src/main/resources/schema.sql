drop table if exists TBL_HUMAN;
create table TBL_HUMAN
(
   human_id integer not null,
   name varchar(255),
   gender enum('FEMALE', 'MALE'),
   dna array not null,
   mutant boolean not null,
   CONSTRAINT TBL_ROUTE_PK PRIMARY KEY (human_id)
);