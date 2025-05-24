package com.example.task2.service;

import com.example.task2.dto.ScheduleRequestDto;
import com.example.task2.dto.ScheduleResponseDto;
import com.example.task2.entity.Schedule;
import com.example.task2.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        ScheduleResponseDto ResponseDto = scheduleRepository.saveSchedule(requestDto);
        return ResponseDto;
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule(String writer, LocalDate updateTime) {
        List<ScheduleResponseDto> allSchedule = scheduleRepository.findAllSchedule(writer, updateTime);
        return allSchedule;
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "does not exist id=" + id));
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findScheduleById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "does not exist id=" + id));

        if(schedule.getPassword().equals(requestDto.getPassword()))
        {
            int updatedRow = scheduleRepository.updateSchedule(id, requestDto.getContents(), requestDto.getWriter(), requestDto.getPassword());
        }
        else {
            //저장된 비밀번호와 업데이트 요청할때 작성한 비밀번호와 일치하지 않는 경우 bad request 발생
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }
        Schedule updateSchedule = scheduleRepository.findScheduleById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "does not exist id=" + id));
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(updateSchedule);
        return scheduleResponseDto;
    }

    @Override
    public void deleteScheduleById(Long id, String password) {
        Schedule schedule = scheduleRepository.findScheduleById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "does not exist id=" + id));
        if(schedule.getPassword().equals(password))
        {
            int deletedSchedule = scheduleRepository.deleteSchedule(id,password);
            if(deletedSchedule==0){
                //존재하지 않는 일정을 조회하려고 하는 경우 not found 발생
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "does not exist id=" + id);
            }
        }
        else {
            //저장된 비밀번호와 업데이트 요청할때 작성한 비밀번호와 일치하지 않는 경우 bad request 발생
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }
    }
}
