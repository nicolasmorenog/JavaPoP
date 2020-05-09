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

/**
 *
 * @author Jesús Palomino
 */
public class Aplicacion implements Serializable {

    public static Object buscarCorreo(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales, String correo) {

        for (Cliente cliente : listaClientes) {
            if (correo.equals(cliente.getCorreo())) {
                return cliente;
            }
        }
        for (ClienteProfesional clienteProfesional : listaClientesProfesionales) {
            if (correo.equals(clienteProfesional.getCorreo())) {
                return clienteProfesional;
            }
        }
        Admin admin = new Admin();
        if (correo.equals(admin.getCorreo())) {
            return admin;
        }

        Object obj = new Object();
        return obj;
    }

    public static boolean correoApto(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales, String correo) {
        Object user = buscarCorreo(listaClientes, listaClientesProfesionales, correo);
        if (user instanceof Cliente || user instanceof ClienteProfesional || user instanceof Admin) {
            return false;
        }
        return true;
    }

    public static Object login(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Introduce el correo: ");
            String correo = entrada.readLine();
            System.out.println("Introduce la clave: ");
            String contraseña = entrada.readLine();

            Object user = buscarCorreo(listaClientes, listaClientesProfesionales, correo);
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

    public static void registrarseCliente(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {

        Cliente c1 = new Cliente(listaClientes, listaClientesProfesionales);
        listaClientes.add(c1);
        System.out.println("El registro se ha llevado a cabo con exito.");

    }

    public static void registrarseClienteProfesional(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        ClienteProfesional cp1 = new ClienteProfesional(listaClientes, listaClientesProfesionales);
        listaClientesProfesionales.add(cp1);
        System.out.println("El registro se ha llevado a cabo con exito.");
    }
}
