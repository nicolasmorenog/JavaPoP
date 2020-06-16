/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import javapop.Aplicacion;
import javapop.IOinfo;
import javapop.Producto;
import static javapop.Variables.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javapop.Cliente;
import javapop.ClienteProfesional;
import java.util.ArrayList;
import javapop.GestionProductos;

/**
 *
 * @author Jesus
 */
public class PagCliente extends javax.swing.JFrame {

    /**
     * Creates new form PagCliente
     */
    private ArrayList<Producto> productosMostrar;
    private int p = 0;

    public PagCliente() {
        initComponents();

        productosSinUser();

        
    }
    
    private void rellenarDatosCliente(Cliente cliente) {
        profesional1.setSelected(false);
        pagWeb1.setText("");
        horarioAper1.setText("");
        telefono1.setText("");
        descripcion1.setText("");
        correo1.setText(cliente.getCorreo());
        nombre1.setText(cliente.getNombre());
        clave1.setText(cliente.getClave());
        ciudad1.setText(cliente.getUbicacion().getCiudad());
        codigoPostal.setText(cliente.getUbicacion().getCodigoPostal());
        tarjeta.setText(cliente.getTarjeta());
        dni.setText(cliente.getDni());
        if (cliente instanceof ClienteProfesional) {
            profesional1.setSelected(true);
            pagWeb1.setText(((ClienteProfesional) cliente).getWeb());
            horarioAper1.setText(((ClienteProfesional) cliente).getHorario());
            telefono1.setText(((ClienteProfesional) cliente).getTelefono());
            descripcion1.setText(((ClienteProfesional) cliente).getDescripcion());

        }

    }

    private void productosCategoria() {
        
        productosSinUser();
        
        ArrayList<Producto> listaAux = new ArrayList(0);
        
        for (Producto prod: productosMostrar){
            listaAux.add(prod);
        }
        
        String value= jCategorias.getSelectedItem().toString();
        System.out.println("Categoria= "+value);
        for (int i = 0; i < listaAux.size(); i++) {
            
            if (!listaAux.get(i).getCategoria().equals(value)) {
                listaAux.remove(i);
                i--;
                System.out.println("Entró");
            }
        }
        System.out.println("ListaAux: " + listaAux);
        productosMostrar = listaAux;
        actualizarPag();
    }

    private void productosSinUser() {
        ArrayList<Producto> listaAux = new ArrayList<Producto>();
        for (Producto produc: listaProductos){
            listaAux.add(produc);
        }
        
        
        for (int i = 0; i < listaAux.size(); i++) {

            if (listaAux.get(i).getCliente().getCorreo().equals(((Cliente) usuario).getCorreo())) {
                listaAux.remove(i);
                i--;

            }
        }

        productosMostrar = listaAux;
        actualizarPag();
    } 
    private void productosUser(){
        productosMostrar = new ArrayList(0);
        
        for (int i = 0; i < listaProductos.size(); i++) {

            if (listaProductos.get(i).getCliente().getCorreo().equals(((Cliente) usuario).getCorreo())) {
                productosMostrar.add(listaProductos.get(i));
                
            }
        }
        actualizarPag();
    }
   

