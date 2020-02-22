package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Automovil;
import entities.Usuario;

@SuppressWarnings("unused")
public class DataAutomovil {

	// Traer todos
	@SuppressWarnings("finally")
	public ArrayList<Automovil> GetAll() {
		ArrayList<Automovil> autos = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from automoviles");

			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					entities.Automovil auto = new Automovil();
					auto.setCliente(new Usuario());
					auto.getCliente().setID(rs.getInt("id_usuario"));
					auto.setColor(rs.getString("color"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setID(rs.getString("id_patente"));
					autos.add(auto);

				}

			}
		} catch (SQLException e) {
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

			return autos;
		}

	}

	// Traer todos
	@SuppressWarnings("finally")
	public ArrayList<Automovil> GetAll(int idusuario) {
		ArrayList<Automovil> autos = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from automoviles where id_usuario = ?");
			pst.setInt(1, idusuario);
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					entities.Automovil auto = new Automovil();
					auto.setCliente(new Usuario());
					auto.getCliente().setID(rs.getInt("id_usuario"));
					auto.setColor(rs.getString("color"));
					auto.setMarca(rs.getString("marca"));
					auto.setModelo(rs.getString("modelo"));
					auto.setID(rs.getString("id_patente"));
					autos.add(auto);

				}

			}
		} catch (SQLException e) {
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

			return autos;
		}

	}

	// Traer uno
	@SuppressWarnings("finally")
	public entities.Automovil GetOne(String nropatente) {
		entities.Automovil auto = new entities.Automovil();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from automoviles where id_patente = ?");
			pst.setString(1, nropatente);
			rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				auto.setCliente(new Usuario());
				auto.getCliente().setID(rs.getInt("id_usuario"));
				auto.setColor(rs.getString("color"));
				auto.setMarca(rs.getString("marca"));
				auto.setModelo(rs.getString("modelo"));
				auto.setID(rs.getString("id_patente"));

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

			return auto;
		}

	}

	// ABM

	public void Delete(String ID) {
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("delete from automoviles where id_patente=?");
			stmt.setString(1, ID);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Update(entities.Automovil auto) {
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE automoviles SET id_usuario = ? ,color = ? ,marca = ?,modelo= ? where id_patente = ?");

			stmt.setInt(1, (int) auto.getCliente().getID());
			stmt.setString(2, auto.getColor());
			stmt.setString(3, auto.getMarca());
			stmt.setString(4, auto.getModelo());
			stmt.setString(5, (String) auto.getID());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Insert(entities.Automovil auto) {
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into automoviles(id_patente,color ,marca ,modelo ,id_usuario) values(?,?,?,?,?)");

			stmt.setInt(5, (int) auto.getCliente().getID());
			stmt.setString(2, auto.getColor());
			stmt.setString(3, auto.getMarca());
			stmt.setString(4, auto.getModelo());
			stmt.setString(1, (String) auto.getID());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Save(entities.Automovil auto) {

		switch (auto.getState())

		{
		case Deleted:
			this.Delete((String) auto.getID());
			break;

		case New:
			this.Insert(auto);
			break;

		case Modified:
			this.Update(auto);
			break;
		default:
			auto.setState(entities.Entity.States.Unmodified);
			break;
		}

	}

}
