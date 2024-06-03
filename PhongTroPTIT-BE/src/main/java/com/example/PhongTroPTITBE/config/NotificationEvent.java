package com.example.PhongTroPTITBE.config;

import com.example.PhongTroPTITBE.entity.Post;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {

    private Post post;

    public NotificationEvent(Object source, Post post) {
        super(source);
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
