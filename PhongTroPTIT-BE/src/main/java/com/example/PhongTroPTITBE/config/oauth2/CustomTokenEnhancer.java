package com.example.PhongTroPTITBE.config.oauth2;

import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.User;
import com.example.PhongTroPTITBE.mapper.UserMapper;
import com.example.PhongTroPTITBE.model.UserDTO;
import com.example.PhongTroPTITBE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UserRepository userRepository;

    UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication auth) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = userRepository.findByEmail(auth.getName()).get();
        UserDTO userDTO = mapper.entityToDTO(user);
        userDTO.setB64(null);
        userDTO.setFileType(null);
        userDTO.setRole(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        additionalInfo.put("account", userDTO);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
