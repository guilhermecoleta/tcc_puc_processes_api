create table process_status (
    id bigint constraint pk_process_status primary key,
    name varchar(100) not null
);

create sequence seq_process_status
    increment 1
        minvalue 1
        maxvalue 9223372036854775807
        start 1
        cache 1;






