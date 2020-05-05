/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;


public class Admin {
    private final String correo;
    private final String clave;
    private final String nombre;
    public Admin(){
        this.correo= "admin@javapop.com";
        this.clave= "admin";
        this.nombre = "admin";
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Admin{" + "correo=" + correo + ", clave=" + clave + ", nombre=" + nombre + '}';
    }
    
        
    
}
