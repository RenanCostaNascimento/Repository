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
	public boolean mover(int xIn, int yIn, int xFin, int yFin) {
		if ((xFin>7) || (xFin<0) || (yFin<0) || (yFin>7)) return false;
		
		if (((xFin == xIn+2)||(xFin==xIn-2)) && ((yFin == yIn+1)||(yFin == yIn-1))) return true;
		if ((((yFin == yIn +2) || (yFin == yIn-2))) && (((xFin==xIn+1) || (xFin==xIn-1)))) return true;
			
		
		return false;
		
	}

	
}
