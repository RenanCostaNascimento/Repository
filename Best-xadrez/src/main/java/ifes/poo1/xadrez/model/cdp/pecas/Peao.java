package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;

public class Peao extends Peca {
	
	public Peao(Cores cor) {
		super(cor, NomePecas.peao, 1);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		/*peao preto*/
		if(this.getCor().equals(Cores.preto)){
			if(colunaFinal == colunaInicial){
				/*primeiro movimento*/
				if((linhaInicial == 6) && (linhaFinal == linhaInicial-2) || (linhaFinal == linhaInicial -1))
					return true;
				/*movimento comum*/
				if(linhaFinal == linhaInicial -1)
					return true;
			}
		/*peao branco*/
		}else{
			/*movimento comum*/
			if(colunaFinal == colunaInicial){
				/*primeiro movimento*/
				if((linhaInicial == 1) && (linhaFinal == linhaInicial+2) || (linhaFinal == linhaInicial +1))
					return true;
				/*movimento comum*/
				if(linhaFinal == linhaInicial +1)
					return true;
			/*movimento de captura*/
			}
		}
			
		return false;
	}

	@Override
	public boolean capturar(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		/*peao preto*/
		if(this.getCor().equals(Cores.preto)){
			if((linhaFinal == linhaInicial-1) && ((colunaFinal == colunaInicial+1) || (colunaFinal == colunaInicial-1)))
				return true;
		}
		/*peao branco*/
		else{
			if((linhaFinal == linhaInicial+1) && ((colunaFinal == colunaInicial+1) || (colunaFinal == colunaInicial-1)))
				return true;
		}
		
		return false;
		
	}



}
