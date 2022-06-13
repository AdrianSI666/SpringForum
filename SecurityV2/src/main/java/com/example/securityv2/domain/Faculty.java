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

    public Faculty(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Institute getInstitute() {
        return institute;
    }
}