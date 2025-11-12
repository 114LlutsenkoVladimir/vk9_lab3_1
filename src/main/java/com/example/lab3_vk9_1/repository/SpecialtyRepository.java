package com.example.lab3_vk9_1.repository;

import com.example.lab3_vk9_1.entity.Specialty;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SpecialtyRepository extends GenericRepository<Specialty, Long>{
    protected SpecialtyRepository() {
        super(Specialty.class);
    }
}
