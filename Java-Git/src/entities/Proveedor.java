package entities;

import entities.Entity.States;

public class Proveedor implements Entity 
{
	private int idcuit;
	private String razon_social;
	private int tel;
	private String direccion;
	private String email;
	private States state;
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }
	public Object getID()
	{
		return this.idcuit;
	}
	public void setID(Object idcuit)
	{
		if(idcuit.getClass() == Integer.class)
	    {
			this.idcuit=(Integer) idcuit;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}
	
	
	public String getRazonSocial() 
	{
		return razon_social;
		}
	public void setRazonSocial(String razon_social) {
		this.razon_social = razon_social;
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
