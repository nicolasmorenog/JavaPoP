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
import java.io.Serializable;
public class ClienteProfesional extends Cliente implements Serializable{
    private String descripcion;
    private String horaApertura;
    private String horaCierre;
    private int telefono;
    private String web;

    public ClienteProfesional(Cliente cliente,String descripcion, String horaApertura, String horaCierre,
            int telefono, String web) {
        
        super(cliente.getCorreo(),cliente.getClave(),cliente.getNombre(),cliente.getDni(),cliente.getTarjeta(),cliente.getUbicacion());
        this.descripcion = descripcion;
        this.horaApertura = horaApertura; // probablemente cambiar a Date
        this.horaCierre = horaCierre;
        this.telefono = telefono;
        this.web = web;
    }

    @Override
    public String toString() {
        return "ClienteProfesional{" + super.toString() +"descripcion=" + descripcion + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", telefono=" + telefono + ", web=" + web + '}';
    }
    
    
    
    
}
