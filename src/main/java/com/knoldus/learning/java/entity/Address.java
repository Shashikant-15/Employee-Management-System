package com.knoldus.learning.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 5)
    private Integer houseNumber;

    @Column(nullable = false, length = 50)
    private String Landmark;

    @Column(nullable = false, length = 8)
    private String pinCode;


     @ManyToOne
     @JoinColumn(name = "employee_id")
     private Employee employee;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseNumber=" + houseNumber +
                ", Landmark='" + Landmark + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", employee=" + employee +
                '}';
    }
}
