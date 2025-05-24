package com.example.task2.repository;

import com.example.task2.dto.ScheduleRequestDto;
import com.example.task2.dto.ScheduleResponseDto;
import com.example.task2.entity.Schedule;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto);

    List<ScheduleResponseDto> findAllSchedule(String writer, LocalDate updateTime);
    List<ScheduleResponseDto> findAllScheduleByUpdateTime(String updateTime);
    List<ScheduleResponseDto> findAllScheduleByWriter(String writer);

    Optional<Schedule> findScheduleById(Long id);

    int deleteSchedule(Long id, String password);

    int updateSchedule(Long id,String contents, String writer, String password);


}
