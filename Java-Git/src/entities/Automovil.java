package entities;

public class Automovil extends Entity
{   
  
	private String _idpatente; // AB123CD
	private String _marca;
	private String _modelo;
	private String _color;
	private int _idusuario;

	public String getPatente() {
		return _idpatente;
	}
	
	public void setPatente(String patente) {
		this._idpatente = patente;
		
	}
	public String getMarca() {
		return _marca;
	}
	public void setMarca(String marca) {
		this._marca = marca;
	}
	public String getModelo() {
		return _modelo;
	}
	public void setModelo(String modelo) {
		this._modelo = modelo;
	}
	public String getColor() {
		return _color;
	}
	public void setColor(String color) {
		this._color = color;
	}
	public int getIDCliente() {
		return _idusuario;
	}
	public void setIDCliente(int idcliente) {
		this._idusuario = idcliente;
	}
}
