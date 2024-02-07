package com.fajarnashirul.edi.crud.test.service.implementation;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import com.fajarnashirul.edi.crud.test.repository.UserRepository;
import com.fajarnashirul.edi.crud.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation implements UserService {
    private final UserRepository userRepository;

    public UserImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserModel userModel) {
        userRepository.save(userModel);
        return mapToUserDto(userModel);
    }

    private UserDto mapToUserDto(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userModel.getUserId());
        userDto.setNamaLengkap(userModel.getNamaLengkap());
        userDto.setUsername(userModel.getUsername());
        userDto.setStatus(userModel.getStatus());

        return userDto;
    }
}
