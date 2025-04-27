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
	public List<Biblioteca> listarProdutos(){
		return bibliotecaService.listarLivros();
	}
	
	@PostMapping("/inserir")
	public void adicionar(@RequestBody Biblioteca biblioteca) {
		bibliotecaService.adicionar(biblioteca);
	}
	
	@PutMapping("/alugar")
	public void alugar(@RequestParam Long id) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setDisponivel(0);
		biblioteca.setId(id);
		
		bibliotecaService.alugar(biblioteca);
	}
	
	@PutMapping("/devolver")
	public void devolver(@RequestParam Long id) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setDisponivel(1);
		biblioteca.setId(id);
		
		bibliotecaService.devolver(biblioteca);
	}
	
	@DeleteMapping("/remover")
	public void deletarLivro(Long id) {
		bibliotecaService.deletarLivro(id);
	}

}
