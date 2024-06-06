package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmetDto {

    private String full_name;
    private String email;
    private String password;
    private String color;
    private String initial_letter;
    private Integer avatarId;

}
