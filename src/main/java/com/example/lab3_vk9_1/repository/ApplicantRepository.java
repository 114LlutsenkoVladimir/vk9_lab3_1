package com.example.lab3_vk9_1.repository;

import com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto;
import com.example.lab3_vk9_1.entity.Applicant;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ApplicantRepository extends GenericRepository<Applicant, Long> {
    protected ApplicantRepository() {
        super(Applicant.class);
    }

    public List<ApplicantBySpecialtyDto> findAllBySpecialty(Long specialtyId) {
        return em.createQuery("""
        SELECT new com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto(
            a.id, a.firstName, a.lastName, s.id, s.name
        )
        FROM SpecialtyForApplicant sfa
        JOIN sfa.applicant a
        JOIN sfa.specialty s
        WHERE s.id = :specialtyId
        """, ApplicantBySpecialtyDto.class)
                .setParameter("specialtyId", specialtyId)
                .getResultList();
    }

    public List<ApplicantBySpecialtyDto> findAllApplicantSpecialties(Long applicantId) {
        return em.createQuery("""
        SELECT new com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto(
            a.id, a.firstName, a.lastName, s.id, s.name
        )
        FROM SpecialtyForApplicant sfa
        JOIN sfa.applicant a
        JOIN sfa.specialty s
        WHERE a.id = :applicantId
        """, ApplicantBySpecialtyDto.class)
                .setParameter("applicantId", applicantId)
                .getResultList();
    }
}
