package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.service.AccomodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccomodationController {
    @Autowired
    AccomodationServiceImpl accomodationService;
}
