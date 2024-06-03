package com.example.PhongTroPTITBE.model;

public class SearchDTO {
    private double acreageStart;

    private double acreageEnd;

    private double priceStart;

    private double priceEnd;

    private int motel;

    private long idDistrict;

    private double xCoordinate;

    private double yCoordinate;

    private double radius;

    public SearchDTO() {
    }

    public SearchDTO(double acreageStart, double acreageEnd, double priceStart, double priceEnd, int motel,
                     long idDistrict, double xCoordinate, double yCoordinate, double radius) {
        this.acreageStart = acreageStart;
        this.acreageEnd = acreageEnd;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
        this.motel = motel;
        this.idDistrict = idDistrict;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.radius = radius;
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

    public int getMotel() {
        return motel;
    }

    public void setMotel(int motel) {
        this.motel = motel;
    }

    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

