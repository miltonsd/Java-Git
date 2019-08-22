package entities;

import java.util.Date;

//import java.util.ArrayList;

public class Factura extends Entity
{
	private int _idfactura;
	private Date _fechaemision;
	private float _importetotal;
	private int _idusuario;
	//private ArrayList<HojaDeParte> _hoja;
	
	
	public int getIDFactura() {
		return _idfactura;
	}
	public void setIDFactura(int id_factura) {
		this._idfactura = id_factura;
	}
	public int getIDUsuario() {
		return _idusuario;
	}
	public void setIDUsuario( int idusuario ) 
	{
		this._idusuario = idusuario;
	}
	
	public Date getFechaEmision() {
		return _fechaemision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this._fechaemision = fecha_emision;
	}
	
	public double getImporteTotal() {
		return _importetotal;
	}
	public void setImporteTotal(float importe_total) {
		this._importetotal = importe_total;
	}
	
	/* @Override
	 public String toString() 
	{
		this.importe_total=0;
		
		String cliente= this.getHoja().getAuto().getCliente().getApellido()+","
				+ " "+this.getHoja().getAuto().getCliente().getNombre();
		
		String s="Factura N�: "+this.getId_factura()+
				"\nFecha: "+this.getFecha_emision()+
				"\n\nCliente: "+cliente+
				"\nRepuesto - Precio Unit - Cantidad - Subtotal\n";
		
		for(Repuesto r: this.getHoja().repuestos.keySet()) {
			s+=r.getDescripcion()+
					" - $"+r.getPrecio_unitario()+
					" - "+this.getHoja().repuestos.get(r)+
					" - $"+(r.getPrecio_unitario()*this.getHoja().repuestos.get(r))+
					"\n";
			
			this.importe_total  +=  r.getPrecio_unitario() * this.getHoja().repuestos.get(r);
		}
		return s+"\nTotal: $"+this.importe_total+
				"\nMecanico: "+this.getHoja().getMecanico().getApellido()+
				", "+this.getHoja().getMecanico().getNombre();
	} */
}
