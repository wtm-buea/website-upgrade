package org.wtm.wtmwebsite.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.exception.ConflictException;

import java.util.List;

@org.springframework.stereotype.Repository
public class MemberRepository implements Repository<MemberDocument> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void createCollection() {
        if( !mongoTemplate.collectionExists(MemberDocument.class) ) {
            mongoTemplate.createCollection(MemberDocument.class);
        }
    }

    @Override
    public MemberDocument create(MemberDocument memberDoc) {
        if ( mongoTemplate.count(new Query(Criteria.where("email").is(memberDoc.getEmail())),
                MemberDocument.class) == 0 ) {
            mongoTemplate.insert(memberDoc, "member");
            return memberDoc;
        }
        throw ConflictException.create("Conflict: email, {0} already exist in the system", memberDoc.getEmail());
    }

    @Override
    public List<MemberDocument> findAll( Pageable pageable ) {
        Query query = new Query().with(pageable);
        List<MemberDocument> members = mongoTemplate.find(query, MemberDocument.class);
        return members;
    }

    @Override
    public MemberDocument findById(String uuid) {
        return mongoTemplate.findOne(new Query(Criteria.where("uuid").is(uuid)), MemberDocument.class);
    }

    public MemberDocument findByEmail(String email) {
        return mongoTemplate.findOne(new Query(Criteria.where("email").is(email)), MemberDocument.class);
    }

    @Override
    public MemberDocument update(MemberDocument memberDoc) {
        if (mongoTemplate.count(new Query(Criteria.where("uuid").ne(memberDoc.getUuid()).
                andOperator(Criteria.where("email").is(memberDoc.getEmail()))), MemberDocument.class) == 0 ) {

            Query query = new Query(Criteria.where("uuid").is(memberDoc.getUuid()));
            Update update = new Update();
            update.set("firstName", memberDoc.getFirstName());
            update.set("lastName", memberDoc.getLastName());
            update.set("email", memberDoc.getEmail());
            update.set("dob", memberDoc.getDob());
            update.set("profile", memberDoc.getProfile());
            update.set("account", memberDoc.getAccount());
            update.set("roles", memberDoc.getRole());
            update.set("eventIds", memberDoc.getEventIds());

            mongoTemplate.updateMulti(query, update, MemberDocument.class);
            return memberDoc;
        }
        throw ConflictException.
                create("Conflict: email: {0} already exist in the system", memberDoc.getEmail());
    }

    @Override
    public void delete(String uuid) {
        mongoTemplate.updateFirst(new Query(Criteria.where("uuid").is(uuid)),
                Update.update("isActive", false), MemberDocument.class);
    }

    public Long count() {
        return mongoTemplate.count(new Query(), MemberDocument.class);
    }
}
