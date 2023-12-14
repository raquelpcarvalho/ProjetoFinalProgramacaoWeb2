package com.ada.ProjetoFinalProgramacaoWeb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;


    @ManyToOne
    private TypeProduct type;

//    @Column(name = "description", nullable = false)
//    private String description;


//    @Column(name = "barcode", nullable = false)
//    private String barcode;
}
