create table process_stage (
    id bigint constraint pk_process_stage primary key,
    observation varchar(1000),
    note varchar(1000),
    order_process_stage integer not null,
    expected_dat_start timestamp not null,
    dat_start timestamp,
    expected_dat_end timestamp not null,
    dat_end timestamp,
    name varchar(100),
    process_id bigint constraint process_fk REFERENCES process(id)
);

create sequence seq_process_stage
    increment 1
        minvalue 1
        maxvalue 9223372036854775807
        start 1
        cache 1;




