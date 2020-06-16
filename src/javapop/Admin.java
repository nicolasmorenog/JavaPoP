
package javapop;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 * 
 * @version v2.0 06/2019
 */

public class Admin{
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
