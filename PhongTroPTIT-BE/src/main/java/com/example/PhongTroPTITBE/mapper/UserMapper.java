package com.example.PhongTroPTITBE.mapper;


import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({})
    UserDTO entityToDTO(User user);

    default UserDTO entityToDTOWithRoles(User user) {
        UserDTO userDTO = entityToDTO(user);
        userDTO.setRole(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return userDTO;
    }
}

