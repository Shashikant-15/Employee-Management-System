package com.knoldus.learning.java.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 16)
    private String name;

    @Column(nullable = false, length = 16)
    private String departmentType;
    @Column(nullable = false, length = 16)
    private Long salary;
    @Column(nullable = false, length = 12)
    private String type;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_add_id")
//    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_id",referencedColumnName = "id")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_id",referencedColumnName = "id")
    private List<Contact> contact;

    public Employee() {
    }

    public Employee(int id, String name, String departmentType, Long salary, String type) {
        this.id = id;
        this.name = name;
        this.departmentType = departmentType;
        this.salary = salary;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentType='" + departmentType + '\'' +
                ", salary=" + salary +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
