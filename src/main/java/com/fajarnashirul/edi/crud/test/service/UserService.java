package com.fajarnashirul.edi.crud.test.service;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;

public interface UserService {
    UserDto createUser(UserModel userModel);
}
