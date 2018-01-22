package org.wtm.wtmwebsite.service.mapper;

import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dao.RoleDocument;
import org.wtm.wtmwebsite.dto.Member;
import org.wtm.wtmwebsite.dto.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberMapper {

    public static Member getMemberDTO(MemberDocument memberDoc) {
        List<Role> roles = new ArrayList<>();
        memberDoc.getRole().
                forEach(roleDoc -> roles.add(RoleMapper.getRoleDTO(roleDoc)));

        return new Member(memberDoc.getUuid(), memberDoc.getFirstName(), memberDoc.getLastName(),
                memberDoc.getEmail(), memberDoc.getDob(), memberDoc.getAccount(),
                memberDoc.getProfile(), roles, memberDoc.getEventIds());
    }

    public static MemberDocument getMemberDAO(Member member) {
        List<RoleDocument> roleDocs = new ArrayList<>();
        member.getRoles().
                forEach(role -> roleDocs.add(RoleMapper.getRoleDAO(role)));

        return new MemberDocument(member.getUuid(), member.getFirstName(), member.getLastName(),
                member.getEmail(), member.getDob(), member.getProfile(), member.getAccount(),
                roleDocs, member.getEventIds(), true);
    }

}
