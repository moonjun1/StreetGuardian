package com.example.neighborhood.Dto;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private Long id; // Primary Key
    private String email;
    private String password;
    private String nickname;
    private int point;
}
