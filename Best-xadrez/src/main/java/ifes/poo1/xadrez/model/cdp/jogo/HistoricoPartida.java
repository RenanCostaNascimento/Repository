package ifes.poo1.xadrez.model.cdp.jogo;

import ifes.poo1.xadrez.model.reuse.Model;
import java.io.Serializable;
import java.util.Date;

public class HistoricoPartida extends Model implements Comparable<HistoricoPartida>, Serializable{
	
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private String vencedor;
        
        public String toString(){
            return vencedor+"\nHora de Inicio: "+dataHoraInicio.toString()+"\nHora de Termino: "+dataHoraFim.toString();
        }
	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public Date getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(Date dataHoraFim) {
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
