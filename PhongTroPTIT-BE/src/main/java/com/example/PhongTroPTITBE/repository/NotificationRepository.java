package com.example.PhongTroPTITBE.repository;

import com.example.PhongTroPTITBE.entity.Notification;
import com.example.PhongTroPTITBE.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Page<Notification> findAllByUser(User user, Pageable pageable);

    Page<Notification> findDistinctByUser(User user, Pageable pageable);

    Page<Notification> findAllByUserAndAndCriteria_Id(User user, Long idCriteria, Pageable pageable);
}
