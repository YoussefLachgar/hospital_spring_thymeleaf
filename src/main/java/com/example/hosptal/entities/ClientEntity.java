package com.example.hosptal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String raisonsociale;
    private String mail;

    @OneToMany(mappedBy = "client")
    private List<FactureEntity> factures;
    @OneToMany(mappedBy = "client")
    private List<MedicamentEntity> medicaments;
}
