package ifes.poo1.xadrez.model.cdp.pecas.factory;

import ifes.poo1.xadrez.model.cdp.constantes.Cores;
import ifes.poo1.xadrez.model.cdp.constantes.NomePecas;
import ifes.poo1.xadrez.model.cdp.pecas.Peca;

public class PecasFactory {
	private static String classPath = "ifes.poo1.xadrez.model.cdp.pecas.";
	private static Peca peca = null;
	@SuppressWarnings("rawtypes")
	private static Class classe;
	
	public static Peca fabricate(NomePecas className, Cores cor){
		return fabricate(className.toString(), cor);
	}

	public static Peca fabricate(String className, Cores cor){
		
		try {
			classe = Class.forName(classPath+className);
			peca = (Peca) classe.newInstance();
			peca.setCor(cor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return peca;
	} 
}

