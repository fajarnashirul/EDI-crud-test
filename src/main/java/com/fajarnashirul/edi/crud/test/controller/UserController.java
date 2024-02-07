package com.fajarnashirul.edi.crud.test.controller;

import com.fajarnashirul.edi.crud.test.Dto.UserDto;
import com.fajarnashirul.edi.crud.test.model.UserModel;
import com.fajarnashirul.edi.crud.test.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
        if (userService.existsUserByUsername(userModel.getUsername())){
            return ResponseEntity.badRequest().body("username already exists");
        }
        UserDto user = userService.createUser(userModel);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping(path = "/{userId}")
    public ResponseEntity<?> getUser(@PathVariable(name = "userId") String userId){
        try {
            if (userId.equals("all")){
                List<UserDto> users = userService.getAllUser();
                return ResponseEntity.ok(users);
            }
            return ResponseEntity.ok(userService.getUserById(Integer.parseInt(userId)));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + userId +" not found");
        }

    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<?> delDataUser(@PathVariable(name = "userId") Integer userId){
        try {
            userService.delDataUser(userId);
            return ResponseEntity.ok("User with ID " + userId +  " has been deleted");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + userId +" not found");
        }

    }
}
