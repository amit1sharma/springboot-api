package com.boot.api.model;

import com.boot.api.enums.Department;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255,nullable = true)
    private String name;

    @Column(length = 20)
    private Department dept;


    public Customer(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }
}
