package com.example.lab3_vk9_1.service;

import com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto;
import com.example.lab3_vk9_1.entity.Applicant;
import com.example.lab3_vk9_1.entity.Specialty;
import com.example.lab3_vk9_1.entity.SpecialtyForApplicant;
import com.example.lab3_vk9_1.repository.ApplicantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Transactional
public class ApplicantService extends AbstractCrudService<Applicant, Long, ApplicantRepository> {

    @Inject
    private SpecialtyService specialtyService;


    public List<ApplicantBySpecialtyDto> findAllApplicantSpecialties(Long applicantId) {
        return repository.findAllApplicantSpecialties(applicantId);
    }

    public List<ApplicantBySpecialtyDto> findAllBySpecialty(Long specialtyId) {
        return repository.findAllBySpecialty(specialtyId);
    }

    public void addSpecialtiesToApplicant(Applicant applicant, List<Long> specialtyIds) {
        Set<Specialty> specialties = new HashSet<>();
        for (Long i : specialtyIds) {
            specialties.add(specialtyService.findById(i));
        }
        for (Specialty s : specialties) {
            SpecialtyForApplicant sfa = new SpecialtyForApplicant();
            sfa.setApplicant(applicant);
            sfa.setSpecialty(s);
            applicant.addSpecialty(sfa);
        }
    }
}
