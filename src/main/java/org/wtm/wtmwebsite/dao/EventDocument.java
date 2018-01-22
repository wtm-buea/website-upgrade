package org.wtm.wtmwebsite.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "event")
public class EventDocument {

    @Id
    private String uuid;
    private String name;
    private Date date;
    private String location;
    private List<MemberDocument> organizers;
    private List<Gallery> gallery;
    private Boolean isActive;

    public EventDocument() {
    }

    public EventDocument(String uuid, String name, Date date, String location,
                         List<MemberDocument> organizers, List<Gallery> gallery,
                         Boolean isActive) {
        this.uuid = uuid;
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizers = organizers;
        this.gallery = gallery;
        this.isActive = isActive;
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

    public List<MemberDocument> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<MemberDocument> organizers) {
        this.organizers = organizers;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
