package entities;

public class Rol extends Entity
{
	private int _idrol;
	private String _descripcion; // 1 - Cliente ; 2 - Mec�nico ; 3 - Administrador 
	
	public int getIDRol() {
		return _idrol;
	}
	public void setIDRol(int cod_rol) {
		this._idrol = cod_rol;
	}
	public String getDescripcion() {
		return _descripcion;
	}
	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}
}
