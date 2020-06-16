/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Hola buenas amigos.
 */
package javapop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 *
 * @version v2.0 06/2019
 */
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
    private boolean urgente;

    /**
     * <p>Constructor con parámetros</p>
     *
     * @param titulo. Título tipo (String) del producto
     * @param categoria. Categoría tipo (String) del producto
     * @param descripcion. Descripción tipo (String) del producto
     * @param estadoProducto. Estado tipo (String) del producto
     * @param fechaPublicacion. Fecha de publicación tipo (String) del producto
     * @param fotografia. Ruta de la fotografía tipo (String) del producto
     * @param precio. Precio tipo (String) del producto
     * @param ubicacion. Ubicación tipo (Ubicacion) del cliente propietario del
     * producto
     * @param cliente. Cliente propietario tipo (Cliente) del producto
     * @param urgente . Urgencia tipo (boolean) del producto
     */
    public Producto(String titulo, String categoria, String descripcion, String estadoProducto, String fechaPublicacion, String fotografia, String precio, Ubicacion ubicacion, Cliente cliente, boolean urgente) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estadoProducto = estadoProducto;
        this.fechaPublicacion = fechaPublicacion;
        this.fotografia = fotografia;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.cliente = cliente;
        this.urgente = urgente;
    }

    /**
     * <p>Constructor sin fechaPublicacion ni ubicacion como parámetros</p>
     *
     * @param titulo. Título tipo (String) del producto
     * @param categoria. Categoría tipo (String) del producto
     * @param descripcion. Descripción tipo (String) del producto
     * @param estadoProducto. Estado tipo (String) del producto
     * @param fotografia. Ruta de la fotografía tipo (String) del producto
     * @param precio. Precio tipo (String) del producto
     * @param cliente. Cliente propietario tipo (Cliente) del producto
     * @param urgente . Urgencia tipo (boolean) del producto
     */
    public Producto(String titulo, String categoria, String descripcion, String estadoProducto, String fotografia, String precio, Cliente cliente, boolean urgente) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estadoProducto = estadoProducto;
        setFechaPublicacion();
        this.fotografia = fotografia;
        this.precio = precio;
        this.ubicacion = cliente.getUbicacion();
        this.cliente = cliente;
        this.urgente = urgente;
    }

    /**
     * <p>Constructor con únicamente cliente como parámetro</p>
     *
     * @param cliente. Cliente propietario del producto
     */
    public Producto(Cliente cliente) {
        System.out.println("Introduzca el título: ");
        setTitulo();
        setCategoria();
        System.out.println("Introduzca una descripcion: ");
        setDescripcion();
        setEstadoProducto();
        System.out.println("Introduzca una fotografia del producto (nombre del archivo): ");
        setFotografia();
        System.out.println("Introduzca el precio de venta del producto: ");
        //setPrecio();
        this.ubicacion = cliente.getUbicacion();
        setFechaPublicacion();
        this.cliente = cliente;
        setUrgente();
    }

    public Producto(ClienteProfesional clienteProfesional) {
        System.out.println("Introduzca el título: ");
        setTitulo();
        setCategoria();
        System.out.println("Introduzca una descripcion: ");
        setDescripcion();
        setEstadoProducto();
        System.out.println("Introduzca una fotografia del producto (nombre del archivo): ");
        setFotografia();
        System.out.println("Introduzca el precio de venta del producto: ");
        //setPrecio();
        this.ubicacion = clienteProfesional.getUbicacion();
        setFechaPublicacion();
        this.cliente = clienteProfesional;
        setUrgente();
    }

    //Getters y Setters
    //titulo
    public void setTitulo(String titulo) {
    }

    public void setTitulo() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.titulo = entrada.readLine();
        } catch (IOException e) {

        }
    }

    public String getTitulo() {
        return titulo;
    }

    //descripcion
    public String getDescripcion() {
        return descripcion;
    }

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

    //cliente
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //ubicacion
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    //precio
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    //categoria
    public void setCategoria() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        String[] categorias = "Moda y accesorios:TV, audio y foto:Moviles y Telefonia:Informatica y electronica:Consolas y videojuegos:Deportes y ocio".split(":");
        while (!correcto) {
            System.out.println("Introduzca el numero de la categoria que desea: ");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ".-" + categorias[i]);
            }
            try {
                System.out.println("->");
                String txt = entrada.readLine();
                int num = Integer.parseInt(txt);

                if (num > 0 && num <= categorias.length) {
                    this.categoria = categorias[num - 1];
                    System.out.println("La categoria elegida es: " + this.categoria);
                    correcto = true;
                } else {
                    System.out.println("La categoría deber ser elegida entre el 1 y el " + categorias.length);
                }

            } catch (Exception e) {
                System.out.println("La categoria que ha introducido no existe. Pruebe de nuevo (Introduzca el numero de la categoria que desea).");

            }
        }

    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    //estadoproducto
    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void setEstadoProducto() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        String[] estado = "Nuevo:Como nuevo:Bueno:Aceptable:Regular".split(":");
        while (!correcto) {
            System.out.println("Introduzca el numero del estado que desea: ");
            for (int i = 0; i < estado.length; i++) {
                System.out.println((i + 1) + ".-" + estado[i]);
            }
            try {
                System.out.println("->");
                String txt = entrada.readLine();
                int num = Integer.parseInt(txt);
                if (num > 0 && num <= estado.length) {
                    this.estadoProducto = estado[num - 1];
                    System.out.println("El estado elegido es: " + this.estadoProducto);
                    correcto = true;
                } else {
                    System.out.println("El estado debe ser elegido entre el 1 y el " + estado.length);
                }
            } catch (Exception e) {
                System.out.println("El estado que ha introducido no existe. Pruebe de nuevo.");
            }
        }
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    //fotografia
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public void setFotografia() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.fotografia = entrada.readLine();
        } catch (Exception e) {

        }
    }

    public String getFotografia() {
        return fotografia;
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    //urgente
    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public void setUrgente() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean correcto = false;
            while (!correcto) {
                System.out.println("¿El producto es urgente (si o no)?");
                String isurgente = entrada.readLine();
                if (isurgente.toLowerCase().equals("si")) {
                    this.urgente = true;
                    correcto = true;
                } else if (isurgente.toLowerCase().equals("no")) {
                    this.urgente = false;
                    correcto = true;
                } else {
                    System.out.println("Las opciones son solo si o no.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "titulo=" + titulo + ", categoria=" + categoria + ", descripcion=" + descripcion + ", estadoProducto=" + estadoProducto + ", fechaPublicacion=" + fechaPublicacion + ", fotografia=" + fotografia + ", precio=" + precio + ",cliente=" + cliente.getCorreo() + ", ubicacion=" + ubicacion + ", urgente=" + urgente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        hash = 29 * hash + Objects.hashCode(this.categoria);
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + Objects.hashCode(this.estadoProducto);
        hash = 29 * hash + Objects.hashCode(this.fechaPublicacion);
        hash = 29 * hash + Objects.hashCode(this.fotografia);
        hash = 29 * hash + Objects.hashCode(this.precio);
        hash = 29 * hash + Objects.hashCode(this.ubicacion);
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + (this.urgente ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getFotografia().equals(((Producto) obj).getFotografia())) {
            return true;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.urgente != other.urgente) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.estadoProducto, other.estadoProducto)) {
            return false;
        }
        if (!Objects.equals(this.fechaPublicacion, other.fechaPublicacion)) {
            return false;
        }
        if (!Objects.equals(this.fotografia, other.fotografia)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

}
