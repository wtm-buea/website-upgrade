package org.wtm.wtmwebsite.service.query;

import org.wtm.wtmwebsite.dto.Event;

import java.util.Date;
import java.util.List;

public interface EventQuery {

    Event findById(String uuid);
    List<Event> findByName(String name);
    Event findByDate(Date date);
    List<Event> findByLocation(String location);
    List<Event> findAll();

}
