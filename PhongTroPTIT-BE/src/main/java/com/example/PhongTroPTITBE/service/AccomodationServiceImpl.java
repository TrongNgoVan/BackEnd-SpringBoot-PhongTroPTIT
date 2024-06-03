package com.example.PhongTroPTITBE.service;



import com.example.PhongTroPTITBE.entity.Accomodation;
import com.example.PhongTroPTITBE.entity.District;
import com.example.PhongTroPTITBE.model.AccomodationDTO;
import com.example.PhongTroPTITBE.model.PostDTO;
import com.example.PhongTroPTITBE.repository.AccomodationRepository;
import com.example.PhongTroPTITBE.repository.DistrictRepository;
import com.example.PhongTroPTITBE.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccomodationServiceImpl extends AccomodationService {
    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    PostRepository postRepository;

}

