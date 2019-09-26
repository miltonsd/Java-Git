package entities;

import entities.Entity.States;

public class Usuario implements Entity
{
	private int idusuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String email;
	private int tel;
	private String user;
	private String password;
	private Rol rol;
	private Boolean habilitado;
	private States state;
	
	public Object getID()
	{
		return (int) this.idusuario;
	}
	public void setID(Object idusuario)
	{
		if(idusuario.getClass() == Integer.class)
	    {
			this.idusuario=(Integer) idusuario;
	    }
		else
		{	
		new Exception("El ID agregado no pertenece al tipo valido para la clase");	
	    }
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Rol getRol() 
	{
		return this.rol;
	}
	public void setRol(Rol rol)
	{
		this.rol=rol;
	}
	
	public States getState() 
    {
		return this.state;
    }
	public  void setState(States state) 
    {
		this.state = state;
    }
	
	@Override
	public String toString() {
		
		return "Email:   "+ getEmail();
	}
	
	
	
}
