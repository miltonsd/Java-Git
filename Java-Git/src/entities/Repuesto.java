package entities;

import entities.Entity.States;

public class Repuesto implements Entity
{
	private int idrepuesto;
	private String descripcion;
	private int stock;
	private int punto_pedido;
	private float precio_unitario;
	private Proveedor proveedor;
	private TipoRepuesto tiporepuesto;
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
		return this.idrepuesto;
	}
	public void setID(Object idrepuesto)
	{
		if(idrepuesto.getClass() == Integer.class)
	    {
			this.idrepuesto=(Integer) idrepuesto;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}
	
	public Proveedor getProveedor()
	{
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
		
	}
	
	public TipoRepuesto getTipoRepuesto() {
		return tiporepuesto;
	}
	public void setTipoRepuesto(TipoRepuesto tiporepuesto)
	{
		this.tiporepuesto= tiporepuesto;
		
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	public int getStock()
	{
		return stock;
	}
	public void setStock(int stock) 
	{
		this.stock = stock;
	}
	
	public int getPuntoPedido() {
		return punto_pedido;
	}
	public void setPuntoPedido(int punto_pedido) {
		this.punto_pedido = punto_pedido;
	}

	public float getPrecioUnitario() {
		return precio_unitario;
	}
	public void setPrecioUnitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}		
}
