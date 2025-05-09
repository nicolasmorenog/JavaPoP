package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javapop.Variables.*;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 *
 * @version v2.0 06/2019
 */
public class Cliente implements Serializable {

    private String correo;
    private String clave;
    private String nombre;
    private String dni;
    private String tarjeta;
    private Ubicacion ubicacion;
    private ArrayList<Producto> listaProductosC;

    /**
     * <p>
     * Constructor con parámetros</p>
     *
     * @param correo. Correo asociado a la cuenta del cliente
     * @param clave. Contraseña de la cuenta del cliente
     * @param nombre. Nombre del cliente
     * @param dni. DNI del cliente
     * @param tarjeta. Tarjeta del cliente
     * @param ubicacion. Ubicación del cliente que consiste en ciudad y código
     * postal
     */
    public Cliente(String correo, String clave, String nombre, String dni, String tarjeta, Ubicacion ubicacion) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.dni = dni;
        this.tarjeta = tarjeta;
        this.ubicacion = ubicacion;
        this.listaProductosC = new ArrayList<Producto>();
    }

    /**
     * <p>
     * Constructor por defecto</p>
     */
    public Cliente() {
        System.out.println("Introduzca el correo electronico: ");
        setCorreo();
        System.out.println("Introduzca la clave: ");
        setClave();
        System.out.println("Introduzca el nombre: ");
        setNombre();
        System.out.println("Introduzca el dni: ");
        setDni();
        System.out.println("Introduzca el numero de la tarjeta (un numero de 16 cifras): ");
        setTarjeta();
        this.ubicacion = new Ubicacion();
        this.listaProductosC = new ArrayList<Producto>();

    }

    /**
     * <p>
     * Método constructor de cliente tomando como parámetro un profesional (Baja
     * como Cliente Profesional)</p>
     *
     * @param clientepro. Cliente profesional
     */
    public Cliente(ClienteProfesional clientepro) {
        this.correo = clientepro.getCorreo();
        this.clave = clientepro.getClave();
        this.nombre = clientepro.getNombre();
        this.dni = clientepro.getDni();
        this. tarjeta = clientepro.getTarjeta();
        this.ubicacion = clientepro.getUbicacion();
        this.listaProductosC = new ArrayList<Producto>();

    }

    //Getters
    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    //Setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCorreo() {
        /**
         * <p>
         * Patrón para validar el email</p>
         */
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        /**
         * <p>
         * Comprobación de si el email ingresado ya ha sido registrado
         * previamente o no es válido</p>
         */
        try {
            boolean correcto = false;
            while (!correcto) {
                String email = entrada.readLine();
                Matcher mather = pattern.matcher(email);

                if (mather.find()) {
                    correcto = Aplicacion.correoApto(email);
                    if (correcto) {
                        this.correo = email;
                    } else {
                        System.out.println("El email ingresado ya ha sido registrado previamente");
                    }

                } else {
                    System.out.println("El email ingresado no es válido.");
                }
            }
            /**
             * @exception e. Se lanza si no entra en el while
             */
        } catch (Exception e) {

        }
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setClave() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.clave = entrada.readLine();
        } catch (Exception e) {

        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.nombre = entrada.readLine();
        } catch (Exception e) {

        }
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDni() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.dni = entrada.readLine();
        } catch (Exception e) {

        }
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setTarjeta() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        /**
         * <p>
         * Comprobación para validar la tarjeta</p>
         */
        try {
            boolean correcto = false;

            while (!correcto) {
                correcto = true;
                String ptarjeta = entrada.readLine();

                if (ptarjeta.length() == 16) {
                    for (int i = 0; i < ptarjeta.length(); i++) {
                        if (!Character.isDigit(ptarjeta.charAt(i))) { //No funciona, CORREGIR
                            correcto = false;
                        }
                    }
                    if (correcto) {
                        this.tarjeta = ptarjeta;
                    } else {
                        System.out.println("La tarjeta solo debe incluir numeros");
                    }
                } else {
                    System.out.println("La longitud debe ser de 16 numeros");
                    correcto = false;
                }
            }
        } catch (Exception e) {

        }
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * <p>
     * Método para añadir productos a la lista de productos global</p>
     *
     * @param listaProductosGlobal. Lista con los productos de todos los
     * clientes
     */
    public void añadirProducto(ArrayList<Producto> listaProductosGlobal) {

        Producto producto = new Producto(this);
        this.listaProductosC.add(producto);
        listaProductosGlobal.add(producto);

    }

    /**
     * <p>
     * Método para añadir un producto a la lista de productos de un cliente</p>
     *
     * @param producto. Producto a añadir
     */
    public void añadirProducto(Producto producto) {

        this.listaProductosC.add(producto);
        listaProductos.add(producto);

    }

    /**
     * <p>
     * Método para eliminar un producto de la lista del cliente</p>
     *
     * @param productoEliminar. Producto a eliminar
     */
    public void eliminarProducto(Producto productoEliminar) {
        /*System.out.println(this.listaProductosC);
        //this.listaProductosC.remove(productoEliminar);
        for (Producto prod : this.listaProductosC) {
            if (prod.equals(productoEliminar)) {
                System.out.println("True");
            } else {
                System.out.println("false");
            }
        }*/

        int index = this.listaProductosC.indexOf(productoEliminar);
        this.listaProductosC.remove(index);

        //System.out.println(this.listaProductosC);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductosC;
    }

    public void setListaProductos(ArrayList<Producto> listaProductosP) {
        this.listaProductosC = listaProductosP;
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", nombre=" + nombre + ", dni=" + dni + ", tarjeta=" + tarjeta + ", ubicacion=" + ubicacion + ", listaProductos=" + listaProductosC + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.correo);
        hash = 79 * hash + Objects.hashCode(this.clave);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.dni);
        hash = 79 * hash + Objects.hashCode(this.tarjeta);
        hash = 79 * hash + Objects.hashCode(this.ubicacion);
        hash = 79 * hash + Objects.hashCode(this.listaProductosC);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.listaProductosC, other.listaProductosC)) {
            return false;
        }
        return true;
    }

}
