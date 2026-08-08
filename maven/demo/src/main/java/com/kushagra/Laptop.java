package com.kushagra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private String model;

    @ManyToOne//one laptop can have only one alien, but one alien can have many laptops.manyto one never use mappedBy attribute, because it is used in one to many relationship.
    @JoinColumn(name = "alien_id")
    private alien alien;

    public alien getAlien() {
        return alien;
    }
    public void setAlien(alien alien) {
        this.alien = alien;
    }
    

    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", brand=" + brand + ", model=" + model + ", alien=" + alien + "]";
    }
   

    
}
