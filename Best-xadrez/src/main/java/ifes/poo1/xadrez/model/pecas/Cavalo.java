package ifes.poo1.xadrez.model.pecas;

public class Cavalo extends Pecas {
	private int valor = 3;
	
	public Cavalo(String cor) {
		super(cor);
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
