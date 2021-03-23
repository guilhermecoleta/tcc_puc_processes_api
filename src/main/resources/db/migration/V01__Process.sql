create table process (
    id bigint constraint pk_process primary key,
    number bigint not null,
    priority integer not null,
    document_id bigint not null,
    product_id bigint not null,
    quantity_product integer not null,
    process_status varchar(50)
);

create sequence seq_process
    increment 1
        minvalue 1
        maxvalue 9223372036854775807
        start 1
        cache 1;






