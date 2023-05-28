package com.emsi.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateAnnonce;


    @ManyToOne
    private Entreprise entreprise;
    @ManyToMany(mappedBy = "annonces", fetch = FetchType.LAZY)
    private List<Condidat> condidats;

}
