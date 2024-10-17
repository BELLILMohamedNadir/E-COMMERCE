package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.config.JwtService;
import com.bmn.e_commerce.dtos.UserDto;
import com.bmn.e_commerce.mappers.UserMapper;
import com.bmn.e_commerce.models.AuthenticationRequest;
import com.bmn.e_commerce.models.User;
import com.bmn.e_commerce.models.response.AuthenticationResponse;
import com.bmn.e_commerce.repositories.UserRepository;
import com.bmn.e_commerce.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(UserDto userDto) throws Exception {
        //TODO save the photo
        User user = mapper.mapTo(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User u = repository.save(user);

        if (u == null)
            throw new Exception("the user has not been inserted");

        return "Registered Successfully";
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Optional<User> user = repository.findByEmail(request.getEmail());

        // when we're here officially that user exist because .authenticate throw an exception else
        User u =user.get();
        String jwtToken = jwtService.generateToken(u);
        return AuthenticationResponse
                .builder()
                .id(u.getId())
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .email(u.getEmail())
                .role(u.getRole().name())
                .phone(u.getPhone())
                .address(u.getAddress())
                .token(jwtToken)
                .build();
    }
}
