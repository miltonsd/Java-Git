package entities;

//import java.util.HashMap;

public class HojaDeParte extends Entity
{
	private int _idhoja;
	private int _idmecanico;
	private int _idfactura;
	private String _idpatente;
	private float _costomanodeobra;
	
	
	//HashMap<Repuesto, Integer> repuestos = new HashMap<Repuesto, Integer>();
	

	public int getIDFactura()
	{
		return _idfactura;
	}
	public int setIDFactura()
	{
		return _idfactura;
	}

	public int getIDHoja() {
		return _idhoja;
		}
	public void setIDHoja(int id_hoja) {
		this._idhoja = id_hoja;
	}
	public int getIDMecanico() {
		return _idmecanico;
	}
	public void setMecanico(int mecanico) {
		this._idmecanico = mecanico;
	}
	public String getIDPatente() {
		return _idpatente;
	}
	public void setIDPatente(String idpatente) {
		this._idpatente = idpatente;
	}
	public float getCostoManoDeObra() {
		return _costomanodeobra;
	}
	public void setCostoManoDeObra(float costomanodeobra) {
		this._costomanodeobra = costomanodeobra;
	}
/*	public HashMap<Repuesto, Integer> getRepuestos() {
		return repuestos;
	} */
	
/*	public void setRepuestos(Repuesto rep, int cant) {
		this.repuestos.put(rep, cant);
	}*/
}
