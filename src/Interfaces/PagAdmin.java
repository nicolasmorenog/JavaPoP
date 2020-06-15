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
import javapop.Cliente;
import javapop.ClienteProfesional;
import javapop.IOinfo;
import javapop.Producto;
import static javapop.Variables.listaClientes;
import static javapop.Variables.listaProductos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jesus
 */
public class PagAdmin extends javax.swing.JFrame {

    static int p;
    boolean b4 = false;
    boolean b5 = false;
    boolean b6 = false;
    boolean b7 = false;
    boolean b8 = false;
    boolean b9 = false;
    int indexCliente = -1;

    /**
     * Creates new form PagAdmin
     */
    private ArrayList<Producto> productosMostrar;
    private int pp = 0;

    public PagAdmin() {
        initComponents();
        productosMostrar = listaProductos;
        p = 0;

        actualizarListaClientesPanel();

    }

    public void actualizarPag() {
        jP8.setVisible(false);
        jP7.setVisible(false);
        jP6.setVisible(false);
        jP5.setVisible(false);
        jP4.setVisible(false);
        jP3.setVisible(false);
        jP2.setVisible(false);
        jP1.setVisible(false);
        pape1.setVisible(false);
        pape2.setVisible(false);
        pape3.setVisible(false);
        pape4.setVisible(false);
        pape5.setVisible(false);
        pape6.setVisible(false);
        pape7.setVisible(false);
        pape8.setVisible(false);

        if (productosMostrar.size() >= pp + 8) {
            rellenarPanel(jP8, productosMostrar.get(pp + 7));
            jP8.setVisible(true);
            pape8.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 7) {
            rellenarPanel(jP7, productosMostrar.get(pp + 6));
            jP7.setVisible(true);
            pape7.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 6) {
            rellenarPanel(jP6, productosMostrar.get(pp + 5));
            jP6.setVisible(true);
            pape6.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 5) {
            rellenarPanel(jP5, productosMostrar.get(pp + 4));
            jP5.setVisible(true);
            pape5.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 4) {
            rellenarPanel(jP4, productosMostrar.get(pp + 3));
            jP4.setVisible(true);
            pape4.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 3) {
            rellenarPanel(jP3, productosMostrar.get(pp + 2));
            jP3.setVisible(true);
            pape3.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 2) {
            rellenarPanel(jP2, productosMostrar.get(pp + 1));
            jP2.setVisible(true);
            pape2.setVisible(true);
        }
        if (productosMostrar.size() >= pp + 1) {
            rellenarPanel(jP1, productosMostrar.get(pp));
            jP1.setVisible(true);
            pape1.setVisible(true);
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

    private void actualizarListaClientesPanel() {
        int longi = listaClientes.size();

        jPanelc1.setVisible(false);
        jPanelc2.setVisible(false);
        jPanelc3.setVisible(false);
        jPanelc4.setVisible(false);
        jPanelc5.setVisible(false);
        jPanelc6.setVisible(false);

        if ((p + 1) <= longi) {

            jPanelc1.setVisible(true);
            numero1.setText(String.valueOf(p + 1));
            jnombrec1.setText(listaClientes.get(p).getNombre());
            jcorreoc1.setText(listaClientes.get(p).getCorreo());
            if (listaClientes.get(p) instanceof ClienteProfesional) {
                jPanelc1.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc1.setBackground(new Color(255, 255, 255));
            }
        }
        if ((p + 2) <= longi) {

            jPanelc2.setVisible(true);
            numero2.setText(String.valueOf(p + 2));
            jnombrec2.setText(listaClientes.get(p + 1).getNombre());
            jcorreoc2.setText(listaClientes.get(p + 1).getCorreo());
            if (listaClientes.get(p + 1) instanceof ClienteProfesional) {
                jPanelc2.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc2.setBackground(new Color(255, 255, 255));
            }
        }
        if ((p + 3) <= longi) {

            jPanelc3.setVisible(true);
            numero3.setText(String.valueOf(p + 3));
            jnombrec3.setText(listaClientes.get(p + 2).getNombre());
            jcorreoc3.setText(listaClientes.get(p + 2).getCorreo());
            if (listaClientes.get(p + 2) instanceof ClienteProfesional) {
                jPanelc3.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc3.setBackground(new Color(255, 255, 255));
            }
        }
        if ((p + 4) <= longi) {

            jPanelc4.setVisible(true);
            numero4.setText(String.valueOf(p + 4));
            jnombrec4.setText(listaClientes.get(p + 3).getNombre());
            jcorreoc4.setText(listaClientes.get(p + 3).getCorreo());
            if (listaClientes.get(p + 3) instanceof ClienteProfesional) {
                jPanelc4.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc4.setBackground(new Color(255, 255, 255));
            }
        }
        if ((p + 5) <= longi) {

            jPanelc5.setVisible(true);
            numero5.setText(String.valueOf(p + 5));
            jnombrec5.setText(listaClientes.get(p + 4).getNombre());
            jcorreoc5.setText(listaClientes.get(p + 4).getCorreo());
            if (listaClientes.get(p + 4) instanceof ClienteProfesional) {
                jPanelc5.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc5.setBackground(new Color(255, 255, 255));
            }
        }
        if ((p + 6) <= longi) {

            jPanelc6.setVisible(true);
            numero6.setText(String.valueOf(p + 6));
            jnombrec6.setText(listaClientes.get(p + 5).getNombre());
            jcorreoc6.setText(listaClientes.get(p + 5).getCorreo());
            if (listaClientes.get(p + 5) instanceof ClienteProfesional) {
                jPanelc6.setBackground(new Color(254, 194, 67));
            } else {
                jPanelc6.setBackground(new Color(255, 255, 255));
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

        jPanel3 = new javax.swing.JPanel();
        adminClientes = new javax.swing.JPanel();
        listaClientesPanel = new javax.swing.JPanel();
        jPanelc1 = new javax.swing.JPanel();
        numero1 = new javax.swing.JLabel();
        jcorreoc1 = new javax.swing.JLabel();
        jnombrec1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanelc2 = new javax.swing.JPanel();
        numero2 = new javax.swing.JLabel();
        jnombrec2 = new javax.swing.JLabel();
        jcorreoc2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanelc3 = new javax.swing.JPanel();
        numero3 = new javax.swing.JLabel();
        jnombrec3 = new javax.swing.JLabel();
        jcorreoc3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanelc4 = new javax.swing.JPanel();
        numero4 = new javax.swing.JLabel();
        jnombrec4 = new javax.swing.JLabel();
        jcorreoc4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanelc5 = new javax.swing.JPanel();
        numero5 = new javax.swing.JLabel();
        jnombrec5 = new javax.swing.JLabel();
        jcorreoc5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanelc6 = new javax.swing.JPanel();
        numero6 = new javax.swing.JLabel();
        jnombrec6 = new javax.swing.JLabel();
        jcorreoc6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        pape8 = new javax.swing.JButton();
        pape1 = new javax.swing.JButton();
        pape2 = new javax.swing.JButton();
        pape3 = new javax.swing.JButton();
        pape4 = new javax.swing.JButton();
        pape5 = new javax.swing.JButton();
        pape6 = new javax.swing.JButton();
        pape7 = new javax.swing.JButton();
        TopPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setLayout(new java.awt.CardLayout());

        listaClientesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelc1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc1MouseClicked(evt);
            }
        });
        jPanelc1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero1.setText("1.");
        jPanelc1.add(numero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jcorreoc1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc1.add(jcorreoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jnombrec1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc1.add(jnombrec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jButton4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setBorder(null);
        jButton4.setOpaque(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanelc1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 506, 60));

        jPanelc2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc2MouseClicked(evt);
            }
        });
        jPanelc2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero2.setText("2.");
        jPanelc2.add(numero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jnombrec2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc2.add(jnombrec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jcorreoc2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc2.add(jcorreoc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jButton5.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.setBorder(null);
        jButton5.setOpaque(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanelc2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 506, 60));

        jPanelc3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc3MouseClicked(evt);
            }
        });
        jPanelc3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero3.setText("3.");
        jPanelc3.add(numero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jnombrec3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc3.add(jnombrec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jcorreoc3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc3.add(jcorreoc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jButton6.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton6.setText("Eliminar");
        jButton6.setBorder(null);
        jButton6.setOpaque(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanelc3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 506, 60));

        jPanelc4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc4MouseClicked(evt);
            }
        });
        jPanelc4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero4.setText("4.");
        jPanelc4.add(numero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jnombrec4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc4.add(jnombrec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jcorreoc4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc4.add(jcorreoc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jButton7.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.setBorder(null);
        jButton7.setOpaque(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanelc4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 506, 60));

        jPanelc5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc5MouseClicked(evt);
            }
        });
        jPanelc5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero5.setText("5.");
        jPanelc5.add(numero5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jnombrec5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc5.add(jnombrec5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jcorreoc5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc5.add(jcorreoc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jButton8.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton8.setText("Eliminar");
        jButton8.setBorder(null);
        jButton8.setOpaque(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanelc5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 506, 60));

        jPanelc6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelc6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelc6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelc6MouseClicked(evt);
            }
        });
        jPanelc6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        numero6.setText("6.");
        jPanelc6.add(numero6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jnombrec6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc6.add(jnombrec6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jcorreoc6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanelc6.add(jcorreoc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, 20));

        jButton9.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton9.setText("Eliminar");
        jButton9.setBorder(null);
        jButton9.setOpaque(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanelc6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 20, 70, -1));

        listaClientesPanel.add(jPanelc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 506, 60));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jButton2.setText("<---");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        listaClientesPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jButton3.setText("--->");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        listaClientesPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

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

        jButton10.setText("Ver productos cliente");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(0, 111, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(244, 184, 44));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout adminClientesLayout = new javax.swing.GroupLayout(adminClientes);
        adminClientes.setLayout(adminClientesLayout);
        adminClientesLayout.setHorizontalGroup(
            adminClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminClientesLayout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(listaClientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminClientesLayout.setVerticalGroup(
            adminClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminClientesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(adminClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaClientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(adminClientes, "card4");

        adminProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP1.setBackground(new java.awt.Color(255, 255, 255));
        jP1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1.setForeground(new java.awt.Color(255, 125, 0));
        jP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        adminProductos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 88, 550));

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
        jP3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 190));

        adminProductos.add(jP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 11, -1, 296));

        jP4.setBackground(new java.awt.Color(255, 255, 255));
        jP4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP4.setForeground(new java.awt.Color(255, 125, 0));
        jP4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        pape8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape8.setBorder(null);
        pape8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape8ActionPerformed(evt);
            }
        });
        adminProductos.add(pape8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 20, -1));

        pape1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape1.setBorder(null);
        pape1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape1ActionPerformed(evt);
            }
        });
        adminProductos.add(pape1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 20, -1));

        pape2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape2.setBorder(null);
        pape2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape2ActionPerformed(evt);
            }
        });
        adminProductos.add(pape2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 20, -1));

        pape3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape3.setBorder(null);
        pape3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape3ActionPerformed(evt);
            }
        });
        adminProductos.add(pape3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 20, -1));

        pape4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape4.setBorder(null);
        pape4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape4ActionPerformed(evt);
            }
        });
        adminProductos.add(pape4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 20, -1));

        pape5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape5.setBorder(null);
        pape5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape5ActionPerformed(evt);
            }
        });
        adminProductos.add(pape5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 20, -1));

        pape6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape6.setBorder(null);
        pape6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape6ActionPerformed(evt);
            }
        });
        adminProductos.add(pape6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 20, -1));

        pape7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/papeleraPeque.png"))); // NOI18N
        pape7.setBorder(null);
        pape7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pape7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pape7ActionPerformed(evt);
            }
        });
        adminProductos.add(pape7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 20, -1));

        jPanel3.add(adminProductos, "card2");

        TopPanel.setBackground(new java.awt.Color(244, 184, 44));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javapop/Imagenes/LogoBlanco.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrar clientes", "Administrar productos", "Administrar ventas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(78, 78, 78)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(136, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        setSize(new java.awt.Dimension(1158, 811));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //IOinfo.guardarClientesProfesionales(listaClientesProfesionales);
        IOinfo.guardarClientes(listaClientes);
        IOinfo.guardarProductos(listaProductos);

        System.out.println("final programa" + listaClientes);
        //System.out.println("final programa clientes profesionales" + listaClientesProfesionales);
        System.out.println("final programa productos" + listaProductos);
    }//GEN-LAST:event_formWindowClosing

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int selec = jComboBox1.getSelectedIndex();

        if (selec == 0 && !adminClientes.isVisible()) {
            adminClientes.setVisible(true);
            actualizarListaClientesPanel();
            adminProductos.setVisible(false);
            //adminVentas.setVisible(false);
        } else if (selec == 1 && !adminProductos.isVisible()) {
            adminClientes.setVisible(false);
            adminProductos.setVisible(true);
            actualizarPag();
            //adminVentas.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (p + 6 < listaClientes.size()) {
            p += 6;
            actualizarListaClientesPanel();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (p - 6 >= 0) {
            p -= 6;
            actualizarListaClientesPanel();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new LoginP().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p);
        actualizarListaClientesPanel();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p + 1);
        actualizarListaClientesPanel();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p + 2);
        actualizarListaClientesPanel();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p + 3);
        actualizarListaClientesPanel();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p + 4);
        actualizarListaClientesPanel();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        listaClientes.remove(p + 5);
        actualizarListaClientesPanel();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void clave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clave1ActionPerformed

    private void jPanelc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc1MouseClicked
        // TODO add your handling code here:
        if (!b4) {
            rellenarDatosCliente(listaClientes.get(p));
            indexCliente = 0;
        }

    }//GEN-LAST:event_jPanelc1MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        b4 = true;
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        b4 = false;
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        b5 = true;
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        b5 = false;
    }//GEN-LAST:event_jButton5MouseExited

    private void jPanelc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc2MouseClicked
        // TODO add your handling code here:
        if (!b5) {
            rellenarDatosCliente(listaClientes.get(p + 1));
            indexCliente = 1;
        }
    }//GEN-LAST:event_jPanelc2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if (pp + 8 < productosMostrar.size()) {
            pp += 8;
        }
        actualizarPag();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if (pp - 8 >= 0) {
            pp -= 8;
        }
        actualizarPag();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void pape8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape8ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 7).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 7));
        
        productosMostrar.get(pp + 7).getCliente().setListaProductos(productos);
        listaProductos.remove(productosMostrar.get(pp + 7));

        actualizarPag();
    }//GEN-LAST:event_pape8ActionPerformed

    private void pape6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape6ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 5).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 5));
        
        productosMostrar.get(pp + 5).getCliente().setListaProductos(productos);
        listaProductos.remove(productosMostrar.get(pp + 5));

        actualizarPag();
    }//GEN-LAST:event_pape6ActionPerformed

    private void pape1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape1ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp).getCliente().getListaProductos();         
        productos.remove(productosMostrar.get(pp));
        
        productosMostrar.get(pp).getCliente().setListaProductos(productos);
        
        listaProductos.remove(productosMostrar.get(pp));
        actualizarPag();
    }//GEN-LAST:event_pape1ActionPerformed

    private void jPanelc4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc4MouseClicked
        // TODO add your handling code here:
        if (!b7) {
            rellenarDatosCliente(listaClientes.get(p + 3));
            indexCliente = 3;
        }
    }//GEN-LAST:event_jPanelc4MouseClicked

    private void jPanelc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc5MouseClicked
        // TODO add your handling code here:
        if (!b8) {
            rellenarDatosCliente(listaClientes.get(p + 4));
            indexCliente = 4;
        }
    }//GEN-LAST:event_jPanelc5MouseClicked

    private void jPanelc6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc6MouseClicked
        // TODO add your handling code here:
        if (!b9) {
            rellenarDatosCliente(listaClientes.get(p + 5));
            indexCliente = 5;
        }
    }//GEN-LAST:event_jPanelc6MouseClicked

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        b7 = true;
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        b7 = false;
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        b8 = true;
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        b8 = false;
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        b9 = true;
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        b9 = false;
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        b6 = true;
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        b6 = false;
    }//GEN-LAST:event_jButton6MouseExited

    private void jPanelc3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelc3MouseClicked
        // TODO add your handling code here:
        if (!b6) {
            rellenarDatosCliente(listaClientes.get(p + 2));
            indexCliente = 2;
        }
    }//GEN-LAST:event_jPanelc3MouseClicked

    private void pape2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape2ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 1).getCliente().getListaProductos();
        
        productos.remove(productosMostrar.get(pp + 1));
        productosMostrar.get(pp + 1).getCliente().setListaProductos(productos);
          
        listaProductos.remove(productosMostrar.get(pp + 1));

        actualizarPag();
    }//GEN-LAST:event_pape2ActionPerformed

    private void pape3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape3ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 2).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 2));
        
        productosMostrar.get(pp + 2).getCliente().setListaProductos(productos);
        listaProductos.remove(productosMostrar.get(pp + 2));

        actualizarPag();
    }//GEN-LAST:event_pape3ActionPerformed

    private void pape4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape4ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 3).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 3));
        
        productosMostrar.get(pp + 3).getCliente().setListaProductos(productos);
        
        listaProductos.remove(productosMostrar.get(pp + 3));

        actualizarPag();
    }//GEN-LAST:event_pape4ActionPerformed

    private void pape5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape5ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 4).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 4));
        
        productosMostrar.get(pp + 4).getCliente().setListaProductos(productos);
        listaProductos.remove(productosMostrar.get(pp + 4));

        actualizarPag();
    }//GEN-LAST:event_pape5ActionPerformed

    private void pape7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pape7ActionPerformed
        // TODO add your handling code here:
        ArrayList<Producto> productos = productosMostrar.get(pp + 6).getCliente().getListaProductos();
        productos.remove(productosMostrar.get(pp + 6));
        
        productosMostrar.get(pp + 6).getCliente().setListaProductos(productos);
        listaProductos.remove(productosMostrar.get(pp + 6));

        actualizarPag();
    }//GEN-LAST:event_pape7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        productosMostrar = listaClientes.get(indexCliente).getListaProductos();
        adminProductos.setVisible(true);
        adminClientes.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(PagAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagAdmin().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel adminClientes;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP1;
    private javax.swing.JPanel jP2;
    private javax.swing.JPanel jP3;
    private javax.swing.JPanel jP4;
    private javax.swing.JPanel jP5;
    private javax.swing.JPanel jP6;
    private javax.swing.JPanel jP7;
    private javax.swing.JPanel jP8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelc1;
    private javax.swing.JPanel jPanelc2;
    private javax.swing.JPanel jPanelc3;
    private javax.swing.JPanel jPanelc4;
    private javax.swing.JPanel jPanelc5;
    private javax.swing.JPanel jPanelc6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jcorreoc1;
    private javax.swing.JLabel jcorreoc2;
    private javax.swing.JLabel jcorreoc3;
    private javax.swing.JLabel jcorreoc4;
    private javax.swing.JLabel jcorreoc5;
    private javax.swing.JLabel jcorreoc6;
    private javax.swing.JLabel jnombrec1;
    private javax.swing.JLabel jnombrec2;
    private javax.swing.JLabel jnombrec3;
    private javax.swing.JLabel jnombrec4;
    private javax.swing.JLabel jnombrec5;
    private javax.swing.JLabel jnombrec6;
    private javax.swing.JPanel listaClientesPanel;
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel nombreError;
    private javax.swing.JLabel numero1;
    private javax.swing.JLabel numero2;
    private javax.swing.JLabel numero3;
    private javax.swing.JLabel numero4;
    private javax.swing.JLabel numero5;
    private javax.swing.JLabel numero6;
    private javax.swing.JTextField pagWeb1;
    private javax.swing.JLabel pagWebError1;
    private javax.swing.JButton pape1;
    private javax.swing.JButton pape2;
    private javax.swing.JButton pape3;
    private javax.swing.JButton pape4;
    private javax.swing.JButton pape5;
    private javax.swing.JButton pape6;
    private javax.swing.JButton pape7;
    private javax.swing.JButton pape8;
    private javax.swing.JCheckBox profesional1;
    private javax.swing.JFormattedTextField tarjeta;
    private javax.swing.JLabel tarjetaError;
    private javax.swing.JFormattedTextField telefono1;
    private javax.swing.JLabel telefonoError1;
    // End of variables declaration//GEN-END:variables
}
