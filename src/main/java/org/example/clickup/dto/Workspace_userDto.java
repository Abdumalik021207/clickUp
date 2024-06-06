package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_userDto {

    private Integer workspace_id;
    private Integer user_id;
    private String workspace_role_id;
    private Timestamp date_invited;
    private Timestamp date_joined;

}
