package com.example.labvariant20.repository;

import com.example.labvariant20.model.UtilityCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityChargeRepository extends JpaRepository<UtilityCharge, Long> {
}