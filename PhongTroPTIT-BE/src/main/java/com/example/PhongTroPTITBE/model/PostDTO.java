package com.example.PhongTroPTITBE.model;



import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    private long id;

    private String title;

    private String content;

    private boolean approved;

    private boolean notApproved;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    private boolean del;

    private UserDTO userDTO;

    private AccomodationDTO accomodationDTO;

    private List<CommentDTO> commentDTOS;

    private List<String> imageStrings;

    public PostDTO() {
    }

    public PostDTO(long id, String title, String content, boolean approved, boolean notApproved, LocalDateTime createAt,
                   LocalDateTime lastUpdate, boolean del, UserDTO userDTO, AccomodationDTO accomodationDTO,
                   List<CommentDTO> commentDTOS, List<String> imageStrings) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.approved = approved;
        this.notApproved = notApproved;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.del = del;
        this.userDTO = userDTO;
        this.accomodationDTO = accomodationDTO;
        this.commentDTOS = commentDTOS;
        this.imageStrings = imageStrings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isNotApproved() {
        return notApproved;
    }

    public void setNotApproved(boolean notApproved) {
        this.notApproved = notApproved;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public AccomodationDTO getAccomodationDTO() {
        return accomodationDTO;
    }

    public void setAccomodationDTO(AccomodationDTO accomodationDTO) {
        this.accomodationDTO = accomodationDTO;
    }

    public List<CommentDTO> getCommentDTOS() {
        return commentDTOS;
    }

    public void setCommentDTOS(List<CommentDTO> commentDTOS) {
        this.commentDTOS = commentDTOS;
    }

    public List<String> getImageStrings() {
        return imageStrings;
    }

    public void setImageStrings(List<String> imageStrings) {
        this.imageStrings = imageStrings;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}

