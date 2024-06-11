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
public class Category extends AbsEntity {

    @Column(nullable = false)
    private String name;
    @OneToOne
    private Project projectId;
    @Column(nullable = false)
    private String acces_type;
    @Column(nullable = false)
    private boolean archived;
    @Column(nullable = false)
    private String color;


}
