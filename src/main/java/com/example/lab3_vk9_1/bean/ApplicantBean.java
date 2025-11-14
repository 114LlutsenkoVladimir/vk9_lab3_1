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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named("applicantBean")
@RequestScoped
public class ApplicantBean implements Serializable {
    @Inject
    private ApplicantService applicantService;

    @Inject
    private SpecialtyService specialtyService;


    public ApplicantBean() {
    }

    private List<ApplicantBySpecialtyDto> dataTableList = new ArrayList<>();

    private Applicant form = new Applicant();

    private Long selectedApplicantId;

    private Long selectedSpecialtyId = 1L;

    private List<Long> selectedSpecialtyIds = new ArrayList<>();

    public List<Long> getSelectedSpecialtyIds() {
        return selectedSpecialtyIds;
    }

    public void setSelectedSpecialtyIds(List<Long> selectedSpecialtyIds) {
        this.selectedSpecialtyIds = selectedSpecialtyIds;
    }

    public void setSelectedApplicantId(Long selectedApplicantId) {
        this.selectedApplicantId = selectedApplicantId;
    }

    public void setSelectedSpecialtyId(Long selectedSpecialtyId) {
        this.selectedSpecialtyId = selectedSpecialtyId;
    }

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
        applicantService.addSpecialtiesToApplicant(form, selectedSpecialtyIds);
        applicantService.create(form);
        dataTableList = applicantService.findAllApplicantSpecialties(form.getId());
        form = new Applicant();
    }

    public void findApplicantById() {
        dataTableList = applicantService.findAllApplicantSpecialties(selectedApplicantId);
        selectedApplicantId = null;
    }

    public void updateApplicant() {
        Applicant dbApplicant = applicantService.findById(selectedApplicantId);
        dbApplicant.copy(form);
        applicantService.update(dbApplicant);
        dataTableList = applicantService.findAllApplicantSpecialties(selectedApplicantId);
        selectedApplicantId = null;
        form = new Applicant();
    }

    public void updateDataTableBySpecialtyId() {
        dataTableList = applicantService.findAllBySpecialty(selectedSpecialtyId);
        selectedSpecialtyId = null;
    }

    public void deleteApplicant() {
        applicantService.delete(selectedApplicantId);
        updateDataTableBySpecialtyId();
        selectedApplicantId = null;
    }

    public List<Specialty> getAllSpecialties() { return specialtyService.findAll(); }



}
