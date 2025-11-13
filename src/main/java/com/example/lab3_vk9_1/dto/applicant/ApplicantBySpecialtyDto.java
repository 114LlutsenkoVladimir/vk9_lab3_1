package com.example.lab3_vk9_1.dto.applicant;

import java.time.LocalDate;

public record ApplicantBySpecialtyDto (
    Long applicantId,
    String firstName,
    String lastName,
    LocalDate birthDate,
    Double averageMark,
    Long specialtyId,
    String specialtyName
) {}
