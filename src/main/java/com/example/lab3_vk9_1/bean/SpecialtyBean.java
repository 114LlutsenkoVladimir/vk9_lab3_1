package com.example.lab3_vk9_1.bean;

import com.example.lab3_vk9_1.entity.Applicant;
import com.example.lab3_vk9_1.entity.Specialty;
import com.example.lab3_vk9_1.service.SpecialtyService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("specialtyBean")
@RequestScoped
public class SpecialtyBean {
    @Inject
    private SpecialtyService specialtyService;

    private Specialty form = new Specialty();

    private List<Specialty> dataTableList;

    private Long selectedSpecialtyId;

    private String errorMessage = "";

    public SpecialtyBean() {
    }

    @PostConstruct
    public void init() {
        updateDataTable();
    }

    public Specialty getForm() {
        return form;
    }

    public List<Specialty> getDataTableList() {
        return dataTableList;
    }

    public SpecialtyService getSpecialtyService() {
        return specialtyService;
    }

    public Long getSelectedSpecialtyId() {
        return selectedSpecialtyId;
    }

    public void setSelectedSpecialtyId(Long selectedSpecialtyId) {
        this.selectedSpecialtyId = selectedSpecialtyId;
    }

    public void createSpecialty() {
        specialtyService.create(form);
        dataTableList = new ArrayList<>(List.of(specialtyService.findById(form.getId())));
        form = new Specialty();
    }

    public void findSpecialtyById() {
        dataTableList = new ArrayList<>(List.of(specialtyService.findById(selectedSpecialtyId)));
        selectedSpecialtyId = null;
    }

    public void updateSpecialty() {
        Specialty dbSpecialty = specialtyService.findById(selectedSpecialtyId);
        dbSpecialty.copy(form);
        specialtyService.update(dbSpecialty);
        dataTableList = new ArrayList<>(List.of(specialtyService.findById(selectedSpecialtyId)));
        selectedSpecialtyId = null;
        form = new Specialty();
    }

    public void updateDataTable() {
        dataTableList = specialtyService.findAll();
        selectedSpecialtyId = null;
    }

    public void deleteSpecialty() {
        try {
            specialtyService.delete(selectedSpecialtyId);
        } catch (RuntimeException e) {
            errorMessage = e.getMessage();
        }
        updateDataTable();
        selectedSpecialtyId = null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
