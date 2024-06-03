package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.model.CriteriaDTO;
import org.springframework.data.domain.Page;

public interface CriteriaService {
    Page<CriteriaDTO> getCriteriaByEmail(String email, int page, boolean bool);

    CriteriaDTO createCriteria(CriteriaDTO criteriaDTO, String email);

    CriteriaDTO stopCriteria(Long idCriteria);

    CriteriaDTO startCriteria(Long idCriteria);
}
