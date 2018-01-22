package org.wtm.wtmwebsite.dto;

import org.wtm.wtmwebsite.dao.Gallery;

import java.util.Date;
import java.util.List;

public class Event {

    private String uuid;
    private String name;
    private Date date;
    private String location;
    private List<Member> organizers;
    private List<Gallery> gallery;

    public Event() {
    }

    public Event(String uuid, String name, Date date, String location,
                 List<Member> organizers, List<Gallery> gallery) {
        this.uuid = uuid;
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizers = organizers;
        this.gallery = gallery;
    }

    public String getUuid() {
       return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<Member> organizers) {
        this.organizers = organizers;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }
}
