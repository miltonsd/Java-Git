package entities;

public class Factura {
	private int id;
	private String fecha_emision;
	private HojaDeParte hoja;
	private double importe_total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public HojaDeParte getHoja() {
		return hoja;
	}
	public void setHoja(HojaDeParte hoja) {
		this.hoja = hoja;
	}
	public double getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}
}
