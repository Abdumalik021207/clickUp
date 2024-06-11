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
public class Category_user extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category category_id;

    @OneToOne
    private User user_id;

    @Column(nullable = false)
    private String task_permission;
}
