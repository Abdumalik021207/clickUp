package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_historyDto {

    private Long task_id;
    private String change_field_name;
    private Timestamp before;
    private Timestamp after;
    private Timestamp data;

}
