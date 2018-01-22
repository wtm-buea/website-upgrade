package org.wtm.wtmwebsite.dto;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    String uuid;
    String name;

    public Role() {
    }

    public Role(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
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

    @Override
    public String getAuthority() {
        return name;
    }
}
