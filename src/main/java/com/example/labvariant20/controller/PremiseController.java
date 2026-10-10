package com.example.labvariant20.controller;

import com.example.labvariant20.model.Premise;
import com.example.labvariant20.service.PremiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premises")
public class PremiseController {
    private final PremiseService service;

    public PremiseController(PremiseService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Premise>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Premise> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Premise> create(@RequestBody Premise premise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(premise));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Premise> update(@PathVariable Long id, @RequestBody Premise premise) {
        return ResponseEntity.ok(service.update(id, premise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}