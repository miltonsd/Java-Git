package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.HojaDeParte;
import entities.HojaRepuesto;
import entities.Repuesto;

public class DataHojaRepuesto {
	// Traer todos
	@SuppressWarnings("finally")
	public ArrayList<entities.HojaRepuesto> GetAll() {
		ArrayList<entities.HojaRepuesto> hojarepuestos = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = FactoryConexion.getInstancia().getConn().prepareStatement("select * from hoja_repuestos ");

			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					entities.HojaRepuesto hojarepuesto = new HojaRepuesto();
					hojarepuesto.setHojaDeParte(new HojaDeParte());
					hojarepuesto.getHojaDeParte().setID(rs.getInt("id_hoja"));
					hojarepuesto.setRepuesto(new Repuesto());
					hojarepuesto.getRepuesto().setID(rs.getInt("id_repuesto"));
					hojarepuesto.setCantidad(rs.getInt("cantidad"));
					hojarepuesto.setPrecioTotal(rs.getFloat("precio_total"));
					hojarepuestos.add(hojarepuesto);

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

			return hojarepuestos;
		}

	}

	public ArrayList<entities.HojaRepuesto> GetAll(int id_hoja) {
		ArrayList<entities.HojaRepuesto> hojarepuestos = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from hoja_repuestos  where id_hoja = ?");
			pst.setInt(1, id_hoja);

			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					entities.HojaRepuesto hojarepuesto = new HojaRepuesto();
					hojarepuesto.setHojaDeParte(new HojaDeParte());
					hojarepuesto.getHojaDeParte().setID(rs.getInt("id_hoja"));
					hojarepuesto.setRepuesto(new Repuesto());
					hojarepuesto.getRepuesto().setID(rs.getInt("id_repuesto"));
					hojarepuesto.setCantidad(rs.getInt("cantidad"));
					hojarepuesto.setPrecioTotal(rs.getFloat("precio_total"));
					hojarepuestos.add(hojarepuesto);

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

			return hojarepuestos;
		}

	}

	// Traer uno
	@SuppressWarnings("finally")
	public entities.HojaRepuesto GetOne(int id_hoja, int id_repuesto) {
		entities.HojaRepuesto hojarepuesto = new entities.HojaRepuesto();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from hoja_repuestos where id_hoja = ? and id_repuesto = ?");
			pst.setInt(1, id_hoja);
			pst.setInt(2, id_repuesto);
			rs = pst.executeQuery();
			if (rs != null && rs.next()) {

				hojarepuesto.setHojaDeParte(new HojaDeParte());
				hojarepuesto.getHojaDeParte().setID(rs.getInt("id_hoja"));
				hojarepuesto.setRepuesto(new Repuesto());
				hojarepuesto.getRepuesto().setID(rs.getInt("id_repuesto"));
				hojarepuesto.setCantidad(rs.getInt("cantidad"));
				hojarepuesto.setPrecioTotal(rs.getFloat("precio_total"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

			return hojarepuesto;
		}

	}

	// ABM

	public void Delete(HojaRepuesto hojarepuesto) {
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("delete from hoja_repuestos where id_hoja=? and id_repuesto = ?");
			stmt.setInt(1, (int) hojarepuesto.getHojaDeParte().getID());
			stmt.setInt(2, (int) hojarepuesto.getRepuesto().getID());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Update(entities.HojaRepuesto hojarepuesto) {
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE hoja_repuestos SET cantidad=?, precio_total=? where  id_repuesto =? and id_hoja = ?");

			stmt.setInt(1, hojarepuesto.getCantidad());
			stmt.setFloat(2, hojarepuesto.getPrecioTotal());
			stmt.setInt(3, (int) hojarepuesto.getRepuesto().getID());
			stmt.setInt(4, (int) hojarepuesto.getHojaDeParte().getID());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FactoryConexion.getInstancia().releaseConn();
		}

	}

	public void Insert(entities.HojaRepuesto hojarepuesto) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into hoja_repuestos(id_hoja, id_repuesto, cantidad, precio_total) values(?,?,?,?)");

			stmt.setFloat(4, hojarepuesto.getPrecioTotal());
			stmt.setInt(2, (int) hojarepuesto.getRepuesto().getID());
			stmt.setInt(1, (int) hojarepuesto.getHojaDeParte().getID());
			stmt.setInt(3, (int) hojarepuesto.getCantidad());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				hojarepuesto.setID(keyResultSet.getInt(1));
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

	public void Save(entities.HojaRepuesto hojarepuesto) {

		switch (hojarepuesto.getState())

		{
		case Deleted:
			this.Delete(hojarepuesto);
			break;

		case New:
			this.Insert(hojarepuesto);
			break;

		case Modified:
			this.Update(hojarepuesto);
			break;
		default:
			hojarepuesto.setState(entities.Entity.States.Unmodified);
			break;
		}
	}
}
