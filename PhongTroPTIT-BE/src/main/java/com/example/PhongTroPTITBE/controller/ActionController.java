package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.model.ActionDTO;
import com.example.PhongTroPTITBE.service.ActionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
@Api(value = "Tìm nhà trọ", description = "Xem các hoạt động của website")
@PreAuthorize("#oauth2.hasAnyScope('read')")
public class ActionController {
    @Autowired
    ActionServiceImpl actionService;

    @ApiOperation(value = "Lấy một trang các hoạt động")
    @GetMapping
    public Page<ActionDTO> getAction(@RequestParam int page, @RequestParam(required = false, defaultValue = "-1") Long id) {
       if(id.equals(-1l))
           return actionService.getAction(page);
       else
           return actionService.getActionByApprover(id, page);
    }
}
