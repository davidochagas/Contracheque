package br.com.alterdata.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.models.Contracheque;
import br.com.alterdata.services.ContrachequeService;

@RestController
@RequestMapping({ "/contracheque" })
public class ContrachequeController {
	
	@Autowired
	ContrachequeService contrachequeService;
	
	@GetMapping(path="/{idContracheque}", produces= {MediaType.APPLICATION_OCTET_STREAM_VALUE})
	public ResponseEntity<Resource> recuperarContrachequePorId(@PathVariable Integer idContracheque) throws IOException{
		Contracheque contracheque = contrachequeService.getById(idContracheque);
		 String nomeArquivo = String.format("%s_%s_%s.pdf", 
				contracheque.getFuncionario().getMatricula(), 
				contracheque.getAno(),
				contracheque.getMes());
		
		Resource resource = new InputStreamResource(new ByteArrayInputStream(contracheque.getImagemContracheque()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-disposition", "attachment; filename=" + nomeArquivo);
		
		return ResponseEntity.ok().headers(responseHeaders).body(resource);
	}
	
	@GetMapping(path="/funcionario/{idFuncionario}")
	public ResponseEntity<List<Contracheque>> getByFuncinario(@PathVariable Integer idFuncionario){
		return ResponseEntity.ok(contrachequeService.getByFuncionario(idFuncionario));
	}
	
	@GetMapping(path="/funcionario/{idFuncionario}/ano/{ano}")
	public ResponseEntity <List<Contracheque>> getByFuncionarioData(@PathVariable Integer idFuncionario, @PathVariable String ano){
		return ResponseEntity.ok(contrachequeService.getByFuncionarioData(idFuncionario, ano));
	}
	
	@GetMapping(path="/anos/{idFuncionario}")
	public ResponseEntity <Set<String>> getAnosByFuncionario(@PathVariable Integer idFuncionario){
		return ResponseEntity.ok(contrachequeService.getAnosByFuncionario(idFuncionario));
	}
}
