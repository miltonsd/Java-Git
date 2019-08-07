package entities;

import java.util.ArrayList;

public class HojaDeParte {
	private int id_hoja;
	private Usuario mecanico;
	private Automovil auto;
	private double manoDeObra;
	ArrayList<Repuesto> rep = new ArrayList<Repuesto>();
	
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
	public double getManoDeObra() {
		return manoDeObra;
	}
	public void setManoDeObra(double manoDeObra) {
		this.manoDeObra = manoDeObra;
	}
	public ArrayList<Repuesto> getRep() {
		return rep;
	}
	public void setRep(ArrayList<Repuesto> rep) {
		this.rep = rep;
	}
}
