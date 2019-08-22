package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entities.Usuario;

public class DataUsuario 
{
	// Traer todos
			@SuppressWarnings("finally")
			public ArrayList<entities.Usuario> GetAll()
			{
				ArrayList<entities.Usuario> Usuarios = new ArrayList<>() ;
				PreparedStatement pst=null;
				ResultSet rs=null;
				
				try 
				{
				    pst= FactoryConexion.getInstancia().getConn().prepareStatement
							("select * from usuarios ");
		           
					rs= pst.executeQuery();
					if(rs!=null) 
					{
						while(rs.next()) 
					   {
							entities.Usuario Usuario = new Usuario();
							Usuario.setIDUsuario(rs.getInt("id_usuario"));
							Usuario.setDni(rs.getInt("dni"));
							Usuario.setEmail(rs.getString("email"));
							Usuario.setApellido(rs.getString("apellido"));
							Usuario.setNombre(rs.getString("nombre"));
							Usuario.setPassword(rs.getString("password"));
							Usuario.setUser(rs.getString("user"));
							Usuario.setRol(rs.getInt("id_rol"));
							Usuario.setTel(rs.getInt("tel"));
							Usuario.setHabilitado(rs.getBoolean("habilitado"));
							
							Usuarios.add(Usuario);
							
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
					
					return Usuarios;
		    	}
						
			}

			// Traer uno
			@SuppressWarnings("finally")
			public entities.Usuario GetOne(int  idusuario)
			{
				entities.Usuario Usuario = new Usuario();
				PreparedStatement pst=null;
				ResultSet rs=null;
				try 
				{
				    pst= FactoryConexion.getInstancia().getConn().prepareStatement
							("select * from repuestos where id_repuesto = ?");
		            pst.setInt(1, idusuario);
					rs= pst.executeQuery();
					if(rs!=null && rs.next()) 
					{
						
							Usuario.setIDUsuario(rs.getInt("id_usuario"));
							Usuario.setDni(rs.getInt("dni"));
							Usuario.setEmail(rs.getString("email"));
							Usuario.setApellido(rs.getString("apellido"));
							Usuario.setNombre(rs.getString("nombre"));
							Usuario.setPassword(rs.getString("password"));
							Usuario.setUser(rs.getString("user"));
							Usuario.setRol(rs.getInt("id_rol"));
							Usuario.setTel(rs.getInt("tel"));
							Usuario.setHabilitado(rs.getBoolean("habilitado"));
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
					
					return Usuario;
		    	}
					
			}

			//ABM
			
			public void Delete(int ID)
			{ 
			  PreparedStatement stmt= null;
				try 
				{				
					stmt=FactoryConexion.getInstancia().getConn().
							prepareStatement("delete from usuarios where id_usuario=?");
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
			public void Update(entities.Usuario usuario)
			{
				PreparedStatement stmt= null;
				
				try 
				{				
					stmt=FactoryConexion.getInstancia().getConn().
							prepareStatement("UPDATE usuarios SET habilitado=?,dni=?,email=?,apellido=?,nombre=?,password=?,user=?,id_rol=?,tel=? where id_usuario=?");
					
					stmt.setBoolean(1,usuario.getHabilitado());
					stmt.setInt(2,usuario.getDni());
					stmt.setString(3,usuario.getEmail());
					stmt.setString(4,usuario.getApellido());
					stmt.setString(5,usuario.getNombre());
					stmt.setString(6,usuario.getPassword());
					stmt.setString(7,usuario.getUser());
					stmt.setInt(8,usuario.getRol());
					stmt.setInt(9,usuario.getTel());
					stmt.setInt(10,usuario.getIDUsuario());
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
			public void Insert(entities.Usuario usuario)
			{  
			   PreparedStatement stmt= null;
			   ResultSet keyResultSet=null;
				try {
					stmt=FactoryConexion.getInstancia().getConn().
							prepareStatement(
									"insert into usuarios(habilitado ,dni ,email ,apellido ,nombre ,password ,user ,id_rol ,tel) values(?,?,?,?,?,?,?,?,?)",
									PreparedStatement.RETURN_GENERATED_KEYS);
					
					
					stmt.setBoolean(1,usuario.getHabilitado());
					stmt.setInt(2,usuario.getDni());
					stmt.setString(3,usuario.getEmail());
					stmt.setString(4,usuario.getApellido());
					stmt.setString(5,usuario.getNombre());
					stmt.setString(6,usuario.getPassword());
					stmt.setString(7,usuario.getUser());
					stmt.setInt(8,usuario.getRol());
					stmt.setInt(9,usuario.getTel());
					
					stmt.executeUpdate();
					
					keyResultSet=stmt.getGeneratedKeys();
		            if(keyResultSet!=null && keyResultSet.next())
		            {
		               usuario.setIDUsuario(keyResultSet.getInt(1));
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
			public void Save(entities.Usuario usuario) 
			{
				
				switch(usuario.getState())
				
				{
				case Deleted:
					this.Delete(usuario.getID());
				break;
				
				case New:
					this.Insert(usuario);
				break;
				
				case Modified:
					this.Update(usuario);
					break;
				default:
					usuario.setState(entities.Entity.States.Unmodified);
				   break;
				}
				
				
			}
			

}
