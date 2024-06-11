package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_dependencyDto {

    private Long task_id;
    private Long dependency_task_id;
    private String dependency_type;

}
