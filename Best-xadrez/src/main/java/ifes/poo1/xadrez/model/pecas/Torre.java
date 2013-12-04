package ifes.poo1.xadrez.model.pecas;

public class Torre extends Pecas {
	private int valor = 5;
	public Torre(String cor) {
		super(cor);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "T";
	}
	@Override
	public boolean mover(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal) {
		
		if((linhaFinal-linhaInicial == 0) || (colunaFinal - colunaInicial == 0))
			return true;
		
		return false;
		
	}

}
