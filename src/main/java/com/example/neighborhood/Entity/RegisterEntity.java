package com.example.neighborhood.Entity;
import com.example.neighborhood.Dto.RegisterDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@jakarta.persistence.Entity
@Getter
@Setter
@Table(name = "userinfo")
public class RegisterEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private int point;

    public RegisterEntity inputDto(RegisterDto registerDto){
        BCryptPasswordEncoder hash = new BCryptPasswordEncoder();

        this.email = registerDto.getEmail();
        this.password = hash.encode(registerDto.getPassword());
        this.nickname = registerDto.getNickname();
        this.point = 0;

        return this;
    }

}
