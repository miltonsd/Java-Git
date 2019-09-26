package business;
import java.util.ArrayList;
import data.DataAutomovil;

public class BusinessAutomovil
{

	
	public entities.Automovil getOne(String nropatente)
	{
		DataAutomovil da = new DataAutomovil();
		return 	da.GetOne(nropatente);
	}
	public ArrayList<entities.Automovil> getAll()
	{
		DataAutomovil da = new DataAutomovil();
		return 	da.GetAll();
		
	}
		

	
}
