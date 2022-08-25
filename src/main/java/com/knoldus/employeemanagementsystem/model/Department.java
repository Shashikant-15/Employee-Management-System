package com.knoldus.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {

    @Id
    @SequenceGenerator(name = "dept_sequence",
            sequenceName = "dept_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "dept_sequence")
    @Column(name = "id", nullable = false)
    @NotEmpty(message = "id can't be empty")
    private Long id;

    @NotEmpty(message = "Department name can't be empty")
    @Size(min = 2, message = "Department name should have at least 2 characters")
    private String name;




}
