package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Proveedor;
import entities.Repuesto;
import entities.TipoRepuesto;

public class DataTipoRepuesto {
	
	// Traer todos
			@SuppressWarnings("finally")
			public ArrayList<entities.TipoRepuesto> GetAll()
			{
				ArrayList<entities.TipoRepuesto> tiporepuesto = new ArrayList<>() ;
				PreparedStatement pst=null;
				ResultSet rs=null;
				
				try 
				{
				    pst= FactoryConexion.getInstancia().getConn().prepareStatement
							("select * from tipo_repuestos ");
		           
					rs= pst.executeQuery();
					if(rs!=null) 
					{
						while(rs.next()) 
					   {							
							entities.TipoRepuesto tr = new TipoRepuesto();
							tr.setID(rs.getInt("id_tipo_repuesto"));
							tr.setDescripcion(rs.getString("descripcion"));
							tiporepuesto.add(tr);
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
					
					return tiporepuesto;
		    	}
						
			}

			// Traer uno
			@SuppressWarnings("finally")
			public entities.TipoRepuesto GetOne(int idtiporepuesto)
			{
				entities.TipoRepuesto tr = new TipoRepuesto();
				PreparedStatement pst=null;
				ResultSet rs=null;
				try 
				{
				    pst= FactoryConexion.getInstancia().getConn().prepareStatement
							("select * from tipo_repuestos where id_tipo_repuesto = ?");
		            pst.setInt(1, idtiporepuesto);
					rs= pst.executeQuery();
					if(rs!=null && rs.next())  
						
					{
						tr.setID(rs.getInt("id_tipo_repuesto"));
						tr.setDescripcion(rs.getString("descripcion"));
						
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
					
					return tr;
		    	}
					
			}


}
