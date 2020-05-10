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
public class Javapop{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Cliente> listaClientes = new ArrayList();
        ArrayList<ClienteProfesional> listaClientesProfesionales = new ArrayList();
        ArrayList<Producto> listaProductos = new ArrayList();
        
<<<<<<< HEAD
=======

>>>>>>> ebcacd194491d6a11247e235f7811d592424e250
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
<<<<<<< HEAD
<<<<<<< HEAD
            switch (estado) {
                case 0: //estado 0: pantalla de inicio de sesion y registro de usuario
                {
                    //le damos al usuario 4 opciones a elegir
                    System.out.println("Elige la accion que deseas realizar (Escribe el numero de la opcion): "
                            + "\n1.-Iniciar sesion "
                            + "\n2.-Registrarse como Cliente "
                            + "\n3.-Registrarse como Cliente Profesional "
                            + "\n4.-Salir\n");
                    System.out.print("->");
                    int accion = input.nextInt();
                    //"switch" para ejecutar la accion que ha elegido dependiendo de su respuesta
                    switch (accion) {

                        case 1: //inicio de sesion
                            user = Aplicacion.login(listaClientes, listaClientesProfesionales);
                            if (user instanceof Cliente) {
                                cliente = (Cliente) user;
                                estado = 2;

                            } else if (user instanceof ClienteProfesional) {
                                clienteProfesional = (ClienteProfesional) user;
                                estado = 3;
                            } else if (user instanceof Admin) {
                                estado = 1;
                            }
                            break;

                        case 2://registrarse como usuario
                            Aplicacion.registrarseCliente(listaClientes, listaClientesProfesionales);
                            break;

                        case 3://registrarse como usuario profesional
                            Aplicacion.registrarseClienteProfesional(listaClientes, listaClientesProfesionales);
                            break;
                        case 4: //salida del bucle "while (!terminar)"
                            terminar = true;
                        default:
                            System.out.println("La opcion elegida no esta disponible.");
                    }
                    break;
=======
            // Estado 0: Pantalla de inicio y registro 
            if (estado == 0) {
                // Pedimos al usuario que seleccione una operacion a realizar

                System.out.println("Elige la accion que deseas realizar (Escribe el numero de la opcion): "
                        + "\n1.-Iniciar sesion "
                        + "\n2.-Registrarse como Cliente "
                        + "\n3.-Registrarse como Cliente Profesional "
                        + "\n4.-Salir\n");
                System.out.print("->");
                int accion = input.nextInt();
                // Ejecutamos esa operacion
                switch (accion) {

                    case 1: // Realizar el "inicio de sesion"
                        user = Aplicacion.login(listaClientes, listaClientesProfesionales);
                        if (user instanceof Cliente) {
                            cliente = (Cliente) user;
                            estado = 2;

                        } else if (user instanceof ClienteProfesional) {
                            clienteProfesional = (ClienteProfesional) user;
                            estado = 3;
                        } else if (user instanceof Admin) {
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
                        break;
                    default:
                        System.out.println("La opcion introducida no es valida");
                       
>>>>>>> ebcacd194491d6a11247e235f7811d592424e250
                }
            } else if (estado == 1) {
                System.out.println("Bienvenido a la pagina de administrador, seleccione una opcion:"
                        + "\n1.-Consultar usuarios"
                        + "\n2.-Consultar productos"
                        + "\n3.-Consultar ventas realizadas"
                        + "\n4. Salir");
                System.out.print("->");
                int accion = input.nextInt();
                switch (accion) {
                    case 1:
                        System.out.println("Lista de todos los usuarios registrados:");
                        for (int i = 0; i < listaClientes.size(); i++) {
                            System.out.println(listaClientes.get(i).getCorreo());
                        }
                        for (int i = 0; i < listaClientesProfesionales.size(); i++) {
                            System.out.println(listaClientesProfesionales.get(i).getCorreo());
                        }
                        System.out.println("Introduzca el correo del cliente que desea consultar: ");
                        try {
                            String correo = entrada.readLine();
                            Object consulta = Aplicacion.buscarCorreo(listaClientes, listaClientesProfesionales, correo);
                            if (consulta instanceof Cliente || consulta instanceof ClienteProfesional) {
                                System.out.println(consulta);
                            } else {
                                System.out.println("El correo introducido no existe");
                            }
                        } catch (Exception e) {

                        }
                        break;
                    case 2:
                        System.out.println("Lista de todos los productos: ");
                        for (int i = 0; i < listaProductos.size(); i++) {
                            if (listaProductos.get(i).getCliente() instanceof Cliente) {
                                Cliente c1 = (Cliente) listaProductos.get(i).getCliente();
                                System.out.println((i + 1) + ".-" + listaProductos.get(i).getTitulo()
                                        + " perteneciente al usuario " + c1.getNombre());
                            } else if (listaProductos.get(i).getCliente() instanceof ClienteProfesional) {
                                ClienteProfesional c1 = (ClienteProfesional) listaProductos.get(i).getCliente();
                                System.out.println((i + 1) + ".-" + listaProductos.get(i).getTitulo()
                                        + " perteneciente al usuario " + c1.getNombre());
                            }
                        }
                        System.out.println("Introduzca el numero del producto que desea consultar");
                        try {
                            String txtadmin2 = entrada.readLine();
                            int numadmin2 = Integer.parseInt(txtadmin2);
                            System.out.println(listaProductos.get(numadmin2));
                        } catch (Exception e) {
                            System.out.println("El producto introducido no se encuentra en la lista");
                        }

                        break;

                    case 3:

                        break;
                    case 4:
                        terminar = true;
                        break;
                    default:
                        System.out.println("Opcion elegida no valida.");
                }
            } else if (estado == 2) {
                System.out.println("Bienvenido, seleccione una opcion:"
                        + "\n1.-Subir producto"
                        + "\n2.-Consultar mis productos"
                        + "\n3.-Eliminar producto"
                        + "\n4.-Buscar producto"
                        + "\n5.-Darse de alta como Cliente Profesional"
                        + "\n6. Salir");
                System.out.print("->");
                int accion2 = input.nextInt();
                switch (accion2) {
                    case 1:
                        System.out.println("Añade producto a continuacion:");
                        cliente.añadirProducto(listaProductos);
                        break;
                    case 2:
                        
                        System.out.println("Sus productos son los siguientes: ");
                        for (int i = 0; i < cliente.getListaProductos().size(); i++) {
                            System.out.println((i+1)+".-"+cliente.getListaProductos().get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Elija el producto que desea eliminar");
                        System.out.println("Sus productos son los siguientes: ");
                        for (int i = 0; i < cliente.getListaProductos().size(); i++) {
                            System.out.println((i+1)+".-"+cliente.getListaProductos().get(i));
                        }
                        System.out.println("Escriba el titulo del producto que va a eliminar: ");
                        try{
                            boolean prodEncontrado = false;
                            String titulo = entrada.readLine();
                            for (int i=0; i<cliente.getListaProductos().size();i++){
                                if (cliente.getListaProductos().get(i).getTitulo().toLowerCase().equals(titulo.toLowerCase())){
                                    cliente.eliminarProducto(listaProductos, cliente.getListaProductos().get(i));
                                    prodEncontrado = true;
                                    System.out.println("El producto ha sido eliminado correctamente.");
                                }
                                if (!prodEncontrado){
                                    System.out.println("El titulo introducido no coincide con ningun producto añadido.");
                                }
                            }
                        } catch(Exception e){
                            System.out.println("Error en la entrada de datos "+e.toString());
                        }
                        
                        break;
                        
                    case 6:
                        terminar = true;
                        break;
                    default:{
                            
                        System.out.println("La opcion elegida no esta disponible.");
                    }
<<<<<<< HEAD
                    break;
                default:
                    System.out.println("La opcion elegida no esta disponible.");
=======
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
>>>>>>> parent of 53eb7f6... 
=======

                }
>>>>>>> ebcacd194491d6a11247e235f7811d592424e250
            }
        }*/
        

        IOinfo.guardarClientesProfesionales(listaClientesProfesionales);
        IOinfo.guardarClientes(listaClientes);
<<<<<<< HEAD
        IOinfo.guardarProductos(listaProductos);
                

=======
        IOinfo.guardarProductos(listaProductos); 
        
>>>>>>> parent of 53eb7f6... 
        System.out.println("final programa" + listaClientes);
        System.out.println("final programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("final programa productos" + listaProductos);

    }
}