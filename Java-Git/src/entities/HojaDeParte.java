package entities;

import java.util.HashMap;

public class HojaDeParte {
	private int id_hoja;
	private Usuario mecanico;
	private Automovil auto;
	private double costo_manoDeObra;
	HashMap<Repuesto, Integer> repuestos = new HashMap<Repuesto, Integer>();
	
	public int getId_hoja() {
		return id_hoja;
	}
	public void setId_hoja(int id_hoja) {
		this.id_hoja = id_hoja;
	}
	public Usuario getMecanico() {
		return mecanico;
	}
	public void setMecanico(Usuario mecanico) {
		this.mecanico = mecanico;
	}
	public Automovil getAuto() {
		return auto;
	}
	public void setAuto(Automovil auto) {
		this.auto = auto;
	}
	public double getCosto_manoDeObra() {
		return costo_manoDeObra;
	}
	public void setCosto_manoDeObra(double costo_manoDeObra) {
		this.costo_manoDeObra = costo_manoDeObra;
	}
	public HashMap<Repuesto, Integer> getRepuestos() {
		return repuestos;
	}
	public void setRepuestos(Repuesto rep, int cant) {
		this.repuestos.put(rep, cant);
	}
}
