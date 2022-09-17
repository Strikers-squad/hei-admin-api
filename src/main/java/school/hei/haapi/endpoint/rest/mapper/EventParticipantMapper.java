package school.hei.haapi.endpoint.rest.mapper;

import org.springframework.stereotype.Component;
import school.hei.haapi.model.Event;
import school.hei.haapi.model.EventsParticipant;

@Component
public class EventParticipantMapper {

    public EventsParticipant toRest(EventsParticipant eventsParticipant) {
        EventsParticipant restEvent = new EventsParticipant();
        restEvent.setId(eventsParticipant.getId());
        restEvent.setEvent(eventsParticipant.getEvent());
        restEvent.setStatus((eventsParticipant.getStatus()));
        return restEvent;
    }

    public EventsParticipant toDomain(EventsParticipant eventsParticipant) {
        return EventsParticipant.builder()
                .id(eventsParticipant.getId())
                .event(eventsParticipant.getEvent())
                .status(eventsParticipant.getStatus())
                .build();
    }

}
