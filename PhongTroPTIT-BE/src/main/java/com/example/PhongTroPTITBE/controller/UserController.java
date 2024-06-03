package com.example.PhongTroPTITBE.controller;

import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.RoleName;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.mapper.UserMapper;
import com.example.PhongTroPTITBE.model.AccountDto;
import com.example.PhongTroPTITBE.model.UserDTO;
import com.example.PhongTroPTITBE.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value = "Tìm nhà trọ", description = "Quản lý người dùng")
public class UserController {

    private UserService userService;

    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Lấy danh sách người dùng")
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')") // only ADMIN can get list users
    public Page<UserDTO> getAlLUser(@PageableDefault(page = 0, size = 10) Pageable page,
                                    @RequestParam(value = "role", defaultValue = "") List<String> roles) {
        return userService.selectPageOfUsersInRoles(page, roles).map(mapper::entityToDTOWithRoles);
    }

    @ApiOperation(value = "Lấy thông tin một người dùng")
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
//        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");

        User user = userService.selectUserById(id);

        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Cập nhật thông tin người dùng phía giao diện người dùng")
    @PutMapping("/{id}")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public UserDTO updateProfile(@PathVariable("id") Long id,
                                 @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        User user = userService.changeProfile(userDTO, false);

        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Cập nhật thông tin người dùng phía giao diện quản lý")
    @PutMapping("/{id}/admin")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public UserDTO updateProfileAdmin(@PathVariable("id") Long id,
                                 @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        User user = userService.changeProfile(userDTO, true);

        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Khóa một tài khoản")
    @PutMapping("/{id}/block")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserDTO blockUser(@PathVariable("id") Long id) {
        User user = userService.blockUserById(id, true);

        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Mở khóa một tài khoản")
    @PutMapping("/{id}/unblock")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserDTO unblockUser(@PathVariable("id") Long id) {
        User user = userService.blockUserById(id, false);

        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Thay đổi password")
    @PostMapping("/{id}/password")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public UserDTO changePasswordAUser(@PathVariable("id") Long id,
                                       @RequestParam("password") String newPassword,
                                       @RequestParam(value = "oldPassword", defaultValue = "") String oldPassword,
                                       OAuth2Authentication auth) throws Exception {
        String role = "";
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");
        User authUser = userService.selectUserByEmail(auth.getName());
        if (authUser.getRoles().stream().map(Role::getName).anyMatch(roleName -> roleName == RoleName.ROLE_ADMIN)) {
            role = "ROLE_ADMIN";
        } else {
            role = "ROLE_USER";
        }
        User user = userService.changePassword(id, newPassword, oldPassword, role);

        return mapper.entityToDTO(user);
    }

    // registration flow
    @ApiOperation(value = "Kiểm tra email đã tồn tại hay không")
    @GetMapping("/check")
    public boolean checkExistUser(@RequestParam("email") String email) {
        return (userService.selectUserByEmail(email) != null);
    }

    @ApiOperation(value = "Đăng ký tài khoản")
    @PostMapping
    public UserDTO registerUserAccount(@RequestBody AccountDto accountDto) {
        User user = userService.registration(accountDto);
        return mapper.entityToDTOWithRoles(user);
    }

    @ApiOperation(value = "Lấy avatar của một tài khoản")
    @GetMapping("/{id}/avatar")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public AbstractMap.SimpleEntry<String, String> getAvatar(@PathVariable("id") Long id, OAuth2Authentication auth) {
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");
        return new AbstractMap.SimpleEntry<>("data", userService.selectUserById(id).getB64());
    }

    @ApiOperation(value = "Upload avatar một tài khoản")
    @PostMapping("/{id}/avatar")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public AbstractMap.SimpleEntry<String, String> uploadAvatar(@PathVariable("id") Long id, OAuth2Authentication auth,
                                                                @RequestParam("avatar") MultipartFile file) throws IOException {
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");
        userService.changeAvatar(id, file.getBytes());
        return getAvatar(id, auth);
    }

    @ApiOperation(value = "Delete avatar một tài khoản")
    @DeleteMapping("/{id}/avatar")
    @PreAuthorize("#oauth2.hasAnyScope('read')") // for authenticated request (logged)
    public AbstractMap.SimpleEntry<String, String> removeAvatar(@PathVariable("id") Long id, OAuth2Authentication auth) {
        if (!validRequest(auth, id)) throw new AccessDeniedException("Access dined");
        AbstractMap.SimpleEntry<String, String> avatar = getAvatar(id, auth);
        userService.changeAvatar(id, new byte[]{});
        return avatar;
    }

    @ApiOperation(value = "Phân quyền")
    @PutMapping("/{id}/role")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public UserDTO changeRole(@PathVariable("id") Long id,
                              @RequestBody List<RoleName> role) {
        User user = userService.changeRole(id, role);
        return mapper.entityToDTO(user);
    }

    //user request change profile or admin
    public boolean validRequest(OAuth2Authentication auth, Long userId) {
        User authUser = userService.selectUserByEmail(auth.getName());

        // has ROLE_ADMIN or has userid equal userid request
        return authUser.getRoles().stream().map(Role::getName).anyMatch(roleName -> roleName == RoleName.ROLE_ADMIN)
                || authUser.getId().equals(userId);
    }
}
