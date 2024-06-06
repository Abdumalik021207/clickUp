package org.example.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;

    @OneToOne
    private Workspace workspace_id;

    @Column(nullable = false)
    private String initial_letter;

    @OneToOne
    private Icon icon_id;

    @OneToOne
    private User owner_id;

    @Column(nullable = false)
    private Integer access_type;

}
