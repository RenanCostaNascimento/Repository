package ifes.poo1.xadrez.util.exception;

public class PecaAlheiaException extends Exception {

	public PecaAlheiaException(){
		super("Ladrao! Essa peca nao eh sua!");
	}
}
