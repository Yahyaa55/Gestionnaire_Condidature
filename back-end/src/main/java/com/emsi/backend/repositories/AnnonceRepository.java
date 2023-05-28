package com.emsi.backend.repositories;

import com.emsi.backend.models.Annonce;
import com.emsi.backend.models.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    Optional<Annonce> findById(Long id);
}
