package entities;

public class Repuesto extends Entity
{
	private int _idrepuesto;
	private String _descripcion;
	private int _stock;
	private int _punto_pedido;
	private float _precio_unitario;
	private int _cuitproveedor;
	private int _idtiporepuesto;
	
	public int getIDRepuesto() {
		return _idrepuesto;
	}
	public void setIDRepuesto(int id_repuesto) {
		this._idrepuesto = id_repuesto;
		
	}
	public int getCuitProveedor() {
		return _cuitproveedor;
	}
	public void setCuitProveedor(int cuit) {
		this._cuitproveedor = cuit;
		
	}
	
	public int getIDTipoRepuesto() {
		return _idtiporepuesto;
	}
	public void setIDTipoRepuesto(int idtiporepuesto) {
		this._idtiporepuesto = idtiporepuesto;
		
	}
	public String getDescripcion() {
		return _descripcion;
	}
	public void setDescripcion(String descripcion) {
		this._descripcion = descripcion;
	}
	public int getStock() {
		return _stock;
	}
	public void setStock(int stock) {
		this._stock = stock;
	}
	public int getPuntoPedido() {
		return _punto_pedido;
	}
	public void setPuntoPedido(int punto_pedido) {
		this._punto_pedido = punto_pedido;
	}
	public float getPrecioUnitario() {
		return _precio_unitario;
	}
	public void setPrecioUnitario(float precio_unitario) {
		this._precio_unitario = precio_unitario;
	}		
}
