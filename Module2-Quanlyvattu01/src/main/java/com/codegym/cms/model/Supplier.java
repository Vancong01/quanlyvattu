package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id   ;

    private String name;
    private String description;
    private String address;



    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @OneToMany(targetEntity = Material.class)
    private List<Material> materials;

    public Supplier(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Supplier() {
    }

//    @Override
//    public String toString() {
//        return String.format("Supplier[id=%d, name='%s', description='%s', address='%s']", id, name,description,address);
//    }
    public Long getId() {

        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
    public List<Material> getMaterials() {

        return materials;
    }
}
