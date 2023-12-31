package com.example.mgtsystemlogin.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    public Role() {

    }
    public Role(String name){
        this.name=name;
    }


}
