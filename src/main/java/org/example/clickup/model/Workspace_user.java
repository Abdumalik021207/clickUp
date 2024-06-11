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
public class Workspace_user extends AbsEntity {

    @Column(nullable = false)
    private Integer workspace_id;
    @Column(nullable = false)
    private Integer user_id;

    @OneToOne
    private Workspace_role workspace_role_id;

    @Column(nullable = false)
    private Timestamp date_invited;
    @Column(nullable = false)
    private Timestamp date_joined;
}
