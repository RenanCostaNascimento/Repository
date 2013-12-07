package ifes.poo1.xadrez.util.exception;

public class CaminhoBloqueadoException extends Exception {

	public CaminhoBloqueadoException(){
		super("A peca esta com o caminho bloqueado para fazer esse movimento!");
	}
}
