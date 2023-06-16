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

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Capacity")
public class Capacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Code not null")
    @Column(name = "Code")
    private String code;

    @NotEmpty(message = "Name not null")
    @Column(name = "Name")
    private String name;

    @Column(name = "Date_Create")
    private LocalDate dateCreate;

    @Column(name = "Date_correct")
    private LocalDate dateCorrect;

    @Column(name = "Status")
    private Integer status;
}
