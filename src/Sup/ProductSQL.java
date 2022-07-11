package Sup;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProductSQL {

	private Conexion conexion;
	private String sql;
	
	public ProductSQL(){
		super();
		this.conexion = new Conexion("supermerc");
		this.conexion.connect();//Abre la conexion
		this.sql="";
	}
	
	public void InsertarProd(producto producto) {
		this.sql = "INSERT INTO producto"+
				"(nombre,cantidad,precio,codigo)"+
				"VALUE ('"+
				producto.getNombre()+"',"+
				producto.getCant()+","+
				producto.getPrecio()+","+
				producto.getCod()+")";
		try {
			conexion.getStmt().executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Producto registrado");
		}
	}
	
	public void DescontarStock(producto producto) {
		
		int cant=producto.getCant();
		this .sql = " UPDATE producto SET cantidad = cantidad - "+cant+" WHERE codigo = "+producto.getCod()+"";
//		
		try {
			conexion.getStmt().executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Producto actualizado");
		}
	}
	public void AumentarStock() {
		
		Scanner sc= new Scanner (System.in);
		
		
		System.out.println("Ingrese el codigo del producto que quiere aumentar el stock ");
		int cod= sc.nextInt();
		this .sql = "SELECT codigo FROM producto WHERE codigo = "+cod+"";

		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		}catch(SQLException e) {
			e.printStackTrace();
		
		}finally {
			
			ResultSet rs=conexion.getRs();
			try {
				if(rs.next()) {
					int codt=rs.getInt("codigo");
					if(codt==cod) {
						System.out.println("Cuantos quiere ingresar ?: ");
						int cant= sc.nextInt();
						this.sql="UPDATE producto SET cantidad= cantidad + "+cant+" WHERE codigo ="+cod+"";
						conexion.getStmt().executeUpdate(sql);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producto actualizado");
		}
	}
	
	public void InsertarProdTe() {
		Scanner sc= new Scanner (System.in);
		ProductSQL pro = new ProductSQL();
		
		System.out.println("Nuevo Producto");
		
		

		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Cantidad: ");
		int cant= sc.nextInt();
		
		System.out.println("Codigo: ");
		int cod= sc.nextInt();
		
		System.out.println("Precio: ");
		double precio = sc.nextDouble();
		producto nuevo= new producto(nombre,cant,precio,cod);
		
		pro.InsertarProd(nuevo);
	}
//	public void actualizar() {
//		Scanner sc = new Scanner (System.in);
//		ProductSQL pro = new ProductSQL();
//		
//		System.out.println("Nombre: ");
//		String nombre = sc.nextLine();
//		
//		System.out.println("Cantidad: ");
//		int cant= sc.nextInt();
//		producto nuevo= new producto(nombre,cant,,cod);
//	}
	
	public ListaProductos ConsultarProductos() {
		ListaProductos ListaP = new ListaProductos();
		this.sql="SELECT * FROM producto";
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			ResultSet rs=conexion.getRs();
			try {
				while(rs.next()) {
					producto pro = new producto(
							
							rs.getString("nombre"),
							rs.getInt("cantidad"),
							rs.getInt("precio"),
							rs.getInt("codigo"));
					ListaP.AgregarProducto(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ListaP;
	}
}
