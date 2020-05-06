/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Jesús Palomino
 */
public class Aplicacion {

    static Object login(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean login = false;
        Object logged = null;
        while (!login) {
            try {
                System.out.println("Introduce el correo: ");
                String correo = entrada.readLine();
                System.out.println("Introduce la clave: ");
                String contraseña = entrada.readLine();

                for (Cliente cliente : listaClientes) {
                    if (correo.equals(cliente.getCorreo())) {
                        if (contraseña.equals(cliente.getClave())) {
                            login = true;
                            return cliente;

                        } else {
                            System.out.println("La contraseña es incorrecta");
                        }
                    }

                }
                for (ClienteProfesional clienteProfesional : listaClientesProfesionales) {
                    if (correo.equals(clienteProfesional.getCorreo())) {
                        if (contraseña.equals(clienteProfesional.getClave())) {
                            login = true;
                            return clienteProfesional;
                        }
                        System.out.println("La contraseña es incorrecta");
                    }
                }
                Admin admin = new Admin();
                if (correo.equals(admin.getCorreo())) {
                    if (contraseña.equals(admin.getClave())) {
                        login = true;
                        return admin;
                    }
                    System.out.println("La contraseña es incorrecta");
                } else {
                    System.out.println("El correo es incorrecto");
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("Ha iniciado sesion con exito");
        return logged;
    }

    public static void registrarse(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        boolean nuevo = true;
        Cliente c1 = new Cliente();
        for (Cliente cliente : listaClientes) {
            if (c1.getCorreo().equals(cliente.getCorreo())) {
                nuevo = false;
            }
        }
        for (ClienteProfesional clienteProfesional : listaClientesProfesionales) {
            if (c1.getCorreo().equals(clienteProfesional.getCorreo())) {
                nuevo = false;
            }
            if (c1.getCorreo().equals(new Admin().getCorreo())) {
                nuevo = false;
            }
        }
          
        if (nuevo) {
            listaClientes.add(c1);
            System.out.println("El registro se ha llevado a cabo con exito");
        } else {
            System.out.println("El registro no se ha completado debido a que ya existe una cuenta asociada a ese correo");
        }
    }
    
}

