package business;

import java.util.ArrayList;

import data.DataAutomovil;
import entities.Automovil;
import entities.Entity.States;

public class BusinessAutomovil {

	public entities.Automovil getOne(String nropatente) {
		DataAutomovil da = new DataAutomovil();
		return da.GetOne(nropatente);
	}

	public ArrayList<entities.Automovil> getAll() {
		DataAutomovil da = new DataAutomovil();
		return da.GetAll();

	}

	public ArrayList<entities.Automovil> getAllPorUsuario(int idusuario) {
		DataAutomovil da = new DataAutomovil();
		return da.GetAll(idusuario);

	}

	public void Delete(Automovil auto) {
		DataAutomovil da = new DataAutomovil();
		auto.setState(States.Deleted);
		da.Save(auto);

	}

	public void Edit(Automovil auto) {
		DataAutomovil da = new DataAutomovil();
		auto.setState(States.Modified);
		da.Save(auto);

	}

	public void New(Automovil auto) {
		DataAutomovil da = new DataAutomovil();
		auto.setState(States.New);
		da.Save(auto);

	}

}
