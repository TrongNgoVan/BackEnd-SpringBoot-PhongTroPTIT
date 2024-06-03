package com.example.PhongTroPTITBE.repository;


import  com.example.PhongTroPTITBE.entity.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
}

