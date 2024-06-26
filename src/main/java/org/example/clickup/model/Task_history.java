package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.clickup.model.template.AbsEntity;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task_history extends AbsEntity {

    @OneToOne
    private Task task_id;

    @Column(nullable = false)
    private String change_field_name;
    @Column(nullable = false)
    private Timestamp before;
    @Column(nullable = false)
    private Timestamp after;
    @Column(nullable = false)
    private Timestamp data;
}
