package org.wtm.wtmwebsite.service.query.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wtm.wtmwebsite.dao.RoleDocument;
import org.wtm.wtmwebsite.dto.Role;
import org.wtm.wtmwebsite.repository.RoleRepository;
import org.wtm.wtmwebsite.service.mapper.RoleMapper;
import org.wtm.wtmwebsite.service.query.RoleQuery;

@Service
@Transactional
public class RoleQueryImplementation implements RoleQuery {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(String uuid) {
        RoleDocument roleDoc = roleRepository.findById(uuid);
        return RoleMapper.getRoleDTO(roleDoc);
    }

    @Override
    public Role findByName(String name) {
        RoleDocument roleDoc = roleRepository.findById(name);
        return RoleMapper.getRoleDTO(roleDoc);
    }

}
