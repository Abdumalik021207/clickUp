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
public class Workspace_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer workspace_id;
    @Column(nullable = false)
    private Integer user_id;
    @Column(nullable = false)
    private String workspace_role_id;
    @Column(nullable = false)
    private Timestamp date_invited;
    @Column(nullable = false)
    private Timestamp date_joined;
}
