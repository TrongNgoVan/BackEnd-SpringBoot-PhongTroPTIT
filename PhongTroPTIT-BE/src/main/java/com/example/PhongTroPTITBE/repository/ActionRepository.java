package com.example.PhongTroPTITBE.repository;


import com.example.PhongTroPTITBE.entity.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Page<Action> findAll(Pageable pageable);

    Page<Action> findAllByUser_Id(Long id, Pageable pageable);

}

