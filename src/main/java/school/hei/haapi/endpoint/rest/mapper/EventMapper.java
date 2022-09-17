package school.hei.haapi.endpoint.rest.mapper;

import org.springframework.stereotype.Component;
import school.hei.haapi.model.Event;

@Component
public class EventMapper {

    public Event toRest(Event event) {
        Event restEvent = new Event();
        restEvent.setId(event.getId());
        restEvent.setEventType(event.getEventType());
        restEvent.setDescription(event.getDescription());
        restEvent.setResponsible(event.getResponsible());
        restEvent.setStartEvent(event.getStartEvent());
        restEvent.setEndEvent(event.getEndEvent());
        restEvent.setStatus(event.getStatus());
        restEvent.setPlace(event.getPlace());
        return restEvent;
    }

    public Event toDomain(Event event) {
        return Event.builder()
                .id(event.getId())
                .eventType(event.getEventType())
                .description(event.getDescription())
                .responsible(event.getResponsible())
                .startEvent(event.getStartEvent())
                .endEvent(event.getEndEvent())
                .place(event.getPlace())
                .status(event.getStatus())
                .build();
    }

}
