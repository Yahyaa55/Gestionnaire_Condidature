package com.emsi.backend.repositories;

import com.emsi.backend.models.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondidatRepository extends JpaRepository<Condidat, Long> {
    Optional<Condidat> findById(Long id);
}
