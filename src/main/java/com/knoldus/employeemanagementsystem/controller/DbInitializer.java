package com.knoldus.employeemanagementsystem.controller;

import com.knoldus.employeemanagementsystem.model.Designation;
import com.knoldus.employeemanagementsystem.repo.DesignationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {
    private final DesignationRepository designationRepository;

    public DbInitializer(DesignationRepository designationRepository){
        this.designationRepository = designationRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.designationRepository.deleteAll();

        Designation designation = new Designation(1L,"Intern",0,10000);
        Designation designation1 = new Designation(2L,"Software Consultant",2,40000);
        Designation designation2 = new Designation(3L,"Sr Software Consultant",5,80000);

        this.designationRepository.save(designation);
        this.designationRepository.save(designation1);
        this.designationRepository.save(designation2);

    }
}