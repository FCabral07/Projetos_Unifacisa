package br.com.ouvidoriaAbella;

import javax.swing.JOptionPane;

public class AppOuvidoria {

	public static void main(String[] args) {

		Ouvidoria ouvidoriaAbella = new Ouvidoria("Ouvidoria Abella", "Felipe");
		
		int opcao = 7;
		
		// 1 Criar nova manifestacao, 2 Listar as manifestacoes, 3 Listar Manifestação Pelo Tipo, 4 Pesquisar por nome, 5 Excluir por ID, 6 Sair
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema de Ouvidoria do Professor Abella");
		
		while(opcao != 6) {
			
			String respostaString;
			respostaString = JOptionPane
					.showInputDialog("Digite a opção que deseja: "
								  + "\n1- Criar Manifestação" 
								  + "\n2- Listar Manifestações"
								  + "\n3- Listar Manifestações Pelo Tipo"
								  + "\n4- Listar Manifestações Pelo Nome"
								  + "\n5- Excluir Manifestação"
								  + "\n6- Sair");
			opcao = Integer.parseInt(respostaString);
			
			if(opcao == 1) {
				String tipoManifestacaoStr = JOptionPane.showInputDialog("Qual o tipo da manifestação?"
						+ "\nE- Elogio"
						+ "\nR- Reclamação"
						+ "\nS- Sugestão");
				
				String titulo = JOptionPane.showInputDialog("Digite o título: ");
				String descricao = JOptionPane.showInputDialog("Digite a descrição: ");
				String solicitante = JOptionPane.showInputDialog("Digite o seu nome: ");
				
				TipoManifestacao tipoManifestacao;
				
				if(tipoManifestacaoStr.equalsIgnoreCase("E")) {
					tipoManifestacao = TipoManifestacao.ELOGIO;
				} else if(tipoManifestacaoStr.equalsIgnoreCase("R")) {
					tipoManifestacao = TipoManifestacao.RECLAMACAO;
				} else if(tipoManifestacaoStr.equalsIgnoreCase("S")) {
					tipoManifestacao = TipoManifestacao.SUGESTAO;
				}else {
					JOptionPane.showMessageDialog(null, "Você inseriu um tipo inválido, por padrão ele será um elogio.");
					tipoManifestacao = TipoManifestacao.ELOGIO;
				}
				
				Manifestacao novaContaInserida = new Manifestacao(titulo, descricao, solicitante, tipoManifestacao);
				ouvidoriaAbella.adicionarManifestacaoParaOuvidoria(novaContaInserida);
				

				JOptionPane.showMessageDialog(null, "Nova manifestação criada com sucesso!");
			} else if(opcao == 2) {
				ouvidoriaAbella.listarManifestacoes();
			}else if(opcao == 3) {
				String tipoRequerido = JOptionPane.showInputDialog("Qual o tipo da manifestação deseja procurar?"
						+ "\nE- Elogio"
						+ "\nR- Reclamação"
						+ "\nS- Sugestão");
				
				if(tipoRequerido.equalsIgnoreCase("R")) {
					ouvidoriaAbella.listarReclamacao();
				}else if(tipoRequerido.equalsIgnoreCase("E")) {
					ouvidoriaAbella.listarElogio();
				}else if(tipoRequerido.equalsIgnoreCase("S")) {
					ouvidoriaAbella.listarSugestao();
				}else {
					JOptionPane.showMessageDialog(null, "Tipo inválido, digite uma das três opções:"
														+ "\nE- Elogio"
														+ "\nR- Reclamação"
														+ "\nS- Sugestão");
				}
			}else if(opcao == 4) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				ouvidoriaAbella.listarPorNome(nome);
			}else if(opcao == 5) {
				String respostaOpcao = JOptionPane.showInputDialog("Digite o ID da manifestação a "
						+ "ser excluída: ");
				int intRespostaOpcao = Integer.parseInt(respostaOpcao);
				ouvidoriaAbella.excluirManifestacao(intRespostaOpcao);
			}else if(opcao > 6 || opcao < 1) {
				JOptionPane.showMessageDialog(null, "Digite uma opcão válida.");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Obrigado por usar o Sistema de Ouvidoria do Professor Abella!");
		
	}
	

}
