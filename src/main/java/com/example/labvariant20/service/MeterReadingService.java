package com.example.labvariant20.service;

import com.example.labvariant20.model.MeterReading;
import com.example.labvariant20.repository.MeterReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeterReadingService {
    private final MeterReadingRepository readingRepository;

    public MeterReadingService(MeterReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public List<MeterReading> getAll() { return readingRepository.findAll(); }
    public Optional<MeterReading> getById(Long id) { return readingRepository.findById(id); }
    public MeterReading create(MeterReading reading) { return readingRepository.save(reading); }

    public MeterReading update(Long id, MeterReading updated) {
        return readingRepository.findById(id).map(reading -> {
            reading.setMeter(updated.getMeter());
            reading.setPeriod(updated.getPeriod());
            reading.setValue(updated.getValue());
            reading.setVerificationStatus(updated.getVerificationStatus());
            return readingRepository.save(reading);
        }).orElseThrow(() -> new RuntimeException("MeterReading not found"));
    }

    public void delete(Long id) { readingRepository.deleteById(id); }
}