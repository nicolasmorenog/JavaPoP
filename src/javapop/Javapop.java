/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.util.ArrayList;
import java.io.*;

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

        listaClientes = IOinfo.leerListaClientes();
        listaClientesProfesionales = IOinfo.leerListaClientesProfesionales();

        System.out.println("comienzo programa" + listaClientes);
        System.out.println("comienzo programa" + listaClientesProfesionales);

        Ubicacion u1 = new Ubicacion("12345", "Guada");
        Cliente c1 = new Cliente("c1@gmail.com", "1234", "cliente1", "1234", "12374859394839", u1);
        ClienteProfesional cp1 = new ClienteProfesional(c1, "Local SUcio", "9:00", "13:00", "616623407", "www.pornhub.es");

        //listaClientes.add(c1);
        //listaClientesProfesionales.add(cp1);
        
        Aplicacion.Registrarse(listaClientes,listaClientesProfesionales);
        System.out.println("final programa" + listaClientes);
        
        IOinfo.guardarClientesProfesionales(listaClientesProfesionales);
        IOinfo.guardarClientes(listaClientes);
        
        //System.out.println(Aplicacion.login(listaClientes, listaClientesProfesionales));
        //Producto p1 = new Producto("1", "hola", "hola", "nuevo", "hola", 32.23);
        //System.out.println(p1);
        
    }

}
