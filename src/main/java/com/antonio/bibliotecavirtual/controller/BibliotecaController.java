package com.antonio.bibliotecavirtual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = { "/biblioteca" })
public class BibliotecaController {

	private final BibliotecaService bibliotecaService;

	public BibliotecaController(BibliotecaService bibliotecaService) {
		this.bibliotecaService = bibliotecaService;
	}

	@GetMapping("/livros")
	public ResponseEntity<List<BibliotecaDTO>> listarProdutos() {
		return ResponseEntity.ok(bibliotecaService.listarLivros().stream().map(x -> new BibliotecaDTO(x)).toList());
	}
	
	@GetMapping("/livros/{id}")
	public ResponseEntity<List<BibliotecaDTO>> findById(@PathVariable Long id) {
		return ResponseEntity.ok(bibliotecaService.findById(id).stream().map(x -> new BibliotecaDTO(x)).toList());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<BibliotecaDTO> adicionar(@RequestBody Biblioteca biblioteca) {
		Optional<Biblioteca> bibliotecaAdd = bibliotecaService.adicionar(biblioteca.getTitulo(), biblioteca.getAutor(),
				biblioteca.getAno(), 1);
		BibliotecaDTO dto = new BibliotecaDTO(bibliotecaAdd.get());
		if (bibliotecaAdd.isPresent()) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}/alugar")
	public ResponseEntity<BibliotecaDTO> alugar(@PathVariable Long id) {
		Optional<Biblioteca> biblioteca = bibliotecaService.findById(id);

		if (biblioteca.isPresent()) {
			bibliotecaService.alugar(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}/devolver")
	public ResponseEntity<BibliotecaDTO> devolver(@PathVariable Long id) {
		Optional<Biblioteca> biblioteca = bibliotecaService.findById(id);

		if (biblioteca.isPresent()) {
			bibliotecaService.devolver(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/remover")
	public void deletarLivro(@RequestParam Long id) {
		bibliotecaService.deletarLivro(id);
	}

}
