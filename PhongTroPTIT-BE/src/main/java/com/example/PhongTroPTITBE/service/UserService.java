package com.example.PhongTroPTITBE.service;



import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.RoleName;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.model.AccountDto;
import com.example.PhongTroPTITBE.model.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UserService {

    User selectUserByEmail(String userName);

    Role selectRoleByName(RoleName name);

    User changePassword(Long id, String newPassword, String oldPassword, String role) throws Exception;

    Page<User> selectPageOfUsersInRoles(Pageable page, List<String> rolesString);

    User blockUserById(Long id, boolean block);

    User selectUserById(Long id);

    User changeProfile(UserDTO userDTO, boolean admin);

    User changeRole(Long id, List<RoleName> role);

    User registration(AccountDto accountDto);

    void changeAvatar(Long id, byte[] fileBytes);

}

