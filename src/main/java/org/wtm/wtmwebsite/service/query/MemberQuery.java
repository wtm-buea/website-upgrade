package org.wtm.wtmwebsite.service.query;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.wtm.wtmwebsite.dto.Member;

@PreAuthorize("hasRole('ADMIN')")
public interface MemberQuery {

    Member findById(String uuid);
    Member findByEmail(String email);
    Page<Member> findAll(Integer page, Integer size);

}
