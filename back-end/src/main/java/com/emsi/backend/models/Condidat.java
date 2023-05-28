package com.emsi.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Condidat extends User{
    private String nom;
    private String prenom;
    private String tel;
    public static String owner;
    @ManyToMany
    @JoinTable(
            name = "candidat_annonce",
            joinColumns = @JoinColumn(name = "idCondidat"),
            inverseJoinColumns = @JoinColumn(name = "idAnnonce")
    )
    private List<Annonce> annonces;


    static {
        owner = "This project is Made By Hanin & Fayek";
    }


}
