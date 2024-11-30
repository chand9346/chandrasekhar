package com.example.home.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="property_name")
    private String propertyName;

    @Column(name="property_type")
    private String propertyType; // "buy", "sell", or "rent"

    @Column(name="beds_count")
    private int bedsCount;

    @Column(name="baths_count")
    private int bathsCount;

    @Column(name="sqrfeet_range")
    private String sqrfeetRange;

    @Column(name="imgage_url")
    private String image_url;

    @Column(name="price")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public int getBathsCount() {
        return bathsCount;
    }

    public void setBathsCount(int bathsCount) {
        this.bathsCount = bathsCount;
    }

    public String getSqrfeetRange() {
        return sqrfeetRange;
    }

    public void setSqrfeetRange(String sqrfeetRange) {
        this.sqrfeetRange = sqrfeetRange;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Property(){

    }
    public Property(Long id, String propertyName, String propertyType, int bedsCount, int bathsCount,
            String sqrfeetRange, String image_url, double price) {
        this.id = id;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.bedsCount = bedsCount;
        this.bathsCount = bathsCount;
        this.sqrfeetRange = sqrfeetRange;
        this.image_url = image_url;
        this.price = price;
    }

   
    






}
