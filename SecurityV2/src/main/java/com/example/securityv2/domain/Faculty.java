package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="faculty", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "faculty_name_unique",columnNames = "name")
        })
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute institute;
}