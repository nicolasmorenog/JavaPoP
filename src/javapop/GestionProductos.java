/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.util.ArrayList;

/**
 *
 * @author Jesús Palomino
 */
public class GestionProductos {

    public static void ordenarProductosCercania(ArrayList<Producto> listaProductos, Cliente comprador) {
        String txt = comprador.getUbicacion().getCodigoPostal();
        int locComprador = Integer.parseInt(txt);
        int locProductoi;
        int locProductoj;
        int disi;
        int disj;
        int j;
        Producto aux;
        for (int i = 1; i < listaProductos.size(); i++) {
            aux = listaProductos.get(i);
            locProductoi = Integer.parseInt(listaProductos.get(i).getUbicacion().getCodigoPostal());
            disi = Math.abs(locComprador - locProductoi);
            j = i - 1;
            locProductoj = Integer.parseInt(listaProductos.get(j).getUbicacion().getCodigoPostal());
            disj = Math.abs(locComprador - locProductoj);
            while ((j >= 0) && (disi < disj)) {

                listaProductos.set(j + 1, listaProductos.get(j));
                j--;
                if (j >= 0) {
                    locProductoj = Integer.parseInt(listaProductos.get(j).getUbicacion().getCodigoPostal());
                    disj = Math.abs(locComprador - locProductoj);
                }
            }
            listaProductos.set(j + 1, aux);
        }

    }

    public static void subirUrgentes(ArrayList<Producto> listaProductos) {
        Producto aux;
        int contador = 0;
        for (int i = listaProductos.size() - 1; i >= contador; i--) {
            if (listaProductos.get(i).isUrgente()) {
                aux = listaProductos.get(i);
                listaProductos.remove(aux);
                listaProductos.add(0, aux);
                i++;
                contador++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        Ubicacion u1 = new Ubicacion("00000", "Guada");
        Cliente c1 = new Cliente("c1@gmail.com", "1234", "cliente1", "1234", "12374859394839", u1);
        for (int i = 0; i < 5; i++) {
            listaProductos.add(new Producto(c1));
        }
        ordenarProductosCercania(listaProductos, c1);
        for (int i = 0; i < 5; i++) {
            System.out.println(listaProductos.get(i));
            System.out.println();
        }
        subirUrgentes(listaProductos);
        for (int i = 0; i < 5; i++) {
            System.out.println(listaProductos.get(i));
        }
    }

    Ubicacion u1 = new Ubicacion("28512", "Alcala de Henares");
    Ubicacion u2 = new Ubicacion("12345", "Guadalajara");
    
    Cliente c1 = new Cliente("cliente@gmail.com", "avionetas", "cliente", "1234", "12374859394839", u1);
    Cliente c2 = new Cliente("jesuspalomino@gmail.com", "avionetas", "Jesukete", "1234", "12374859394839", u2);

    ClienteProfesional cp1 = new ClienteProfesional(c1, "hola", "01:30-10:00", "123123123", "dsadda");

    //Producto p1 = new Producto("AMD Ryzen 9", "TV audio y foto", "Lo mejor que puedes encontrar calidad/precio", "Regular", "./javapop.ImagenesProductos/5BpIeRB5Ru-AMD Ryzen 9.png", "463,00", u1, cp1, true);
    //Producto p2 = new Producto("Cocacola", "Moda y accesorios", "Original", "Aceptable", "./javapop.Imagenes/5KebdiQKgG-cola-can.png", "1,50", u2, c2, false);

    //listaProductos.add(p1);

    //cp1.añadirProducto();
}
