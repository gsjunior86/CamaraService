package br.camara.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="deputado")
public class Deputado {
	
	@Id
	@Column(name="idCadastro")
	private int idCadastro;
	
	@Column(name="condicao")
	private String condicao;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nome_parlamentar")
	private String nomeParlamentar;
	
	@Column(name="url_foto")
	private String urlFoto;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="partido")
	private String partido;
	
	@Column(name="gabinete")
	private String gabinete;
	
	@Column(name="anexo")
	private String anexo;
	
	@Column(name="fone")
	private String fone;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="id.idCadastro")
	private List<DetalheDeputado> detalheDeputado;
		

	public List<DetalheDeputado> getDetalheDeputado() {
		return detalheDeputado;
	}

	public void setDetalheDeputado(List<DetalheDeputado> detalheDeputado) {
		this.detalheDeputado = detalheDeputado;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public int getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeParlamentar() {
		return nomeParlamentar;
	}

	public void setNomeParlamentar(String nomeParlamentar) {
		this.nomeParlamentar = nomeParlamentar;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getGabinete() {
		return gabinete;
	}

	public void setGabinete(String gabinete) {
		this.gabinete = gabinete;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
