package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.EventsParticipant;
import school.hei.haapi.repository.EventsParticipantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventsParticipantService {

    private final EventsParticipantRepository repository;

    public EventsParticipant getById(String eventParticipantId) {
        return repository.getById(eventParticipantId);
    }

    public List<EventsParticipant> getAll() {
        return repository.findAll();
    }

    public List<EventsParticipant> saveAll(List<EventsParticipant> eventsParticipants) {
        return repository.saveAll(eventsParticipants);
    }
}
