package com.example.assignment_java5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Code not null")
    @Column(name = "Code")
    private String code;

    @NotEmpty(message = "Full Name not null")
    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "Gender")
    private Integer gender;

    @NotEmpty(message = "Phone Number not null")
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @NotEmpty(message = "Address not null")
    @Column(name = "Address")
    private String address;
}
