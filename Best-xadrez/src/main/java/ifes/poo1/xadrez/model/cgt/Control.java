package ifes.poo1.xadrez.model.cgt;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.jogador.Jogador;
import ifes.poo1.xadrez.model.cdp.jogo.Jogo;
import ifes.poo1.xadrez.model.cdp.tabuleiro.Tabuleiro;
import ifes.poo1.xadrez.view.cci.ControladorTelas;

//EAEAEEAAEAEEAOUGAUSGUOGAHSHUGAHUGWAHUGWHAUGWHPOG

public class Control {
	
	private ControladorTelas controladorTela = new ControladorTelas();
	private Jogo jogo;
	
	public void ImprimeTab(){ 
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (jogo.getTabuleiro().getCasas(j,i) == null) System.out.print("x");
				else System.out.print(jogo.getTabuleiro().getCasas(j,i)); 
			}
                        
			System.out.print("\n");
		}
	}
	
	private void controlarPeca(String comando){
		
		if (comando.length() > 4){ 
			System.out.println("Acima de 4 caracteres");
		}
		
		else{
			
			int posXin = Character.getNumericValue(comando.charAt(0));
			int posYin = Character.getNumericValue(comando.charAt(1));
			
			int posXfin = Character.getNumericValue(comando.charAt(2));
			int posYfin = Character.getNumericValue(comando.charAt(3));
			
			//tabuleiro.getCasas(posXin, posYin);
			
			if (jogo.getTabuleiro().getCasas(posXin, posYin).mover(posXin, posYin, posXfin, posYfin)){ 
				//pega a peça que está em posXin e posYin e verifica se ela pode mover para (posXfin,posYfin).
				jogo.getTabuleiro().moverPeca(posXin, posYin, posXfin, posYfin);
			}
			
			else System.out.println("Não foi possível movimentar");
		}
		
	}
	
	public void controlarMenuInicial()
	{
		int opcao = controladorTela.controlarMenuInicial();
		switch(opcao)
		{
		case 1:
			String nomeJogadores[] = new String[2];
			nomeJogadores = controladorTela.controlarNovoJogo();
			iniciarJogo(nomeJogadores);
			break;
		case 2:
			controladorTela.controlarDadosPartidas();
			controlarMenuInicial();
			break;
		default:
			controladorTela.controlarSair();
		}
	}
	
	private void iniciarJogo(String[] nomeJogadores)
	{	
		
		Jogador branco = new Jogador(nomeJogadores[0], Cores.branco);
		Jogador preto = new Jogador(nomeJogadores[1], Cores.preto);
                
		Tabuleiro tabuleiro = new Tabuleiro();
		
		jogo = new Jogo(tabuleiro, branco, preto);
		
		controlarJogo();
	}
	
	
	private void controlarJogo()
	{	
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		
		String comando = controladorTela.pegarComandoUsuario(jogo.getVez());
		controlarPeca(comando);
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		mudarVezJogador(jogo);
		
		comando = controladorTela.pegarComandoUsuario(jogo.getVez());
		controlarPeca(comando);
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		mudarVezJogador(jogo);
		
		comando = controladorTela.pegarComandoUsuario(jogo.getVez());
		controlarPeca(comando);
		controladorTela.mostrarTabuleiro(jogo.getTabuleiro());
		mudarVezJogador(jogo);
	}	
	
	private void mudarVezJogador(Jogo jogo)
	{
		if(jogo.getVez().equals(jogo.getBranco()))
			jogo.setVez(jogo.getPreto());
		else
			jogo.setVez(jogo.getBranco());
	}
}
