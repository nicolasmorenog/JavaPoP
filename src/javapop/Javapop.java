/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Jesús Palomino
 */
public class Javapop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Cliente> listaClientes = new ArrayList();
        ArrayList<ClienteProfesional> listaClientesProfesionales = new ArrayList();
        ArrayList<Producto> listaProductos = new ArrayList();
        
        listaClientes = IOinfo.leerListaClientes();
        listaClientesProfesionales = IOinfo.leerListaClientesProfesionales();
        listaProductos = IOinfo.leerListaProductos();

        System.out.println("comienzo programa clientes" + listaClientes);
        System.out.println("comienzo programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("comienzo programa productos" + listaProductos);
        
        Ubicacion u1 = new Ubicacion("12345","Guada");
        Cliente c1 = new Cliente("c1@gmail.com", "1234", "cliente1", "1234", "12374859394839", u1);
        
        Producto p1 = new Producto(c1);
        listaProductos.add(p1);

        
        /*Scanner input = new Scanner(System.in);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Object user = new Object();
        int estado= 0;
        boolean terminar = false;
        while (!terminar) {
            // Estado 0: Pantalla de inicio y registro 
            if (estado == 0) {                   
                // Pedimos al usuario que seleccione una operacion a realizar
                
                System.out.println("Elige la accion que deseas realizar (Escribe el numero de la opcion): "
                        + "\n1.-Iniciar sesion "
                        + "\n2.-Registrarse como Usuario "
                        + "\n3.-Registrarse como Usuario Profesional "
                        + "\n4.-Salir\n");
                System.out.print("->");
                int accion = input.nextInt();
                // Ejecutamos esa operacion
                switch (accion) {
                    
                    case 1: // Realizar el "inicio de sesion"
                        user = Aplicacion.login(listaClientes, listaClientesProfesionales);
                            if (user instanceof Cliente){
                                estado = 2;
                                
                            } else if (user instanceof ClienteProfesional){
                                estado = 3;
                            } else if (user instanceof Admin){
                                estado = 1;
                            }
                        break;
                    
                    case 2:// Realizar el "registro de usuario"
                        Aplicacion.registrarseCliente(listaClientes, listaClientesProfesionales);
                        break;
                        
                    case 3:// Salimos del bucle principal
                        Aplicacion.registrarseClienteProfesional(listaClientes, listaClientesProfesionales);
                        break;
                    case 4:
                        terminar = true;
                }
            } else if (estado == 1){
                System.out.println("Bienvenido a la pagina de administrador, seleccione una opcion:"
                        + "\n1.-Consultar usuarios");
                System.out.print("->");
                int accion = input.nextInt();
            }
        }*/
        

        IOinfo.guardarClientesProfesionales(listaClientesProfesionales);
        IOinfo.guardarClientes(listaClientes);
        IOinfo.guardarProductos(listaProductos); 
        
        System.out.println("final programa" + listaClientes);
        System.out.println("final programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("final programa productos" + listaProductos);

    }
}
