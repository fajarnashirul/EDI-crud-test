package com.fajarnashirul.edi.crud.test.service.implementation;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import com.fajarnashirul.edi.crud.test.repository.UserRepository;
import com.fajarnashirul.edi.crud.test.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public UserDto getUserById(Integer userId) {
        Optional<UserModel> userModel = userRepository.findById(userId);
        if (userModel.isPresent()) {
            return mapToUserDto(userModel.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto) // Fungsi untuk mengubah UserModel menjadi UserDto
                .collect(Collectors.toList());
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
