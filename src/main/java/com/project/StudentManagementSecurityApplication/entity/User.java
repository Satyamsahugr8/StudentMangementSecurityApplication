package com.project.StudentManagementSecurityApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false, unique = true, length = 45)
private String email;

@Column(nullable = false, length = 64)
private String password;

@Column(name = "first_name", nullable = false, length = 20)
private String firstName;

@Column(name = "last_name", nullable = false, length = 20)
private String lastName;

// getters and setters are not shown
}