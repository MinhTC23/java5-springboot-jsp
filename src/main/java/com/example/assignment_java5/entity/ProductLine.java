package com.example.assignment_java5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "Product_Line")
public class ProductLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Code not null")
    @Column(name = "Code")
    private String code;

    @NotEmpty(message = "Name not null")
    @Column(name = "Name")
    private String name;

    @NotNull(message = "Import price not null")
    @Column(name = "Import_price")
    private Float importPrice;

    @NotNull(message = "Price not null")
    @Column(name = "Price")
    private Float price;

    @Column(name = "Date_Create")
    private LocalDate dateCreate;

    @Column(name = "Date_correct")
    private LocalDate dateCorrect;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Manufacturer")
    private Manufacturer manufacturer;
}
