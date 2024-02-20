package com.mychellmotta.storebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String email;
    private String password;
    private String address;
    private String zipCode;
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
