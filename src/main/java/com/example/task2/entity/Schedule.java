package com.example.task2.entity;


import com.example.task2.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String contents;
    private String writer;
    private String password;
    private LocalDate writeTime;
    private LocalDate updateTime;

    public Schedule(ScheduleRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
        this.writeTime = requestDto.getWriteTime();
        this.updateTime = requestDto.getUpdateTime();
    }

}
