package com.example.lab3_vk9_1.dto.applicant;

public record ApplicantBySpecialtyDto (
    Long applicantId,
    String firstName,
    String lastName,
    Long specialtyId,
    String specialtyName
) {}
