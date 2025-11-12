package com.example.lab3_vk9_1.repository;

import com.example.lab3_vk9_1.entity.Subject;

public class SubjectRepository extends GenericRepository<Subject, Long>{
    protected SubjectRepository() {
        super(Subject.class);
    }
}
