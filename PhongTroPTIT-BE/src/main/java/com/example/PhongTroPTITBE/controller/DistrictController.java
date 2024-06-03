package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.model.DistrictDTO;
import com.example.PhongTroPTITBE.service.DistrictServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@Api(value = "Tìm nhà trọ", description = "Lấy danh sách quận")
public class DistrictController {
    @Autowired
    DistrictServiceImpl districtService;

    @ApiOperation(value = "Lấy tất cả quận")
    @GetMapping
    public List<DistrictDTO> getAllDistrict() {
        return districtService.getAllDistrict();
    }
}
