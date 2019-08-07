package entities;

public class Repuesto {
	private int id_repuesto;
	private String descripcion;
	private double precio_unit;
	private int stock;
	private int puntoPedido;
	
	public int getId_repuesto() {
		return id_repuesto;
	}
	public void setId_repuesto(int id_repuesto) {
		this.id_repuesto = id_repuesto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_unit() {
		return precio_unit;
	}
	public void setPrecio_unit(double precio_unit) {
		this.precio_unit = precio_unit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPuntoPedido() {
		return puntoPedido;
	}
	public void setPuntoPedido(int puntoPedido) {
		this.puntoPedido = puntoPedido;
	}	
}
