package com.example.task2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    @NotBlank(message = "contents는 비어 있을 수 없습니다.")
    @Size(max = 200, message = "contents는 200자 이내여야 합니다.")
    private String contents;

    private String writer;

    @NotBlank(message = "작성자명은 비어있을 수 없습니다.")
    private String password;

    private LocalDate writeTime;

    private LocalDate updateTime;
}
