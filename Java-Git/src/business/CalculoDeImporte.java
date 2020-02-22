package business;
import java.util.ArrayList;

import business.*;
import entities.Factura;
import entities.HojaDeParte;
import entities.HojaRepuesto;
import entities.Repuesto;
public class CalculoDeImporte 
{	
	private BusinessFactura negocioFactura = new BusinessFactura();
	private BusinessHojaDeParte negocioHojaDeParte = new BusinessHojaDeParte();
	private BusinessRepuesto negocioRepuesto = new BusinessRepuesto();
	private BusinessHojaRepuesto negocioHojaRepuesto = new BusinessHojaRepuesto();
	
	public void Calcular(int idfactura) {
		Factura factura = negocioFactura.getOne(idfactura);
		ArrayList<HojaDeParte> hojas =  negocioHojaDeParte.getAllConFactura(idfactura);
		
		float importetotal = 0 ;
		for(HojaDeParte h:hojas)
		{	
			h.setHojasRepuestos(negocioHojaRepuesto.getAll((int)h.getID()));
			for(HojaRepuesto hr:h.getHojaRepuestos())
			{	
				hr.setRepuesto(negocioRepuesto.getOne((int)hr.getRepuesto().getID()));
			}
			importetotal = importetotal + h.calcularPrecioTotal();
			
		}
		
		factura.setImporteTotal(importetotal);
		negocioFactura.Edit(factura);
				
				
		/*if(negocioFactura.getAll()!=null) 
		{
			ArrayList<Factura> factura = negocioFactura.getAll();
		}
		if(negocioRepuesto.getAll()!=null) 
		{
			ArrayList<Repuesto> repuestos = negocioRepuesto.getAll();
		}
		if(negocioHojaDeParte.getAllConFactura(idfactura)!=null) 
		{
			ArrayList<HojaDeParte> hojas = negocioHojaDeParte.getAll();
		}
		if(negocioFactura.getOne(idfactura)!=null) 
		{
			Factura factura = negocioFactura.getOne(idfactura);*/
		}
		
	}
	

