package entities;

public class ProveedorRepuestos  implements Entity
{
	
	private Repuesto repuesto;
	private States state;
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }

	private Proveedor provedor;
	public Proveedor getProvedor() {
		return provedor;
	}
	public void setProvedor(Proveedor provedor) {
		this.provedor = provedor;
	}
	public Repuesto getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	
	
}
