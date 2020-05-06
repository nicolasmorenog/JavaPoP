/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.io.Serializable;
public class Producto implements Serializable{
    private String titulo;
    private String categoria;
    private String descripcion;
    private String estadoProducto;
    private String fechaPublicacion;
    private String fotografia;
    private double precio;
    private Ubicacion ubicacion;

    public Producto(String titulo, String categoria, String descripcion, String estadoProducto, String fotografia, double precio) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estadoProducto = estadoProducto;        
        this.fotografia = fotografia;
        this.precio = precio;
        //this.ubicacion = empleado.getUbicacion();
        setFechaPublicacion(); //Coge la fecha del reloj del pc
        
    } 

    public void setFechaPublicacion() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
        LocalDateTime ahora = LocalDateTime.now();
        this.fechaPublicacion = dtf.format(ahora);
    }

    
    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", categoria=" + categoria + ", descripcion=" + descripcion + ", estadoProducto=" + estadoProducto + ", fechaPublicacion=" + fechaPublicacion + ", fotografia=" + fotografia + ", precio=" + precio + ", ubicacion=" + ubicacion + '}';
    }
    
    
}
