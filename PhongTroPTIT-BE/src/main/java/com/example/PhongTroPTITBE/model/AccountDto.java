package com.example.PhongTroPTITBE.model;

import com.example.PhongTroPTITBE.entity.RoleName;

import java.util.List;

public class AccountDto {

    private String email;

    private String password;

    private String fullName;

    private String address;

    private String phone;

    private List<RoleName> role;

    public AccountDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<RoleName> getRole() {
        return role;
    }

    public void setRole(List<RoleName> role) {
        this.role = role;
    }
}

