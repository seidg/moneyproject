package com.example.money.member.config;


import com.example.money.member.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable);

        http.formLogin(formlogin -> formlogin
                .usernameParameter("loginId")
                .passwordParameter("password")
                .loginPage("/security/login")
                .defaultSuccessUrl("/security/login")
                .failureUrl("/security/login")
        );
        http.logout(logout -> logout
                .logoutUrl("/security/logout")
                .invalidateHttpSession(true)
        );

        http.authorizeRequests(auth -> auth
                .requestMatchers("/security/info").authenticated()
                .requestMatchers("/security/admin/**").hasAnyAuthority(UserRole.ADMIN.name())
                .anyRequest().permitAll()
        );


        return http.build();

    }



}
