package br.com.alterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alterdata.models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Query(value = "SELECT * FROM funcionario where matricula = :matricula", nativeQuery = true)
	Funcionario getWithMatricula(String matricula);
}
