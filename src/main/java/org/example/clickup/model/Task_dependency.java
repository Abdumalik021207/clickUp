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
public class Task_dependency extends AbsEntity {

    @OneToOne
    private Task task_id;

    @Column(nullable = false)
    private Integer dependency_task_id;
    @Column(nullable = false)
    private String dependency_type;
}
