package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer space_id;
    @Column(nullable = false)
    private Integer project_id;
    @Column(nullable = false)
    private Integer category_id;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String type;
}
