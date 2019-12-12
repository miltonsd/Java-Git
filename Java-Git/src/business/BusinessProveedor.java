package business;

import java.util.ArrayList;

import data.DataHojaDeParte;
import data.DataProveedor;

public class BusinessProveedor {
	
	public entities.Proveedor getOne(int cuit)
	{
		DataProveedor dp = new DataProveedor();
		return 	dp.GetOne(cuit);
	}
	public ArrayList<entities.Proveedor> getAll()
	{
		DataProveedor dp = new DataProveedor();
		return 	dp.GetAll();
		
	}

}
