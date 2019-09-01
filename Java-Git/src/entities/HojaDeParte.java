package entities;

import java.util.ArrayList;

//import java.util.HashMap;

public class HojaDeParte implements Entity
{
	private int idhoja;
	private Usuario mecanico;
	private Factura factura;
	private Automovil automovil;
	private ArrayList<HojaRepuestos> hojarepuestos;
	private float costomanodeobra;
	private States state;
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }
	
	//HashMap<Repuesto, Integer> repuestos = new HashMap<Repuesto, Integer>();
	public Object getID()
	{
		return this.idhoja;
	}
	public void setID(Object idhoja)
	{
		if(idhoja.getClass() == Integer.class)
	    {
			this.idhoja=(Integer) idhoja;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}

	public Factura getFactura()
	{
		return factura;
	}
	public void setFactura(Factura factura)
	{
		this.factura =factura;
	}

	
	public Usuario getMecanico() 
	{
		return mecanico;
	}
	public void setMecanico(Usuario mecanico) {
		this.mecanico = mecanico;
	}
	
	public Automovil getAutomovil() {
		return automovil;
	}
	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}
	public float getCostoManoDeObra() {
		return costomanodeobra;
	}
	public void setCostoManoDeObra(float costomanodeobra) {
		this.costomanodeobra = costomanodeobra;
	}
	
	public float calcularPrecioTotal() 
	{  float preciototal=getCostoManoDeObra();
		for(entities.HojaRepuestos hojarepuesto : this.hojarepuestos) 
		{
			preciototal+=hojarepuesto.calcularPrecioTotal();
			
		}
		return preciototal;
	}
/*	public HashMap<Repuesto, Integer> getRepuestos() {
		return repuestos;
	} */
	
/*	public void setRepuestos(Repuesto rep, int cant) {
		this.repuestos.put(rep, cant);
	}*/
}
