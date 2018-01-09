package com.alves.lista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alves.lista.model.Convidado;
import com.alves.lista.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@RequestMapping("/")
	public String Index() {
		
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaconvidados(Model model) {
		
		model.addAttribute("convidados", convidadoService.findAll());
		
		return "listaconvidados";
	}
	
	@PostMapping
	@RequestMapping("/salvar")
	public String salvarConvidado(@RequestParam("nome") String nome, 
			@RequestParam("email") String email, 
			@RequestParam("telefone") String telefone, Model model) {
		
		Convidado convidado = new Convidado(nome, email, telefone);
		convidadoService.salvar(convidado);
		
		model.addAttribute("convidados", convidadoService.findAll());
		
		return "listaconvidados";
	}
}
