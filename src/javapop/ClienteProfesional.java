
package javapop;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 * 
 * @version v2.0 06/2019
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteProfesional extends Cliente implements Serializable {

    private String descripcion;
    private String horario;
    private String telefono;
    private String web;
    private Ubicacion ubicacion; 

    //constructor normal
    public ClienteProfesional(Cliente cliente) {

        super(cliente.getCorreo(), cliente.getClave(), cliente.getNombre(), cliente.getDni(), cliente.getTarjeta(), cliente.getUbicacion());
        System.out.println("Introduce una descripción para tu perfil: ");
        setDescripcion();
        setHorario();
        System.out.println("Introduce un numero de telefono: ");
        setTelefono();
        System.out.println("Introduce una pagina web: ");
        setWeb();
        
    }
    
    public ClienteProfesional(Cliente cliente, String descripcion, String horario,String telefono, String web) {

        super(cliente.getCorreo(), cliente.getClave(), cliente.getNombre(), cliente.getDni(), cliente.getTarjeta(), cliente.getUbicacion());
        
        this.descripcion=descripcion;
        this.horario=horario;
        
        this.telefono=telefono;
        
        this.web=web;
        
        
    }
    //constructor de entrada
    public ClienteProfesional() {
        
        super();
        System.out.println("Introduce una descripción para tu perfil: ");
        setDescripcion();
        setHorario();
        System.out.println("Introduce un numero de telefono: ");
        setTelefono();
        System.out.println("Introduce una pagina web: ");
        setWeb(); 
        

    }

    public void setHorario(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean comprobado = false;
        while (!comprobado) {
            try {
                System.out.print("Introduzca el horario de apertura(00:00-00:00): ");
                String horarioApertura = input.readLine();
                Pattern pat = Pattern.compile("[0-2]+[0-9]+:+[0-5]+[0-9]" + "-" + "[0-2]+[0-9]+:+[0-5]+[0-9]");
                
                Matcher mat = pat.matcher(horarioApertura);
                
                if (mat.matches()) {
                    int hora1 = Integer.parseInt(horarioApertura.substring(0, 2));
                    //System.out.println(hora1); //para comprobar horas
                    int hora2 = Integer.parseInt(horarioApertura.substring(6, 8));
                    //System.out.println(hora2); //para comprobar horas
                    if (!(hora1 >= 24 || hora2 >= 24)) {
                        this.horario = horarioApertura;
                        comprobado = true;
                    } else {
                        System.out.println("Las horas no pueden superar las 24h");
                    }
                }  else{
                    System.out.println("El horario debe seguir la estructura 00:00-00:00");
                }
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }
        }
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

    //telefono
    /*public String getTelefono() {
        return telefono;
    }
    */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getWeb() {
        return web;
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
    //funciones propias
    /*public void añadirProducto(ArrayList<Producto> listaProductosGlobal){
        
        Producto producto = new Producto(this);
        this.getListaProductos().add(producto);
        listaProductosGlobal.add(producto);
        
    }*/

    
    
    @Override
    public String toString() {
        return "ClienteProfesional{" + super.toString() + "descripcion=" + descripcion + ", horaApertura=" + horario + ", telefono=" + telefono + ", web=" + web + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.horario);
        hash = 61 * hash + Objects.hashCode(this.telefono);
        hash = 61 * hash + Objects.hashCode(this.web);
        hash = 61 * hash + Objects.hashCode(this.ubicacion);
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
        final ClienteProfesional other = (ClienteProfesional) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.web, other.web)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        return true;
    }
    

}
