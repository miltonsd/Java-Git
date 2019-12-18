package business;
import java.util.ArrayList;

import data.DataFactura;
import data.DataHojaDeParte;
import entities.Factura;
import entities.HojaDeParte;
import entities.Entity.States;

public class BusinessHojaDeParte 
{	DataHojaDeParte hp = new DataHojaDeParte();
	public entities.HojaDeParte getOne(int idhoja)
	{
		
		return 	hp.GetOne(idhoja);
	}
	public ArrayList<entities.HojaDeParte> getAll()
	{
		
		return 	hp.GetAll();
		
	}
	public ArrayList<entities.HojaDeParte> getAllConFactura(int id_factura)
	{
		
		return 	hp.getAllFactura(id_factura);
		
	}
	
	public void Delete(HojaDeParte hoja)
	{
		
		hoja.setState(States.Deleted);
		hp.Save(hoja);
		
	}
	public void Edit(HojaDeParte hoja)
	{	
		
		hoja.setState(States.Modified);
		hp.Save(hoja);
		
	}
	public void New(HojaDeParte hoja)
	{	
		
		hoja.setState(States.New);
		hp.Save(hoja);
		
	}
		

}
