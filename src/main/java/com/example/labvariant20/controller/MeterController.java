package com.example.labvariant20.controller;

import com.example.labvariant20.model.Meter;
import com.example.labvariant20.service.MeterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meters")
public class MeterController {
    private final MeterService service;

    public MeterController(MeterService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Meter>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Meter> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Meter> create(@RequestBody Meter meter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(meter));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Meter> update(@PathVariable Long id, @RequestBody Meter meter) {
        return ResponseEntity.ok(service.update(id, meter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
