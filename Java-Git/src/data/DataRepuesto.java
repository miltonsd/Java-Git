package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Repuesto;

public class DataRepuesto
{
	// Traer todos
		@SuppressWarnings("finally")
		public ArrayList<entities.Repuesto> GetAll()
		{
			ArrayList<entities.Repuesto> repuestos = new ArrayList<>() ;
			PreparedStatement pst=null;
			ResultSet rs=null;
			
			try 
			{
			    pst= FactoryConexion.getInstancia().getConn().prepareStatement
						("select * from repuestos ");
	           
				rs= pst.executeQuery();
				if(rs!=null) 
				{
					while(rs.next()) 
				   {
						entities.Repuesto repuesto = new Repuesto();
						repuesto.setID(rs.getInt("id_repuesto"));
						repuesto.setDescripcion(rs.getString("descripcion"));
						repuesto.getTipoRepuesto().setID(rs.getInt("id_tipo_repuesto"));
						repuesto.setPrecioUnitario(rs.getFloat("precio_unitario"));
						repuesto.getProveedor().setID(rs.getInt("cuit"));
						repuesto.setStock(rs.getInt("stock"));
						repuesto.setPuntoPedido(rs.getInt("punto_pedido"));
						repuestos.add(repuesto);
						
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
				
				return repuestos;
	    	}
					
		}

		// Traer uno
		@SuppressWarnings("finally")
		public entities.Repuesto GetOne(int idrepuesto)
		{
			entities.Repuesto repuesto = new entities.Repuesto() ;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try 
			{
			    pst= FactoryConexion.getInstancia().getConn().prepareStatement
						("select * from repuestos where id_repuesto = ?");
	            pst.setInt(1, idrepuesto);
				rs= pst.executeQuery();
				if(rs!=null && rs.next())  
				{
					    repuesto.setID(rs.getInt("id_repuesto"));
						repuesto.setDescripcion(rs.getString("descripcion"));
						repuesto.getTipoRepuesto().setID(rs.getInt("id_tipo_repuesto"));
						repuesto.setPrecioUnitario(rs.getFloat("precio_unitario"));
						repuesto.getProveedor().setID(rs.getInt("cuit"));
						repuesto.setStock(rs.getInt("stock"));
						repuesto.setPuntoPedido(rs.getInt("punto_pedido"));
						
					
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
				
				return repuesto;
	    	}
				
		}

		//ABM
		
		public void Delete(int ID)
		{ 
		  PreparedStatement stmt= null;
			try 
			{				
				stmt=FactoryConexion.getInstancia().getConn().
						prepareStatement("delete from repuestos where id_repuesto=?");
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
		public void Update(entities.Repuesto repuesto)
		{
			PreparedStatement stmt= null;
			
			try 
			{				
				stmt=FactoryConexion.getInstancia().getConn().
						prepareStatement("UPDATE repuestos SET descripcion = ?,stock = ?,punto_pedido=?, precio_unitario = ?,id_tipo_repuesto= ?,cuit = ? where id_repuesto = ?");
				
				stmt.setString(1, repuesto.getDescripcion());
				stmt.setInt(2, repuesto.getStock());
				stmt.setInt(3, repuesto.getPuntoPedido());
				stmt.setFloat(4, repuesto.getPrecioUnitario());
				stmt.setInt(5,(int) repuesto.getTipoRepuesto().getID());
				stmt.setInt(6,(int) repuesto.getProveedor().getID());
				stmt.setInt(7,(int) repuesto.getID());
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
		public void Insert(entities.Repuesto repuesto)
		{  
		   PreparedStatement stmt= null;
		   ResultSet keyResultSet=null;
			try {
				stmt=FactoryConexion.getInstancia().getConn().
						prepareStatement(
								"insert into repuestos( descripcion, stock, punto_pedido, precio_unitario, id_tipo_repuesto , cuit) values(?,?,?,?,?,?)",
								PreparedStatement.RETURN_GENERATED_KEYS
								);
				
				
				stmt.setString(1, repuesto.getDescripcion());
				stmt.setInt(2, repuesto.getStock());
				stmt.setInt(3, repuesto.getPuntoPedido());
				stmt.setFloat(4, repuesto.getPrecioUnitario());
				stmt.setInt(5, (int) repuesto.getTipoRepuesto().getID());
				stmt.setInt(6, (int) repuesto.getProveedor().getID());
				stmt.executeUpdate();
				
				keyResultSet=stmt.getGeneratedKeys();
	            if(keyResultSet!=null && keyResultSet.next())
	            {
	                repuesto.setID(keyResultSet.getInt(1));
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
		public void Save(entities.Repuesto repuesto) 
		{
			
			switch(repuesto.getState())
			
			{
			case Deleted:
				this.Delete((int)repuesto.getID());
			break;
			
			case New:
				this.Insert(repuesto);
			break;
			
			case Modified:
				this.Update(repuesto);
				break;
			default:
			   repuesto.setState(entities.Entity.States.Unmodified);
			   break;
			}
			
			
		}
		
	
	
	
}
