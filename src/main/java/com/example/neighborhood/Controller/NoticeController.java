package com.example.neighborhood.Controller;

import com.example.neighborhood.Entity.MissionsEntity;
import com.example.neighborhood.Entity.NoticeEntity;
import com.example.neighborhood.Repository.MissionsRepository;
import com.example.neighborhood.Repository.NoticeRepository;
import com.example.neighborhood.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;
    private NoticeEntity noticeEntity = new NoticeEntity();


    @GetMapping("/notice")
    public String notice(Model model){
        NoticeEntity noticeEntity = new NoticeEntity();
        List<NoticeEntity> noticee = noticeRepository.findAll();
        model.addAttribute("articleList", noticee);
        return "index(1)";
    }

    @GetMapping("/articles")
    public String articles(){
        return "index(1)";
    }

    @GetMapping("/articles/new")
    public String notice_new(){
        return "new(4)";
    }

}
