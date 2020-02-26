package business;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import data.DataUsuario;
import entities.Rol;
import entities.Usuario;

@SuppressWarnings("unused")
public class BusinessUsuario {
	private String par;
	DataUsuario du = new DataUsuario();

	public entities.Usuario getOne(int idusuario) {
		return du.GetOne(idusuario);
	}

	public entities.Usuario getOnePorEmail(String email) {
		return du.getOnePorEmail(email);
	}

	public ArrayList<entities.Usuario> getAll() {
		return du.GetAll();
	}

	public ArrayList<entities.Usuario> getAllPorRol(Rol.Roles rol) {
		int idrol;
		switch (rol) {
		case Mecanico:
			idrol = 1;
		case Cliente:
			idrol = 2;
		case Admin:
			idrol = 3;
		default:
			idrol = 1;
		}
		return du.GetAll(idrol);
	}
/*
	public boolean verificarUsuario(Usuario usu) {
		String sha256hexStr = DigestUtils.sha256Hex(usu.getEmail() + du.getParametro() + usu.getPassword());
		if (du.getOnePorEmail(usu.getEmail()).getPassword().equals(sha256hexStr)) {
			return true;
		} else {
			return false;
		}
	}
*/
	
	public boolean verificarUsuario(Usuario usu) {
		Usuario u= this.getOnePorEmail(usu.getEmail());
		if (u.getPassword().contentEquals(usu.getPassword())){
			return true;
		} else {
			return false;
		}
	}
	
	public Usuario encriptarUsuario(Usuario usu) {
		par = du.getParametro();
		String sha256hexStr = DigestUtils.sha256Hex(usu.getEmail() + par + usu.getPassword());
		usu.setPassword(sha256hexStr);
		return usu;

	}

}
