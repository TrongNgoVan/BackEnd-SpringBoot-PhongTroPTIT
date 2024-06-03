package com.example.PhongTroPTITBE.model;

public class ImageDTO {
    private String id;

    private String fileName;

    private String fileType;

    private String Uri;

    private Long idPost;

    public ImageDTO() {
    }

    public ImageDTO(String id, String fileName, String fileType, String uri, Long idPost) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        Uri = uri;
        this.idPost = idPost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }
}
