package com.cbcode.cardatabase.domain;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Sales")
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salesid;
    @Column(name = "salesName", nullable = false, length = 20)
    private String firstname;
    @Column(name = "salesLastname", nullable = false, length = 30)
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sales")
    private List<Car> cars;

    public Sales() {
    }

    public Sales( String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;


    }

    public long getSalesid() {
        return salesid;
    }

    public void setSalesid(long salesid) {
        this.salesid = salesid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
