package com.smd.workshopspringMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smd.workshopspringMVC.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

	public List<Titulo> findByDescricaoContaining(String descricao);
}
