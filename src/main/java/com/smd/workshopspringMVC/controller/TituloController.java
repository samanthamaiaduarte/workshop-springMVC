package com.smd.workshopspringMVC.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smd.workshopspringMVC.model.StatusTitulo;
import com.smd.workshopspringMVC.model.Titulo;
import com.smd.workshopspringMVC.model.TituloFilter;
import com.smd.workshopspringMVC.services.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private TituloService service;

	@RequestMapping
	public ModelAndView listar(@ModelAttribute("filtro") TituloFilter filtro) {
		//List<Titulo> titulos = service.listar();
		List<Titulo> titulos = service.listarPorDescricao(filtro);
		
		ModelAndView mv = new ModelAndView("ListaTitulos");
		mv.addObject("titulos", titulos);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edicao(@PathVariable("id") Titulo titulo) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(titulo);
		return mv;
	}
	
	@PostMapping
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return "CadastroTitulo";
		}
		
		service.salvar(titulo);
		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
		return "redirect:/titulos";
	}
	
	@DeleteMapping("/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.excluir(id);
		
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/titulos";		
	}
	
	@PutMapping("/{id}/receber")
	public @ResponseBody String receber(@PathVariable Long id) {
		return service.receber(id);
	}
	
	@ModelAttribute("todosStatus")
	public List<StatusTitulo> todosStatus() {
		return Arrays.asList(StatusTitulo.values());
	}
}
