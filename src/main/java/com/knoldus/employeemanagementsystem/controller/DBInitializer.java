package com.knoldus.employeemanagementsystem.controller;

import com.knoldus.employeemanagementsystem.model.Designation;
import com.knoldus.employeemanagementsystem.repo.DesignationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * here DbInitializer  used to describe DB for Designation entry...
 *
 * store the db value like designation id,name,experience & salary.
 */
@Component
public class DBInitializer implements CommandLineRunner {
    private final DesignationRepository designationRepository;

    public DBInitializer(DesignationRepository designationRepository){
        this.designationRepository = designationRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.designationRepository.deleteAll();

        Designation designation = new Designation(1L,"Intern",0,15000);
        Designation designation1 = new Designation(2L,"Software Consultant",2,40000);
        Designation designation2 = new Designation(3L,"Software Developer",5,80000);

        this.designationRepository.save(designation);
        this.designationRepository.save(designation1);
        this.designationRepository.save(designation2);

    }
}