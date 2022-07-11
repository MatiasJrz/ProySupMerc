package Sup;

public class producto {

	private String nombre;
	private int cant;
	private int cod;
	private double precio;

	
	public producto(String nombre,int cant,double precio,int cod ) {
		this.nombre=nombre;
		this.cant=cant;
		this.cod=cod;
		this.precio=precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "- Nombre:" + nombre + ", Cantidad:" + cant + ", Codigo:" + cod + ", Precio:$" + precio + "";
	}
		
	
	
	
}
