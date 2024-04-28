package com.pub.wysio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER")
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NICKNAME")
    private String nickname;
    @Column(name="LIVER_STRENGTH")
    private Double liverStrength;
    @Column(name="BICEP_SIZE")
    private Integer bicepSize;

    // TODO: pubVisit & Fight entities
    /*
    @Join-ok

    private List<pubVisit> pubVisits;
    private List<Fight> fights;
    */
}

