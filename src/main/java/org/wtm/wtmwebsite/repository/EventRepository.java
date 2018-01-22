package org.wtm.wtmwebsite.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.wtm.wtmwebsite.dao.EventDocument;
import org.wtm.wtmwebsite.dao.MemberDocument;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public class EventRepository implements Repository<EventDocument> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void createCollection() {
        if( !mongoTemplate.collectionExists(EventDocument.class) ) {
            mongoTemplate.createCollection(EventDocument.class);
        }
    }

    @Override
    public EventDocument create(EventDocument eventDoc) {
        mongoTemplate.insert(eventDoc, "event");
        return eventDoc;
    }

    @Override
    public List findAll(Pageable pageable) {
        return mongoTemplate.findAll(EventDocument.class);
    }

    @Override
    public EventDocument findById(String uuid) {
        return mongoTemplate.findOne(new Query(Criteria.where("uuid").is(uuid)), EventDocument.class);
    }

    public EventDocument findByName(String name) {
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), EventDocument.class);
    }

    public EventDocument findByDate(Date date) {
        return mongoTemplate.findOne(new Query(Criteria.where("date").is(date)), EventDocument.class);
    }

    public EventDocument findByLocaction(String location) {
        return mongoTemplate.findOne(new Query(Criteria.where("location").is(location)), EventDocument.class);
    }

    @Override
    public EventDocument update(EventDocument eventDoc) {
        Query query = new Query(Criteria.where("uuid").is(eventDoc.getUuid()));
        Update update = new Update();
        update.set("name", eventDoc.getName());
        update.set("date", eventDoc.getDate());
        update.set("location", eventDoc.getLocation());
        update.set("organizers", eventDoc.getOrganizers());
        update.set("gallery", eventDoc.getGallery());

        mongoTemplate.updateFirst(query, update, MemberDocument.class);
        return eventDoc;
    }

    @Override
    public void delete(String uuid) {
        mongoTemplate.updateFirst(new Query(Criteria.where("uuid").is(uuid)),
                Update.update("isActive", false), EventDocument.class);

    }
}
