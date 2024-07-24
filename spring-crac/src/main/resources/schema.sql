create table `spring-crac`.attendee
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table `spring-crac`.attendee_technologies
(
    attendee_id bigint       not null,
    technology  varchar(255) null,
    constraint FKcgkfv5bqtlsa3231a6ua2orxn
        foreign key (attendee_id) references `spring-crac`.attendee (id)
);

