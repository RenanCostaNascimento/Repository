package ifes.poo1.xadrez.model.cdp.jogo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Checkpoint implements Serializable{
	
	String nome;
	Jogo jogo;
	GregorianCalendar dataSalvamento;
	
	public Checkpoint(Jogo jogo, String nome){
		this.nome = nome;
		this.jogo = jogo;
		this.dataSalvamento = new GregorianCalendar();
	}
	
	public String toString(){
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		return this.nome + " -- " +this.getJogo().getBranco().getNome() + " x " + this.getJogo().getPreto().getNome() + ", em " + formatoData.format(this.getDataSalvamento().getTime());
	}
	
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public GregorianCalendar getDataSalvamento() {
		return dataSalvamento;
	}
	public void setDataSalvamento(GregorianCalendar dataSalvamento) {
		this.dataSalvamento = dataSalvamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
