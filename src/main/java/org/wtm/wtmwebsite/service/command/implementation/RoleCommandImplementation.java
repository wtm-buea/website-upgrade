package org.wtm.wtmwebsite.service.command.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.RoleDocument;
import org.wtm.wtmwebsite.dto.Role;
import org.wtm.wtmwebsite.repository.RoleRepository;
import org.wtm.wtmwebsite.service.command.RoleCommand;
import org.wtm.wtmwebsite.service.mapper.RoleMapper;

import java.util.UUID;

@Service
@Transactional
public class RoleCommandImplementation implements RoleCommand {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role createRole(Role role) {
        role.setUuid(UUID.randomUUID().toString());
        RoleDocument newRole = roleRepository.create(RoleMapper.getRoleDAO(role));
        return RoleMapper.getRoleDTO(newRole);
    }

    @Override
    public Role updateRole(Role role) {
        RoleDocument updatedRole = roleRepository.update(RoleMapper.getRoleDAO(role));
        return RoleMapper.getRoleDTO(updatedRole);
    }

    @Override
    public void deleteRole(String uuid) {
        roleRepository.delete(uuid);
    }
}
