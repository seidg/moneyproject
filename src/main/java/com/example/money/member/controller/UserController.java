package com.example.money.member.controller;

import com.example.money.member.dto.JoinRequest;
import com.example.money.member.dto.LoginRequest;
import com.example.money.member.entity.UserEntity;
import com.example.money.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security")
public class UserController {

    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("loginType", "security");
        model.addAttribute("pageName", "Security 로그인");

        model.addAttribute("joinRequest", new JoinRequest());
        return "users/join";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginType","security");
        model.addAttribute("pageName", "Security 로그인");

        model.addAttribute("loginRequest",new LoginRequest());
        return "users/login";
    }

}
