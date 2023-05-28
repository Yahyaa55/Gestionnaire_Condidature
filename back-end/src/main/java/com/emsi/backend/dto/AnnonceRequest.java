package com.emsi.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceRequest {
    private String description;
    private Date dateAnnonce;
    private Long idEntreprise;
}
