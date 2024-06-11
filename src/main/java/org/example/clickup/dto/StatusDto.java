package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private String name;
    private Long space_id;
    private Long project_id;
    private Long category_id;
    private String color;
    private String type;

}
