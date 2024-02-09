package com.fajarnashirul.edi.crud.test.service;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto createUser(UserModel userModel);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser(Pageable pageable);
    void delDataUser(Integer userId);
    Boolean existsUserByUsername(String username);
}
