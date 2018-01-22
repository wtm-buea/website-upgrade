package org.wtm.wtmwebsite.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.wtm.wtmwebsite.dao.RoleDocument;

import java.util.List;

@org.springframework.stereotype.Repository
public class RoleRepository implements Repository<RoleDocument> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void createCollection() {
        if( !mongoTemplate.collectionExists(RoleDocument.class) ) {
            mongoTemplate.createCollection(RoleDocument.class);
        }
    }

    @Override
    public RoleDocument create(RoleDocument roleDoc) {
        mongoTemplate.insert(roleDoc, "role");
        return roleDoc;
    }

    @Override
    public List<RoleDocument> findAll(Pageable pageable) {
        return mongoTemplate.findAll(RoleDocument.class);
    }

    @Override
    public RoleDocument findById(String uuid) {
        return mongoTemplate.findOne(new Query(Criteria.where("uuid").is(uuid)), RoleDocument.class);
    }

    public RoleDocument findByName(String name) {
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), RoleDocument.class);
    }

    @Override
    public RoleDocument update(RoleDocument roleDoc) {
        if (mongoTemplate.count(new Query(Criteria.where("name").is(roleDoc.getName())),
                RoleDocument.class) == 0) {
            mongoTemplate.updateFirst(new Query(Criteria.where("uuid").is(roleDoc.getUuid())),
                    Update.update("name", roleDoc.getName()), RoleDocument.class);
            return roleDoc;
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        mongoTemplate.updateFirst(new Query(Criteria.where("uuid").is(uuid)),
                Update.update("isActive", false), RoleDocument.class);
    }
}
