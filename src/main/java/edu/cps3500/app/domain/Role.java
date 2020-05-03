package edu.cps3500.app.domain;

import javax.persistence.*;

@Entity
@Embeddable
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}