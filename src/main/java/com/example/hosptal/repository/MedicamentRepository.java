package com.example.hosptal.repository;

import com.example.hosptal.entities.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
}
