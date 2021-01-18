package br.com.alterdata.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;



@Entity
@Table(name="contracheque")
public class Contracheque implements Serializable {
	
	private static final long serialVersionUID = 2103677445935061431L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "ano")
	private String ano;
	
	@NotNull
	@Column(name = "mes")
	private String mes;
	
	@NotNull
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name = "imagem_contracheque")
	private byte[] imagemContracheque;
	
	
	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public byte[] getImagemContracheque() {
		return imagemContracheque;
	}


	public void setImagemContracheque(byte[] imagemContracheque) {
		this.imagemContracheque = imagemContracheque;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	
}
