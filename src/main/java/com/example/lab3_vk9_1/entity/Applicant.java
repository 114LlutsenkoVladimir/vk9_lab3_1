package com.example.lab3_vk9_1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Size(max = 70)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Column(name = "average_mark", nullable = false)
    private Double averageMark;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpecialtyForApplicant> specialties = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public Set<SpecialtyForApplicant> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<SpecialtyForApplicant> specialties) {
        this.specialties = specialties;
    }

    public void addSpecialty(SpecialtyForApplicant sfa) { specialties.add(sfa); }

    public void copy(Applicant applicant) {
        this.firstName = applicant.getFirstName();
        this.lastName = applicant.getLastName();
        this.averageMark = applicant.getAverageMark();
        this.birthDate = applicant.getBirthDate();
    }
}