package business;

import java.util.ArrayList;

import data.DataFactura;
import entities.Entity.States;
import entities.Factura;

public class BusinessFactura {
	public entities.Factura getOne(int idfactura) {
		DataFactura rep = new DataFactura();
		return rep.GetOne(idfactura);
	}

	public ArrayList<entities.Factura> getAll() {
		DataFactura rep = new DataFactura();
		return rep.GetAll();

	}

	public void Delete(Factura rep) {
		DataFactura dr = new DataFactura();
		rep.setState(States.Deleted);
		dr.Save(rep);

	}

	public void Edit(Factura rep) {
		DataFactura dr = new DataFactura();
		rep.setState(States.Modified);
		dr.Save(rep);

	}

	public void New(Factura rep) {
		DataFactura dr = new DataFactura();
		rep.setState(States.New);
		dr.Save(rep);

	}

}
