package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="commentary", schema = "public")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int rate;
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
