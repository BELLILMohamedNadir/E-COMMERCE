package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.UserDto;
import com.bmn.e_commerce.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User mapTo(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

    @Override
    public UserDto mapFrom(User user) {
        return mapper.map(user, UserDto.class);
    }
}
