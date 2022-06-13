package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="institute", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "institute_name_unique",columnNames = "name")
        })
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*@OneToMany(mappedBy = "institute") //Gdy tak się robi, to trzeba dwóstronnie zapisywać relację, dodać do instytutu uczelnie i instytut do uczelni
    private List<Faculty> faculty;*/

    public Institute(String name) {
        this.name = name;
    }
}
