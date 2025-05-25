package com.example.task2.service;

import com.example.task2.dto.ScheduleRequestDto;
import com.example.task2.dto.ScheduleResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedule(String writer, LocalDate updateTime);
//    List<ScheduleResponseDto> findAllScheduleByUpdateTime(String updateTime);
//    List<ScheduleResponseDto> findAllScheduleByWriter(String writer);
    List<ScheduleResponseDto> findScheduleByPage(int page, int size);

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto);

    void deleteScheduleById(Long id, String password);

}
