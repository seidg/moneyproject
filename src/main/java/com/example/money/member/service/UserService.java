package com.example.money.member.service;

import com.example.money.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //������ ���Կ� ���ȴ� . ������ ���Կ� ���� �ڵ带 ����
public class UserService {

    private final UserRepository userRepository;




}
