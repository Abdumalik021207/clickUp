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
    private Long workspace_id;
    private String initial_letter;
    private Long icon_id;
    private Long owner_id;
    private Long access_type;

}
