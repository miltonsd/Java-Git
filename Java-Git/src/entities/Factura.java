package entities;

public class Factura {
	private int id_factura;
	private String fecha_emision;
	private HojaDeParte hoja;
	private double importe_total;
	
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	public String getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public HojaDeParte getHoja() {
		return hoja;
	}
	public void setHoja(HojaDeParte hoja) {
		this.hoja = hoja;
	}
	public double getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}
	
	@Override
	public String toString() {
		this.importe_total=0;
		String cliente= this.getHoja().getAuto().getCliente().getApellido()+", "+this.getHoja().getAuto().getCliente().getNombre();
		String s="Factura Nº: "+this.getId_factura()+"\nFecha: "+this.getFecha_emision()+"\n\nCliente: "+cliente+"\nRepuesto - Precio Unit - Cantidad - Subtotal\n";
		for(Repuesto r: this.getHoja().repuestos.keySet()) {
			s+=r.getDescripcion()+" - $"+r.getPrecio_unitario()+" - "+this.getHoja().repuestos.get(r)+" - $"+(r.getPrecio_unitario()*this.getHoja().repuestos.get(r))+"\n";
			this.importe_total+=r.getPrecio_unitario()*this.getHoja().repuestos.get(r);
		}
		return s+"\nTotal: $"+this.importe_total+"\nMecanico: "+this.getHoja().getMecanico().getApellido()+", "+this.getHoja().getMecanico().getNombre();
	}
}
