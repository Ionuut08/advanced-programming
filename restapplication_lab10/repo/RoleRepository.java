package com.example.ionut.restapplication.repo;


import com.example.ionut.restapplication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleName(String name);

}
