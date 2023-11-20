package io.github.vikie1.portfolio.auth.user;

import io.github.vikie1.portfolio.security.SecurityProtocols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserRepository userRepository;
    @Autowired SecurityProtocols securityProtocols; //to get the password encoder

    public void signUp(UserEntity user){
        PasswordEncoder encoder = securityProtocols.getPasswordEncoder();
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }
}