    /*private void eliminarProducto(Producto producto) {
        System.out.println("ProductosMostrar: " + productosMostrar);
        int index = Aplicacion.buscarCorreoIndex(producto.getCliente().getCorreo());
        System.out.println("index: " + index);
        System.out.println("Cliente" + producto);
        
        int index1 = listaProductos.indexOf(producto);

        Cliente cliente = producto.getCliente();

        System.out.println(cliente);

        System.out.println("1");

        cliente.eliminarProducto(producto);

        System.out.println("2");

        if (!filtrado || filtrado2) {
            System.out.println("3");
            int u = listaProductos.indexOf(producto);
            System.out.println("u" + u);

            listaProductos.remove(u);
        }
        if (filtrado2) {
            int c = productosMostrar.indexOf(producto);
            productosMostrar.remove(c);
        } if (filtrado){
            System.out.println("Fotografia producto "+ producto.getFotografia());
            for (Producto prod:listaProductos){
                System.out.println("FotografiaLista: "+ prod.getFotografia());
                if (prod.getFotografia().equals(producto.getFotografia())){
                    listaProductos.remove(prod);
                    break;
                }
            }
        }

        listaClientes.set(index, cliente);

        actualizarPag();

    }*/
    public void actualizarPag() {
        GestionProductos.ordenarProductosCercania(productosMostrar, (Cliente)usuario);
        GestionProductos.subirUrgentes(productosMostrar);
        
        adminProductos.setVisible(true);
        jDatosCliente.setVisible(false);
        
        jP8.setVisible(false);
        jP7.setVisible(false);
        jP6.setVisible(false);
        jP5.setVisible(false);
        jP4.setVisible(false);
        jP3.setVisible(false);
        jP2.setVisible(false);
        jP1.setVisible(false);
        /*pape1.setVisible(false);
        pape2.setVisible(false);
        pape3.setVisible(false);
        pape4.setVisible(false);
        pape5.setVisible(false);
        pape6.setVisible(false);
        pape7.setVisible(false);
        pape8.setVisible(false);*/
        noProductos.setVisible(false);

        if (productosMostrar.isEmpty()) {
            noProductos.setVisible(true);
        }

        if (productosMostrar.size() >= p + 8) {
            rellenarPanel(jP8, productosMostrar.get(p + 7));
            jP8.setVisible(true);
            //pape8.setVisible(true);
        }
        if (productosMostrar.size() >= p + 7) {
            rellenarPanel(jP7, productosMostrar.get(p + 6));
            jP7.setVisible(true);
            //pape7.setVisible(true);
        }
        if (productosMostrar.size() >= p + 6) {
            rellenarPanel(jP6, productosMostrar.get(p + 5));
            jP6.setVisible(true);
            //pape6.setVisible(true);
        }
        if (productosMostrar.size() >= p + 5) {
            rellenarPanel(jP5, productosMostrar.get(p + 4));
            jP5.setVisible(true);
            //pape5.setVisible(true);
        }
        if (productosMostrar.size() >= p + 4) {
            rellenarPanel(jP4, productosMostrar.get(p + 3));
            jP4.setVisible(true);
            //pape4.setVisible(true);
        }
        if (productosMostrar.size() >= p + 3) {
            rellenarPanel(jP3, productosMostrar.get(p + 2));
            jP3.setVisible(true);
            //pape3.setVisible(true);
        }
        if (productosMostrar.size() >= p + 2) {
            rellenarPanel(jP2, productosMostrar.get(p + 1));
            jP2.setVisible(true);
            //pape2.setVisible(true);
        }
        if (productosMostrar.size() >= p + 1) {
            rellenarPanel(jP1, productosMostrar.get(p));
            jP1.setVisible(true);
            //pape1.setVisible(true);
        }

    }

