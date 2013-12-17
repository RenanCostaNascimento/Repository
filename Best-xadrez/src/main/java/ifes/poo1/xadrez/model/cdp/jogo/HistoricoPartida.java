package ifes.poo1.xadrez.model.cdp.jogo;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class HistoricoPartida implements Comparable<HistoricoPartida>, Serializable{
	
	private GregorianCalendar dataHoraInicio;
	private GregorianCalendar dataHoraFim;
	private String vencedor;
        
        public String toString(){
            return vencedor+"\nHora de Inicio: "+dataHoraInicio.toString()+"\nHora de Termino: "+dataHoraFim.toString();
        }
	public GregorianCalendar getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(GregorianCalendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public GregorianCalendar getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(GregorianCalendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public String getVencedor() {
		return vencedor;
	}
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
	public int compareTo(HistoricoPartida partida) {
            return this.getDataHoraInicio().compareTo(partida.getDataHoraInicio());
        }
        
            

	
}
