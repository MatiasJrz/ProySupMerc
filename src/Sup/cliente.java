package Sup;

public class cliente {

	


	private String nombre;
	 private long dni;
	 private int edad;
	 private long telef;
	 private String dom;
	 private ListaProductos Carrito;
	
	 public cliente(String nombre, long dni, int edad, long telef, String dom, ListaProductos carrito) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.telef = telef;
		this.dom = dom;
		Carrito = carrito;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getTelef() {
		return telef;
	}

	public void setTelef(long telef) {
		this.telef = telef;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	
//	public String toString() {
//		return "cliente [Nombre=" + nombre + ", DNI=" + dni + ", Edad=" + edad + ", Telefono=" + telef + ", Domicilio=" + dom
//				+ "]";
//	}
	public ListaProductos getCarrito() {
		return Carrito;
	}
	public void setCarrito(ListaProductos carrito) {
		Carrito = carrito;
	}
	

	public String toString() {
			return "cliente [Nombre=" + nombre + ", DNI=" + dni + ", Edad=" + edad + ", Telefono=" + telef + ", Domicilio=" + dom
				+ " ]";
	} 
}
