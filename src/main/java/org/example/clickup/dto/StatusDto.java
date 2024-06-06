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
    private Integer space_id;
    private Integer project_id;
    private Integer category_id;
    private String color;
    private String type;

}
