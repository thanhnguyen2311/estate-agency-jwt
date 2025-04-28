package com.example.estateagencyrent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Authority(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Authority() {
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
