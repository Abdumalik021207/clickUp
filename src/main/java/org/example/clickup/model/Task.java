package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer status_id;
    @Column(nullable = false)
    private Integer priority_id;
    @Column(nullable = false)
    private Integer parent_task_id;
    @Column(nullable = false)
    private Timestamp started_date;
    @Column(nullable = false)
    private Timestamp start_time_has;
    @Column(nullable = false)
    private Timestamp due_date;
    @Column(nullable = false)
    private Timestamp due_time_has;
    @Column(nullable = false)
    private long estimate_time;
    @Column(nullable = false)
    private Timestamp actived_date;
}
