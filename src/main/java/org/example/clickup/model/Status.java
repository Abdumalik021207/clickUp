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

    @OneToOne
    private Space space_id;

    @OneToOne
    private Project project_id;

    @OneToOne
    private Category category_id;

    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String type;
}
