package business;

import java.util.ArrayList;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

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
	public void Delete(Repuesto rep) throws MySQLIntegrityConstraintViolationException
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.Deleted);
		dr.Save(rep);
	

	}
		
		
	
	public void Edit(Repuesto rep) throws MySQLIntegrityConstraintViolationException
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.Modified);
		dr.Save(rep);
		
	}
	public void New(Repuesto rep) throws MySQLIntegrityConstraintViolationException
	{	
		DataRepuesto dr = new DataRepuesto();
		rep.setState(States.New);
		dr.Save(rep);
		
	}
		
}
