package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public class Cavalo extends Peca {
	
	public Cavalo(Cores cor) {
		super(cor, NomePecas.cavalo, 3);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return "C";
		
	}
	
	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		if ((colunaFinal>7) || (colunaFinal<0) || (linhaFinal<0) || (linhaFinal>7)) return false;
		
		if (((colunaFinal == colunaInicial+2)||(colunaFinal==colunaInicial-2)) && ((linhaFinal == linhaInicial+1)||(linhaFinal == linhaInicial-1))) return true;
		if ((((linhaFinal == linhaInicial +2) || (linhaFinal == linhaInicial-2))) && (((colunaFinal==colunaInicial+1) || (colunaFinal==colunaInicial-1)))) return true;
			
		
		return false;
		
	}

	@Override
	public boolean capturar(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {


		if ((colunaFinal>7) || (colunaFinal<0) || (linhaFinal<0) || (linhaFinal>7)) return false;
		
		if (((colunaFinal == colunaInicial+2)||(colunaFinal==colunaInicial-2)) && ((linhaFinal == linhaInicial+1)||(linhaFinal == linhaInicial-1))) return true;
		if ((((linhaFinal == linhaInicial +2) || (linhaFinal == linhaInicial-2))) && (((colunaFinal==colunaInicial+1) || (colunaFinal==colunaInicial-1)))) return true;
			
		
		return false;
		
	}

	
}
