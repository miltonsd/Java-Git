package prueba;
import entities.Entity.States;
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
			
			usu.setNombre("aaaaaa");
			usu.setIDUsuario(1);
			usu.setApellido("ale");
			usu.setUser("a");
			usu.setPassword("ale");
			usu.setDni(3950232);
			usu.setEmail("al");
			usu.setTel(44444);
			usu.setRol(1);
			usu.setHabilitado(true);
			usu.setState(entities.Entity.States.Modified);
			du.Save(usu);
			System.out.println("usuario agregado a la bdd");
			
			//du.Delete(0);
			
		}
		
		s.close();
		

          }
}
