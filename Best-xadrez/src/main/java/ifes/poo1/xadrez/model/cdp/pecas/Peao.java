package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Peao extends Peca {
	
	public Peao(Cores cor) {
		super(cor, "Peao", 1);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean mover(int xIn, int yIn, int xFin, int yFin) {
		
		if ((xIn == xFin) && ((yFin == yIn +1)||(yFin == yIn-1))) return true;
		if (((yIn == 1) || (yIn == 6)) && ((yFin == yIn+2)||yFin == yIn-2)) return true;
		
		return false;
		
	}



}
