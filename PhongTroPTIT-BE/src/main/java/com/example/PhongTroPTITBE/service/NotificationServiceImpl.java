package com.example.PhongTroPTITBE.service;



import com.example.PhongTroPTITBE.entity.*;
import com.example.PhongTroPTITBE.exception.NotificationException;
import com.example.PhongTroPTITBE.exception.UserException;
import com.example.PhongTroPTITBE.model.NotificationDTO;
import com.example.PhongTroPTITBE.model.PostDTO;
import com.example.PhongTroPTITBE.model.UserDTO;
import com.example.PhongTroPTITBE.repository.CriteriaRepository;
import com.example.PhongTroPTITBE.repository.NotificationRepository;
import com.example.PhongTroPTITBE.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    CriteriaRepository criteriaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageService imageService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createNotification(User user, Post post, Criteria criteria, NotificationName notificationName) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setPost(post);
        notification.setCreateAt(LocalDateTime.now());
        if (notificationName.equals(NotificationName.NOTIFICATION)) {
            notification.setCriteria(criteria);
            notification.setNotificationName(notificationName);
            notification.setSeen(false);
        } else if (notificationName.equals(NotificationName.APPROVE)){
            notification.setCriteria(null);
            notification.setNotificationName(notificationName);
            notification.setSeen(true);
        } else {
            notification.setCriteria(null);
            notification.setNotificationName(notificationName);
            notification.setSeen(true);
        }

        notificationRepository.save(notification);
    }

    @Override
    public Page<NotificationDTO> getNotificationByEmailAndCriteria(String email, Long idCriteria, int page) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Page<Notification> notificationPage = notificationRepository.findAllByUserAndAndCriteria_Id(user.get(), idCriteria, PageRequest.of(page, 10));
            return notificationPage.map(this::notificationToNotificationDTO);
        } else {
            throw new UserException("Không tìm thấy user " + email);
        }
    }

    @Override
    public Page<NotificationDTO> getNotificationByEmail(String email, int page, boolean screen) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Page<Notification> notificationPage;
            if (screen)
                notificationPage = notificationRepository.findAllByUser(user.get(), PageRequest.of(page, 10, Sort.by("createAt").descending()));
            else
                notificationPage = notificationRepository.findAllByUser(user.get(), PageRequest.of(page, 4, Sort.by("createAt").descending()));
            return notificationPage.map(this::notificationToNotificationDTO);
        } else {
            throw new UserException("Không tìm thấy user " + email);
        }
    }

    @Override
    public NotificationDTO seenNotification(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            notification.get().setSeen(true);
            notificationRepository.save(notification.get());
            return notificationToNotificationDTO(notification.get());
        } else {
            throw new NotificationException("Không tìm thấy notification id " + id);
        }
    }

    public NotificationDTO notificationToNotificationDTO(Notification notification) {
        NotificationDTO notificationDTO = modelMapper.map(notification, NotificationDTO.class);
        notificationDTO.setPostDTO(modelMapper.map(notification.getPost(), PostDTO.class));
        List<String> images = imageService.getImageByIdPost(notification.getPost().getId());
        notificationDTO.getPostDTO().setImageStrings(images);
        notificationDTO.getPostDTO().setUserDTO(modelMapper.map(notification.getPost().getUser(), UserDTO.class));
        return notificationDTO;
    }
}

