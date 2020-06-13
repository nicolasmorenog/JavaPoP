/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import static javapop.Variables.listaClientes;


/**
 *
 * @author Jesús Palomino
 */
public class Aplicacion implements Serializable {

    public static Object buscarCorreo(String correo) {

        /*for (ClienteProfesional clienteProfesional : listaClientesProfesionales) {
            if (correo.equals(clienteProfesional.getCorreo())) {
                return clienteProfesional;
            }
        }*/
        
        for (Cliente cliente : listaClientes) {
            if (correo.equals(cliente.getCorreo())) {
                return cliente;
            }
        }
        
        Admin admin = new Admin();
        if (correo.equals(admin.getCorreo())) {
            return admin;
        }

        Object obj = new Object();
        return obj;
    }

    public static boolean correoApto(String correo) {
        Object user = buscarCorreo(correo);
        if (user instanceof Cliente || user instanceof ClienteProfesional || user instanceof Admin) {
            return false;
        }
        return true;
    }

    public static Object buscarTitulo(ArrayList<Producto> listaProductos, String titulo) {
        for (Producto producto : listaProductos) {
            if (producto.equals(producto.getTitulo())) {
                return producto;
            } else {
                System.out.println("El titulo introducido no existe");
            }
        }
        Object obj = new Object();
        return obj;
    }

    public static Object login() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Introduce el correo: ");
            String correo = entrada.readLine();
            System.out.println("Introduce la clave: ");
            String contraseña = entrada.readLine();

            Object user = buscarCorreo(correo);
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                if (contraseña.equals(cliente.getClave())) {
                    return cliente;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
            } else if (user instanceof ClienteProfesional) {
                ClienteProfesional clientepro = (ClienteProfesional) user;
                if (contraseña.equals(clientepro.getClave())) {
                    return clientepro;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (contraseña.equals(admin.getClave())) {
                    return admin;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
            } else {
                System.out.println("El correo indicado no esta asociado a ninguna cuenta de usuario, pruebe a registrarse.");
                return user;
            }
            return user;
        } catch (Exception e) {
            System.out.println("Ha surgido un error: " + e.toString());
            return new Object();
        }
    }

    public static void registrarseCliente() {

        Cliente c1 = new Cliente();
        listaClientes.add(c1);
        System.out.println("El registro se ha llevado a cabo con exito.");

    }

    public static void registrarseClienteProfesional() {
        ClienteProfesional cp1 = new ClienteProfesional();
        //listaClientesProfesionales.add(cp1);
        listaClientes.add(cp1);
        System.out.println("El registro se ha llevado a cabo con exito.");
    }
    
    public static void altaClienteProfesional(Cliente cliente){
       
        ClienteProfesional cp1 = new ClienteProfesional(cliente);   
       
        listaClientes.remove(cliente);
        
        listaClientes.add(cp1);
        
        System.out.println("Se ha dado de alta como cliente profesional con exito.");
        
    }
    
    public static void bajaClienteProfesional(ClienteProfesional clientepro){
        Cliente c1 = new Cliente(clientepro);   
       
        //listaClientesProfesionales.remove(clientepro);
        listaClientes.remove(clientepro);
        
        listaClientes.add(c1);
        
        System.out.println("Se ha dado de baja como cliente profesional con exito.");
    }
}
