package com.knoldus.employeemanagementsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "designation")
public class Designation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Designation name can't be empty")
    @Size(min = 2, message = "Designation name should have at least 2 characters")
    private String designationName;

    @NotEmpty(message = "experience can't be empty")
    //@Size(min = 2, message = "Department name should have at least 2 characters")
    private int experience;

    @NotEmpty(message = "Salary can't be empty")
    //@Size(min = 2, message = "Department name should have at least 2 characters")
    private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
