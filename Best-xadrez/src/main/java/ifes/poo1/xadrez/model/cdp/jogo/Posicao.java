package ifes.poo1.xadrez.model.cdp.jogo;

public class Posicao {
	
	private int coluna;
	private int linha;
	
	public Posicao(){
		
	}
                       
                        public static Posicao create(int coluna, int linha){
                                return new Posicao(coluna, linha);
                        }
	
	public Posicao(int coluna, int linha){
		this.coluna = coluna;
		this.linha = linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}

}
