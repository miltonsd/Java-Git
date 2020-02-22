package business;
import java.util.ArrayList;

import data.DataRepuesto;
import data.DataTipoRepuesto;

public class BusinessTipoRepuesto {
	public entities.TipoRepuesto getOne(int idtiporepuesto)
	{
		DataTipoRepuesto tr = new DataTipoRepuesto();
		return 	tr.GetOne(idtiporepuesto);
	}
	public ArrayList<entities.TipoRepuesto> getAll()
	{
		DataTipoRepuesto tr = new DataTipoRepuesto();
		return tr.GetAll();
		
	}
	

}
