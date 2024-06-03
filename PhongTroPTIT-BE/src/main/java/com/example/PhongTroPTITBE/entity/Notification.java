package com.example.PhongTroPTITBE.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criteria_id")
    private Criteria criteria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private boolean seen;

    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private NotificationName notificationName;

    public Notification() {
    }

    public Notification(User user, Criteria criteria, Post post, boolean seen, LocalDateTime createAt, NotificationName notificationName) {
        this.user = user;
        this.criteria = criteria;
        this.post = post;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

