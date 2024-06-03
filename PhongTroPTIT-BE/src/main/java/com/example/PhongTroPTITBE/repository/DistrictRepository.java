package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}

