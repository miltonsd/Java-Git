	package entities;

import entities.Entity.States;

public class HojaRepuestos 
{
	
	private Repuesto repuesto;
	private HojaDeParte hoja;
	private int cantidad;
	private float preciototal;
	private States state;
	

	public States getState() 
    {
		return this.state;
    }

	public  void setState(States state) 
    {
		this.state = state;
    }

	
	public Repuesto getRepuesto() 
	{
		return this.repuesto;
	}
	public void setRepuesto(Repuesto repuesto) 
	{
		this.repuesto=repuesto;
	}
	public HojaDeParte getHoja()
	{
		return this.hoja;
		
	}
	public void setIDHoja(HojaDeParte hoja)
	{
		this.hoja=hoja;
	}
	public int getCantidad()
	{
		return this.cantidad;
		
	}
	public void setCantidad(int cantidad)
	{
		this.cantidad=cantidad;
	}
	
	//cant * precio unitario
	
	public float getPrecioTotal()
	{   
		return this.preciototal;
		
	}
	public void setPrecioTotal(float preciototal)
	{
		this.preciototal=preciototal;
	}
	
	public float calcularPrecioTotal()
	{
		
		float ptotal=0;
		
		return ptotal = this.getRepuesto().getPrecioUnitario() * this.getCantidad();
	}
	
	
	

}
