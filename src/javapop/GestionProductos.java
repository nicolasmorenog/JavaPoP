
package javapop;

import java.util.ArrayList;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 * 
 * @version v2.0 06/2019
 */

public class GestionProductos {

    /**
     * Método para ordenar los productos por cercanía comparando el código 
     * postal del cliente con el código postal de los propietarios de 
     * dichos productos, método de ordenación por insercción.O(n) ((n^2)/4)
     * @param listaProductos. Lista de productos en venta
     * @param comprador. Cliente comprador 
     */
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

    /**
     * Método que sube los productos urgentes al principio de la lista
     * ordenada por cercania
     * @param listaProductos. Lista de productos ordenada por cercanía
     */
    public static void subirUrgentes(ArrayList<Producto> listaProductos) {
        Producto aux;
        int contador = 0;
        /**
         * Recorre la lista de productos entera desde el final.
         * Si alguno de los productos es urgente, lo elimina de la lista
         * y lo añade al principio de la misma
         */
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

}
