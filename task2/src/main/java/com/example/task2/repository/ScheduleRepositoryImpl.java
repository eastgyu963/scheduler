package com.example.task2.repository;

import com.example.task2.dto.ScheduleRequestDto;
import com.example.task2.dto.ScheduleResponseDto;
import com.example.task2.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Repository
public class ScheduleRepositoryImpl  implements ScheduleRepository{

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("contents",scheduleRequestDto.getContents());
        parameters.put("writer",scheduleRequestDto.getWriter());
        parameters.put("password",scheduleRequestDto.getPassword());
        parameters.put("writeTime",scheduleRequestDto.getWriteTime());
        parameters.put("updateTime",scheduleRequestDto.getUpdateTime());//처음 등록할때는 수정일과 작성일 동일

        //insert 실행
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        
        //저장한 내용 reponseDto로 반환
        return new ScheduleResponseDto(key.longValue(),
                scheduleRequestDto.getContents(),
                scheduleRequestDto.getWriter(),
                scheduleRequestDto.getWriteTime(),
                scheduleRequestDto.getUpdateTime());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule(String writer,LocalDate updateTime) {
        StringBuilder sql = new StringBuilder("SELECT * FROM schedule WHERE 1=1");
        List<Object> params = new ArrayList<>();

        //작성자 조건이 오는 경우 쿼리에 조건 추가해준다.
        if (writer != null && !writer.isEmpty()) {
            sql.append(" AND writer = ?");
            params.add(writer);
        }

        //수정일 조건이 오는 경우 쿼리에 조건 추가해준다.
        if (updateTime != null) {
            sql.append(" AND DATE(updateTime) = ?");
            params.add(java.sql.Date.valueOf(updateTime));
        }

        //수정일 기준으로 내림차순으로 정렬하기 위한 쿼리 추가
        sql.append(" ORDER BY updateTime DESC");

        return jdbcTemplate.query(sql.toString(), params.toArray(), scheduleResponseDtoRowMapper()
        );
    }

    @Override
    public List<ScheduleResponseDto> findAllScheduleByUpdateTime(String updateTime) {
        return jdbcTemplate.query("select * from schedule where updateTime=?", scheduleResponseDtoRowMapper(), updateTime);
    }

    @Override
    public List<ScheduleResponseDto> findAllScheduleByWriter(String writer) {
        return jdbcTemplate.query("select * from schedule where writer=?", scheduleResponseDtoRowMapper(), writer);
    }

    @Override
    public Optional<Schedule> findScheduleById(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from schedule where id=?", scheduleRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public int deleteSchedule(Long id,String password) {
        int update = jdbcTemplate.update("delete from schedule where id=?", id);
        return update;
    }

    @Override
    public int updateSchedule(Long id, String contents, String writer, String password) {
        LocalDate now = LocalDate.now();
        int updatedRow = jdbcTemplate.update("update schedule set contents=?, writer=?, updateTime=? where id=?", contents, writer,now ,id);
        return updatedRow;
    }



    private RowMapper<ScheduleResponseDto> scheduleResponseDtoRowMapper(){

        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("contents"),
                        rs.getString("writer"),
                        rs.getTimestamp("writeTime").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("updateTime").toLocalDateTime().toLocalDate()
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapper(){

        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("contents"),
                        rs.getString("writer"),
                        rs.getString("password"),
                        rs.getTimestamp("writeTime").toLocalDateTime().toLocalDate(),
                        rs.getTimestamp("updateTime").toLocalDateTime().toLocalDate()
                );
            }
        };
    }


}
