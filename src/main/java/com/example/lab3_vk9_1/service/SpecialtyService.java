package com.example.lab3_vk9_1.service;

import com.example.lab3_vk9_1.entity.Specialty;
import com.example.lab3_vk9_1.repository.SpecialtyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SpecialtyService extends AbstractCrudService<Specialty, Long, SpecialtyRepository> {


    @Override
    public void delete(Long id) {
        Specialty specialty = findById(id);
        if(specialty == null)
            return;
        if (repository.hasApplicants(id))
            throw new RuntimeException("У цієї спеціальності є абітурієнти");
        super.delete(id);
    }
}
