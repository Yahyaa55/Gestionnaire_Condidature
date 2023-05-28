package com.emsi.backend.controllers;


import ch.qos.logback.core.model.Model;
import com.emsi.backend.dto.PostulerRequest;
import com.emsi.backend.models.Annonce;
import com.emsi.backend.models.Condidat;
import com.emsi.backend.repositories.AnnonceRepository;
import com.emsi.backend.repositories.CondidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    public class CondidatController {
        @Autowired
        CondidatRepository condidatRepository;
        @Autowired
        AnnonceRepository annonceRepository;

        @PostMapping("/Condidat")
        public Condidat addCondidat(@RequestBody Condidat condidat){
            condidatRepository.save(condidat);
            return condidat;

        }

        @GetMapping("/Condidat/{id}")
        public Optional<Condidat> getCondidatByEmail(@PathVariable Long id) throws Exception{
            Optional<Condidat> condidat ;
            condidat = this.condidatRepository.findById(id);
            return condidat;
        }

        @GetMapping("/Condidat")
        public List<Condidat> getAll(Model model) {
            return this.condidatRepository.findAll();
        }

        @PutMapping("/Condidat/Annonce/{id}")
        public Optional<Annonce> postulerAnnonce(@PathVariable Long id, @RequestBody PostulerRequest postulerRequest) {
            return this.annonceRepository.findById(id).map((x -> {
                x.getCondidats().add(condidatRepository.findById(postulerRequest.getIdCondidat()).orElseThrow());
                Condidat condidat = condidatRepository.findById(postulerRequest.getIdCondidat()).orElseThrow();
                int index = x.getCondidats().indexOf(condidat);
                x.getCondidats().get(index).getAnnonces().add(x);
                return this.annonceRepository.save(x);
            }));
        }

        @PutMapping("/Condidat/{id}")
        public Condidat updateCondidat(@PathVariable Long id, @RequestBody Condidat condidat) {
            return this.condidatRepository.findById(id).map(x -> {
                x.setNom(condidat.getNom());
                x.setPrenom(condidat.getPrenom());
                x.setTel(condidat.getTel());
                x.setEmail(condidat.getEmail());
                x.setMotDePasse(condidat.getMotDePasse());
                return this.condidatRepository.save(x);
            }).orElseGet(() -> this.condidatRepository.save(condidat));

        }

        @DeleteMapping("/Condidat/{id}")
        public void deleteCondidatById(@PathVariable Long id) throws Exception {
            this.condidatRepository.deleteById(id);
        }

        @DeleteMapping("/Condidat")
        public void deleteAllCondidat() {
            this.condidatRepository.deleteAll();
        }
}
