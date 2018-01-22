package org.wtm.wtmwebsite.service.command;

import org.wtm.wtmwebsite.dto.Event;

public interface EventCommand {

    Event createEvent( Event event );
    Event updateEvent( Event event );
    void deleteEvent( String uuid );

}
