package com.example.labvariant20.controller;

import com.example.labvariant20.model.MeterReading;
import com.example.labvariant20.service.MeterReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meter-readings")
public class MeterReadingController {
    private final MeterReadingService service;

    public MeterReadingController(MeterReadingService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<MeterReading>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<MeterReading> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MeterReading> create(@RequestBody MeterReading reading) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(reading));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MeterReading> update(@PathVariable Long id, @RequestBody MeterReading reading) {
        return ResponseEntity.ok(service.update(id, reading));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}