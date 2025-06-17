package com.antonio.bibliotecavirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antonio.bibliotecavirtual.dto.BibliotecaDTO;
import com.antonio.bibliotecavirtual.model.Biblioteca;
import com.antonio.bibliotecavirtual.repository.BibliotecaRepository;


@Service
public class BibliotecaService {

	private final BibliotecaRepository bibliotecaRepository;
	
	public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}
	
	public List<BibliotecaDTO> listarLivros(){
		return bibliotecaRepository.findAll().stream().map(x -> new BibliotecaDTO(x)).toList();
	}
	
	@Transactional
	public void adicionar(Biblioteca biblioteca) {
		bibliotecaRepository.save(biblioteca);
	}
	
	@Transactional
	public void alugar(Long id) {
		Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
		biblioteca.setDisponivel(0);
		bibliotecaRepository.save(biblioteca);
	}
	
	@Transactional
	public void devolver(Long id) {
		Biblioteca biblioteca = bibliotecaRepository.findById(id).get();
		biblioteca.setDisponivel(1);
		bibliotecaRepository.save(biblioteca);
	}
	
	@Transactional
	public void deletarLivro(Long id) {
		bibliotecaRepository.deleteById(id);
	}

}
