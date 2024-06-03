package com.example.PhongTroPTITBE.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "criteria")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean motel;

    private boolean stop;

    private double priceStart;

    private double priceEnd;

    private double acreageStart;

    private double acreageEnd;

    private LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    public Criteria() {
    }

    public Criteria(User user, boolean motel, boolean stop, double priceStart, double priceEnd, double acreageStart,
                    double acreageEnd, LocalDateTime createAt, District district) {
        this.user = user;
        this.motel = motel;
        this.stop = stop;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
        this.acreageStart = acreageStart;
        this.acreageEnd = acreageEnd;
        this.createAt = createAt;
        this.district = district;
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

    public boolean isMotel() {
        return motel;
    }

    public void setMotel(boolean motel) {
        this.motel = motel;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public double getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(double priceStart) {
        this.priceStart = priceStart;
    }

    public double getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(double priceEnd) {
        this.priceEnd = priceEnd;
    }

    public double getAcreageStart() {
        return acreageStart;
    }

    public void setAcreageStart(double acreageStart) {
        this.acreageStart = acreageStart;
    }

    public double getAcreageEnd() {
        return acreageEnd;
    }

    public void setAcreageEnd(double acreageEnd) {
        this.acreageEnd = acreageEnd;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}

