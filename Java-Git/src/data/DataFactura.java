package data;

import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataFactura {
	// Traer todos
	@SuppressWarnings("finally")
	public List<Factura> GetAll()
	{
		List<entities.Factura> facturas= new ArrayList<entities.Factura>() ;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try 
		{
		    pst= FactoryConexion.getInstancia().getConn().prepareStatement
					("select * from facturas ");
           
			rs= pst.executeQuery();
			if(rs!=null) 
			{
				while(rs.next()) 
			   {
					entities.Factura factura = new Factura();
					factura.setUsuario(new Usuario());
					factura.setID(rs.getInt("id_factura"));
					factura.setFecha_emision(rs.getDate("fecha_emision"));
					factura.setHojas(new ArrayList<HojaDeParte>());
					factura.getUsuario().setID(rs.getInt("id_usuario"));
					factura.setImporteTotal(rs.getFloat("importe_total"));
					facturas.add(factura);
					
				}
				
		    }
		}
		
		catch (SQLException e)
		{
		     e.printStackTrace();
		}
				
		
		finally 
		{
			
			try 
		   {
			if(rs!=null) 
			{
				rs.close();
			}
			
			if(pst!=null)
			{
				pst.close();
			}
			
			FactoryConexion.getInstancia().releaseConn();
			
		     } 
			catch (SQLException e) 
		  {
			e.printStackTrace();
			
		  }
			
			return facturas;
    	}
				
	}

	// Traer uno
	@SuppressWarnings("finally")
	public entities.Factura GetOne(int id_factura)
	{
		entities.Factura factura = new entities.Factura() ;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try 
		{
		    pst= FactoryConexion.getInstancia().getConn().prepareStatement
					("select * from facturas where id_factura = ?");
            pst.setInt(1, id_factura);
			rs= pst.executeQuery();
			if(rs!=null && rs.next())  
			{ 
				factura.setHojas(new ArrayList<HojaDeParte>());
				factura.setUsuario(new Usuario());
				
				factura.setID(rs.getInt("id_factura"));
				factura.setFecha_emision(rs.getDate("fecha_emision"));
				factura.getUsuario().setID(rs.getInt("id_usuario"));
				factura.setImporteTotal(rs.getFloat("importe_total"));
				
					
				
		    }
		}
		
		catch (SQLException e)
		{
		     e.printStackTrace();
		}
				
		
		finally 
		{
			
			try 
		   {
			if(rs!=null) 
			{
				rs.close();
			}
			
			if(pst!=null)
			{
				pst.close();
			}
			
			FactoryConexion.getInstancia().releaseConn();
			
		     } 
			catch (SQLException e) 
		  {
			e.printStackTrace();
			
		  }
			
			return factura;
    	}
			
	}

	//ABM
	
	public void Delete(int ID)
	{ 
	  PreparedStatement stmt= null;
		try 
		{				
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("delete from hojas_de_parte where id_hoja=?");
			stmt.setInt(1, ID);
			stmt.execute();				
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		finally 
		{
			FactoryConexion.getInstancia().releaseConn();
		}	
			
		
		
	}
	public void Update(entities.HojaDeParte hoja)
	{
		PreparedStatement stmt= null;
		
		try 
		{				
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("UPDATE hojas_de_parte SET costo_mano_de_obra=?,id_mecanico=?,id_factura=?,id_patente=? where id_hoja = ?");
			
			stmt.setFloat(1, hoja.getCostoManoDeObra());
			stmt.setInt(2, (int)hoja.getMecanico().getID());
			stmt.setInt(3, (int)hoja.getFactura().getID());
			stmt.setString(4,(String) hoja.getAutomovil().getID());
			stmt.setInt(5, (int)hoja.getID());

			stmt.execute();
		
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		finally 
		{
			FactoryConexion.getInstancia().releaseConn();
		}	
			
		
		
		
		
	}
	public void Insert(entities.HojaDeParte hoja)
	{  
	   PreparedStatement stmt= null;
	   ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into hojas_de_parte( costo_mano_de_obra, id_mecanico, id_factura, id_patente,id_hoja) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			
			stmt.setFloat(1, hoja.getCostoManoDeObra());
			stmt.setInt(2, (int) hoja.getMecanico().getID());
			stmt.setInt(3, (int) hoja.getFactura().getID());
			stmt.setString(4,(String) hoja.getAutomovil().getID());
			stmt.setInt(5, (int) hoja.getID());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
               hoja.setID(keyResultSet.getInt(1));
            }
	        }
		
		catch(SQLException e)
		{
			   e.printStackTrace();
		}
		
		finally 
		{
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		
	}
	public void Save(entities.HojaDeParte hoja) 
	{
		
		switch(hoja.getState())
		
		{
		case Deleted:
			this.Delete((int) hoja.getID());
		break;
		
		case New:
			this.Insert(hoja);
		break;
		
		case Modified:
			this.Update(hoja);
			break;
		default:
		   hoja.setState(entities.Entity.States.Unmodified);
		   break;
		}
		}

}
