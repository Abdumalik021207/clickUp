package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Time_trackerDto {

    private Long task_id;
    private Timestamp started_time;
    private Timestamp stopped_time;

}
