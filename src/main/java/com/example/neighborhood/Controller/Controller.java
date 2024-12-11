package com.example.neighborhood.Controller;

import com.example.neighborhood.Dto.RegisterDto;
import com.example.neighborhood.Entity.RegisterEntity;
import com.example.neighborhood.Repository.RegisterRepository;
import com.example.neighborhood.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@org.springframework.stereotype.Controller
public class Controller {
    private RegisterRepository registerRepository;
    private Service service = new Service();
    private RegisterEntity registerEntity = new RegisterEntity();
    private RegisterDto registerDto = new RegisterDto();

    @Autowired
    public Controller(RegisterRepository registerRepository, Service service){
        this.registerRepository = registerRepository;
        this.service = service;
    }

    @GetMapping("/")
    public String main(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/signup")
    public String signup()
    {
        return "signup";
    }

    @GetMapping("/main")
    public String main()
    {
        return "main";
    }

    @GetMapping("/missions/new")
    public String missions_new()
    {
        return "missions-new";
    }

    @GetMapping("/rank")
    public  String rank()
    {
        return "rank";
    }

    @GetMapping("/mypage")
    public String mypage()
    {
        return "mypage";
    }

    @GetMapping("/status")
    public String status()
    {
        return "status";
    }

}
