package org.wtm.wtmwebsite.service.mapper;

import org.wtm.wtmwebsite.dao.EventDocument;
import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dto.Event;
import org.wtm.wtmwebsite.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {

    public static Event getEventDTO(EventDocument eventDoc) {
        List<Member> organizers = new ArrayList<>();
                eventDoc.getOrganizers().
                        forEach(memberDoc -> organizers.add(MemberMapper.getMemberDTO(memberDoc)));

                return new Event(eventDoc.getUuid(), eventDoc.getName(),
                eventDoc.getDate(), eventDoc.getLocation(), organizers, eventDoc.getGallery());
    }

    public static EventDocument getEventDAO(Event event) {
        List<MemberDocument> organizers = new ArrayList<>();
        event.getOrganizers().
                forEach(member -> organizers.add(MemberMapper.getMemberDAO(member)));

        return new EventDocument(event.getUuid(), event.getName(),
                event.getDate(), event.getLocation(), organizers, event.getGallery(), true);
    }

}
