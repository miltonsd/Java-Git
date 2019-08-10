package entities;

public class Rol {
	private int cod_rol;
	private String descripcion; // 1 - Cliente ; 2 - Mecánico ; 3 - Administrador 
	
	public int getCod_rol() {
		return cod_rol;
	}
	public void setCod_rol(int cod_rol) {
		this.cod_rol = cod_rol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
