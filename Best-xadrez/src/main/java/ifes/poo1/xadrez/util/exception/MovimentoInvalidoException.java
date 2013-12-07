package ifes.poo1.xadrez.util.exception;

public class MovimentoInvalidoException extends Exception {
	
	public MovimentoInvalidoException(){
		super("Acredito que essa peca nao consiga fazer esse movimento...");
	}
}
