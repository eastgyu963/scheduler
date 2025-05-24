package com.example.task2.dto;

import com.example.task2.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String contents;
    private String writer;
    //private String password;
    private LocalDate writeTime;
    private LocalDate updateTime;

    public ScheduleResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.contents =schedule.getContents();
        this.writer=schedule.getWriter();
        //this.password=schedule.getPassword();
        this.writeTime=schedule.getWriteTime();
        this.updateTime=schedule.getUpdateTime();
    }

}
