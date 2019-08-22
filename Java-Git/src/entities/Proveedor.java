package entities;

public class Proveedor extends Entity 
{
	private int _idcuit;
	private String _razon_social;
	private int tel;
	private String direccion;
	private String email;
	
	public int getIDCuit() {
		return _idcuit;
	}
	public void setIDCuit(int cuit) {
		this._idcuit = cuit;
	}
	public String getRazon_social() 
	{
		return _razon_social;
		}
	public void setRazon_social(String razon_social) {
		this._razon_social = razon_social;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
