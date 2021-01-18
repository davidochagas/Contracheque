package br.com.alterdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alterdata.models.Funcionario;
import br.com.alterdata.services.FuncionarioService;

@RestController
@RequestMapping({ "/funcionario" })
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        return ResponseEntity.ok(funcionarioService.getAll());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Funcionario> get(@PathVariable Integer id){
        return ResponseEntity.ok(funcionarioService.getById(id).get());
    }
}
