package com.fajarnashirul.edi.crud.test.repository;

import com.fajarnashirul.edi.crud.test.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
