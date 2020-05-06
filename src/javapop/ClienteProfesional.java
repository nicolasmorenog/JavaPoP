/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

/**
 *
 * @author Jesús Palomino
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

public class ClienteProfesional extends Cliente implements Serializable {

    private String descripcion;
    private String horaApertura;
    private String horaCierre;
    private String telefono;
    private String web;
    private Ubicacion ubicacion; //lo he añadido porque no entiendo porque daba error aunque sea herencia de Cliente

    //constructor normal
    public ClienteProfesional(Cliente cliente, String descripcion, String horaApertura, String horaCierre,
            String telefono, String web) {

        super(cliente.getCorreo(), cliente.getClave(), cliente.getNombre(), cliente.getDni(), cliente.getTarjeta(), cliente.getUbicacion());
        this.descripcion = descripcion;
        this.horaApertura = horaApertura; // probablemente cambiar a Date
        this.horaCierre = horaCierre;
        this.telefono = telefono;
        this.web = web;
    }
    
    //constructor de entrada
    public ClienteProfesional() {
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

        System.out.println("Introduce una descripción para tu perfil: ");
        setDescripcion();
        System.out.println("Introduce un numero de telefono: ");
        setTelefono();
        System.out.println("Introduce una pagina web: ");
        setWeb();
        

    }

    //descripcion
    /*public String getDescripcion() {
        return descripcion;
    }
    */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescripcion() {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.descripcion = entrada.readLine();
        } catch (Exception e) {

        }
    }

    //telefono
    /*public String getTelefono() {
        return telefono;
    }
    */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTelefono() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        while (!correcto) {
            try {
                String ptelefono = entrada.readLine();
                if (ptelefono.length() == 9) {
                    try {
                        Integer.parseInt(ptelefono);
                        this.telefono = ptelefono;
                        correcto = true;
                    } catch (Exception e) {
                        System.out.println("El telefono debe estar compuesto por numeros, intentelo de nuevo.");
                    }
                } else {
                    System.out.println("El telefono debe ser de 9 cifras, intentelo de nuevo.");
                }
            } catch (Exception e) {

            }
        }
    }

    //web
    /*public String getWeb() {
        return web;
    }
    */
    public void setWeb(String web) {
        this.web = web;
    }

    public void setWeb() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.web = entrada.readLine();
        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return "ClienteProfesional{" + super.toString() + "descripcion=" + descripcion + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", telefono=" + telefono + ", web=" + web + '}';
    }

}
