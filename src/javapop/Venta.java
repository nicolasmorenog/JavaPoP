/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 *
 * @version v2.0 06/2019
 */
public class Venta implements Serializable{

    private Producto producto;
    private Cliente comprador;
    private Cliente vendedor;
    private String fecha;

    /**
     * <p>
     * Constructor con parámetros</p>
     *
     * @param producto. Producto a vender
     * @param comprador. Cliente que compra el producto
     * @param vendedor. Cliente que vende el producto
     */
    public Venta(Producto producto, Cliente comprador, Cliente vendedor) {
        this.producto = producto;
        this.comprador = comprador;
        this.vendedor = vendedor;
        setFecha();
    }

    //Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFecha() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        this.fecha = dtf.format(ahora);
    }

}
