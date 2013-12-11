package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;

public class Bispo extends PecaAbstrata{
	
	public Bispo(Cores cor) {
		super(cor, NomePecas.bispo, 3);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean mover(Posicao posicaoFinal) {

		
		for (int aux = 0; aux < 8; aux++){
			if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()-aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()-aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()-aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()-aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;
		}
		
		return false;
		
	}

	@Override
	public boolean capturar(Posicao posicaoFinal ) {

		for (int aux = 0; aux < 8; aux++){
			if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()-aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()-aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()+aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()-aux == posicaoFinal.getLinha())) return true;
			if ((getPosicao().getColuna()-aux == posicaoFinal.getColuna()) && (getPosicao().getLinha()+aux == posicaoFinal.getLinha())) return true;
		}
		
		return false;
		
	}





}
