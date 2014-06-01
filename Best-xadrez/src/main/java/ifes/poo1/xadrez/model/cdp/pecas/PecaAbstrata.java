package ifes.poo1.xadrez.model.cdp.pecas;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import java.io.Serializable;

/**
 * Camada abstrata da peca, contem funções basicas de get e set e o metódo
 * construtor para inicializar as peças
 */
public abstract class PecaAbstrata implements Peca, Serializable {

    protected boolean seMovimentou;
    protected Cores cor;
    protected int valor;
    protected NomePecas nome;
    protected Posicao posicao;

    public PecaAbstrata(NomePecas nome, int valor, Cores cor) {
        this.nome = nome;
        this.valor = valor;
        this.cor = cor;
    }

    public NomePecas getNome() {
        return nome;
    }

    public void setNome(NomePecas nome) {
        this.nome = nome;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public Cores getCor() {
        return cor;
    }

    public void setCor(Cores cor) {
        this.cor = cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean isSeMovimentou() {
        return seMovimentou;
    }

    public void actMovimentou() {
        this.seMovimentou = true;
    }

    public Peca clone() {
        try {
            // call clone in Object. 
            return (Peca) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(" Cloning not allowed. ");
            return this;
        }

    }

}
