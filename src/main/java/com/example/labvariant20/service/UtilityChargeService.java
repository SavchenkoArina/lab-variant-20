package com.example.labvariant20.service;

import com.example.labvariant20.model.UtilityCharge;
import com.example.labvariant20.repository.UtilityChargeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilityChargeService {
    private final UtilityChargeRepository chargeRepository;

    public UtilityChargeService(UtilityChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    public List<UtilityCharge> getAll() {
        return chargeRepository.findAll();
    }

    public Optional<UtilityCharge> getById(Long id) {
        return chargeRepository.findById(id);
    }

    public UtilityCharge create(UtilityCharge charge) {
        if (charge.getMeter() != null && charge.getVolume() != null && charge.getMeter().getTariffPerUnit() != null) {
            double tariff = charge.getMeter().getTariffPerUnit();
            charge.setAmount(charge.getVolume() * tariff);
        }
        return chargeRepository.save(charge);
    }

    public UtilityCharge update(Long id, UtilityCharge updated) {
        return chargeRepository.findById(id).map(charge -> {
            charge.setPeriod(updated.getPeriod());
            charge.setVolume(updated.getVolume());
            charge.setStatus(updated.getStatus());
            if (charge.getMeter() != null && charge.getVolume() != null && charge.getMeter().getTariffPerUnit() != null) {
                charge.setAmount(charge.getVolume() * charge.getMeter().getTariffPerUnit());
            }
            return chargeRepository.save(charge);
        }).orElseThrow(() -> new RuntimeException("UtilityCharge not found with id " + id));
    }

    public void delete(Long id) {
        chargeRepository.deleteById(id);
    }
}