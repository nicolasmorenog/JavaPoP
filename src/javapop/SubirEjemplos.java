/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.time.LocalDate;
import java.util.ArrayList;
import static javapop.Variables.*;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 * 
 * @version v2.0 06/2019
 */
public class SubirEjemplos {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args){
        // TODO code application logic here
         
        //ArrayList<Venta> registroT = new ArrayList();
        ArrayList<Cliente> listaC = new ArrayList();

        ArrayList<Producto> listaP = new ArrayList();

        //(String correo, String clave, String nombre, String dni, String tarjeta, Ubicacion ubicacion)

        Cliente c1 = new Cliente("alex@gmail.com", "avionetas", "Alex", "03216469 B" , "5291 7509 2363 5061",  new Ubicacion("19002", "Guadalajara" ));

        Cliente c2 = new Cliente("marta@yahoo.com","avionetas", "Marta", "00000000 r", "1234 5678 9123 4567",    new Ubicacion( "19005","Guadalajara"));
        Cliente c3 = new Cliente("carlos@gmail.com","avionetas", "Carlos", "56456465 R","1564 5678 9456 1235", new Ubicacion("19003","Guadalajara"));
        Cliente c4 = new Cliente("cliente@gmail.com","avionetas", "Cliente", "56456465 R","1564 5678 9456 1235", new Ubicacion("19003","Guadalajara"));
        //ClienteProfesional cp1 = new ClienteProfesional("x5432165 r", "Marco", "marco@gmail.com", "111555", new Ubicacion("Malaga", 15006), "5335 7279 5023 9387", "Especialista en electrodomesticos", "08:00-14:00", "(+34) 642 768 482", "electromarco.com");
        //(String titulo, String categoria, String descripcion, String estadoProducto, String fotografia, String precio, Cliente cliente, boolean urgente)
        
        Producto prod1 = new Producto("Ventilador", "Informática y electrónica", "Ligero y ergonomico", "Nuevo",".\\src\\javapop\\ImagenesProductos\\AODHGc4N1H-soup-can.png" ,"25.59", c1, false);
        Producto prod2 = new Producto("Vestido",  "Moda y accesorios", "Rojo y largo", "Nuevo",  ".\\src\\javapop\\ImagenesProductos\\F3d7d3s5X1-niñoPulgar.gif","30", c1, true);
        Producto prod3 = new Producto("iPhone", "Moviles y telefonia","iPhoneX",  "Como nuevo",  ".\\src\\javapop\\ImagenesProductos\\HXjMvktYxC-milk-box-package.png","1000", c2, false);
        Producto prod4 = new Producto("Abrigo", "Moda y accesorios","De piel",  "Regular",  ".\\src\\javapop\\ImagenesProductos\\85s2rsW4vj-barcode-scanner.png","10", c2, true);
        Producto prod5 = new Producto("Samsung S7",  "Moviles y telefonia","sddw","Nuevo",  ".\\JavaPoP\\src\\javapop\\ImagenesProductos\\MT1iwUj17B-pastry-box.png","120",c3,true);
        
        //Venta v1 = new Venta(prod5,c1);
        //c3.setListaProductos(new ArrayList(0));
        
        
        c1.añadirProducto(prod1);
        c1.añadirProducto(prod2);
        c2.añadirProducto(prod3);
        c2.añadirProducto(prod4);
        c3.añadirProducto(prod5);
        
        /*listaProductos.add(prod1);
        listaProductos.add(prod2);
        listaProductos.add(prod3);
        listaProductos.add(prod4);*/
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        listaClientes.add(c4);
        //listaClientes.add(c1);
        
        //registroT.add(v1);
        IOinfo.guardarClientes(listaClientes);
        IOinfo.guardarProductos(listaProductos);

        System.out.println("final programa" + listaClientes);
        //System.out.println("final programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("final programa productos" + listaProductos);
        
    }
}
