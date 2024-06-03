package com.example.PhongTroPTITBE.model;


import com.example.PhongTroPTITBE.entity.NotificationName;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;

    private PostDTO postDTO;

    private boolean seen;

    private LocalDateTime createAt;

    private NotificationName notificationName;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, PostDTO postDTO, boolean seen, LocalDateTime createAt, NotificationName notificationName) {
        this.id = id;
        this.postDTO = postDTO;
        this.seen = seen;
        this.createAt = createAt;
        this.notificationName = notificationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public NotificationName getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(NotificationName notificationName) {
        this.notificationName = notificationName;
    }
}

