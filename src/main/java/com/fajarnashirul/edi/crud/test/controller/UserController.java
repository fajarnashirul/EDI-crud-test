package com.fajarnashirul.edi.crud.test.controller;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import com.fajarnashirul.edi.crud.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel){
        UserDto user = userService.createUser(userModel);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping(path = "/{userId}")
    public ResponseEntity<?> getUser(@PathVariable(name = "userId") String userId){
        if (userId.equals("all")){
            List<UserDto> users = userService.getAllUser();
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.ok(userService.getUserById(Integer.parseInt(userId)));
    }
}
