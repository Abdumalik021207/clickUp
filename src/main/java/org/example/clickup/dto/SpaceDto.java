package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {

    private String name;
    private String color;
    private Integer workspace_id;
    private String initial_letter;
    private Integer icon_id;
    private Integer owner_id;
    private Integer access_type;

}
