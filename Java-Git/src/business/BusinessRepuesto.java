package business;

import java.util.ArrayList;

import data.DataRepuesto;

public class BusinessRepuesto {
	
	public entities.Repuesto getOne(int idrepuesto)
	{
		DataRepuesto rep = new DataRepuesto();
		return 	rep.GetOne(idrepuesto);
	}
	public ArrayList<entities.Repuesto> getAll()
	{
		DataRepuesto rep = new DataRepuesto();
		return rep.GetAll();
		
	}
		
}
