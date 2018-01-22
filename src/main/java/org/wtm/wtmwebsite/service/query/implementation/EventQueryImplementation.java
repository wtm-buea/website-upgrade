package org.wtm.wtmwebsite.service.query.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.EventDocument;
import org.wtm.wtmwebsite.dto.Event;
import org.wtm.wtmwebsite.repository.EventRepository;
import org.wtm.wtmwebsite.service.mapper.EventMapper;
import org.wtm.wtmwebsite.service.query.EventQuery;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EventQueryImplementation implements EventQuery {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event findById(String uuid) {
        EventDocument eventDoc = eventRepository.findById(uuid);
        return EventMapper.getEventDTO(eventDoc);
    }

    @Override
    public List<Event> findByName(String name) {
        return null;
    }

    @Override
    public Event findByDate(Date date) {
        EventDocument eventDoc = eventRepository.findByDate(date);
        return EventMapper.getEventDTO(eventDoc);
    }

    @Override
    public List<Event> findByLocation(String location) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

}
