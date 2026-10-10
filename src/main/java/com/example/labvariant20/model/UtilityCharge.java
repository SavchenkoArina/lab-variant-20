package com.example.labvariant20.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utility_charges")
public class UtilityCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "premise_id")
    private Premise premise;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private String period;
    private Double volume;
    private Double amount;
    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public UtilityCharge() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Premise getPremise() { return premise; }
    public void setPremise(Premise premise) { this.premise = premise; }

    public Meter getMeter() { return meter; }
    public void setMeter(Meter meter) { this.meter = meter; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}