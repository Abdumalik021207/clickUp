package org.example.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clickup.model.template.Permission;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_permissionDto {

    private Long workspace_role_id;
    private Permission permission;

}
