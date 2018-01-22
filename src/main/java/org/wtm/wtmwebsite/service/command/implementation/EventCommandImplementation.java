package org.wtm.wtmwebsite.service.command.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.EventDocument;
import org.wtm.wtmwebsite.dto.Event;
import org.wtm.wtmwebsite.repository.EventRepository;
import org.wtm.wtmwebsite.service.command.EventCommand;
import org.wtm.wtmwebsite.service.mapper.EventMapper;

import java.util.UUID;

@Service
@Transactional
public class EventCommandImplementation implements EventCommand {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        event.setUuid(UUID.randomUUID().toString());
        EventDocument eventDoc = eventRepository.create(EventMapper.getEventDAO(event));
        return EventMapper.getEventDTO(eventDoc);
    }

    @Override
    public Event updateEvent(Event event) {
        EventDocument eventDoc = eventRepository.update(EventMapper.getEventDAO(event));
        return EventMapper.getEventDTO(eventDoc);
    }

    @Override
    public void deleteEvent(String uuid) {
        eventRepository.delete(uuid);
    }

}
