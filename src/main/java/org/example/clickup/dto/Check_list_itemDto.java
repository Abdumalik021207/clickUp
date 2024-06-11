package org.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check_list_itemDto {

    private String name;
    private Long check_list_id;
    private boolean resolved;
    private Long assigned_user_id;

}
