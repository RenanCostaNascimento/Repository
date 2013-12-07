package ifes.poo1.xadrez.util.exception;

public class CapturaInvalidaPecaPropriaException extends Exception {

	public CapturaInvalidaPecaPropriaException(){
		super("Por que mesmo voce quer capturar sua propria peca?");
	}
}
