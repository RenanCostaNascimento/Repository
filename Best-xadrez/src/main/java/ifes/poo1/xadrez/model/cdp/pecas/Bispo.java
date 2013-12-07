package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;

public class Bispo extends Pecas{
	private int valor = 3;
	
	public Bispo(Cores cor) {
		super(cor);
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