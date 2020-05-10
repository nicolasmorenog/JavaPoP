/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Serializable {
    
    private String correo;
    private String clave;
    private String nombre;
    private String dni;
    private String tarjeta;
    private Ubicacion ubicacion;
    private ArrayList<Producto> listaProductos;
    //private Producto producto;

    //constructor normal
    public Cliente(String correo, String clave, String nombre, String dni, String tarjeta, Ubicacion ubicacion) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.dni = dni;
        this.tarjeta = tarjeta;
        this.ubicacion = ubicacion;
        this.listaProductos = new ArrayList<Producto>();
    }

    //constructor entradas
    public Cliente(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        System.out.println("Introduzca el correo electronico: ");
        setCorreo(listaClientes, listaClientesProfesionales);
        System.out.println("Introduzca la clave: ");
        setClave();
        System.out.println("Introduzca el nombre: ");
        setNombre();
        System.out.println("Introduzca el dni: ");
        setDni();
        System.out.println("Introduzca el numero de la tarjeta (un numero de 16 cifras): ");
        setTarjeta();
        this.ubicacion = new Ubicacion();
        this.listaProductos = new ArrayList<Producto>();

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

    public void setCorreo(ArrayList<Cliente> listaClientes, ArrayList<ClienteProfesional> listaClientesProfesionales) {
        // Patrón para validar el email
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        try {
            boolean correcto = false;
            while (!correcto) {
                String email = entrada.readLine();
                Matcher mather = pattern.matcher(email);

                if (mather.find()) {
                    correcto = Aplicacion.correoApto(listaClientes, listaClientesProfesionales, email);
                    if (correcto) {
                        this.correo = email;
                    } else {
                        System.out.println("El email ingresado ya ha sido registrado previamente");
                    }

                } else {
                    System.out.println("El email ingresado no es válido.");
                }
            }
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

    //metodos
    public void añadirProducto(ArrayList<Producto> listaProductosGlobal) {

        Producto producto = new Producto(this);
        this.listaProductos.add(producto);
        listaProductosGlobal.add(producto);

    }

    public void eliminarProducto(ArrayList<Producto> listaProductosGlobal,Producto productoEliminar) {
        
        this.listaProductos.remove(productoEliminar);
        listaProductosGlobal.remove(productoEliminar);
        
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
   

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", nombre=" + nombre + ", dni=" + dni + ", tarjeta=" + tarjeta + ", ubicacion=" + ubicacion + ", listaProductos=" + listaProductos + '}';
    }

}
