package Sup;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SQLUsuarios {
	
	private Conexion conexion;
	private String sql;
	public SQLUsuarios(){
		
	this.conexion = new Conexion("supermerc");
	this.conexion.connect();//Abre la conexion
	this.sql="";
	}
	Scanner sc= new Scanner (System.in);
	
	public void registrarUs(Usuario usr) {
		
		
		this.sql="INSERT INTO usuarios"+
				"(nomuser,pass,nombre,correo,id_tipo)"
				+ " VALUES ('"+
				usr.getNomUser()+"','"+
				usr.getPass()+"','"+
				usr.getNombre()+"','"+
				usr.getCorreo()+"',"+
				usr.getId_tipo()+")";
		
		try {
			conexion.getStmt().executeUpdate(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			System.out.println("Usuario registrado");
		}
	}
	
	
	
	
	public int InicSec() {
		int idT=0;
		System.out.println("Nombre Usuario: ");
		String nom = sc.nextLine();
		
		System.out.println("Contraseña: ");
		String p = sc.nextLine();
		this.sql="SELECT id, nomuser, pass, nombre , correo, id_tipo FROM usuarios WHERE nomuser='"+nom+"' AND pass='"+p+"'";
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ResultSet rs=conexion.getRs();
			try {
				if(rs.next()) 
					idT = rs.getInt("id_tipo");
					
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return idT;
		
	}
//	public void IniciarSec() {
//		ListaCliente ListaC= new ListaCliente();
//		System.out.println("Nombre Usuario: ");
//		String nom = sc.nextLine();
//		
//		System.out.println("Contraseña: ");
//		String p = sc.nextLine();
//		this.sql="SELECT id, nomuser, pass, nombre , correo, id_tipo FROM usuarios WHERE nomuser='"+nom+"' AND pass='"+p+"'";
//		try {
//			conexion.setRs(conexion.getStmt().executeQuery(sql));
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//		
//			ResultSet rs=conexion.getRs();
//			try {
//				if(rs.next()) {
//					int idT = rs.getInt("id_tipo");
//					if(idT==2) {
//						
//						System.out.println("Sesion iniciada:");
//						ListaC=menuCliente();
//					}
//					else if(idT==1) {
//						System.out.println("Sesion iniciada:");
//					
//						
//						menuAdmin(ListaC);
//					}
//					
//					
//				}
//				else System.out.println("Usuario o contraseña incorrecto");
////				
//			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//	}
	public void guardar() {
		
		SQLUsuarios user = new SQLUsuarios();
		
		System.out.println("Nuevo Usuario");
		
		

		System.out.println("Nombre Usuario: ");
		String nomUser = sc.nextLine();
		
		System.out.println("Contraseña: ");
		String pass = sc.nextLine();
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Correo:  ");
		String correo = sc.nextLine();
		
		 int id_tipo = 2;
		Usuario nuevo= new Usuario(nomUser,pass,nombre,correo,id_tipo);
		
		user.registrarUs(nuevo);
	}
	public  void menuCliente(ListaCliente ListaC) {
		 Scanner sn = new Scanner(System.in);
	        boolean salir = false;
	        int opcion,i;
	        double total; //Guardaremos la opcion del usuario
//	        ListaCliente  ListaC = new ListaCliente();
	        ListaProductos ListaP = new ListaProductos();
    		ListaProductos carrito = new ListaProductos();
	        while (!salir) {
	 
	            System.out.println("1. Agregar Productos al carrito");
	            
	            System.out.println("2. Ver productos seleccionados");
	            System.out.println("3. Confirmar compra");
	            System.out.println("4. Salir");
	            try {
	 
	                System.out.println("Escribe una de las opciones");
	                opcion = sn.nextInt();
	                ProductSQL LP = new ProductSQL();
	        		
	        		ListaP=LP.ConsultarProductos();
	                switch (opcion) {
	                    case 1:
	                        System.out.println("Has seleccionado la opcion 1");
	                        
	                        System.out.println("Lista de productos: ");
	                    	ListaP.MostrarProducto();
	                    	carrito=ListaP.SelecProdu();
		                    
	                    	
	                        break;
	                    case 2: 
                				if(carrito.cant_lisP()>0) {
                				System.out.println("Productos seleccionados");	
	                    		carrito.MostrarProducto();}
                				else System.out.println("No has seleccionado productos todavia");
                				
                				break;
                				
	                    case 3: 
	                    		if(carrito.cant_lisP()>0) {
	                    			total=0;
	                    			for(i=0;i<carrito.cant_lisP();i++) {
	                    				total=total+carrito.get(i).getPrecio();
	                    			}
	                    			System.out.println("Total a pagar:$ "+total);
	                    			System.out.println("Desea comprar los productos seleccionados?\n1)Si)2)No");
	                    			int res=sc.nextInt();
	                    			sc.nextLine();
	                    			if(res==1) {
	                    				ListaC.AgregarCliente(carrito);
	                    				ListaC.MostrarCliente();
	                    				for(i=0;i<carrito.cant_lisP();i++)
	                    					LP.DescontarStock(carrito.get(i));
	                    			}
	                    			else System.out.println("Se cancelo la compra");
	                    		}
	                    		else System.out.println("El carrito esta vacio");
	                    		
	                    		break;
	                    case 4:
	                    	
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
	public void menuAdmin(ListaCliente ListaC) {
		 Scanner sn = new Scanner(System.in);
	        boolean salir = false;
	        int opcion; //Guardaremos la opcion del usuario
	 
	        while (!salir) {
	 
	            System.out.println("1. Ver todos los productos");
	            System.out.println("2. Registrar producto");
	            System.out.println("3. Aumentar Stock de un producto");
	            System.out.println("4. Ver Cliente que realizaron una compra y su productos seleccionados");
	            System.out.println("5. Salir");
	 
	            try {
	 
	                System.out.println("Escribe una de las opciones");
	                opcion = sn.nextInt();
	                ProductSQL LP = new ProductSQL();
	        		ListaProductos ListaP = new ListaProductos();
	                switch (opcion) {
	                    case 1:
	                        System.out.println("Has seleccionado la opcion 1");
	                        
	                        ListaP=LP.ConsultarProductos();
	                    	ListaP.MostrarProducto();
	                        break;
	                    case 2: LP.InsertarProdTe();
	                    	break;
	                    case 3: LP.AumentarStock();break;
	                    case 4: if(ListaC.cant_lisC()>0) {
            				System.out.println("Lista de clientes");	
                    		ListaC.MostrarCliente();
                    		
                    		}
            				else System.out.println("Ningun cliente realizo una compra");break;
	                    case 5:
	                        salir = true;
	                        break;
	                    default:
	                        System.out.println("Solo números entre 1 y 2");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                sn.next();
	            }
	        }
	}
}
