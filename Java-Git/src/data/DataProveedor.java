package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Proveedor;
import entities.TipoRepuesto;

public class DataProveedor {
	// Traer todos
				@SuppressWarnings("finally")
				public ArrayList<entities.Proveedor> GetAll()
				{
					ArrayList<entities.Proveedor> proveedores = new ArrayList<>() ;
					PreparedStatement pst=null;
					ResultSet rs=null;
					
					try 
					{
					    pst= FactoryConexion.getInstancia().getConn().prepareStatement
								("select * from proveedores ");
			           
						rs= pst.executeQuery();
						if(rs!=null) 
						{
							while(rs.next()) 
						   {							
								entities.Proveedor proveedor = new Proveedor();
								proveedor.setID(rs.getInt("cuit"));
								proveedor.setDireccion(rs.getString("direccion"));
								proveedor.setEmail(rs.getString("email"));
								proveedor.setRazonSocial(rs.getString("razon_social"));
								proveedor.setTel(rs.getInt("tel"));
								proveedores.add(proveedor);
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
						
						return proveedores;
			    	}
							
				}

				// Traer uno
				@SuppressWarnings("finally")
				public entities.Proveedor GetOne(int cuit)
				{
					entities.Proveedor proveedor = new Proveedor();
					PreparedStatement pst=null;
					ResultSet rs=null;
					try 
					{
					    pst= FactoryConexion.getInstancia().getConn().prepareStatement
								("select * from proveedores where cuit = ?");
			            pst.setInt(1, cuit);
						rs= pst.executeQuery();
						if(rs!=null && rs.next())  							
						{							
							proveedor.setID(rs.getInt("cuit"));
							proveedor.setDireccion(rs.getString("direccion"));
							proveedor.setEmail(rs.getString("email"));
							proveedor.setRazonSocial(rs.getString("razon_social"));
							proveedor.setTel(rs.getInt("tel"));							
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
						
						return proveedor;
			    	}
						
				}

}
