package com.example.money.member.service;

import com.example.money.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //������ ���Կ� ���ȴ� . ������ ���Կ� ���� �ڵ带 ����
public class UserService {

    private final UserRepository userRepository;

    public boolean checkLoginId(String loginId){
        return userRepository.existsByLoginId(loginId);
    }

    public boolean checkNickname(String nickname){
        return userRepository.existsByNickname(nickname);
    }








}
