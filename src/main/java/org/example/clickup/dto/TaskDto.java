package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String name;
    private String description;
    private Integer status_id;
    private Integer priority_id;
    private Integer parent_task_id;
    private Timestamp started_date;
    private Timestamp start_time_has;
    private Timestamp due_date;
    private Timestamp due_time_has;
    private long estimate_time;
    private Timestamp actived_date;

}
