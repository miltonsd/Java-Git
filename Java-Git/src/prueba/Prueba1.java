package prueba;
import entities.Entity.States;
import entities.Factura;
import entities.Rol;
import entities.Usuario;
import data.DataFactura;
import data.DataUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

import business.BusinessUsuario;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
public class Prueba1 
{
	private static final States New = null;

	public static void main(String[] args)
	{
		System.out.println("Mostrar todo");
		DataUsuario du= new DataUsuario();
		ArrayList<entities.Usuario> Usuarios = du.GetAll();
	    for(Usuario u : Usuarios) 
	    {System.out.println(u.getEmail());
	    	
	    }
		
	    DataFactura df = new DataFactura();
	    List<entities.Factura> f = df.GetAll();
	    for(Factura x : f)
	    {
	    	System.out.println(x.getImporteTotal());
	    }
	    	System.out.println(df.GetOne(1).getImporteTotal());
	    
		//du.GetAll().forEach((u) -> System.out.println(u.getEmail()));
		
		System.out.println(du.GetOne(4).getEmail());
		System.out.println(du.getOnePorEmail("ale@hotmail.com").getPassword());
		BusinessUsuario bu = new BusinessUsuario();
		
		
		
		
		if(du.getOnePorEmail("ale@hotmail.com").getPassword().equals("ale"))
		{System.out.println("es true2");}
		
		String par = du.getParametro();
		String sha256hexStr = DigestUtils.sha256Hex("admin@hotmail.com"+par+"1234"); 
		System.out.println(sha256hexStr);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        Scanner s=new Scanner(System.in);
		
		/*System.out.println("\nBusca una pesona? (S/N)");
		if(s.nextLine().equalsIgnoreCase("s")) {
			
			Usuario usu=new Usu();
			usu.setDocumento(new Documento());
			
			System.out.print("Tipo doc: ");
			usu.getDocumento().setTipo(s.nextLine());
			System.out.print("Nro doc: ");
			usu.getDocumento().setNro(s.nextLine());
			System.out.println("\nBuscar persona "+
					usu.getDocumento().getTipo()+" "+
					usu.getDocumento().getNro());
			System.out.println(du.getByDocumento(usu));
          
		}
            */
		System.out.println("\nAgrega un usuario? (S/N)");
		if(s.nextLine().equalsIgnoreCase("s")) {
			Usuario usu= new entities.Usuario();
			System.out.println("usuario agregado a la bdd");
			System.out.printf("id " + usu.getID() +"dni" + usu.getDni());
			
			Rol rol = new entities.Rol();
			rol.setID(1);
			usu.setRol(rol);
			usu.setNombre("aaaaaa");
			usu.setID(3);
			usu.setApellido("aleASD");
			usu.setUser("a");
			usu.setPassword("ale");
			usu.setDni(3950232);
			usu.setEmail("al");
			usu.setTel(44444);
			
			
			usu.setHabilitado(true);
			usu.setState(entities.Entity.States.Deleted);
			du.Save(usu);
			System.out.println("usuario agregado a la bdd");
			
			//du.Delete(0);
			
		}
		
		s.close();
		

          }
}
