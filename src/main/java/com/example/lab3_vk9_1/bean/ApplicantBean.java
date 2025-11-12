package com.example.lab3_vk9_1.bean;

import com.example.lab3_vk9_1.dto.applicant.ApplicantBySpecialtyDto;
import com.example.lab3_vk9_1.entity.Applicant;
import com.example.lab3_vk9_1.entity.Specialty;
import com.example.lab3_vk9_1.service.ApplicantService;
import com.example.lab3_vk9_1.service.SpecialtyService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("applicantBean")
@RequestScoped
public class ApplicantBean implements Serializable {
    @Inject
    private ApplicantService applicantService;

    @Inject
    private SpecialtyService specialtyService;

    @Inject
    public ApplicantBean(ApplicantService applicantService,
                         SpecialtyService specialtyService) {
        this.applicantService = applicantService;
        this.specialtyService = specialtyService;
    }

    public ApplicantBean() {
    }

    private List<ApplicantBySpecialtyDto> dataTableList = new ArrayList<>();

    private Applicant form = new Applicant();

    private Long selectedApplicantId;

    private Long selectedSpecialtyId;

    public Applicant getForm() {
        return form;
    }


    public Long getSelectedSpecialtyId() {
        return selectedSpecialtyId;
    }

    public Long getSelectedApplicantId() {
        return selectedApplicantId;
    }

    public List<ApplicantBySpecialtyDto> getDataTableList() {
        return dataTableList;
    }

    public void createApplicant() {
        applicantService.create(form);
        dataTableList = applicantService.findAllApplicantSpecialties(form.getId());
        form = new Applicant();
    }

    public void findApplicantById() {
        dataTableList = applicantService.findAllApplicantSpecialties(selectedApplicantId);
    }

    public void updateApplicant() {
        Applicant applicant = applicantService.findById(selectedApplicantId);
        applicant.copy(form);
        applicantService.update(applicant);
    }

    public void updateDataTableBySpecialtyId() {
        dataTableList = applicantService.findAllBySpecialty(selectedSpecialtyId);
    }

    public void deleteApplicant() {
        applicantService.delete(selectedApplicantId);
        updateDataTableBySpecialtyId();
    }

    public List<Specialty> getAllSpecialties() { return specialtyService.findAll(); }



}
