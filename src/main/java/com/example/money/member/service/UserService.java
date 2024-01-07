package com.example.money.member.service;

import com.example.money.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //의존성 주입에 사용된다 . 생성자 주입에 대한 코드를 생성
public class UserService {

    private final UserRepository userRepository;




}
