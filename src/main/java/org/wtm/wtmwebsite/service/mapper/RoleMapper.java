package org.wtm.wtmwebsite.service.mapper;

import org.wtm.wtmwebsite.dao.RoleDocument;
import org.wtm.wtmwebsite.dto.Role;

public class RoleMapper {

    public static Role getRoleDTO(RoleDocument roleDocument) {
        return new Role(roleDocument.getUuid(), roleDocument.getName());
    }

    public static RoleDocument getRoleDAO(Role role) {
        return new RoleDocument(role.getUuid(), role.getName(), true);
    }

}
