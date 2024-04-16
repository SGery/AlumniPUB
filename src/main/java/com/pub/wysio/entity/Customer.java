package com.pub.wysio.entity;

import jakarta.persistence.*;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="NICKNAME")
    private String nickname;
    @Column(name="LIVERSTRENGTH")
    private double liverStrength;
    @Column(name="BICEPSIZE")
    private int bicepCize;

    // TODO: pubVisit & Fight entities
    /*
    private List<pubVisit> pubVisits;
    private List<Fight> fights;
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getLiverStrength() {
        return liverStrength;
    }

    public void setLiverStrength(double liverStrength) {
        this.liverStrength = liverStrength;
    }

    public int getBicepCize() {
        return bicepCize;
    }

    public void setBicepCize(int bicepCize) {
        this.bicepCize = bicepCize;
    }
}
