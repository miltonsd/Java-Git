package entities;

public class Rol implements Entity {
	private int idrol;
	private String descripcion; // 1 - Cliente ; 2 - Mec�nico ; 3 - Administrador
	private States state;

	public States getState() {
		return this.state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Object getID() {
		return (int) this.idrol;
	}

	public void setID(Object idrol) {
		if (idrol.getClass() == Integer.class) {
			this.idrol = (Integer) idrol;

		} else {
			new Exception("El ID agregado no pertenece al tipo valido para la clase");
		}

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public enum Roles {
		Cliente, Mecanico, Admin
	}
}
