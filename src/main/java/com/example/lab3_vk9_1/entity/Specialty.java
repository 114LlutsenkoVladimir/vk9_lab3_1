package com.example.lab3_vk9_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<SpecialtyForApplicant> applicants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<SpecialtyForApplicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<SpecialtyForApplicant> applicants) {
        this.applicants = applicants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void copy(Specialty specialty) {
        this.name = specialty.getName();
    }

}