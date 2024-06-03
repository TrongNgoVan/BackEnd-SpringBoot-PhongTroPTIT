package com.example.PhongTroPTITBE.model;

import java.time.LocalDateTime;

public class CriteriaDTO {
    private Long id;

    private boolean motel;

    private double priceStart;

    private double priceEnd;

    private double acreageStart;

    private double acreageEnd;

    private DistrictDTO districtDTO;

    private boolean stop;

    private LocalDateTime createAt;

    public CriteriaDTO() {
    }

    public CriteriaDTO(Long id, boolean motel, double priceStart, double priceEnd, double acreageStart, double acreageEnd,
                       DistrictDTO districtDTO, boolean stop, LocalDateTime createAt) {
        this.id = id;
        this.motel = motel;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
        this.acreageStart = acreageStart;
        this.acreageEnd = acreageEnd;
        this.districtDTO = districtDTO;
        this.stop = stop;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isMotel() {
        return motel;
    }

    public void setMotel(boolean motel) {
        this.motel = motel;
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

    public DistrictDTO getDistrictDTO() {
        return districtDTO;
    }

    public void setDistrictDTO(DistrictDTO districtDTO) {
        this.districtDTO = districtDTO;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}

