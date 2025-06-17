package com.antonio.bibliotecavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antonio.bibliotecavirtual.model.Biblioteca;
import com.antonio.bibliotecavirtual.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

	private final BibliotecaRepository bibliotecaRepository;

	public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
		this.bibliotecaRepository = bibliotecaRepository;
	}

	public List<Biblioteca> listarLivros() {
		return bibliotecaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Biblioteca> findById(Long id) {
		return bibliotecaRepository.findById(id);

	}

	@Transactional
	public Optional<Biblioteca> adicionar(String titulo, String autor, String ano, int disponivel) {
		Biblioteca bibliotecaAdd = new Biblioteca();

		if (!(titulo == null || autor == null || ano == null)) {

			bibliotecaAdd.setAno(ano);
			bibliotecaAdd.setAutor(autor);
			bibliotecaAdd.setTitulo(titulo);
			bibliotecaAdd.setDisponivel(disponivel);
			
			return Optional.of(bibliotecaRepository.save(bibliotecaAdd));
		}

		return Optional.empty();
	}

	@Transactional
	public Optional<Biblioteca> alugar(Long id) {
		Optional<Biblioteca> bibliotecaAtt = bibliotecaRepository.findById(id);

		if (bibliotecaAtt.isPresent()) {
			Biblioteca biblioteca = bibliotecaAtt.get();
			biblioteca.setDisponivel(0);

			return Optional.of(bibliotecaRepository.save(biblioteca));
		}

		return Optional.empty();
	}

	@Transactional
	public Optional<Biblioteca> devolver(Long id) {
		Optional<Biblioteca> bibliotecaAtt = bibliotecaRepository.findById(id);

		if (bibliotecaAtt.isPresent()) {
			Biblioteca biblioteca = bibliotecaAtt.get();
			biblioteca.setDisponivel(1);

			return Optional.of(bibliotecaRepository.save(biblioteca));
		}

		return Optional.empty();
	}

	@Transactional
	public void deletarLivro(Long id) {
		bibliotecaRepository.deleteById(id);
	}

}
