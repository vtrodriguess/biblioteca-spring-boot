package com.antonio.bibliotecavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antonio.bibliotecavirtual.model.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

}
