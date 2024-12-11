package com.example.neighborhood.Controller;

import com.example.neighborhood.Dto.RegisterDto;
import com.example.neighborhood.Entity.RegisterEntity;
import com.example.neighborhood.Repository.RegisterRepository;
import com.example.neighborhood.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Controller
public class LoginController {
    private BCryptPasswordEncoder hash = new BCryptPasswordEncoder();
    private RegisterRepository registerRepository;
    private Service service;
    private RegisterEntity registerEntity = new RegisterEntity();

    @Autowired
    public LoginController(RegisterRepository registerRepository, Service service)
    {
        this.registerRepository = registerRepository;
        this.service = service;
    }

    @PostMapping("/login-input")
    public String login(RegisterDto registerDto){
        registerEntity =  registerRepository.findByEmail(registerDto.getEmail()).orElse(null);
        if(registerEntity == null) //회원정보가 없음
        {
            System.out.println("회원정보가 없음..");
        }
        else{
            if(hash.matches(registerDto.getPassword(), registerEntity.getPassword())){ //password같을 경우
                System.out.println("로그인 성공");
                return "main";
            }
            else{
                System.out.println("비밀번호가 알맞지 않음\n");
            }
        }
        return "main";
    }
}
