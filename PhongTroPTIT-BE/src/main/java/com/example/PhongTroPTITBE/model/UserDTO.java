package com.example.PhongTroPTITBE.model;



import com.example.PhongTroPTITBE.entity.RoleName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class UserDTO {
    private Long id;

    private String fullName;

    private String email;

    private String address;

    private String phone;

    private boolean block;

    private String b64;

    private String fileType;

    @Enumerated(EnumType.STRING)
    private List<RoleName> role;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, String address, String phone, boolean block, String b64,
                   String fileType, List<RoleName> role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.block = block;
        this.b64 = b64;
        this.fileType = fileType;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleName> getRole() {
        return role;
    }

    public void setRole(List<RoleName> role) {
        this.role = role;
    }

    public String getB64() {
        return b64;
    }

    public void setB64(String b64) {
        this.b64 = b64;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}

