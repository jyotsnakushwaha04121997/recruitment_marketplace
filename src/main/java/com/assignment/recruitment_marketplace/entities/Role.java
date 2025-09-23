package com.assignment.recruitment_marketplace.entities;

import jakarta.persistence.*;

/**
 * Role entity (ROLE_ADMIN, ROLE_ORGADMIN, ROLE_USER).
 */
@Entity
@Table(name = "role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String name;

    public Role() {}
    public Role(Long id, String name) { this.id = id; this.name = name; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
