package Sup;
import java.util.ArrayList;
import java.util.Scanner;
public class ListaCliente {
	Scanner sc= new Scanner(System.in);
	private ArrayList<cliente> ListCliente;
	
	public ListaCliente() {
		ListCliente = new ArrayList<>();
	}
	
	public void AgregarCliente(ListaProductos carrito) {
		System.out.println("Complete los siguientes datos personales");
		
		
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("DNI: ");
		long dni= sc.nextLong();
		
		System.out.println("Edad: ");
		int edad= sc.nextInt();
		
		System.out.println("Telefono: ");
		long telef = sc.nextLong();sc.nextLine();
		
		System.out.println("Domicilio: ");
		String dom = sc.nextLine();
		
		cliente nuevo= new cliente(nombre,dni,edad,telef,dom,carrito);
		ListCliente.add(nuevo);
		
	}
	public void MostrarCliente() {
		for(int i=0;i<ListCliente.size();i++) {
			System.out.println(ListCliente.get(i));
		}
	}
	public int cant_lisC() {
		return ListCliente.size();
	}
	public cliente get(int i) {
		// TODO Auto-generated method stub
		return ListCliente.get(i);
	}
	
}
