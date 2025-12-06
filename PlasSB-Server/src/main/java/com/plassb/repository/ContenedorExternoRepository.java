package com.plassb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plassb.model.ContenedorExterno;

@Repository
public interface ContenedorExternoRepository extends JpaRepository<ContenedorExterno, Long> {
    ContenedorExterno findByIdExterno(Long idExterno);
}