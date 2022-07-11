package Sup;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner (System.in);
		
		SQLUsuarios user = new SQLUsuarios();
		ProductSQL LP = new ProductSQL();
		ListaProductos ListaP = new ListaProductos();
		ListaCliente ListaC= new ListaCliente();
		
		 Scanner sn = new Scanner(System.in);
	        boolean salir = false;
	        int opcion; //Guardaremos la opcion del usuario
	 
	        while (!salir) {
	 
	            System.out.println("1. Iniciar Seccion");
	            System.out.println("2. Registrarse");
	            System.out.println("3. Salir");
	 
	            try {
	 
	                System.out.println("Escribe una de las opciones");
	                opcion = sn.nextInt();
	 
	                switch (opcion) {
	                    case 1:
	                        System.out.println("Has seleccionado la opcion 1");
	                        
	                        switch(user.InicSec()) {
	                        case 1: user.menuAdmin(ListaC);break;
	                        case 2: user.menuCliente(ListaC);break;
	                        default : System.out.println("El usuario o contraseña incorrectos");break;
	                        }
	                        break;
	                    case 2:
	                        System.out.println("Has seleccionado la opcion 2");
	                        user.guardar();
	                        break;
	                    
	                    case 3:
	                        salir = true;
	                        break;
	                    default:
	                        System.out.println("Solo números entre 1 y 3");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                sn.next();
	            }
	        }
	        
	}

}
