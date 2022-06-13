package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="year", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "year_name_unique",columnNames = "name")
        })
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Year(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
