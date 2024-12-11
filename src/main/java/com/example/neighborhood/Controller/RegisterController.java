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
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Controller
public class RegisterController {
    private RegisterRepository registerRepository;
    private Service service;
    private RegisterEntity registerEntity = new RegisterEntity();

    @Autowired
    public RegisterController(RegisterRepository registerRepository, Service service){ //의존성주입
        this.registerRepository = registerRepository;
        this.service = service;
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto){
        System.out.println("\nemail : " + registerDto.getEmail() + "\n/password : " + registerDto.getPassword() + "\n/nickname : " + registerDto.getNickname());
        registerRepository.save(registerEntity.inputDto(registerDto));
        return "main";
    }

}
