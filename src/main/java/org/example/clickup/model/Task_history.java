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
public class Task_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer task_id;
    @Column(nullable = false)
    private String change_field_name;
    @Column(nullable = false)
    private Timestamp before;
    @Column(nullable = false)
    private Timestamp after;
    @Column(nullable = false)
    private Timestamp data;
}
