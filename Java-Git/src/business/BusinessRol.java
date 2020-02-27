package business;

import data.DataRol;
import entities.Rol;

@SuppressWarnings("unused")
public class BusinessRol {
	DataRol dr = new DataRol();
	
	public entities.Rol getOne(int idRol) {
		return dr.GetOne(idRol);
	}
}