    public void rellenarPanel(JPanel panel, Producto produc) { //Producto produc, 
        Component[] components = panel.getComponents();

        int cont = 0;
        for (Component component : components) {
            if (component.getClass().equals(JLabel.class) && cont == 0) {
                ((JLabel) component).setText(produc.getPrecio() + " €");
                cont++;
            } else if (component.getClass().equals(JLabel.class) && cont == 1) {
                ((JLabel) component).setText(produc.getTitulo());
                cont++;
            } else if (component.getClass().equals(JLabel.class) && cont == 2) {
                ((JLabel) component).setText(produc.getDescripcion());
                cont++;
            } else if (component.getClass().equals(JLabel.class) && cont == 3) {
                ImageIcon icon = new ImageIcon(produc.getFotografia());
                Image resizedImage = icon.getImage().getScaledInstance(190, 190, java.awt.Image.SCALE_DEFAULT);
                ((JLabel) component).setIcon(new ImageIcon(resizedImage));
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLupa = new javax.swing.JToggleButton();
        jBusqueda = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jCategorias = new javax.swing.JComboBox<>();
        IniSesion3 = new javax.swing.JButton();
        IniSesion4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jDatosCliente = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        correo1 = new javax.swing.JTextField();
        nombre1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ciudad1 = new javax.swing.JTextField();
        clave1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pagWeb1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion1 = new javax.swing.JTextArea();
        profesional1 = new javax.swing.JCheckBox();
        telefono1 = new javax.swing.JFormattedTextField();
        horarioAper1 = new javax.swing.JFormattedTextField();
        pagWebError1 = new javax.swing.JLabel();
        horarioError1 = new javax.swing.JLabel();
        telefonoError1 = new javax.swing.JLabel();
        descripcionError1 = new javax.swing.JLabel();
        dni = new javax.swing.JFormattedTextField();
        codigoPostal = new javax.swing.JFormattedTextField();
        tarjeta = new javax.swing.JFormattedTextField();
        correoError = new javax.swing.JLabel();
        nombreError = new javax.swing.JLabel();
        claveError = new javax.swing.JLabel();
        ciudadError = new javax.swing.JLabel();
        dniError = new javax.swing.JLabel();
        tarjetaError = new javax.swing.JLabel();
        codigoPostalError = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        IniSesion = new javax.swing.JButton();
        IniSesion1 = new javax.swing.JButton();
        IniSesion2 = new javax.swing.JButton();
        adminProductos = new javax.swing.JPanel();
        jP1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jP2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jP3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jP4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jP6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jP8 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jP5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jP7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        noProductos = new javax.swing.JPanel();
        jLabelNopp = new javax.swing.JLabel();
        travolta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 650));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TopPanel.setBackground(new java.awt.Color(244, 184, 44));
        TopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/LogoBlanco.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        TopPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 100));

        jLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/lupaVolt30x30.png"))); // NOI18N
        jLupa.setBorder(null);
        jLupa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLupaActionPerformed(evt);
            }
        });
        TopPanel.add(jLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 70, 40, 32));
        jLupa.getAccessibleContext().setAccessibleParent(jBusqueda);

        TopPanel.add(jBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 200, 32));

        jButton4.setText("Inicio");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        TopPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, 32));

        jCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moda y accesorios", "TV audio y foto", "Móviles y telefonía", "Informática y electrónica", "Consolas y videojuegos", "Deporte y ocio" }));
        jCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoriasActionPerformed(evt);
            }
        });
        TopPanel.add(jCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 180, 30));

        IniSesion3.setBackground(new java.awt.Color(255, 255, 255));
        IniSesion3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        IniSesion3.setForeground(new java.awt.Color(244, 184, 44));
        IniSesion3.setText("Mi Perfil");
        IniSesion3.setBorder(null);
        IniSesion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniSesion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IniSesion3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IniSesion3MouseExited(evt);
            }
        });
        IniSesion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniSesion3ActionPerformed(evt);
            }
        });
        TopPanel.add(IniSesion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 80, 30));

        IniSesion4.setBackground(new java.awt.Color(255, 255, 255));
        IniSesion4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        IniSesion4.setForeground(new java.awt.Color(244, 184, 44));
        IniSesion4.setText("Cerrar sesión");
        IniSesion4.setBorder(null);
        IniSesion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniSesion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IniSesion4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IniSesion4MouseExited(evt);
            }
        });
        IniSesion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniSesion4ActionPerformed(evt);
            }
        });
        TopPanel.add(IniSesion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 150, 30));

        jPanel1.setLayout(new java.awt.CardLayout());

        correo1.setEditable(false);

        nombre1.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel14.setText("Correo");

        ciudad1.setEditable(false);

        clave1.setEditable(false);
        clave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clave1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel15.setText("Contraseña");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel16.setText("Nombre");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel17.setText("Ciudad");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel18.setText("DNI");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel19.setText("Tarjeta de crédito");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel20.setText("Código Postal");

        jPanel5.setBackground(new java.awt.Color(254, 176, 112));

        pagWeb1.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel21.setText("Página web");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel22.setText("Teléfono");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel23.setText("Horario de apertura");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel24.setText("Descripción del negocio");

        descripcion1.setEditable(false);
        descripcion1.setBackground(new java.awt.Color(231, 231, 231));
        descripcion1.setColumns(20);
        descripcion1.setRows(5);
        jScrollPane2.setViewportView(descripcion1);

        profesional1.setBackground(new java.awt.Color(254, 176, 112));
        profesional1.setFont(new java.awt.Font("Verdana", 2, 16)); // NOI18N
        profesional1.setText("Cliente Profesional");
        profesional1.setEnabled(false);

        telefono1.setEditable(false);
        try {
            telefono1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+34 ### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        horarioAper1.setEditable(false);
        horarioAper1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));

        pagWebError1.setForeground(new java.awt.Color(255, 0, 0));

        horarioError1.setForeground(new java.awt.Color(255, 0, 0));

        telefonoError1.setForeground(new java.awt.Color(255, 0, 0));

        descripcionError1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descripcionError1))
                    .addComponent(pagWeb1)
                    .addComponent(profesional1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(telefono1)
                    .addComponent(horarioAper1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(telefonoError1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(pagWebError1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(horarioError1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(profesional1)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(pagWebError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagWeb1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(horarioError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horarioAper1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(telefonoError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(descripcionError1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dni.setEditable(false);
        try {
            dni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######## ?")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        codigoPostal.setEditable(false);
        try {
            codigoPostal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tarjeta.setEditable(false);
        try {
            tarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        correoError.setForeground(new java.awt.Color(255, 0, 0));

        nombreError.setForeground(new java.awt.Color(255, 0, 0));

        claveError.setForeground(new java.awt.Color(255, 0, 0));

        ciudadError.setForeground(new java.awt.Color(255, 0, 0));

        dniError.setForeground(new java.awt.Color(255, 0, 0));

        tarjetaError.setForeground(new java.awt.Color(255, 0, 0));

        codigoPostalError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tarjeta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(29, 29, 29)
                        .addComponent(correoError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(correo1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clave1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ciudad1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dni, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoPostal)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(34, 34, 34)
                                .addComponent(nombreError))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(ciudadError))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(dniError))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(codigoPostalError))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(claveError))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(tarjetaError)))
                        .addGap(0, 332, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(correoError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(nombreError))
                .addGap(18, 18, 18)
                .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(claveError))
                .addGap(3, 3, 3)
                .addComponent(clave1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ciudadError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(dniError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tarjetaError))
                .addGap(18, 18, 18)
                .addComponent(tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(codigoPostalError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel47.setFont(new java.awt.Font("Segoe UI Symbol", 0, 40)); // NOI18N
        jLabel47.setText("Mi perfil");

        IniSesion.setBackground(new java.awt.Color(255, 255, 255));
        IniSesion.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        IniSesion.setForeground(new java.awt.Color(204, 102, 0));
        IniSesion.setText("Subir Producto");
        IniSesion.setBorder(null);
        IniSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IniSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IniSesionMouseExited(evt);
            }
        });
        IniSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniSesionActionPerformed(evt);
            }
        });

        IniSesion1.setBackground(new java.awt.Color(255, 125, 0));
        IniSesion1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IniSesion1.setForeground(new java.awt.Color(255, 255, 255));
        IniSesion1.setText("Quiero ser cliente profesional");
        IniSesion1.setBorder(null);
        IniSesion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniSesion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IniSesion1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                IniSesion1MouseReleased(evt);
            }
        });
        IniSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniSesion1ActionPerformed(evt);
            }
        });

        IniSesion2.setBackground(new java.awt.Color(255, 125, 0));
        IniSesion2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        IniSesion2.setForeground(new java.awt.Color(255, 255, 255));
        IniSesion2.setText("Mis productos");
        IniSesion2.setBorder(null);
        IniSesion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniSesion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IniSesion2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                IniSesion2MouseReleased(evt);
            }
        });
        IniSesion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniSesion2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDatosClienteLayout = new javax.swing.GroupLayout(jDatosCliente);
        jDatosCliente.setLayout(jDatosClienteLayout);
        jDatosClienteLayout.setHorizontalGroup(
            jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDatosClienteLayout.createSequentialGroup()
                .addGroup(jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDatosClienteLayout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(jLabel47))
                    .addGroup(jDatosClienteLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDatosClienteLayout.createSequentialGroup()
                                .addComponent(IniSesion2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(IniSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(IniSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jDatosClienteLayout.setVerticalGroup(
            jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDatosClienteLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IniSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IniSesion2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IniSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        jPanel1.add(jDatosCliente, "card3");

        adminProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP1.setBackground(new java.awt.Color(255, 255, 255));
        jP1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1.setForeground(new java.awt.Color(255, 125, 0));
        jP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP1MouseClicked(evt);
            }
        });
        jP1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel4.setText("jLabel4");
        jP1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("jLabel4");
        jP1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel6.setText("jLabel4");
        jP1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 11, -1, 296));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/flechaderecha100.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        adminProductos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 88, 550));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/flechaIzquierda100.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        adminProductos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 86, 570));

        jP2.setBackground(new java.awt.Color(255, 255, 255));
        jP2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP2.setForeground(new java.awt.Color(255, 125, 0));
        jP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP2MouseClicked(evt);
            }
        });
        jP2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel8.setText("jLabel4");
        jP2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("jLabel4");
        jP2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel10.setText("jLabel4");
        jP2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 11, -1, 296));

        jP3.setBackground(new java.awt.Color(255, 255, 255));
        jP3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP3.setForeground(new java.awt.Color(255, 125, 0));
        jP3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP3MouseClicked(evt);
            }
        });
        jP3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel12.setText("jLabel4");
        jP3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("jLabel4");
        jP3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel25.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel25.setText("jLabel4");
        jP3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 190));

        adminProductos.add(jP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 11, -1, 296));

        jP4.setBackground(new java.awt.Color(255, 255, 255));
        jP4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP4.setForeground(new java.awt.Color(255, 125, 0));
        jP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP4MouseClicked(evt);
            }
        });
        jP4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel27.setText("jLabel4");
        jP4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel28.setText("jLabel4");
        jP4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel29.setText("jLabel4");
        jP4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 11, -1, 296));

        jP6.setBackground(new java.awt.Color(255, 255, 255));
        jP6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP6.setForeground(new java.awt.Color(255, 125, 0));
        jP6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP6MouseClicked(evt);
            }
        });
        jP6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel31.setText("jLabel4");
        jP6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel32.setText("jLabel4");
        jP6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel33.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel33.setText("jLabel4");
        jP6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 313, -1, 296));

        jP8.setBackground(new java.awt.Color(255, 255, 255));
        jP8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP8.setForeground(new java.awt.Color(255, 125, 0));
        jP8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP8MouseClicked(evt);
            }
        });
        jP8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel35.setText("jLabel4");
        jP8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel36.setText("jLabel4");
        jP8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel37.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel37.setText("jLabel4");
        jP8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 313, -1, 296));

        jP5.setBackground(new java.awt.Color(255, 255, 255));
        jP5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP5.setForeground(new java.awt.Color(255, 125, 0));
        jP5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP5MouseClicked(evt);
            }
        });
        jP5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel39.setText("jLabel4");
        jP5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel40.setText("jLabel4");
        jP5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel41.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel41.setText("jLabel4");
        jP5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 313, -1, 296));

        jP7.setBackground(new java.awt.Color(255, 255, 255));
        jP7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP7.setForeground(new java.awt.Color(255, 125, 0));
        jP7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jP7MouseClicked(evt);
            }
        });
        jP7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel43.setText("jLabel4");
        jP7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, -1));

        jLabel44.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel44.setText("jLabel4");
        jP7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, -1));

        jLabel45.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel45.setText("jLabel4");
        jP7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, -1));
        jP7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 313, -1, 296));

        noProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNopp.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabelNopp.setText("No se han encontrado productos con las características indicadas");
        jLabelNopp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        noProductos.add(jLabelNopp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, 40));

        travolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/travolta.gif"))); // NOI18N
        noProductos.add(travolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 11, -1, -1));

        adminProductos.add(noProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 550, 560));

        jPanel1.add(adminProductos, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1154, 812));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("final programa" + listaVentas);
        
        IOinfo.guardarClientes(listaClientes);
        IOinfo.guardarProductos(listaProductos);
        IOinfo.guardarVentas(listaVentas);
        
        
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        productosSinUser();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoriasActionPerformed
        // TODO add your handling code here:
        productosCategoria();
        
    }//GEN-LAST:event_jCategoriasActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        actualizarPag();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP1MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p),this).setVisible(true);
    }//GEN-LAST:event_jP1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if (p + 8 < productosMostrar.size()) {
            p += 8;
        }
        actualizarPag();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if (p - 8 >= 0) {
            p -= 8;
        }
        actualizarPag();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP2MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 1),this).setVisible(true);
    }//GEN-LAST:event_jP2MouseClicked

    private void jP3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP3MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 2),this).setVisible(true);
    }//GEN-LAST:event_jP3MouseClicked

    private void jP4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP4MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 3),this).setVisible(true);
    }//GEN-LAST:event_jP4MouseClicked

    private void jP6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP6MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 5),this).setVisible(true);
    }//GEN-LAST:event_jP6MouseClicked

    private void jP8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP8MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 7),this).setVisible(true);
    }//GEN-LAST:event_jP8MouseClicked

    private void jP5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP5MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 4),this).setVisible(true);
    }//GEN-LAST:event_jP5MouseClicked

    private void jP7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jP7MouseClicked
        // TODO add your handling code here:
        new CompraProducto(productosMostrar.get(p + 6),this).setVisible(true);
    }//GEN-LAST:event_jP7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        //productosSinUser();
        System.out.println("listaProductos: "+listaProductos);
        System.out.println("productosMostrar: "+productosMostrar);
        
        productosMostrar = listaProductos;
        
        actualizarPag();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLupaActionPerformed
        // TODO add your handling code here:
        productosMostrar = new ArrayList(0);
        for (Producto product: listaProductos){
            if (jBusqueda.getText().equals(product.getTitulo()) && !product.getCliente().getCorreo().equals(((Cliente)usuario).getCorreo())){
                productosMostrar.add(product);
            }
        }
        actualizarPag();
    }//GEN-LAST:event_jLupaActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        actualizarPag();
    }//GEN-LAST:event_formFocusGained

    private void clave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clave1ActionPerformed

    private void IniSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniSesionActionPerformed
        // TODO add your handling code here:
        new AddProducto().setVisible(true);
    }//GEN-LAST:event_IniSesionActionPerformed

    private void IniSesion1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion1MousePressed

    private void IniSesion1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion1MouseReleased

    private void IniSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniSesion1ActionPerformed
        // TODO add your handling code here:
        new AltaClientePro((Cliente) usuario, this).setVisible(true);
    }//GEN-LAST:event_IniSesion1ActionPerformed

    private void IniSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesionMouseExited
        // TODO add your handling code here:
        IniSesion.setBackground(Color.WHITE);
        IniSesion.setForeground(new Color(255,125,0));
    }//GEN-LAST:event_IniSesionMouseExited

    private void IniSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesionMouseEntered
        // TODO add your handling code here:
        IniSesion.setBackground(new Color(244,184,44));
        IniSesion.setForeground(Color.WHITE);
    }//GEN-LAST:event_IniSesionMouseEntered

    private void IniSesion2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion2MousePressed

    private void IniSesion2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion2MouseReleased

    private void IniSesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniSesion2ActionPerformed
        // TODO add your handling code here:
        productosUser();
    }//GEN-LAST:event_IniSesion2ActionPerformed

    private void IniSesion3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion3MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_IniSesion3MouseEntered

    private void IniSesion3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion3MouseExited

    private void IniSesion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniSesion3ActionPerformed
        // TODO add your handling code here:
        rellenarDatosCliente((Cliente)usuario);
        adminProductos.setVisible(false);
        jDatosCliente.setVisible(true);
    }//GEN-LAST:event_IniSesion3ActionPerformed

    private void IniSesion4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion4MouseEntered

    private void IniSesion4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniSesion4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_IniSesion4MouseExited

    private void IniSesion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniSesion4ActionPerformed
        // TODO add your handling code here:
        new LoginP().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_IniSesion4ActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagCliente().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IniSesion;
    private javax.swing.JButton IniSesion1;
    private javax.swing.JButton IniSesion2;
    private javax.swing.JButton IniSesion3;
    private javax.swing.JButton IniSesion4;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel adminProductos;
    private javax.swing.JTextField ciudad1;
    private javax.swing.JLabel ciudadError;
    private javax.swing.JTextField clave1;
    private javax.swing.JLabel claveError;
    private javax.swing.JFormattedTextField codigoPostal;
    private javax.swing.JLabel codigoPostalError;
    private javax.swing.JTextField correo1;
    private javax.swing.JLabel correoError;
    private javax.swing.JTextArea descripcion1;
    private javax.swing.JLabel descripcionError1;
    private javax.swing.JFormattedTextField dni;
    private javax.swing.JLabel dniError;
    private javax.swing.JFormattedTextField horarioAper1;
    private javax.swing.JLabel horarioError1;
    private javax.swing.JTextField jBusqueda;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCategorias;
    private javax.swing.JPanel jDatosCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNopp;
    private javax.swing.JToggleButton jLupa;
    private javax.swing.JPanel jP1;
    private javax.swing.JPanel jP2;
    private javax.swing.JPanel jP3;
    private javax.swing.JPanel jP4;
    private javax.swing.JPanel jP5;
    private javax.swing.JPanel jP6;
    private javax.swing.JPanel jP7;
    private javax.swing.JPanel jP8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel noProductos;
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel nombreError;
    private javax.swing.JTextField pagWeb1;
    private javax.swing.JLabel pagWebError1;
    private javax.swing.JCheckBox profesional1;
    private javax.swing.JFormattedTextField tarjeta;
    private javax.swing.JLabel tarjetaError;
    private javax.swing.JFormattedTextField telefono1;
    private javax.swing.JLabel telefonoError1;
    private javax.swing.JLabel travolta;
    // End of variables declaration//GEN-END:variables
}
