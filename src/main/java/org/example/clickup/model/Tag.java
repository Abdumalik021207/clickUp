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
public class Tag extends AbsEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;

    @OneToOne
    private Workspace workspaceId;

}
