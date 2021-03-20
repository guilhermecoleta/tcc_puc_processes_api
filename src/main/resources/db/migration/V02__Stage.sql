create table stage (
    id bigint constraint pk_stage primary key,
    name varchar(100) not null
);

create sequence seq_stage
    increment 1
        minvalue 1
        maxvalue 9223372036854775807
        start 1
        cache 1;





