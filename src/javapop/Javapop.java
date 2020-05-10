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

        //Ubicacion u1 = new Ubicacion("12345", "Guada");
        //Cliente c1 = new Cliente("c1@gmail.com", "1234", "cliente1", "1234", "12374859394839", u1);
        //ClienteProfesional cp1 = new ClienteProfesional(c1, "hola", "01:30-10:00", "123123123", "dsadda");
        //listaProductos.add(p1);
        //cp1.añadirProducto();
        //System.out.println(cp1.toString());
        Scanner input = new Scanner(System.in);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        Object user = new Object();
        Ubicacion u = new Ubicacion("", "");
        Cliente cliente = new Cliente("", "", "", "", "", u);
        ClienteProfesional clienteProfesional = new ClienteProfesional(cliente, "", "", "", "");
        int estado = 0;
        boolean terminar = false;
        while (!terminar) {
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
                        if (user instanceof ClienteProfesional) {
                            clienteProfesional = (ClienteProfesional) user;
                            estado = 3;

                        } else if (user instanceof Cliente) {
                            cliente = (Cliente) user;
                            estado = 2;
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
                            System.out.println(listaProductos.get(numadmin2 - 1));
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
                        + "\n6.-Bandeja de entrada (Solicitudes de venta)"
                        + "\n7. Salir");
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
                            System.out.println((i + 1) + ".-" + cliente.getListaProductos().get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Elija el producto que desea eliminar");
                        System.out.println("Sus productos son los siguientes: ");
                        for (int i = 0; i < cliente.getListaProductos().size(); i++) {
                            System.out.println((i + 1) + ".-" + cliente.getListaProductos().get(i));
                        }
                        System.out.println("Escriba el titulo del producto que va a eliminar: ");
                        try {
                            boolean prodEncontrado = false;
                            String titulo = entrada.readLine();
                            for (int i = 0; i < cliente.getListaProductos().size(); i++) {
                                if (cliente.getListaProductos().get(i).getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                                    cliente.eliminarProducto(listaProductos, cliente.getListaProductos().get(i));
                                    prodEncontrado = true;
                                    System.out.println("El producto ha sido eliminado correctamente.");
                                }
                                if (!prodEncontrado) {
                                    System.out.println("El titulo introducido no coincide con ningun producto añadido.");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error en la entrada de datos " + e.toString());
                        }

                        break;
                    case 4:
                        boolean existe = false;                       
                        System.out.println("Escriba el nombre de la categoria de la cual desea buscar un producto");
                        String[] categorias = "Moda y accesorios:TV, audio y foto:Moviles y Telefonia:Informatica y electronica:Consolas y videojuegos:Deportes y ocio".split(":");
                        for (int i = 0; i < categorias.length; i++) {
                            System.out.println((i + 1) + ".-" + categorias[i]);
                        }
                        try {
                            String categoria = entrada.readLine().toLowerCase();
                            for (int i = 0; i < categorias.length; i++) {
                                if (categoria.equals(categorias[i].toLowerCase())) {
                                    existe = true;
                                }
                            }
                            if (existe) {
                                ArrayList<Producto> listCat = new ArrayList<>();
                                boolean comp = false;
                                while (!comp) {
                                    
                                    System.out.println("¿Desea introducir una palabra clave?");
                                    String res = entrada.readLine();
                                    if (res.toLowerCase().equals("si")) {
                                        System.out.println("Introduzca la palabra clave");
                                        String clave = entrada.readLine();
                                        for (int i = 0; i < listaProductos.size(); i++) {
                                            if (listaProductos.get(i).getCategoria().toLowerCase().equals(categoria) 
                                                    && !listaProductos.get(i).getCliente().getCorreo().equals(cliente.getCorreo())
                                                    && listaProductos.get(i).getTitulo().toLowerCase().contains(clave.toLowerCase())) {
                                                listCat.add(listaProductos.get(i));
                                            }
                                        }
                                        
                                        comp = true;
                                    } else if (res.toLowerCase().equals("no")) {
                                        System.out.println("Aqui se muestra una lista con los productos disponibles de la categoria " + categoria);

                                        for (int i = 0; i < listaProductos.size(); i++) {
                                            if (listaProductos.get(i).getCategoria().toLowerCase().equals(categoria) && !listaProductos.get(i).getCliente().getCorreo().equals(cliente.getCorreo())) {
                                                listCat.add(listaProductos.get(i));
                                            }
                                        }
                                        comp = true;
                                    } else {
                                        System.out.println("La respuesta debe ser si o no");
                                    }
                                }
                                if (listCat.isEmpty()) {
                                    System.out.println("No ha sido encontrado ningun objeto perteneciente a la categoria " + categoria);
                                } else {
                                    GestionProductos.ordenarProductosCercania(listCat, cliente);
                                    GestionProductos.subirUrgentes(listCat);
                                    System.out.println("1.- Volver atras");
                                    for (int i = 0; i < listCat.size(); i++) {
                                        System.out.println((i + 2) + ".-" + listCat.get(i).getTitulo() + ", Precio: " + listCat.get(i).getPrecio() + ", Codigo Postal: " + listCat.get(i).getUbicacion().getCodigoPostal());
                                    }
                                    System.out.println("Seleccione una opcion o un producto");
                                    int elec = input.nextInt();
                                    if (elec == 1) {
                                        System.out.println("Volviendo atras");
                                    } else if (elec > 1 && elec <= listCat.size() + 1) {
                                        Producto productSelecc = listCat.get(elec - 2);
                                        System.out.println(productSelecc);
                                    } else {
                                        System.out.println("A elegido una opcion inexistente.");
                                    }
                                }
                            } else {
                                System.out.println("La categoría introducida no coincide con ninguna de las existentes.");
                            }
                        } catch (Exception e) {
                            System.out.println("La categoría introducida no coincide con ninguna de las existentes.");
                        }
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        terminar = true;
                        break;
                    default: {

                        System.out.println("La opcion elegida no esta disponible.");
                    }

                }
            } else if (estado == 3) {
                System.out.println("Bienvenido a las Opciones de cliente profesional, por favor, seleccione una opcion:"
                        + "\n1.-Subir producto"
                        + "\n2.-Consultar mis productos"
                        + "\n3.-Eliminar producto"
                        + "\n4.-Buscar producto"
                        + "\n5.-Darse de baja como Cliente Profesional"
                        + "\n6. Salir");
                System.out.print("->");
                int accion2 = input.nextInt();
                switch (accion2) {
                    case 1:
                        System.out.println("Añade producto a continuacion:");
                        clienteProfesional.añadirProducto(listaProductos);
                        break;
                    case 2:

                        System.out.println("Sus productos son los siguientes: ");
                        for (int i = 0; i < clienteProfesional.getListaProductos().size(); i++) {
                            System.out.println((i + 1) + ".-" + clienteProfesional.getListaProductos().get(i));
                        }
                        break;
                    case 3:
                        System.out.println("Elija el producto que desea eliminar");
                        System.out.println("Sus productos son los siguientes: ");
                        for (int i = 0; i < clienteProfesional.getListaProductos().size(); i++) {
                            System.out.println((i + 1) + ".-" + clienteProfesional.getListaProductos().get(i));
                        }
                        System.out.println("Escriba el titulo del producto que va a eliminar: ");
                        try {
                            boolean prodEncontrado = false;
                            String titulo = entrada.readLine();
                            for (int i = 0; i < clienteProfesional.getListaProductos().size(); i++) {
                                if (clienteProfesional.getListaProductos().get(i).getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                                    clienteProfesional.eliminarProducto(listaProductos, clienteProfesional.getListaProductos().get(i));
                                    prodEncontrado = true;
                                    System.out.println("El producto ha sido eliminado correctamente.");
                                }
                                if (!prodEncontrado) {
                                    System.out.println("El titulo introducido no coincide con ningun producto añadido.");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error en la entrada de datos " + e.toString());
                        }

                        break;

                    case 6:
                        terminar = true;
                        break;
                    default: {

                        System.out.println("La opcion elegida no esta disponible.");
                    }

                }
            }
        }

        IOinfo.guardarClientesProfesionales(listaClientesProfesionales);
        IOinfo.guardarClientes(listaClientes);
        IOinfo.guardarProductos(listaProductos);

        System.out.println("final programa" + listaClientes);
        System.out.println("final programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("final programa productos" + listaProductos);

    }
}
