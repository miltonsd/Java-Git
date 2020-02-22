package business;

import entities.Repuesto;

public class VerificarStockRepuesto {
	BusinessRepuesto negocioRepuesto = new BusinessRepuesto();
	Repuesto repuesto = new Repuesto();

	public VerificarStockRepuesto(Repuesto repuesto) {
		this.repuesto = negocioRepuesto.getOne((int) repuesto.getID());
	}

	public String ValidarStock(int cantidadpedida, int cantidadanterior, String modo) {
		String Mensaje = null;

		if (cantidadpedida > repuesto.getStock() && modo == "new") {
			Mensaje = "No se posee stock para el repuesto " + repuesto.getDescripcion();
		} else {
			if (cantidadanterior < cantidadpedida && (repuesto.getStock() + cantidadanterior - cantidadpedida < 0)
					&& modo == "edit") {
				Mensaje = "No se posee stock para el repuesto " + repuesto.getDescripcion();
			}
		}

		return Mensaje;
	}

	public void ActualizarStock(int cantidadpedida, int cantidadanterior, String modo) {
		switch (modo) {
		case "edit":
			repuesto.setStock((repuesto.getStock() + cantidadanterior) - cantidadpedida);
			negocioRepuesto.Edit(repuesto);
			break;
		case "new":
			repuesto.setStock(repuesto.getStock() - cantidadpedida);
			negocioRepuesto.Edit(repuesto);
			break;
		case "delete":
			repuesto.setStock(repuesto.getStock() + cantidadanterior);
			negocioRepuesto.Edit(repuesto);
			break;
		}
	}

}
