do
$$
    begin
        if not exists(select from pg_type where typname = 'event_type') then
            create type event_type as enum ('EXPECTED', 'HERE', 'MISSING');
        end if;
    end
$$;

create table if not exists "event"
(
    id                varchar
        constraint event_participant_pk primary key default uuid_generate_v4(),
    event_participant_id    varchar                   not null
    constraint event_participant_pk references "eventsParticipant"(id),
    status            event_participant_status              not null
);
