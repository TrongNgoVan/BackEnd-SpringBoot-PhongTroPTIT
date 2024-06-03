package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
