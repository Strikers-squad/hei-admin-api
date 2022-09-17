do
$$
    begin
        if not exists(select from pg_type where typname = 'type') then
            create type type as enum ('COURSES', 'EXAMS', 'CONFERENCES');
        end if;
        if not exists(select from pg_type where typname = 'event_status') then
            create type event_status as enum ('ACTIVE', 'CANCEL');
        end if;
    end
$$;

create table if not exists "event"
(
    id                varchar
        constraint event_pk primary key default uuid_generate_v4(),
    event_type        type                not null,
    description        varchar                not null,
    responsible_id    varchar                   ,
    constraint  event_responsible_fk     foreign key(responsible_id)     references  "user"(id),
    start_event             timestamp with time zone  not null,
    end_event               timestamp with time zone  not null,
    place_id          varchar                   ,
    constraint  event_place_fk   foreign key(place_id)  references  "place"(id),
    status            event_status              not null
);
