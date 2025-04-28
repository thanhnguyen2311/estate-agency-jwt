package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.Role;
import com.example.estateagencyrent.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public House save(Role role) {
      roleRepository.save(role);
        return null;
    }

    @Override
    public void remove(Long id) {
 roleRepository.deleteById(id);
    }
}
