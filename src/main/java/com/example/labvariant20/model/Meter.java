package com.example.labvariant20.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meters")
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "premise_id")
    private Premise premise;

    private String resourceType;
    private String serialNumber;
    private Double tariffPerUnit;
    private String status;

    @OneToMany(mappedBy = "meter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeterReading> readings = new ArrayList<>();

    public Meter() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Premise getPremise() { return premise; }
    public void setPremise(Premise premise) { this.premise = premise; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public Double getTariffPerUnit() { return tariffPerUnit; }
    public void setTariffPerUnit(Double tariffPerUnit) { this.tariffPerUnit = tariffPerUnit; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<MeterReading> getReadings() { return readings; }
    public void setReadings(List<MeterReading> readings) { this.readings = readings; }
}