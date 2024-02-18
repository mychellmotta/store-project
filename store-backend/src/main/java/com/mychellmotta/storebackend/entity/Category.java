package com.mychellmotta.storebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
