package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.model.CriteriaDTO;
import com.example.PhongTroPTITBE.service.CriteriaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Tìm nhà trọ", description = "Quản lý tiêu chí nhận thông báo")
public class CriteriaController {
    @Autowired
    CriteriaServiceImpl criteriaService;

    @ApiOperation(value = "Lấy một trang tiêu chí của người dùng")
    @GetMapping("/criterias")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public Page<CriteriaDTO> getCriteriaByEmail(OAuth2Authentication auth, @RequestParam("page") int page, @RequestParam("all") boolean bool) {
        return criteriaService.getCriteriaByEmail(auth.getName(), page, bool);
    }

    @ApiOperation(value = "Thêm một tiêu chí mới")
    @PostMapping("/criteria")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CriteriaDTO createCriteria(OAuth2Authentication auth, @RequestBody CriteriaDTO criteriaDTO) {
        return criteriaService.createCriteria(criteriaDTO, auth.getName());
    }

    @ApiOperation(value = "Bật tạm dừng nhận thông báo của một tiêu chí")
    @PutMapping("/criteria/stop/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CriteriaDTO stopCriteria(@PathVariable Long id) {
        return criteriaService.stopCriteria(id);
    }

    @ApiOperation(value = "Tắt tạm dừng nhận thông báo của một tiêu chí")
    @PutMapping("/criteria/start/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public CriteriaDTO startCriteria(@PathVariable Long id) {
        return criteriaService.startCriteria(id);
    }
}
