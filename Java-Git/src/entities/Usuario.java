package entities;

public class Usuario extends Entity
{
	private int _idusuario;
	private String _nombre;
	private String _apellido;
	private int _dni;
	private String _email;
	private int _tel;
	private String _user;
	private String _password;
	private int _rol;
	private Boolean _habilitado;
	
	public int getIDUsuario() {
		return _idusuario;
	}
	public void setIDUsuario(int id_usuario) {
		this._idusuario = id_usuario;
	}
	public String getNombre() {
		return _nombre;
	}
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	public String getApellido() {
		return _apellido;
	}
	public void setApellido(String apellido) {
		this._apellido = apellido;
	}
	public int getDni() {
		return _dni;
	}
	public void setDni(int dni) {
		this._dni = dni;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		this._email = email;
	}
	public int getTel() {
		return _tel;
	}
	public void setTel(int tel) {
		this._tel = tel;
	}
	public String getUser() {
		return _user;
	}
	public void setUser(String user) {
		this._user = user;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String password) {
		this._password = password;
	}
	public int getRol() {
		return _rol;
	}
	public void setRol(int idrol) {
		this._rol = idrol;
	}
	public Boolean getHabilitado() {
		return _habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this._habilitado = habilitado;
	}
}
