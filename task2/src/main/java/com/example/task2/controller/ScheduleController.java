package com.example.task2.controller;

import com.example.task2.dto.ScheduleRequestDto;
import com.example.task2.dto.ScheduleResponseDto;
import com.example.task2.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto){

        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    //수정일, 작성자명을 조건으로 등록된 일정을 모두 조회하는 기능. 두개 정보 모두 안 올수 있으므로 required 속성 활용.
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(@RequestParam(name = "writer",required = false) String writer,
                                                                     @RequestParam(name="updateTime",required = false) LocalDate updateTime){
        return new ResponseEntity<>(scheduleService.findAllSchedule(writer,updateTime), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleRequestDto requestDto){
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable("id") Long id,@RequestBody ScheduleRequestDto requestDto){
        scheduleService.deleteScheduleById(id,requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
