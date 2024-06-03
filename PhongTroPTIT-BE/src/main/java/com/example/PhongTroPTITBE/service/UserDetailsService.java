package com.example.PhongTroPTITBE.service;

import com.example.PhongTroPTITBE.entity.Role;
import com.example.PhongTroPTITBE.entity.RoleName;
import com.example.PhongTroPTITBE.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserServiceImpl service;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class.getSimpleName());

    @Autowired
    public UserDetailsService(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        logger.info("load user with username={}", userName);

        User account = service.selectUserByEmail(userName);
        if (account == null)
            throw new UsernameNotFoundException(String.format("Not found user with username=%s", userName));

        logger.info(account.toString());
        return new org.springframework.security.core.userdetails.User(
                account.getEmail(), account.getPassword(), true,
                true, true, !account.isBlock(),
                AuthorityUtils.createAuthorityList(
                        account.getRoles().stream().map(Role::getName)
                                .map(RoleName::toString)
                                .toArray(String[]::new))
        );
    }


}

