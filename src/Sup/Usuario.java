package Sup;

public class Usuario {
	private String NomUser;
	private String pass;
	private String nombre;
	private String correo;
	private int id_tipo;
	
	public Usuario(String NomUser,String pass, String nombre,String correo,int id_tipo) {
		this.id_tipo=id_tipo;
		this.NomUser=NomUser;
		this.pass=pass;
		this.correo=correo;
		this.nombre=nombre;
	}

	public String getNomUser() {
		return NomUser;
	}

	public void setNomUser(String nomUser) {
		NomUser = nomUser;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
