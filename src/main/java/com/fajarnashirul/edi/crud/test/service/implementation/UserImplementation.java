package com.fajarnashirul.edi.crud.test.service.implementation;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import com.fajarnashirul.edi.crud.test.repository.UserRepository;
import com.fajarnashirul.edi.crud.test.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        if (userRepository.save(userModel) > 0){
            userModel.setUserId(userRepository.getLastUserId());
            return mapToUserDto(userModel);
        }
        throw new InternalError();
    }

    @Override
    public UserDto getUserById(Integer userId) {
        Optional<UserModel> userModel = userRepository.findById(userId);
        if (userModel.isPresent()) {
            return mapToUserDto(userModel.get());// Fungsi untuk mengubah UserModel menjadi UserDto
        }
        throw new EntityNotFoundException();
    }

    @Override
    public List<UserDto> getAllUser(Integer page, Integer size, String orderBy, String sortDir) {
        RowBounds rowBounds = new RowBounds((page - 1) * size, size);
        List<UserModel> users = userRepository.findAll(rowBounds, orderBy, sortDir.toUpperCase());
        if (users.isEmpty()){
            throw new NoSuchElementException();
        }
        return users.stream()
                .map(this::mapToUserDto) // Fungsi untuk mengubah UserModel menjadi UserDto
                .collect(Collectors.toList());
    }

    @Override
    public void delDataUser(Integer userId) {
        Optional<UserModel> userModel = userRepository.findById(userId);
        if (userModel.isPresent()){
            userRepository.delete(userId);
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Boolean existsUserByUsername(String username) {
        return (userRepository.existsByUsername(username) > 0);
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
