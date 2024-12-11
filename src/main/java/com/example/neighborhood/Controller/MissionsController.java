package com.example.neighborhood.Controller;


import com.example.neighborhood.Dto.MissionsDto;
import com.example.neighborhood.Entity.MissionsEntity;
import com.example.neighborhood.Entity.RegisterEntity;
import com.example.neighborhood.Repository.MissionsRepository;
import com.example.neighborhood.Repository.RegisterRepository;
import com.example.neighborhood.Service.Service;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ai.anthropic.AnthropicChatModel;

import java.util.List;
import java.util.Optional;

@Controller
public class MissionsController {

    private String interFace = "/ 사용자 응답 : ";
    private String data =
                        "{응답_규칙: {" +
                            "범위: 주어진 데이터," +
                            "방식: [사용자 응답에 위험도에 해당하는 단어가 존재하면 우측 숫자를 합산하여 합산값 출력]," +
                                "제한사항: 합산숫자로만응답" +
                                "}," +
                                "위험도: {" +
                                "제설: 3," +
                                "쓰레기청소: 2," +
                                "해양쓰레기청소: 9," +
                                "해수욕장 청소: 3," +
                                "산불: 7," +
                                "수질 오염: 8," +
                                "공원 정비: 2," +
                                "비닐봉투 제거: 2," +
                                "에너지 절약 캠페인: 1," +
                                "홍수: 5," +
                                "지진피해: 6," +
                                "태풍피해: 6," +
                                "폭설 피해: 4," +
                                "산사태: 7," +
                                "도로 붕괴: 8," +
                                "교량 파손: 7," +
                                "댐 붕괴: 9," +
                                "화산폭발: 9," +
                                "난민: 5," +
                                "학교폭력피해자: 6," +
                                "성폭력피해자: 5," +
                                "테러피해: 10," +
                                "고립노인: 5," +
                                "아동학대피해자: 7," +
                                "장애인 학대피해자: 6," +
                                "노숙자 지원: 4," +
                                "저소득층 지원: 3," +
                                "청소년 상담: 4," +
                                "응급환자: 10," +
                                "화재 구조: 8," +
                                "실종자 수색: 9," +
                                "유기동물 구조: 4," +
                                "독극물 노출: 9," +
                                "구조요청: 10," +
                                "급성 전염병: 10," +
                                "가스 누출: 8," +
                                "물 부족: 6" +
                                "}" +
                                "}";

    private MissionsRepository missionsRepository;
    private Service service;
    private MissionsEntity missionsEntity = new MissionsEntity();
    private final AnthropicChatModel chatModel;

    @Autowired
    public MissionsController(MissionsRepository missionsRepository, Service service, AnthropicChatModel chatModel)
    {
        this.missionsRepository = missionsRepository;
        this.service = service;
        this.chatModel = chatModel;
    }

    @GetMapping("/missions")
    public String missions(Model model)
    {
        List<MissionsEntity> missionsEntity = missionsRepository.findAll(Sort.by(Sort.Direction.DESC, "risk"));
        model.addAttribute("writer", missionsEntity);
        return "missions";
    }

    @GetMapping("/missions-new")
    public String missions_new()
    {
        return "missions-new";
    }

    @PostMapping("/missions-submit")
    public String missions_submit(MissionsDto missionsDto){
        MissionsEntity missionsEntity = new MissionsEntity();
        String message = data + interFace + missionsDto.getTitle();
        int risk = Integer.parseInt(chatModel.call(message));;

        missionsEntity.setContent(missionsDto.getContent());
        missionsEntity.setTitle(missionsDto.getTitle());
        missionsEntity.setPoint(risk*2);
        missionsEntity.setNickname("guest");
        missionsEntity.setRisk(risk);
        missionsRepository.save(missionsEntity);


        return "redirect:/missions";
    }

    @GetMapping("/missions/{id}")
    public String missions_id(@PathVariable Long id, Model model){
        MissionsEntity missionsEntity = missionsRepository.findById(id).orElse(null);
        model.addAttribute("mission", missionsEntity);
        return "missions-detail";
    }

}
