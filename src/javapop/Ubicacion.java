
package javapop;
/**
 *
 * @author Jesús Palomino
 * @author Nicolás Moreno
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Ubicacion implements Serializable {

    private String codigoPostal;
    private String ciudad;

    /**
     * <p> Metodo constructor con parametros de la clase Ubicacion <p>
     * 
     * @param codigoPostal codigo postal de la ciudad donde reside el cliente
     * @param ciudad ciudad donde reside el cliente
     */
    public Ubicacion(String codigoPostal, String ciudad) {
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    /**
     * <p>Metodo constructor de la clase Ubicacion a introducir por teclado</p>
     */
    public Ubicacion() {
        System.out.println("Introduce el codigo postal (debe ser un numero de 5 cifras): ");
        setCodigoPostal();
        System.out.println("Introduce la ciudad: ");
        setCiudad();
    }

    /**
     * 
     * @return codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * 
     * @param codigoPostal 
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * <p>Metodo para introducir por teclado el codigo postal y que valide
     * que tenga unicamente 5 cifras de tipo int</p>
     */
    public void setCodigoPostal() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean correcto = false;
        while (!correcto) {
            try {
                String pcodigoPostal = entrada.readLine();
                if (pcodigoPostal.length() == 5) {
                    try {
                        Integer.parseInt(pcodigoPostal);
                        this.codigoPostal = pcodigoPostal;
                        correcto = true;
                    } catch (Exception e) {
                        System.out.println("El codigo postal debe estar compuesto por numeros, intentelo de nuevo.");
                    }
                } else {
                    System.out.println("El codigo postal debe ser de 5 cifras, intentelo de nuevo.");
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * 
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     *<p>Metodo para introducir por teclado la ciudad en la que reside
     * el cliente y que valide que sea de tipo String </p>
     * 
     * 
     */
    public void setCiudad() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.ciudad = entrada.readLine();
        } catch (Exception e) {

        }
    }

    /**
     * 
     * @return codigoPosta
     * @return ciudad
     */
    @Override
    public String toString() {
        return "Ubicacion{" + "codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + '}';
    }

}
