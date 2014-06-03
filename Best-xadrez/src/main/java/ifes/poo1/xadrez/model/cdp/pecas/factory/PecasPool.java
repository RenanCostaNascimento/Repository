package ifes.poo1.xadrez.model.cdp.pecas.factory;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.jogo.Posicao;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;
import java.io.Serializable;

import java.util.HashMap;

public class PecasPool implements Serializable{
	private HashMap<Cores, HashMap<NomePecas, Peca>> pecas = new HashMap<>();
	private static PecasPool pp = null;
	
	private PecasPool(){
		pecas.put(Cores.branco, new HashMap<NomePecas, Peca>());
		pecas.put(Cores.preto, new HashMap<NomePecas, Peca>());
	}
	
	
	public static PecasPool getInstanceOf(){
		if (pp == null) pp = new PecasPool();
		return pp;
	}
	
	
	
	public Peca getPeca(NomePecas peca, Cores cor, Posicao pos){
		if (!pecas.get(cor).containsKey(peca)){
			pecas.get(cor).put(peca, PecasFactory.fabricate(peca, cor));
		}
		Peca r = pecas.get(cor).get(peca).clone();
                                             r.setPosicao(pos);
		return r;
		
	}
	
}
