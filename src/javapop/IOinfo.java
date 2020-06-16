
package javapop;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 * 
 * @version v2.0 06/2019
 */

public class IOinfo implements Serializable{

    public static void guardarClientes(ArrayList<Cliente> listaClientes) {
        try {

            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(".\\src\\javapop\\datos\\listaClientes.dat"));
            escribirFichero.writeObject(listaClientes);
            escribirFichero.close();

        } catch (Exception e) {
            System.out.println("Error guardar clientes");
        }
    }

    public static ArrayList<Cliente> leerListaClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            ObjectInputStream leerFicheros = new ObjectInputStream(new FileInputStream(".\\src\\javapop\\datos\\listaClientes.dat"));

            listaClientes = (ArrayList<Cliente>) leerFicheros.readObject();
            leerFicheros.close();
            return listaClientes;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo listaClientes no ha sido encontrado, pruebe a ejecutar de nuevo el programa");
            return listaClientes;
        } catch (Exception e) {
            //System.out.println("Error lectura clientes(Es posible que no haya ningún cliente registrado)");
            System.out.println(e.toString());
            return listaClientes;
        }

    }

    /*public static void guardarClientesProfesionales(ArrayList<ClienteProfesional> listaClientesProfesionales) {
        try {

            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(".\\src\\javapop\\datos\\listaClientesProfesionales.dat"));
            escribirFichero.writeObject(listaClientesProfesionales);
            escribirFichero.close();

        } catch (Exception e) {
            System.out.println("Error lectura clientesProfesionales");// ESTO ES TEMPORAL, ARREGLALO PUTO VAGO
        }
    }

    public static ArrayList<ClienteProfesional> leerListaClientesProfesionales() {
        ArrayList<ClienteProfesional> listaClientesProfesionales = new ArrayList<ClienteProfesional>();
        try {
            ObjectInputStream leerFicheros = new ObjectInputStream(new FileInputStream(".\\src\\javapop\\datos\\listaClientesProfesionales.dat"));

            listaClientesProfesionales = (ArrayList<ClienteProfesional>) leerFicheros.readObject();
            leerFicheros.close();
            return listaClientesProfesionales;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo listaClientesProfesionales no ha sido encontrado, pruebe a ejecutar de nuevo el programa");
            return listaClientesProfesionales;
        } catch (Exception e) {
            //System.out.println("Error lectura clientes(Es posible que no haya ningún cliente registrado)");
            System.out.println(e.toString());
            return listaClientesProfesionales;
        }

    }*/
    public static void guardarProductos(ArrayList<Producto> listaProductos) {
        try {

            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(".\\src\\javapop\\datos\\listaProductos.dat"));
            escribirFichero.writeObject(listaProductos);
            escribirFichero.close();

        } catch (Exception e) {
            System.out.println("Error guardar Productos");
        }
    }
    public static ArrayList<Producto> leerListaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try {
            ObjectInputStream leerFicheros = new ObjectInputStream(new FileInputStream(".\\src\\javapop\\datos\\listaProductos.dat"));

            listaProductos = (ArrayList<Producto>) leerFicheros.readObject();
            leerFicheros.close();
            return listaProductos;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo listaProductos no ha sido encontrado, pruebe a ejecutar de nuevo el programa");
            return listaProductos;
        } catch (Exception e) {
            //System.out.println("Error lectura clientes(Es posible que no haya ningún cliente registrado)");
            System.out.println(e.toString());
            return listaProductos;
        }
}
    
    
    public static void guardarVentas(ArrayList<Venta> listaVentas) {
        try {

            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(".\\src\\javapop\\datos\\listaVentas.dat"));
            escribirFichero.writeObject(listaVentas);
            escribirFichero.close();

        } catch (Exception e) {
            System.out.println("Error guardar ventas");
        }
    }
    
        public static ArrayList<Venta> leerListaVentas() {
        ArrayList<Venta> listaVentas = new ArrayList<Venta>();
        try {
            ObjectInputStream leerFicheros = new ObjectInputStream(new FileInputStream(".\\src\\javapop\\datos\\listaVentas.dat"));

            listaVentas = (ArrayList<Venta>) leerFicheros.readObject();
            leerFicheros.close();
            return listaVentas;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo listaVentas no ha sido encontrado, pruebe a ejecutar de nuevo el programa");
            return listaVentas;
        } catch (Exception e) {
            //System.out.println("Error lectura clientes(Es posible que no haya ningún cliente registrado)");
            System.out.println(e.toString());
            return listaVentas;
        }

    }
}
