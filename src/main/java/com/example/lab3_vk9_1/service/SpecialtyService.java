package com.example.lab3_vk9_1.service;

import com.example.lab3_vk9_1.entity.Specialty;
import com.example.lab3_vk9_1.repository.SpecialtyRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SpecialtyService extends AbstractCrudService<Specialty, Long, SpecialtyRepository> {

}
