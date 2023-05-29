package com.example.hosptal.repository;

import com.example.hosptal.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<FactureEntity, Long> {
}
