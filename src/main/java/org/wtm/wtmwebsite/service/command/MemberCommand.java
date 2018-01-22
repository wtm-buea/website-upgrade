package org.wtm.wtmwebsite.service.command;

import org.springframework.security.access.prepost.PreAuthorize;
import org.wtm.wtmwebsite.dto.Member;

@PreAuthorize("hasRole('ADMIN')")
public interface MemberCommand {

    Member createMember( Member member );
    Member updateMember( Member member );
    void deleteMember( String uuid );

}
