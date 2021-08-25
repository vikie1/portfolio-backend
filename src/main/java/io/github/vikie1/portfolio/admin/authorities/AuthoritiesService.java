package io.github.vikie1.portfolio.admin.authorities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {

    @Autowired AuthoritiesRepo authoritiesRepo;

    public void createAuthority(String username){
        AuthoritiesEntity authoritiesEntity = new AuthoritiesEntity(username, "ROLE_ADMIN");
        authoritiesRepo.save(authoritiesEntity);
    }

    public void deleteAuthority(String username){ authoritiesRepo.deleteByUsername(username); }

}
