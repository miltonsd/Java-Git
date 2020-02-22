package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Rol;
import entities.Usuario;

public class DataUsuario {
	// Traer todos
	@SuppressWarnings("finally")
	public ArrayList<entities.Usuario> GetAll() {
		ArrayList<entities.Usuario> Usuarios = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {

			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuarios ");
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					entities.Usuario Usuario = new Usuario();
					Usuario.setRol(new Rol());

					Usuario.setID(rs.getInt("id_usuario"));
					Usuario.setDni(rs.getInt("dni"));
					Usuario.setEmail(rs.getString("email"));
					Usuario.setApellido(rs.getString("apellido"));
					Usuario.setNombre(rs.getString("nombre"));
					Usuario.setPassword(rs.getString("password"));
					Usuario.setUser(rs.getString("user"));
					Usuario.getRol().setID(rs.getInt("id_rol"));
					Usuario.setTel(rs.getInt("tel"));
					Usuario.setHabilitado(rs.getBoolean("habilitado"));

					Usuarios.add(Usuario);

				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				FactoryConexion.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return Usuarios;
		}

	}

	// get all por rol
	@SuppressWarnings("finally")
	public ArrayList<entities.Usuario> GetAll(int idrol) {
		ArrayList<entities.Usuario> Usuarios = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {

			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuarios where id_rol = ? ");
			pst.setInt(1, idrol);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					entities.Usuario Usuario = new Usuario();
					Usuario.setRol(new Rol());

					Usuario.setID(rs.getInt("id_usuario"));
					Usuario.setDni(rs.getInt("dni"));
					Usuario.setEmail(rs.getString("email"));
					Usuario.setApellido(rs.getString("apellido"));
					Usuario.setNombre(rs.getString("nombre"));
					Usuario.setPassword(rs.getString("password"));
					Usuario.setUser(rs.getString("user"));
					Usuario.getRol().setID(rs.getInt("id_rol"));
					Usuario.setTel(rs.getInt("tel"));
					Usuario.setHabilitado(rs.getBoolean("habilitado"));

					Usuarios.add(Usuario);

				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				FactoryConexion.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return Usuarios;
		}

	}

	// Traer uno
	@SuppressWarnings("finally")
	public entities.Usuario GetOne(int idusuario) {
		entities.Usuario Usuario = new Usuario();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from usuarios where id_usuario = ?");
			pst.setInt(1, idusuario);
			rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				Usuario.setRol(new Rol());
				Usuario.setID(rs.getInt("id_usuario"));
				Usuario.setDni(rs.getInt("dni"));
				Usuario.setEmail(rs.getString("email"));
				Usuario.setApellido(rs.getString("apellido"));
				Usuario.setNombre(rs.getString("nombre"));
				Usuario.setPassword(rs.getString("password"));
				Usuario.setUser(rs.getString("user"));
				Usuario.getRol().setID(rs.getInt("id_rol"));
				Usuario.setTel(rs.getInt("tel"));
				Usuario.setHabilitado(rs.getBoolean("habilitado"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				FactoryConexion.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return Usuario;
		}

	}

	// Traer uno por email string
	@SuppressWarnings("finally")
	public entities.Usuario getOnePorEmail(String email) {

		entities.Usuario Usuario = new Usuario();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuarios where email = ?");
			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				Usuario.setRol(new Rol());
				Usuario.setID(rs.getInt("id_usuario"));
				Usuario.setDni(rs.getInt("dni"));
				Usuario.setEmail(rs.getString("email"));
				Usuario.setApellido(rs.getString("apellido"));
				Usuario.setNombre(rs.getString("nombre"));
				Usuario.setPassword(rs.getString("password"));
				Usuario.setUser(rs.getString("user"));
				Usuario.getRol().setID(rs.getInt("id_rol"));
				Usuario.setTel(rs.getInt("tel"));
				Usuario.setHabilitado(rs.getBoolean("habilitado"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				FactoryConexion.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return Usuario;
		}

	}

	// ABM

	// Traer parametro
	@SuppressWarnings("finally")
	public String getParametro() {

		String par = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from parametro ");

			rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				par = rs.getString("parametro");
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				FactoryConexion.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();

			}

			return par;
		}

	}

	public void Delete(int ID) {
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from usuarios where id_usuario=?");
			stmt.setInt(1, ID);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Update(entities.Usuario usuario) {
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE usuarios SET habilitado=?,dni=?,email=?,apellido=?,nombre=?,password=?,user=?,id_rol=?,tel=? where id_usuario=?");

			stmt.setBoolean(1, usuario.getHabilitado());
			stmt.setInt(2, usuario.getDni());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getNombre());
			stmt.setString(6, usuario.getPassword());
			stmt.setString(7, usuario.getUser());
			stmt.setInt(8, (int) usuario.getRol().getID());
			stmt.setInt(9, usuario.getTel());
			stmt.setInt(10, (int) usuario.getID());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Insert(entities.Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into usuarios(habilitado ,dni ,email ,apellido ,nombre ,password ,user ,id_rol ,tel) values(?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setBoolean(1, usuario.getHabilitado());
			stmt.setInt(2, usuario.getDni());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getNombre());
			stmt.setString(6, usuario.getPassword());
			stmt.setString(7, usuario.getUser());
			stmt.setInt(8, (int) usuario.getRol().getID());
			stmt.setInt(9, usuario.getTel());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				usuario.setID(keyResultSet.getInt(1));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (keyResultSet != null)
					keyResultSet.close();
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void Save(entities.Usuario usuario) {

		switch (usuario.getState())

		{
		case Deleted:
			this.Delete((int) usuario.getID());
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
