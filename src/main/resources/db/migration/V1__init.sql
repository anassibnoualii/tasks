CREATE TABLE task
(
    id     bigint                 NOT NULL,
    name   character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);

CREATE SEQUENCE task_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;
