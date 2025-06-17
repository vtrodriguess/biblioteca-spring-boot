package com.antonio.bibliotecavirtual.dto;

import com.antonio.bibliotecavirtual.model.Biblioteca;

public class BibliotecaDTO {

	private Long id;
	private String titulo;
	private String autor;
	private String ano;
	private int disponivel;
	
	public BibliotecaDTO() {
		
	}

	public BibliotecaDTO(Biblioteca biblioteca) {
		this.id = biblioteca.getId();
		this.titulo = biblioteca.getTitulo();
		this.autor = biblioteca.getAutor();
		this.ano = biblioteca.getAno();
		this.disponivel = biblioteca.getDisponivel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	
	

}
