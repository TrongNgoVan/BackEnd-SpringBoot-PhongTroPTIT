package com.example.PhongTroPTITBE.entity;

import javax.persistence.*;
import javax.validation.constraints.Null;
import lombok.*;
@Entity
@Table(name = "accomodation")
public class Accomodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double acreage;

    private String address;

    private double electricPrice;

    private double waterPrice;

    private boolean internet;

    private boolean parking;

    private boolean airConditioner;

    private boolean heater;

    private boolean cableTV;

    private boolean tv;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ToiletName toilet;

    private double price;

    private boolean status;

    private boolean motel;

    private double xCoordinate;

    private double yCoordinate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    public Accomodation() {
    }

    public Accomodation(double acreage, String address, double electricPrice, double waterPrice, boolean internet,
                        boolean parking, boolean airConditioner, boolean heater, boolean cableTV, boolean tv, ToiletName toilet,
                        double price, boolean status, boolean motel, double xCoordinate, double yCoordinate, Post post, District district) {
        this.acreage = acreage;
        this.address = address;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;
        this.internet = internet;
        this.parking = parking;
        this.airConditioner = airConditioner;
        this.heater = heater;
        this.cableTV = cableTV;
        this.tv = tv;
        this.toilet = toilet;
        this.price = price;
        this.status = status;
        this.motel = motel;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.post = post;
        this.district = district;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(double electricPrice) {
        this.electricPrice = electricPrice;
    }

    public double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public boolean isHeater() {
        return heater;
    }

    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    public boolean isCableTV() {
        return cableTV;
    }

    public void setCableTV(boolean cableTV) {
        this.cableTV = cableTV;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public ToiletName getToilet() {
        return toilet;
    }

    public void setToilet(ToiletName toilet) {
        this.toilet = toilet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMotel() {
        return motel;
    }

    public void setMotel(boolean motel) {
        this.motel = motel;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}

