package com.fajarnashirul.edi.crud.test.service;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;

import java.util.List;

public interface UserService {
    UserDto createUser(UserModel userModel);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser(Integer page, Integer size, String orderBy, String sortDir);
    void delDataUser(Integer userId);
    Boolean existsUserByUsername(String username);
}
