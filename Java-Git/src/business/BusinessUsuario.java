package business;
import java.util.ArrayList;

import data.DataUsuario;
import entities.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

@SuppressWarnings("unused")
public class BusinessUsuario 
{
	private String par;
	DataUsuario du = new DataUsuario();
	
public entities.Usuario getOne(int idusuario)
{
	return 	du.GetOne(idusuario);
}
public entities.Usuario getOnePorEmail(String email)
{
	return 	du.getOnePorEmail(email);
}
public ArrayList<entities.Usuario> getAll()
{
	return 	du.GetAll();
}

public boolean verificarUsuario(Usuario usu) 
{    
	 String sha256hexStr = DigestUtils.sha256Hex(usu.getEmail()+du.getParametro()+usu.getPassword());  
	 if(du.getOnePorEmail(usu.getEmail()).getPassword().equals(sha256hexStr))
	{
		 return true;
	}
	else
	{
		return false;
	}
}

public Usuario encriptarUsuario(Usuario usu)
{    
	 par = du.getParametro();
	 String sha256hexStr = DigestUtils.sha256Hex(usu.getEmail()+par+usu.getPassword()); 
	 usu.setPassword(sha256hexStr);
	 return usu;
	 
}
	


}
