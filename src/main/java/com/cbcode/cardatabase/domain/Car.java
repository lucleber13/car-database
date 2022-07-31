package com.cbcode.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Car")
@Table(name = "car")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "model", nullable = false, length = 50)
    private String model;
    @Column(name = "color", nullable = false, length = 30)
    private String color;
    @Column(name = "regNumber", nullable = false, length = 10)
    private String registerNumber;
    @Column(name = "chassisNumber", nullable = false, length = 30)
    private String chassisNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales")
//    @JoinTable(name = "car_sales",
//        joinColumns = @JoinColumn(name = "salesid"),
//        inverseJoinColumns = @JoinColumn(name = "id"))
    private Sales sales;

    public Car() {
    }


    public Car(String model, String color, String registerNumber, String chassisNumber, Sales sales) {
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.chassisNumber = chassisNumber;
        this.sales = sales;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }
}

