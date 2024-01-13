package com.example.money.member.controller;

import com.example.money.member.entity.UserEntity;
import com.example.money.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping(value={"/security","/"})
    public String home(Model model, Authentication auth){
        model.addAttribute("loginType","security");
        model.addAttribute("pageName","security 로그인");

        if(auth != null){
            UserEntity userEntity = userService.getLoginUserEntityByLoginId(auth.getName());
            if(userEntity != null){
                model.addAttribute("nickname",userEntity.getNickname());

            }
        }
        return "users/home";
    }

}
