package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="user", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique",columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int indeks;
    private String nickname;
    private String password;
    private String icon;
    private String description;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role=new ArrayList<>();
    @ManyToMany
    private Collection<Badge> badges=new ArrayList<>();
    private Boolean locked = false;
    private Boolean enabled = false;

    public User(int indeks, String nickname, String password, String icon, String description, String email, Collection<Role> role, Collection<Badge> badges) {
        this.indeks = indeks;
        this.nickname = nickname;
        this.password = password;
        this.icon = icon;
        this.description = description;
        this.email = email;
        this.role = role;
        this.badges=badges;
    }
}
