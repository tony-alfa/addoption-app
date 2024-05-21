drop table if exists adopter_pet;
drop table if exists adopter;
drop table if exists pet;

drop sequence if exists adopter_pet_id_seq;
drop sequence if exists adopter_id_seq;
drop sequence if exists pet_id_seq;

create table public.pet
(
    id      serial
        constraint pet_pk
            primary key,
    name    varchar(20)  not null,
    type   varchar(100) not null,
    breed  varchar(100)
);

alter table public.pet
    owner to larku;

create table public.scheduledclass
(
    id        serial
        constraint scheduledclass_pk
            primary key,
    startdate date,
    enddate   date,
    course_id integer
        constraint scheduledclass_course_id_fk
            references public.course
);

alter table public.scheduledclass
    owner to larku;

create table public.student
(
    id     serial
        constraint student_pk
            primary key,
    name   varchar(100) not null,
    dob    date,
    status varchar(20)
);

alter table public.student
    owner to larku;

create table public.phonenumber
(
    id         serial
        constraint phonenumber_pk
            primary key,
    type       varchar(20),
    number     varchar(50),
    student_id integer
        constraint phonenumber_student_id_fk
            references public.student
);


alter table public.phonenumber
    owner to larku;

create table public.student_scheduledclass
(
    students_id integer
        constraint student_scheduledclass_student_id_fk
            references public.student,
    classes_id   integer
        constraint student_scheduledclass_scheduledclass_id_fk
            references public.scheduledclass,
    constraint student_scheduledclass_pk
        unique (classes_id, students_id)
);

alter table public.student_scheduledclass
    owner to larku;


-- create sequence public.course_id_seq
--     as integer;

alter sequence public.course_id_seq owner to larku;

alter sequence public.course_id_seq owned by public.course.id;

-- create sequence public.scheduledclass_id_seq
--     as integer;

alter sequence public.scheduledclass_id_seq owner to larku;

alter sequence public.scheduledclass_id_seq owned by public.scheduledclass.id;

-- create sequence public.student_id_seq
--     as integer;

alter sequence public.student_id_seq owner to larku;

alter sequence public.student_id_seq owned by public.student.id;

-- create sequence public.phonenumber_id_seq
--     as integer;

alter sequence public.phonenumber_id_seq owner to larku;

alter sequence public.phonenumber_id_seq owned by public.phonenumber.id;

