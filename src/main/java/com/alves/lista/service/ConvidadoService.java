package com.alves.lista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alves.lista.model.Convidado;
import com.alves.lista.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	@Autowired EmailService emailService;
	
	public List<Convidado> findAll() {
		
		return convidadoRepository.findAll();
	}

	public void salvar(Convidado convidado) {
		
		if(!convidado.getNome().isEmpty() && !convidado.getEmail().isEmpty()) {
		
			System.out.println(convidado.getNome());
		
			convidadoRepository.save(convidado);
			emailService.enviarEmail(convidado);
		}
	}
	
}
