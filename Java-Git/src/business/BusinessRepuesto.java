package business;

import java.util.ArrayList;

import data.DataRepuesto;
import entities.Entity.States;
import entities.Repuesto;

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
	public void Delete(Repuesto rep)
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.Deleted);
		dr.Save(rep);
		
	}
	public void Edit(Repuesto rep)
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.Modified);
		dr.Save(rep);
		
	}
	public void New(Repuesto rep)
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.New);
		dr.Save(rep);
		
	}
		
}
