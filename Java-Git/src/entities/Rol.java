package entities;

public class Rol {
	private int id;
	private String descripcion;
	// 0 - Admin
	// 1 - Mecanico
	// 2 - Cliente
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
