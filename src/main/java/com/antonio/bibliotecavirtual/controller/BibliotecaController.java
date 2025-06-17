package com.antonio.bibliotecavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.bibliotecavirtual.dto.BibliotecaDTO;
import com.antonio.bibliotecavirtual.model.Biblioteca;
import com.antonio.bibliotecavirtual.service.BibliotecaService;

@RestController
@RequestMapping(value = {"/biblioteca", "/Biblioteca"})
public class BibliotecaController {
	
	@Autowired
	private final BibliotecaService bibliotecaService;


	public BibliotecaController(BibliotecaService bibliotecaService) {
		this.bibliotecaService = bibliotecaService;
	}
	
	@GetMapping("/livros")
	public List<BibliotecaDTO> listarProdutos(){
		return bibliotecaService.listarLivros();
	}
	
	@PostMapping("/cadastrar")
	public void adicionar(@RequestBody Biblioteca biblioteca) {
		bibliotecaService.adicionar(biblioteca);
	}
	
	@PutMapping("/alugar")
	public void alugar(@RequestParam Long id) {
		
		bibliotecaService.alugar(id);
	}
	
	@PutMapping("/devolver")
	public void devolver(@RequestParam Long id) {
		bibliotecaService.devolver(id);
	}
	
	@DeleteMapping("/remover")
	public void deletarLivro(Long id) {
		bibliotecaService.deletarLivro(id);
	}

}
