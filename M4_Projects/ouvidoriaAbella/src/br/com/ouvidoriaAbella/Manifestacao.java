package br.com.ouvidoriaAbella;

import java.util.Objects;

public class Manifestacao {
	
	private static Integer sequence = 1;

	private String titulo;
	private Integer id = 100;
	private String descricao;
	private String solicitante;
	private TipoManifestacao tipoManifestacao; // (Reclamacao), (Elogio) e (Sugestao)

	public Manifestacao(String titulo, String descricao, String solicitante, TipoManifestacao tipo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.setId(sequence++);
		this.solicitante = solicitante;
		this.tipoManifestacao = tipo;
	}


	public Manifestacao(String titulo, String solicitante, TipoManifestacao tipo) {
		this.titulo = titulo;
		this.setId(sequence++);
		this.solicitante = solicitante;
		this.tipoManifestacao = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public TipoManifestacao getTipoManifestacao() {
		return tipoManifestacao;
	}

	public void setTipoManifestacao(TipoManifestacao tipoManifestacao) {
		this.tipoManifestacao = tipoManifestacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manifestacao other = (Manifestacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
