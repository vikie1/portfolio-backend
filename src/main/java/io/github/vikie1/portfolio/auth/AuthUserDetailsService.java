package io.github.vikie1.portfolio.auth;

import io.github.vikie1.portfolio.auth.role.RoleEntity;
import io.github.vikie1.portfolio.auth.user.UserEntity;
import io.github.vikie1.portfolio.auth.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();
        return new User(userEntity.getUsername(), userEntity.getPassword(), mapRolesToAuthorities(userEntity.getRoles()));
    }
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <RoleEntity> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
