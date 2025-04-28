package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.Authority;
import com.example.estateagencyrent.entity.User;
import com.example.estateagencyrent.entity.UserUpdate;
import com.example.estateagencyrent.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LoginService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean login(User user) {
        List<User> userList = userRepository.findAll();
        for (User us : userList) {
            if (us.getUsername().equals(user.getUsername()) && us.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean signUp(User user) {
        if (!checkUserExist(user)){
            user.setImg("/src/main/resources/static/img/avatarDefault.jpg");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Authority> authorities = new HashSet<>();
            authorities.add(new Authority("ROLE_USER", user));
            user.setAuthorities(authorities);
            userRepository.save(user);
            return true;
        }return false;
    }

    public boolean checkUserExist(User user) {
        Optional<User> checkExist = userRepository.findUserByUsername(user.getUsername());
        return checkExist.isPresent();
    }

    public boolean changePassword(UserUpdate userUpdate){
        User user_update = userRepository.findById(userUpdate.getId()).get();
        if (user_update.getPassword().equals(userUpdate.getOldPassword())){
            if (userUpdate.getNewPassword().equals(userUpdate.getAutPassword())){
                user_update.setPassword(userUpdate.getNewPassword());
                userRepository.save(user_update);
                return true;
            }
            return false;
        }
        return false;
    }

}
