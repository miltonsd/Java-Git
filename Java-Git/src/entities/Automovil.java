package entities;

public class Automovil implements Entity
{   
  
	private String idpatente; // AB123CD
	private String marca;
	private String modelo;
	private String color;
	private Usuario usuario;
	private States state;
	

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Usuario getCliente() {
		return usuario;
	}
	public void setCliente(Usuario cliente) {
		this.usuario = cliente;
	}
	
	public  States getState() 
    {
	return this.state;
		
	}
	public void setState(States state) 
    {  
	 this.state=state;
	}

	public Object getID()
	{
		return this.idpatente;
	}
	public void setID(Object idpatente)
	{
		if(idpatente.getClass() == String.class)
	    {
			this.idpatente=(String) idpatente;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}


}

