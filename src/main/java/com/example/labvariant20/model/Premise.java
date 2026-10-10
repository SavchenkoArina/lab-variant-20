package com.example.labvariant20.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "premises")
public class Premise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private Double area;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "premise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meter> meters = new ArrayList<>();

    @OneToMany(mappedBy = "premise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UtilityCharge> charges = new ArrayList<>();

    public Premise() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public List<Meter> getMeters() { return meters; }
    public void setMeters(List<Meter> meters) { this.meters = meters; }

    public List<UtilityCharge> getCharges() { return charges; }
    public void setCharges(List<UtilityCharge> charges) { this.charges = charges; }
}