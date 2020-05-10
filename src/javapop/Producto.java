/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.Serializable;

public class Producto implements Serializable {

    private String titulo;
    private String categoria;
    private String descripcion;
    private String estadoProducto;
    private String fechaPublicacion;
    private String fotografia;
    private String precio;
    private Ubicacion ubicacion;
    private Cliente cliente;

    //constructor normal
    public Producto(String titulo, String categoria, String descripcion, String estadoProducto, String fotografia, String precio){
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estadoProducto = estadoProducto;
        this.fotografia = fotografia;
        this.precio = precio;
        //this.ubicacion = empleado.getUbicacion();
        setFechaPublicacion(); //Coge la fecha del reloj del pc

    }

    //constructor de nuevo producto
    public Producto(Cliente cliente) {
        System.out.println("Introduzca el título: ");
        setTitulo();
        System.out.println("Introduzca la categoria de entre las siguientes (sin tildes):"
                + " \n-Moda y accesorios \n-TV, audio y foto \n-Moviles y Telefonia"
                + "\n-Informatica y electronica \n-Consolas y videojuegos \n-Deportes y ocio");
        setCategoria();
        System.out.println("Introduzca una descripcion: ");
        setDescripcion();
        System.out.println("Escoja el estado del producto de entre las siguientes opciones (sin tildes): "
                + "\n-Nuevo \n-Como nuevo \n-Bueno \n-Aceptable \n-Regular");
        setEstadoProducto();
        System.out.println("Introduzca una fotografia del producto (nombre del archivo): ");
        setFotografia();
        System.out.println("Introduzca el precio de venta del producto: ");
        setPrecio();
        this.ubicacion = cliente.getUbicacion();
        setFechaPublicacion();
    }

    //titulo
    public void setTitulo(String titulo) {
    }

    public void setTitulo() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.titulo = entrada.readLine();
        } catch (Exception e) {

        }
    }

    //categoria
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCategoria() { //he dejado todo sin tildes...
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
<<<<<<< HEAD
        String[] categorias = "Moda y accesorios:TV, audio y foto:Moviles y Telefonia:Informatica y electronica:Consolas y videojuegos:Deportes y ocio".split(":");
=======
>>>>>>> parent of 53eb7f6... 
        while (!correcto) {
            try {
                this.categoria = entrada.readLine();
                if (categoria.toLowerCase().equals("moda y accesorios")) {
                    correcto = true;
                } else if (categoria.toLowerCase().equals("tv, audio y foto")) {
                    correcto = true;
                } else if (categoria.toLowerCase().equals("moviles y telefonia")) {
                    correcto = true;
                } else if (categoria.toLowerCase().equals("informatica y electronica")) {
                    correcto = true;
                } else if (categoria.toLowerCase().equals("consolas y videojuegos")) {
                    correcto = true;
                } else if (categoria.toLowerCase().equals("deporte y ocio")) {
                    correcto = true;
                } else {
                    System.out.println("La categoria que ha introducido no existe. Pruebe de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("La categoria que ha introducido no existe. Pruebe de nuevo.");

            }
        }

    }

    //descripcion
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

    //estadoproducto
    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void setEstadoProducto() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        while (!correcto) {
            try {
                this.estadoProducto = entrada.readLine();
                if (estadoProducto.toLowerCase().equals("nuevo")) {
                    correcto = true;
                } else if (estadoProducto.toLowerCase().equals("como nuevo")) {
                    correcto = true;
                } else if (estadoProducto.toLowerCase().equals("bueno")) {
                    correcto = true;
                } else if (estadoProducto.toLowerCase().equals("aceptable")) {
                    correcto = true;
                } else if (estadoProducto.toLowerCase().equals("regular")) {
                    correcto = true;
                } else {
                    System.out.println("El estado del producto que ha introducido no existe. Pruebe de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("El estado del producto que ha introducido no existe. Pruebe de nuevo.");

            }
        }
    }

    
    //fotografia
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
    
    public void setFotografia() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.fotografia= entrada.readLine();
        } catch (Exception e) {

        }
    }

    
    //precio
    public void setPrecio(String precio){
        this.precio = precio;
    }
    
    public void setPrecio() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        while (!correcto) {
            try {
                String pprecio=entrada.readLine();
                
                    
                        Double.parseDouble(pprecio);
                        this.precio = pprecio;
                        correcto = true;
                    
                
            } catch (Exception e) {
                    System.out.println("El precio debe estar compuesto por un numero decimal. Intentelo de nuevo");

            }
        }
    }

    
    //fecha de publicacion
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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
