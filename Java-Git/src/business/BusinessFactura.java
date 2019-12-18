package business;

import java.util.ArrayList;

import data.DataFactura;
import entities.Factura;
import entities.Entity.States;

public class BusinessFactura {
	public entities.Factura getOne(int idrepuesto)
	{
		DataFactura rep = new DataFactura();
		return 	rep.GetOne(idrepuesto);
	}
	public ArrayList<entities.Factura> getAll()
	{
		DataFactura rep = new DataFactura();
		return rep.GetAll();
		
	}
	public void Delete(Factura rep)
	{	
		DataFactura dr = new DataFactura();
		rep.setState(States.Deleted);
		dr.Save(rep);
		
	}
	public void Edit(Factura rep)
	{	
		DataFactura dr = new DataFactura();
		rep.setState(States.Modified);
		dr.Save(rep);
		
	}
	public void New(Factura rep)
	{	
		DataFactura dr = new DataFactura();
		rep.setState(States.New);
		dr.Save(rep);
		
	}

}
