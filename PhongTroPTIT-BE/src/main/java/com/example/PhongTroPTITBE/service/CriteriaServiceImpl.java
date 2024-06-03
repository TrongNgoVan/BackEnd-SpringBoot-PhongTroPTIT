package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Criteria;
import com.example.PhongTroPTITBE.entity.District;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.exception.CriteriaException;
import com.example.PhongTroPTITBE.exception.UserException;
import com.example.PhongTroPTITBE.model.CriteriaDTO;
import com.example.PhongTroPTITBE.model.DistrictDTO;
import com.example.PhongTroPTITBE.repository.CriteriaRepository;
import com.example.PhongTroPTITBE.repository.DistrictRepository;
import com.example.PhongTroPTITBE.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CriteriaServiceImpl implements CriteriaService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CriteriaRepository criteriaRepository;

    @Autowired
    DistrictRepository districtRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<CriteriaDTO> getCriteriaByEmail(String email, int page, boolean bool) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (bool) {
                Page<Criteria> criteriaPage = criteriaRepository.findAllByUser(user.get(), PageRequest.of(page, 10, Sort.by("createAt").descending()));
                return criteriaPage.map(this::criteriaToCriteriaDTO);
            } else {
                Page<Criteria> criteriaPage = criteriaRepository.findAllByUserAndStop(user.get(), false, PageRequest.of(page, 10, Sort.by("createAt").descending()));
                return criteriaPage.map(this::criteriaToCriteriaDTO);
            }
        } else {
            throw new UserException("Không tìm thấy user " + user.get().getEmail());
        }
    }

    @Override
    public CriteriaDTO createCriteria(CriteriaDTO criteriaDTO, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Optional<District> district = districtRepository.findById(criteriaDTO.getDistrictDTO().getId());
            Criteria criteria = modelMapper.map(criteriaDTO, Criteria.class);
            criteria.setPriceStart(criteria.getPriceStart()*1000000);
            criteria.setPriceEnd(criteria.getPriceEnd()*1000000);
            criteria.setUser(user.get());
            criteria.setDistrict(district.get());
            criteria.setCreateAt(LocalDateTime.now());
            criteriaRepository.save(criteria);

            criteriaDTO = criteriaToCriteriaDTO(criteria);
            return criteriaDTO;
        } else {
            throw new UserException("Không tìm thấy user " + user.get().getEmail());
        }
    }

    @Override
    public CriteriaDTO stopCriteria(Long idCriteria) {
        Optional<Criteria> criteria = criteriaRepository.findById(idCriteria);
        if (criteria.isPresent()) {
            criteria.get().setStop(true);
            criteriaRepository.save(criteria.get());
            return criteriaToCriteriaDTO(criteria.get());
        } else {
            throw new CriteriaException("Không tìm thấy Criteria id " + idCriteria);
        }
    }

    @Override
    public CriteriaDTO startCriteria(Long idCriteria) {
        Optional<Criteria> criteria = criteriaRepository.findById(idCriteria);
        if (criteria.isPresent()) {
            criteria.get().setStop(false);
            criteriaRepository.save(criteria.get());
            return criteriaToCriteriaDTO(criteria.get());
        } else {
            throw new CriteriaException("Không tìm thấy Criteria id " + idCriteria);
        }
    }

    public CriteriaDTO criteriaToCriteriaDTO(Criteria criteria) {
        CriteriaDTO criteriaDTO = modelMapper.map(criteria, CriteriaDTO.class);
        criteriaDTO.setDistrictDTO(modelMapper.map(criteria.getDistrict(), DistrictDTO.class));

        return criteriaDTO;
    }
}

