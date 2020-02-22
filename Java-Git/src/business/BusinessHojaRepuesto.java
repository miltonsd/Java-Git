package business;

import java.util.ArrayList;

import data.DataHojaRepuesto;
import entities.HojaRepuesto;
import entities.Entity.States;

public class BusinessHojaRepuesto 
{
	DataHojaRepuesto hr = new DataHojaRepuesto();
	public entities.HojaRepuesto getOne(int idhoja,int idrepuesto)
	{
		
		return 	hr.GetOne(idhoja,idrepuesto);
	}
	public ArrayList<entities.HojaRepuesto> getAll()
	{
		
		return 	hr.GetAll();
		
	}
	public ArrayList<entities.HojaRepuesto> getAll(int id_hoja)
	{
		
		return 	hr.GetAll(id_hoja);
		
	}
	
	
	public void Delete(HojaRepuesto hoja)
	{
		
		hoja.setState(States.Deleted);
		hr.Save(hoja);
		
	}
	public void Edit(HojaRepuesto hoja)
	{	
		
		hoja.setState(States.Modified);
		hr.Save(hoja);
		
	}
	public void New(HojaRepuesto hoja)
	{	
		
		hoja.setState(States.New);
		hr.Save(hoja);
		
	}

}
