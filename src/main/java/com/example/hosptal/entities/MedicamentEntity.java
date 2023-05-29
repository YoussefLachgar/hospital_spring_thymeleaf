package com.example.hosptal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "medicament")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy = "medicament")
    private List<LigneCommandeEntity> ligneCommandes;
}
