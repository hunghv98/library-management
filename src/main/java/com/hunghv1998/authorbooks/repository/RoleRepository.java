package com.hunghv1998.authorbooks.repository;

import com.hunghv1998.authorbooks.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(String role);
}
