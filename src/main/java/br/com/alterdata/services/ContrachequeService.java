package br.com.alterdata.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alterdata.models.Contracheque;
import br.com.alterdata.repository.ContrachequeRepository;

@Service
public class ContrachequeService {
	
	@Autowired
	ContrachequeRepository contrachequeRepository;
	
	@Transactional
	public Contracheque getById(Integer idContracheque){
		return contrachequeRepository.getWithId(idContracheque);
	}
	
	@Transactional
	public List<Contracheque> getByFuncionario(Integer idFuncionario){
		return contrachequeRepository.getWithFuncionario(idFuncionario);
	}
	
	@Transactional
	public List<Contracheque> getByFuncionarioData(Integer idFuncionario, String ano){
		return contrachequeRepository.getWithFuncionarioData(idFuncionario, ano);
	}
	
	@Transactional
	public Set<String> getAnosByFuncionario(Integer idFuncionario){
		return contrachequeRepository.getAnosByFuncionario(idFuncionario);
	}
}
