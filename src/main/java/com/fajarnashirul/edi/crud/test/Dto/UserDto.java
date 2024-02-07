package com.fajarnashirul.edi.crud.test.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Integer userId;
    private String namaLengkap;
    private String username;
    private Character status;
}
