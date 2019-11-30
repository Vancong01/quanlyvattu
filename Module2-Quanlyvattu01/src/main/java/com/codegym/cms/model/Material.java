package com.codegym.cms.model;

import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String code;

    private String name;

    private LocalDate importDate;
    private String description;
    private Long price;
    private Long quantity;
    private String images;

    //Liên kết 2 bảng với nhau
    @ManyToOne
    @JoinColumn(name ="supplier_id")
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Material(String code, String name, LocalDate importDate, String description, Long price, Long quantity, String images) {
        this.code = code;
        this.name = name;
        this.importDate = importDate;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.images = images;
    }

    public Material() {
    }

//    @Override
//    public String toString() {
//        return String.format("Material[id=%d,code='%s', name='%s',importDate='%t', description='%s',price='%d',quantity='%d', images='%s']", id, code,name,importDate,description,price,quantity,images);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
