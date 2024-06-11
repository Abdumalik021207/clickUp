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
public class Icon extends AbsEntity {

    @OneToOne
    private Attachmet attachment_id;

    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String innitial_letter;
    @Column(nullable = false)
    private String icon;
}
