package com.example.hosptal.repository;

import com.example.hosptal.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<ClientEntity,Integer>{
}



