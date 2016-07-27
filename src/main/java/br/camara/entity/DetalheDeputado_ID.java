package br.camara.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalheDeputado_ID implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 975435083931433454L;

	@Column(name="id_cadastro")
	private int idCadastro;
	
	@Column(name="num_legislatura")
	private int numLegislatura;

	public int getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}

	public int getNumLegislatura() {
		return numLegislatura;
	}

	public void setNumLegislatura(int numLegislatura) {
		this.numLegislatura = numLegislatura;
	}
	
	
	

}
