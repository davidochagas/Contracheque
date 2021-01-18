package br.com.alterdata.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.models.Funcionario;
import br.com.alterdata.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Transactional
	public List<Funcionario> getAll(){
		return funcionarioRepository.findAll();
	}
	
	@Transactional
	public Optional<Funcionario> getById(Integer id){
		return funcionarioRepository.findById(id);
	}
	
	
}
