package com.example.task2.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String contents;
    private String writer;
    private String password;
    private LocalDate writeTime;
    private LocalDate updateTime;
}
