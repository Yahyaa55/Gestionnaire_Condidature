package com.emsi.backend.controllers;


import ch.qos.logback.core.model.Model;
import com.emsi.backend.models.Entreprise;
import com.emsi.backend.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    public class EntrepriseController {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    @PostMapping("/Entreprise")
    public Entreprise addEntreprise(@RequestBody Entreprise entreprise){
        entrepriseRepository.save(entreprise);
        return entreprise;

    }

    @GetMapping("/Entreprise/{id}")
    public Optional<Entreprise> getEntrepriseByEmail(@PathVariable Long id) throws Exception{
         Optional<Entreprise> entreprise ;
         entreprise = this.entrepriseRepository.findById(id);
        return entreprise;
    }

    @GetMapping("/Entreprise")
    public List<Entreprise> getAll(Model model) {
        return this.entrepriseRepository.findAll();
    }

    @PutMapping("/Entreprise/{id}")
    public Entreprise updateUser(@PathVariable Long id, @RequestBody Entreprise entreprise) {
        return this.entrepriseRepository.findById(id).map(x -> {
            x.setNom(entreprise.getNom());
            x.setTel(entreprise.getTel());
            x.setLocation(entreprise.getLocation());
            x.setEmail(entreprise.getEmail());
            x.setMotDePasse(entreprise.getMotDePasse());
            return this.entrepriseRepository.save(x);
        }).orElseGet(() -> this.entrepriseRepository.save(entreprise));

    }

    @DeleteMapping("/Entreprise/{id}")
    public void deleteEntrepriseById(@PathVariable Long id) throws Exception {
        this.entrepriseRepository.deleteById(id);
    }

    @DeleteMapping("/Entreprise")
    public void deleteAllEntreprise() {
        this.entrepriseRepository.deleteAll();
    }

}
