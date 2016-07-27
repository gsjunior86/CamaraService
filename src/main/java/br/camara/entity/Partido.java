package br.camara.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="partido")
public class Partido {
	
	
	@Id
	@Column(name="id_partido")
	private String idPartido;
	
	@Column(name="sigla_partido")
	private String siglaPartido;
	
	@Column(name="nome_partido")
	private String nomeDoPartido;
	
	@Column(name="data_criacao")
	private String dataCriacao;
	
	@Column(name="data_extincao")
	private String dataExtincao;
	
	public String getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataExtincao() {
		return dataExtincao;
	}

	public void setDataExtincao(String dataExtincao) {
		this.dataExtincao = dataExtincao;
	}
	
	
	

}
