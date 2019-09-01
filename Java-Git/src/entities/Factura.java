package entities;

import java.util.ArrayList;
import java.util.Date;

import entities.Entity.States;

//import java.util.ArrayList;

public class Factura implements Entity
{
	private int idfactura;
	private Date fechaemision;
	private float importetotal;
	private Usuario usuario;
	private ArrayList<HojaDeParte> hojas;
	private States state;
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }
	//Primary Key
	public Object getID()
	{
		return this.idfactura;
	}
	public void setID(Object idfactura)
	{
		if(idfactura.getClass() == Integer.class)
	    {
			this.idfactura=(Integer) idfactura;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}
	//Atributos
	
	public Date getFechaEmision() {
		return fechaemision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this.fechaemision = fecha_emision;
	}
	
	public double getImporteTotal() {
		return importetotal;
	}
	public void setImporteTotal(float importe_total) {
		this.importetotal = importe_total;
	}
	
	//Objetos asociados
	
	public Usuario getUsuario() 
	{
		return usuario;
	}
	public void setUsuario( Usuario usuario ) 
	{
		this.usuario = usuario;
	}

	public ArrayList<HojaDeParte> getHojas()
    {return this.hojas;}	

	public void setHojas(ArrayList<HojaDeParte> hojas)
	{
		this.hojas=hojas;
	}
	
	public float calcularImporteTotal() 
	{ float importe = 0;
		for (entities.HojaDeParte hoja : this.hojas)
		{
			importe+=hoja.getCostoManoDeObra();

		}
		return importe;
	}
	
    /*  @Override
	 public String toString() 
	{
		this.importe_total=0;
		
		String cliente= this.getHoja().getAuto().getCliente().getApellido()+","
				+ " "+this.getHoja().getAuto().getCliente().getNombre();
		
		String s="Factura N�: "+this.getId_factura()+
				"\nFecha: "+this.getFecha_emision()+
				"\n\nCliente: "+cliente+
				"\nRepuesto - Precio Unit - Cantidad - Subtotal\n";
		
		
		return s+"\nTotal: $"+this.importe_total+
				"\nMecanico: "+this.getHoja().getMecanico().getApellido()+
				", "+this.getHoja().getMecanico().getNombre();
	} */
}
