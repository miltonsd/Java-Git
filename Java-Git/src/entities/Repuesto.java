package entities;

public class Repuesto {
	private int id_repuesto;
	private String descripcion;
	private int stock;
	private int punto_pedido;
	private double precio_unitario;
	
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPunto_pedido() {
		return punto_pedido;
	}
	public void setPunto_pedido(int punto_pedido) {
		this.punto_pedido = punto_pedido;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}		
}
