package br.com.alterdata.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alterdata.models.Contracheque;

@Repository
public interface ContrachequeRepository extends JpaRepository<Contracheque, Integer> {
	
	@Query(value="SELECT * FROM contracheque where id = :id", nativeQuery = true)
	Contracheque getWithId(Integer id);
	
	@Query(value="SELECT * FROM contracheque where id_funcionario = :idFuncionario", nativeQuery = true)
	List<Contracheque> getWithFuncionario(Integer idFuncionario);
	
	@Query(value="SELECT * FROM contracheque where id_funcionario = :idFuncionario AND ano = :ano",
			nativeQuery = true)
	List<Contracheque> getWithFuncionarioData(Integer idFuncionario, String ano);
	
	@Query(value="SELECT ano FROM contracheque WHERE id_funcionario = :idFuncionario", nativeQuery = true)
	Set<String> getAnosByFuncionario(Integer idFuncionario);
	
}
