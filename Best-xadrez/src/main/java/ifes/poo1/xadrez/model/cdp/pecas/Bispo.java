package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Bispo extends Peca{
	
	public Bispo(Cores cor) {
		super(cor, "Bispo", 3);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean mover(int xIn, int yIn, int xFin, int yFin) {

		
		for (int aux = 0; aux < 8; aux++){
			if ((xIn+aux == xFin) && (yIn+aux == yFin)) return true;
			if ((xIn-aux == xFin) && (yIn-aux == yFin)) return true;
			if ((xIn+aux == xFin) && (yIn-aux == yFin)) return true;
			if ((xIn-aux == xFin) && (yIn+aux == yFin)) return true;
		}
		
		return false;
		
	}



}
