package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {

    private Long attachment_id;
    private String color;
    private String innitial_letter;
    private Long icon;

}
