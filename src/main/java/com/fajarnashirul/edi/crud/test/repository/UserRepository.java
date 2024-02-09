package com.fajarnashirul.edi.crud.test.repository;

import com.fajarnashirul.edi.crud.test.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Boolean existsByUsername(String username);
}
