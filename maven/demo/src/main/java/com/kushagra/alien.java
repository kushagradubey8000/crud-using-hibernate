package com.kushagra;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
//@Table(name = "alien_data")//to change the table name in database.default table name will be the class name.
public class alien {
    @Id
    private int id;
    //@Column(name = "alien_name")// to change column name.
    private String name;
    //@Column(name = "alien_tech")// to change column name.

    //@Transient//to not save this data in database. now there will be no tech column there.
    private String tech;
    //@OneToOne//one alien can have only one laptop, but one laptop can have only one alien.
    @OneToMany (mappedBy = "alien")//one alien can have many laptops, but one laptop can have only one alien.
    //@JoinColumn(name = "alien_id")//to specify the foreign key column name in the laptop table.
    private List<Laptop> laptops;//reference variable of Laptop class.//when you make more than one laptop object and want to save them in database, then you need to use List or Set or Map.

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public alien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "alien [id=" + id + ", name=" + name + ", tech=" + tech + ", laptop="+laptops+ "]";
    }

    

    
}
