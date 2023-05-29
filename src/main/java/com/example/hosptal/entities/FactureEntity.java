package com.example.hosptal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num;
    private Date date;
    private int tva;


    @ManyToOne
    private ClientEntity client;
    @OneToMany(mappedBy = "facture")
    private List<LigneCommandeEntity> lignecommandes;
}
