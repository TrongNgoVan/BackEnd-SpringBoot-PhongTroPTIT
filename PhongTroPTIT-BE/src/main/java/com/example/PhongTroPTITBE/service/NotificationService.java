package com.example.PhongTroPTITBE.service;



import com.example.PhongTroPTITBE.entity.Criteria;
import com.example.PhongTroPTITBE.entity.NotificationName;
import com.example.PhongTroPTITBE.entity.Post;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.model.NotificationDTO;
import org.springframework.data.domain.Page;

public interface NotificationService {
    void createNotification(User user, Post post, Criteria criteria, NotificationName notificationName);

    Page<NotificationDTO> getNotificationByEmail(String email, int page, boolean screen);

    Page<NotificationDTO> getNotificationByEmailAndCriteria(String email, Long idCriteria, int page);

    NotificationDTO seenNotification(Long id);
}

