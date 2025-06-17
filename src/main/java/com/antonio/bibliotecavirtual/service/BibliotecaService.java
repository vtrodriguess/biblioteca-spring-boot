package com.antonio.bibliotecavirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonio.bibliotecavirtual.model.Biblioteca;
import com.antonio.bibliotecavirtual.repository.BibliotecaRepository;


@Service
public class BibliotecaService {
	
	@Autowired
	private final BibliotecaRepository bibliotecaRepository;
	
	public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}
	
	public List<Biblioteca> listarLivros(){
		return bibliotecaRepository.findAll();
	}
	
	public void adicionar (Biblioteca biblioteca) {
		bibliotecaRepository.save(biblioteca);
	}
	
	public void alugar(Long id) {
		Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
		biblioteca.setDisponivel(0);
		bibliotecaRepository.save(biblioteca);
	}
	
	public void devolver(Long id) {
		Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
		biblioteca.setDisponivel(1);
		bibliotecaRepository.save(biblioteca);
	}
	
	public void deletarLivro(Long id) {
		bibliotecaRepository.deleteById(id);
	}

}
