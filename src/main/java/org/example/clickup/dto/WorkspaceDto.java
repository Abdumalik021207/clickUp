package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {
    private String name;
    private String color;
    private Long owner_id;
    private String initial_letter;
    private Long avatar_id;
}
