package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.District;
import com.example.PhongTroPTITBE.model.DistrictDTO;
import com.example.PhongTroPTITBE.repository.DistrictRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<DistrictDTO> getAllDistrict() {
        List<District> districts = districtRepository.findAll();
        List<DistrictDTO> districtDTOS = new ArrayList<>();
        for (District district : districts) {
            districtDTOS.add(modelMapper.map(district, DistrictDTO.class));
        }
        return districtDTOS;
    }
}