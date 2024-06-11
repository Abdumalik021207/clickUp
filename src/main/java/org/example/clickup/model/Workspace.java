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
public class Workspace extends AbsEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;

    @OneToOne
    private User owner_id;

    @Column(nullable = false)
    private String initial_letter;
    @Column(nullable = false)
    private Integer avatar_id;
}
