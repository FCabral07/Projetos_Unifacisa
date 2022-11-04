package br.com.ouvidoriaAbella;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ouvidoria {

	private String nomeInstituicao;
	private String nomeResponsavel;

	private ArrayList<Manifestacao> manifestacoes = new ArrayList<Manifestacao>();

	public Ouvidoria(String nomeInstituicao, String nomeResponsavel) {
		this.nomeInstituicao = nomeInstituicao;
		this.nomeResponsavel = nomeResponsavel;
	}

	public void listarManifestacoes() {

		// if(manifestacoes.size() > 0) {
		if (!manifestacoes.isEmpty()) {

			String listagem = "Listagem de Todas as Manifestações: \n\n";
			
			for (Manifestacao manifestacao : manifestacoes) {
				
				if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.RECLAMACAO)) {
					listagem += "Reclamação: \nID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
								manifestacao.getTitulo() + "\n\n";
				}else if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.SUGESTAO)) {
					listagem += "Sugestão: \nID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
							manifestacao.getTitulo() + "\n\n";
				}else if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.ELOGIO)) {
					listagem += "Elogio: \nID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
							manifestacao.getTitulo() + "\n\n";
				}
				
			}
			JOptionPane.showMessageDialog(null,listagem);
			
		} else {
			JOptionPane.showMessageDialog(null, "Sem manifestações a exibir. ");
		}
	}
	
	public void listarReclamacao() {
		
		if (!manifestacoes.isEmpty()) {

			String listagemReclacamao = "Listagem de Todas as Reclamacões: \n\n";
			
			for (Manifestacao manifestacao : manifestacoes) {
				
				if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.RECLAMACAO)) {
					
					listagemReclacamao += "ID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
							manifestacao.getTitulo() + "\n\n";
					}
				}
			
			JOptionPane.showMessageDialog(null,listagemReclacamao);
			
		} else {
			JOptionPane.showMessageDialog(null, "Sem manifestações a exibir. ");
		}
		
	}
	
	public void listarElogio() {
		
		if (!manifestacoes.isEmpty()) {

			String listagemElogio = "Listagem de Todos os Elogios: \n\n";
			
			for (Manifestacao manifestacao : manifestacoes) {
				
				if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.ELOGIO)) {
					
					listagemElogio += "ID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
							manifestacao.getTitulo() + "\n\n";
					}
				}
			
			JOptionPane.showMessageDialog(null,listagemElogio);
			
		} else {
			JOptionPane.showMessageDialog(null, "Sem manifestações a exibir. ");
		}
		
	}

	public void listarSugestao() {
		
		if (!manifestacoes.isEmpty()) {

			String listagemSugestao = "Listagem de Todas as Sugestões: \n\n";
			
			for (Manifestacao manifestacao : manifestacoes) {
				
				if(manifestacao.getTipoManifestacao().equals(TipoManifestacao.SUGESTAO)) {
					
					listagemSugestao += "ID: " + manifestacao.getId() + ", Requerente: " + manifestacao.getSolicitante() + ", Título: " + 
							manifestacao.getTitulo() + "\n\n";
					}
				}
			
			JOptionPane.showMessageDialog(null,listagemSugestao);
			
		} else {
			JOptionPane.showMessageDialog(null, "Sem manifestações a exibir. ");
		}
		
	}
	
	public void listarPorNome(String nome) {
		
		if (!manifestacoes.isEmpty()) {

			String listagemNome = "Listagem das Manifestações: \n\n";
			
			for (Manifestacao manifestacao : manifestacoes) {
				
				if(manifestacao.getSolicitante().equalsIgnoreCase(nome)) {
					
					listagemNome += "ID: " + manifestacao.getId() + ", Título: " + manifestacao.getTitulo() + ", Tipo: " + 
									manifestacao.getTipoManifestacao() + "\n\n";
					}
				}
			
			JOptionPane.showMessageDialog(null,listagemNome);
			
		} else {
			JOptionPane.showMessageDialog(null, "Sem manifestações a exibir. ");
		}
		
	}
	
	public void excluirManifestacao(Integer id) {
		
		for(int i = 0; i < manifestacoes.size(); i++) {
			Manifestacao procuraId = manifestacoes.get(i);
			
			if(procuraId.getId().equals(id)) {
				manifestacoes.remove(procuraId);
				break;
			}
		}
		// this.manifestacoes.remove(id-1);  --> Método antigo, removia pelo index, mas se o usuário tentava apagar o próximo pelo ID, dava errado
	}
	
	public void adicionarManifestacaoParaOuvidoria(Manifestacao novaManifestacao) {
		this.manifestacoes.add(novaManifestacao);
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

}
