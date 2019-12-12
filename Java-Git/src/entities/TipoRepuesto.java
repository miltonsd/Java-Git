package entities;

import entities.Entity.States;

public class TipoRepuesto implements Entity
{
	private int idtiporepuesto;
	private String descripcion;
	
	public Object getID()
	{
		return this.idtiporepuesto;
	}
	public void setID(Object idtiporepuesto)
	{
		if(idtiporepuesto.getClass() == Integer.class)
	    {
			this.idtiporepuesto=(Integer) idtiporepuesto;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion =  descripcion;
	}
	
	
	private States state;
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }
	

}
