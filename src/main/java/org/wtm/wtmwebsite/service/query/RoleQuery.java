package org.wtm.wtmwebsite.service.query;

import org.wtm.wtmwebsite.dto.Role;

public interface RoleQuery {

    Role findById(String uuid);
    Role findByName(String name);

}
