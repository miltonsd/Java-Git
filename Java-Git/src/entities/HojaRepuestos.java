	package entities;

public class HojaRepuestos 
{
	
	private int _idrepuesto;
	private int _idhoja;
	private int _cantidad;
	private float _preciototal;
	
	
	
	public int getIDRepuesto()
	{
		return _idrepuesto;
		
	}
	public void setIDRepuesto(int idrepuesto)
	{
		_idrepuesto=idrepuesto;
	}
	public int getIDHoja()
	{
		return _idhoja;
		
	}
	public void setIDHoja(int idhoja)
	{
		_idhoja=idhoja;
	}
	public int getCantidad()
	{
		return _cantidad;
		
	}
	public void setCantidad(int cantidad)
	{
		_cantidad=cantidad;
	}
	
	//cant * precio unitario
	public float getPrecioTotal()
	{
		return _preciototal;
		
	}
	public void setPrecioTotal(float preciototal)
	{
		_preciototal=preciototal;
	}
	
	
	

}
