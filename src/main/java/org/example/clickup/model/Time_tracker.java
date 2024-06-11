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
public class Time_tracker extends AbsEntity {

    @OneToOne
    private Task task_id;

    @Column(nullable = false)
    private Timestamp started_time;
    @Column(nullable = false)
    private Timestamp stopped_time;
}
