package com.emsi.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entreprise extends User{
    private String nom;
    private String tel;
    private String location;
@JsonIgnore
    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
    private List<Annonce> annonces = new ArrayList<>();


}
