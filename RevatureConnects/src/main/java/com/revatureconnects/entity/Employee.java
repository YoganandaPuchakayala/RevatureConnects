package com.revatureconnects.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    
    private String empName;
    
    private String empEmail;
    
    private String password;
    
    private String department;
    
    private String empDesignation;
    
    @Enumerated(EnumType.STRING)
    private Role role; 
    
    @OneToMany(mappedBy = "curriculumId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Curriculum> assignedCurriculums;


}
