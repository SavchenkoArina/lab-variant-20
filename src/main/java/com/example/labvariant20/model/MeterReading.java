package com.example.labvariant20.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_readings")
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private String period;
    private Double value;
    private String verificationStatus;

    // Автоматически фиксируем время на стороне сервера
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public MeterReading() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Meter getMeter() { return meter; }
    public void setMeter(Meter meter) { this.meter = meter; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    public String getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(String verificationStatus) { this.verificationStatus = verificationStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}