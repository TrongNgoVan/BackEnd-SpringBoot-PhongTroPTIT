package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.model.NotificationDTO;
import com.example.PhongTroPTITBE.service.NotificationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "Tìm nhà trọ", description = "Quản lý thông báo")
public class NotificationController {
    @Autowired
    NotificationServiceImpl notificationService;

    @ApiOperation(value = "Lấy một trang thông báo của người dùng")
    @GetMapping("/notification")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public Page<NotificationDTO> getNotificationByEmail(OAuth2Authentication auth, @RequestParam("page") int page, @RequestParam("screen") boolean screen) {
        return notificationService.getNotificationByEmail(auth.getName(), page, screen);
    }

    @ApiOperation(value = "Lấy một trang thông báo theo một loại tiêu chí của người dùng")
    @GetMapping("/notification/criteria")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public Page<NotificationDTO> getNotificationByEmailAndCriteria(OAuth2Authentication auth, @RequestParam("idCriteria") long id, @RequestParam("page") int page) {
        return notificationService.getNotificationByEmailAndCriteria(auth.getName(), id, page);
    }

    @ApiOperation(value = "Đánh dấu thông báo đã xem")
    @PutMapping("/notification/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')")
    public NotificationDTO seenNotification(@PathVariable long id) {
        return notificationService.seenNotification(id);
    }
}
