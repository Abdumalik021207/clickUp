package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Workspace_role extends AbsEntity {

    @OneToOne
    private Workspace workspace_id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String extends_role;

}
