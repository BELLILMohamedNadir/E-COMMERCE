package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.dtos.UserDto;
import com.bmn.e_commerce.models.AuthenticationRequest;
import com.bmn.e_commerce.models.response.AuthenticationResponse;

public interface UserService{
    String register(UserDto userDto) throws Exception;
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
