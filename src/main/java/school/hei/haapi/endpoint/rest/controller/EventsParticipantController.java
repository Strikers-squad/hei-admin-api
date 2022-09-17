package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.haapi.endpoint.rest.mapper.EventMapper;
import school.hei.haapi.endpoint.rest.mapper.EventParticipantMapper;
import school.hei.haapi.model.Event;
import school.hei.haapi.model.EventsParticipant;
import school.hei.haapi.service.EventService;
import school.hei.haapi.service.EventsParticipantService;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class EventsParticipantController {

    private final EventsParticipantService eventsParticipantService;
    private final EventParticipantMapper eventParticipantMapper;

    @GetMapping(value = "/events_participant/{id}")
    public EventsParticipant getEventById(@PathVariable String id) {
        return eventParticipantMapper.toRest(eventsParticipantService.getById(id));
    }

    @GetMapping(value = "/events_participant")
    public List<EventsParticipant> getEvents() {
        return eventsParticipantService.getAll().stream()
                .map(eventParticipantMapper::toRest)
                .collect(toUnmodifiableList());
    }

    @PutMapping(value = "/events_participant")
    public List<EventsParticipant> createOrUpdateGroups(@RequestBody List<EventsParticipant> toWrite) {
        var saved = eventsParticipantService.saveAll(toWrite.stream()
                .map(eventParticipantMapper::toDomain)
                .collect(toUnmodifiableList()));
        return saved.stream()
                .map(eventParticipantMapper::toRest)
                .collect(toUnmodifiableList());
    }
}
