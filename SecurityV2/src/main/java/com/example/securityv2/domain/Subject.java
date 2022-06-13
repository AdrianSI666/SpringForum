package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subject", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "subject_name_unique",columnNames = "name")
        })
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

    public Subject(String name, Year year) {
        this.name = name;
        this.year = year;
    }
}