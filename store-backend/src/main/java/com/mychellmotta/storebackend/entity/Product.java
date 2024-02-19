package com.mychellmotta.storebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String longDescription;
    private String shortDescription;
    private Double costPrice;
    private Double salePrice;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
