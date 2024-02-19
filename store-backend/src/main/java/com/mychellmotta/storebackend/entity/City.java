package com.mychellmotta.storebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "stateId")
    private State state;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
