package com.example.neighborhood.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionsDto {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private int risk;
    private int point;
}
