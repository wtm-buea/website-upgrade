package org.wtm.wtmwebsite.service.mapper;

import org.wtm.wtmwebsite.dao.MemberDocument;
import org.wtm.wtmwebsite.dto.Account;
import org.wtm.wtmwebsite.dto.Role;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {

    public static Account getAccountDTO(MemberDocument memberDocument) {

        List<Role> roles = new ArrayList<>();
        memberDocument.getRole().
                forEach(roleDoc -> roles.add(RoleMapper.getRoleDTO(roleDoc)));

        return new Account(memberDocument.getAccount().getUuid(), memberDocument.getEmail(),
                memberDocument.getAccount().getPassword(), roles);
    }

}
