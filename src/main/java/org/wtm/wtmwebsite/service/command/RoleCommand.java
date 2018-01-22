package org.wtm.wtmwebsite.service.command;

import org.wtm.wtmwebsite.dto.Role;

public interface RoleCommand {

    Role createRole( Role role );
    Role updateRole( Role role );
    void deleteRole( String uuid );

}
