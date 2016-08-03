package br.camara.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="detalhes_deputado")
@Table(name="detalhes_deputado")
public class DetalheDeputado {
	
	@EmbeddedId
	private DetalheDeputado_ID id;
	
	@Column(name="data_nascimento")
	private String dataNascimento;
	
	@Column(name="nome_profissao")
	private String nomeProfissao;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Partido partido;
	

	public DetalheDeputado_ID getId() {
		return id;
	}

	public void setId(DetalheDeputado_ID id) {
		this.id = id;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeProfissao() {
		return nomeProfissao;
	}

	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	
	
	

}
