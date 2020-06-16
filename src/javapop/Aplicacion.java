package javapop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import static javapop.Variables.listaClientes;
import static javapop.Variables.listaProductos;

/**
 *
 * @author Jesús Palomino Abreu
 * @author Nicolás Moreno González
 *
 * @version v2.0 06/2019
 */
public class Aplicacion implements Serializable {

    /**
     * método que devuelve el tipo del correo introducido
     *
     * @return obj. retorna un objeto vacío si no se ha encontrado ningún correo
     * que coincida
     * @param correo. correo tipo (String) a buscar
     */
    public static Object buscarCorreo(String correo) {

        /**
         * recorre la lista de clientes hasta encontrar el correo del cliente o
         * hasta que llegue al final de la lista
         *
         * @return cliente. cliente asociado al correo encontrado
         */
        for (Cliente cliente : listaClientes) {
            if (correo.equals(cliente.getCorreo())) {
                return cliente;
            }
        }

        Admin admin = new Admin();
        /**
         * mira si el correo coincide con el correo del administrador
         *
         * @return admin. admin asociado al correo encontrado
         */
        if (correo.equals(admin.getCorreo())) {
            return admin;
        }

        Object obj = new Object();
        return obj;
    }

    /**
     * método que devuelve el index del correo introducido
     *
     * @param correo. correo tipo (String) a buscar
     * @return -1. retorna -1 si no se ha encontrado ningún correo que coincida
     */
    public static int buscarCorreoIndex(String correo) {

        int c = 0;
        /**
         * recorre la lista de clientes hasta encontrar el correo del cliente o
         * hasta que llegue al final de la lista
         *
         * @return c. index del correo encontrado
         */
        for (Cliente cliente : listaClientes) {
            if (correo.equals(cliente.getCorreo())) {

                return c;
            }
            c++;
        }
        /*Admin admin = new Admin();
        if (correo.equals(admin.getCorreo())) {
            return admin;
        }
         */
        //Object obj = new Object();
        return -1;

    }

    /**
     * método para saber si el nuevo correo es apto para registro o no
     *
     * @param correo
     * @return boolean. devuelve si el correo es apto para registro o no
     */
    public static boolean correoApto(String correo) {
        Object user = buscarCorreo(correo);
        /**
         * llama al método buscarCorreo() y mira si el correo es instancia de
         * Cliente o de Admin
         */
        if (user instanceof Cliente || user instanceof Admin) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param titulo
     * @return encontrados. devuelve si no ha encontrado ningún título que
     * coincida
     */
    public static ArrayList<Producto> buscarTitulo(String titulo) {
        ArrayList<Producto> encontrados = new ArrayList<Producto>();
        /**
         * recorre la lista de productos hasta encontrar una coincidencia con el
         * titulo del producto o hasta que llegue al final de la lista
         */
        for (Producto producto : listaProductos) {
            if (titulo.equals(producto.getTitulo())) {
                encontrados.add(producto);
            }
        }

        return encontrados;

    }

    /**
     *
     * @return Object
     * @exception e. lanza la excepción e si no entra en ninguna de las
     * condiciones
     */
    public static Object login() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            /**
             * @return user. devuelve el usuario si no entra en ninguna de las
             * condiciones
             */
            /**
             * se pide al usuario que introduzca su corre y contraseña
             */
            System.out.println("Introduce el correo: ");
            String correo = entrada.readLine();
            System.out.println("Introduce la clave: ");
            String contraseña = entrada.readLine();

            Object user = buscarCorreo(correo);
            /**
             *
             */
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                if (contraseña.equals(cliente.getClave())) {
                    return cliente;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
            } else if (user instanceof ClienteProfesional) {
                ClienteProfesional clientepro = (ClienteProfesional) user;
                if (contraseña.equals(clientepro.getClave())) {
                    return clientepro;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (contraseña.equals(admin.getClave())) {
                    return admin;
                } else {
                    System.out.println("La contraseña es incorrecta");
                    user = new Object();
                }
                /**
                 * @return user. devuelve el usuario si el correo no está
                 * asociado a ninguna cuenta de usuario
                 */
            } else {
                System.out.println("El correo indicado no esta asociado a ninguna cuenta de usuario, pruebe a registrarse.");
                return user;
            }

            return user;
        } catch (Exception e) {
            System.out.println("Ha surgido un error: " + e.toString());
            return new Object();
        }
    }

    public static void registrarseCliente() {

        Cliente c1 = new Cliente();
        listaClientes.add(c1);
        System.out.println("El registro se ha llevado a cabo con exito.");

    }

    public static void registrarseClienteProfesional() {
        ClienteProfesional cp1 = new ClienteProfesional();
        //listaClientesProfesionales.add(cp1);
        listaClientes.add(cp1);
        System.out.println("El registro se ha llevado a cabo con exito.");
    }

    public static void altaClienteProfesional(Cliente cliente) {

        ClienteProfesional cp1 = new ClienteProfesional(cliente);

        listaClientes.remove(cliente);

        listaClientes.add(cp1);

        System.out.println("Se ha dado de alta como cliente profesional con exito.");

    }
    /**
     * Dar de baja un cliente profesional y convertirlo en Cliente
     * Función para ejecución por consola
     * @param clientepro 
     */
    public static void bajaClienteProfesional(ClienteProfesional clientepro) {
        Cliente c1 = new Cliente(clientepro);

        //listaClientesProfesionales.remove(clientepro);
        listaClientes.remove(clientepro);

        listaClientes.add(c1);

        System.out.println("Se ha dado de baja como cliente profesional con exito.");
    }
}
