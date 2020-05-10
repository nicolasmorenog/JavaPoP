/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapop;

/**
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
/**
 * 
 * @author Jesús Palomino
 */
public class Ubicacion implements Serializable {

    private String codigoPostal;
    private String ciudad;

    public Ubicacion(String codigoPostal, String ciudad) {
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public Ubicacion() {
        System.out.println("Introduce el codigo postal (debe ser un numero de 5 cifras): ");
        setCodigoPostal();
        System.out.println("Introduce la ciudad: ");
        setCiudad();
    }
    
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setCiudad() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.ciudad = entrada.readLine();
        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + '}';
    }

}
