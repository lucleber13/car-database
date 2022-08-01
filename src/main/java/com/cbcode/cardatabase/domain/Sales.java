package com.cbcode.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "Sales")
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "salesName", nullable = false, length = 20)
    private String firstname;
    @Column(name = "salesLastname", nullable = false, length = 30)
    private String lastname;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(
            name = "cars_sales",
            joinColumns = { @JoinColumn(name = "sales_id") },
            inverseJoinColumns = { @JoinColumn(name = "cars_id") })
    private Set<Car> cars = new HashSet<Car>();

    public Sales() {
    }

    public Sales( String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getid() {
        return id;
    }

    public void setid(long salesid) {
        this.id = id;
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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
