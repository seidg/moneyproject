package com.example.money.member.principal;

import com.example.money.member.entity.UserEntity;
import com.example.money.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLoginId(username).orElseThrow(() -> {
            return new UsernameNotFoundException("해당 유저를 찾을수 없음");
        });

        return new PrincipalDetails(userEntity);
    }
}
