package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable page);

    Page<User> findAllByRolesIn(Pageable page, List<Role> roles);
}
