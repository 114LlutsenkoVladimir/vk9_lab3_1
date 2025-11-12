package com.example.lab3_vk9_1.service;

import com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto;
import com.example.lab3_vk9_1.entity.Applicant;
import com.example.lab3_vk9_1.repository.ApplicantRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ApplicantService extends AbstractCrudService<Applicant, Long, ApplicantRepository> {

    public List<ApplicantBySpecialtyDto> findAllApplicantSpecialties(Long applicantId) {
        return repository.findAllApplicantSpecialties(applicantId);
    }

    public List<ApplicantBySpecialtyDto> findAllBySpecialty(Long specialtyId) {
        return repository.findAllBySpecialty(specialtyId);
    }
}
