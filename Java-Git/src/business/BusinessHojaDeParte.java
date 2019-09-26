package business;
import java.util.ArrayList;
import data.DataHojaDeParte;

public class BusinessHojaDeParte 
{
	public entities.HojaDeParte getOne(int idhoja)
	{
		DataHojaDeParte hp = new DataHojaDeParte();
		return 	hp.GetOne(idhoja);
	}
	public ArrayList<entities.HojaDeParte> getAll()
	{
		DataHojaDeParte hp = new DataHojaDeParte();
		return 	hp.GetAll();
		
	}
		

}
