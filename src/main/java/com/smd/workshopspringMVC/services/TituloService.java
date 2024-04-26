package com.smd.workshopspringMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.workshopspringMVC.model.StatusTitulo;
import com.smd.workshopspringMVC.model.Titulo;
import com.smd.workshopspringMVC.model.TituloFilter;
import com.smd.workshopspringMVC.repository.TituloRepository;

@Service
public class TituloService {

	@Autowired
	private TituloRepository repository;
	
	public List<Titulo> listar() {
		return repository.findAll();
	}
	
	public List<Titulo> listarPorDescricao(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "" : filtro.getDescricao();
		return repository.findByDescricaoContaining(descricao);
	}
	
	public Titulo salvar(Titulo titulo) {
		return repository.save(titulo);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	public String receber(Long id) {
		Titulo titulo = repository.findById(id).get();
		titulo.setStatus(StatusTitulo.RECEBIDO);
		repository.save(titulo);

		return titulo.getStatus().getDescricao();
	}
}
