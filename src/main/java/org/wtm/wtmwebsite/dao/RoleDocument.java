package org.wtm.wtmwebsite.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="role")
public class RoleDocument {

    @Id
    private String uuid;
    private String name;
    private Boolean isActive;

    public RoleDocument() {
    }

    public RoleDocument(String uuid, String name, Boolean isActive) {
        this.uuid = uuid;
        this.name = name;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
