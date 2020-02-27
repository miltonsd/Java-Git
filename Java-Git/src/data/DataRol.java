package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Rol;

public class DataRol {
	@SuppressWarnings("finally")
	public entities.Rol GetOne(int idRol) {
		entities.Rol rol = new Rol();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from roles where id_rol = ?");
			pst.setInt(1, idRol);
			rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				rol.setID(rs.getInt("id_rol"));
				rol.setDescripcion(rs.getString("descripcion"));
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

			return rol;
		}

	}
}