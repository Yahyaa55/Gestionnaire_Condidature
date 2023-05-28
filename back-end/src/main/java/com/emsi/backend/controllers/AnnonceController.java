package com.emsi.backend.controllers;


import ch.qos.logback.core.model.Model;
import com.emsi.backend.dto.AnnonceRequest;
import com.emsi.backend.models.Annonce;
import com.emsi.backend.models.Condidat;
import com.emsi.backend.repositories.AnnonceRepository;
import com.emsi.backend.repositories.CondidatRepository;
import com.emsi.backend.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AnnonceController {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    EntrepriseRepository entrepriseRepository;
    @Autowired
    CondidatRepository condidatRepository;

    @PostMapping("/Annonce")
    public Annonce addAnnonce(@RequestBody AnnonceRequest annonceRequest){
        var annonce = new Annonce();
        annonce.setDescription(annonceRequest.getDescription());
        annonce.setDateAnnonce(annonceRequest.getDateAnnonce());
        annonce.setEntreprise(entrepriseRepository.findById(annonceRequest.getIdEntreprise()).orElseThrow());
        annonceRepository.save(annonce);
        return annonce;
    }

    @GetMapping("/Annonce/{id}")
    public Optional<Annonce> getAnnonceByEmail(@PathVariable Long id) throws Exception{
        Optional<Annonce> annonce ;
        annonce = this.annonceRepository.findById(id);
        return annonce;
    }

    @GetMapping("/Annonce")
    public List<Annonce> getAll(Model model) {
        return this.annonceRepository.findAll();
    }

    @PutMapping("/Annonce/{id}")
    public Annonce updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonce) {
        return this.annonceRepository.findById(id).map(x -> {
            x.setDescription(annonce.getDescription());
            x.setDateAnnonce(annonce.getDateAnnonce());
            return this.annonceRepository.save(x);
        }).orElseGet(() -> this.annonceRepository.save(annonce));

    }

    @DeleteMapping("/Annonce/{id}")
    public void deleteAnnonceById(@PathVariable Long id) throws Exception {
        this.annonceRepository.deleteById(id);
    }

    @DeleteMapping("/Annonce")
    public void deleteAllAnnonce() {
        this.annonceRepository.deleteAll();
    }
}
