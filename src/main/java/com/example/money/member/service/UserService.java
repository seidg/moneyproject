package com.example.money.member.service;

import com.example.money.member.dto.JoinRequest;
import com.example.money.member.dto.LoginRequest;
import com.example.money.member.entity.UserEntity;
import com.example.money.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor //의존성 주입에 사용된다 . 생성자 주입에 대한 코드를 생성
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public boolean checkLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    public boolean checkNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    public void join(JoinRequest joinreq) {
        userRepository.save((joinreq.toEntity(encoder.encode(joinreq.getPassword()))));
    }

    public UserEntity login(LoginRequest loginreq) {
        if (!userRepository.existsByLoginId(loginreq.getLoginId())) {
            return null;
        }
        Optional<UserEntity> userEntity = userRepository.findByLoginId(loginreq.getLoginId());
        if (!userEntity.get().getPassword().equals(loginreq.getPassword())) {
            return null;
        }
        return userEntity.get();

    }

    public UserEntity getLoginUserEntityById(Long userId) {
        Optional<UserEntity> optinalUserEntity = userRepository.findById(userId);
        if(optinalUserEntity.isEmpty()) {
            return null;
        }
        return optinalUserEntity.get();
    }
    public UserEntity getLoginUserEntityByLoginId(String loginId) {
        Optional<UserEntity> optinalUserEntity = userRepository.findByLoginId(loginId);
        if(optinalUserEntity.isEmpty()) {
            return null;
        }
        return optinalUserEntity.get();
    }



}
