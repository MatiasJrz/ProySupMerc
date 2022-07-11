package Sup;
import java.util.ArrayList;
import java.util.Scanner;
public class ListaProductos {
	Scanner sc= new Scanner (System.in);
	private ArrayList<producto> ListaP;
	
	public int cont;
	public ListaProductos() {
		ListaP = new ArrayList<>();
	}
	public void AgregarProducto(producto nuevo) {
		
		ListaP.add(nuevo);
		
	}

		
	
	public ListaProductos SelecProdu() {
		short op;
		int pos,cant;
		ListaProductos carrito = new ListaProductos();
		cont=0;
		do {
			System.out.println("\nPresione el numero del producto que quiere agregar a su carrito");	
			pos= sc.nextInt();
			while(pos>ListaP.size()) {
				System.out.println("\nIntente de nuevo: ");
				pos= sc.nextInt();
				
			}
			System.out.println("Stock disponible del producto: "+ListaP.get(pos).getCant());
			System.out.println("Cuantos desea agregar?");
			cant=sc.nextInt();
			
			while(ListaP.get(pos).getCant()<cant) {
				System.out.println("La cantidad ingresada excede el stock disponible");
				System.out.println("\nIntente de nuevo: ");
				cant= sc.nextInt();
				
			}
			sc.nextLine();
			producto pro= ListaP.get(pos);
			pro.setCant(cant);
			carrito.AgregarProducto(pro);
			
			
			System.out.println("Desea seguir agregando productos?\n1)Seguir agregando\n2)Salir ");
			op=sc.nextShort();
		}while(op!=2);
		return carrito;
	}
	public void MostrarProducto() {
		for(int i=0;i<ListaP.size();i++) {
			System.out.print(i);
			System.out.println(ListaP.get(i));
		}
	}
	
	public int cant_lisP() {
		return ListaP.size();
	}
	public producto get(int i) {
		// TODO Auto-generated method stub
		return ListaP.get(i);
	}
}
