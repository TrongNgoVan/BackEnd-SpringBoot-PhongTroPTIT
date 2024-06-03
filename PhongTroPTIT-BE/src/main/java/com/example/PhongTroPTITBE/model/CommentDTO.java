package com.example.PhongTroPTITBE.model;

import java.time.LocalDateTime;

public class CommentDTO {
    private long id;

    private String content;

    private LocalDateTime lastUpdate;

    private Long idPost;

    private UserDTO userDTO;

    private long rate;

    public CommentDTO() {
    }

    public CommentDTO(long id, String content, LocalDateTime lastUpdate, Long idPost, UserDTO userDTO, long rate) {
        this.id = id;
        this.content = content;
        this.lastUpdate = lastUpdate;
        this.idPost = idPost;
        this.userDTO = userDTO;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}

