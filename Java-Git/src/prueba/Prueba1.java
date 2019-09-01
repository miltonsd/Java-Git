package prueba;
import entities.Entity.States;
import entities.Rol;
import entities.Usuario;
import data.DataUsuario;
import java.util.Scanner;

public class Prueba1 
{
	private static final States New = null;

	public static void main(String[] args) {
		System.out.println("Mostrar todo");
		DataUsuario du= new DataUsuario();
		for(Usuario u: du.GetAll()) {
			System.out.println(u);
		}
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
