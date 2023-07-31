package Vista;

import Config.Conexion;
import Entidades.Caracteristicas;
import Entidades.Factores;
import Entidades.Usuario;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Aplicacion extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Statement statement = null;
    String nombre, rol;
    int idusuario;
    
    //Componentes principales edl jframe
    public Aplicacion(Conexion conexion, int idusuario) throws SQLException {
        setTitle("Herramientas");
        this.nombre = nombre;
        con = conexion;
        this.idusuario=idusuario;
        initComponents();
        locacionventana();
        llenarfactores();
        llenarpanelusuario(idusuario);
    }
    
    //Lugar en donde se muestra la locacion de la ventana
    void locacionventana() {
        setLocationRelativeTo(null);    //Null para mostrarse centrada
    }
    
    //Panel de Usuario, en donde se muestra la informacion del usuario
    void llenarpanelusuario(int idusuario) throws SQLException{
        Usuario temp=new Usuario(con);
        String temprol=temp.getRolById(idusuario);
        String tempnombre=temp.getNombreById(idusuario);
        mostrarnombre.setText(tempnombre);
        mostrarrol.setText(temprol);
    }

    //Lista de factores, este metodo es para llenar el jcombo box con los factores
    void llenarfactores() throws SQLException {
        Factores listaf = new Factores(con, "");
        ArrayList<Factores> lista = listaf.getFactores();
        seleccionfactor.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            seleccionfactor.addItem(lista.get(i).toString());
        }
    }

    //Lista caracteristicas, este metodo es para llenar el jcombo box con las caracteristicas
    void llenarcaracteristicas(int id) throws SQLException {
        Caracteristicas listacarac = new Caracteristicas(con, "");
        ArrayList<Caracteristicas> lista = listacarac.getCaracteristicas(id);
        seleccioncarac.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            seleccioncarac.addItem(lista.get(i).toString());
        }
    }

    //Determinar factor, este metodo es para saber que factor esta seleccionado y asi llenar las caracteristicas
    void determinarfactor() throws SQLException {
        seleccioncarac.removeAllItems();
        String factorselec = (String) seleccionfactor.getSelectedItem(); //factor
        try {
            switch (factorselec) {
                case "Factor 1":
                    //
                    break;
                case "Factor 2":
                    //
                    break;
                case "Factor 3":
                    //
                    break;
                case "Factor 4":
                    //
                    break;
                case "Factor 5":
                    //
                    break;
                case "Factor 6":
                    //
                    break;
                case "Factor 7":
                    //
                    break;
                case "Factor 8":
                    //
                    break;
                case "Factor 9":
                    //
                    break;
                case "Factor 10":
                    //
                    break;
                case "Factor 11":
                    //
                    break;
                case "Factor 12":
                    llenarcaracteristicas(12);
                    break;
            }
        } catch (Exception e) {
        }
    }

    //El metodo continuar al ejecutar el boton seleccionar para abrir el jframe "Aspectos"
    void continuar() throws SQLException {
        String factorselec = (String) seleccionfactor.getSelectedItem();
        String caracselect = (String) seleccioncarac.getSelectedItem();
        Caracteristicas tempcaracteristicas=new Caracteristicas(con,""); 
        if (factorselec.equals("Factor 12") && caracselect.equals("Caracteristica 47")) { //Determinar que caracteristica se selecciono
            int idcaracteristicas=tempcaracteristicas.getIDCaracteristicaNombre(caracselect);
            Usuario tempuser=new Usuario(con);
            String temprol=tempuser.getRolById(idusuario);
            if(temprol.equals("Estudiante")){               //En esta parte se determina el rol al momento de abrir el jframe
                AspectosEstudiantes aspectoestujframe = new AspectosEstudiantes(con,idcaracteristicas);
                aspectoestujframe.setVisible(true);              //jframe para el rol estudiante
            } else { 
                AspectosAdministrador adminjframe = new AspectosAdministrador(con,idcaracteristicas);
                adminjframe.setVisible(true);                    //jframe para el rol Administrador
            }
        } else if (factorselec.equals("Factor 12") && caracselect.equals("Caracteristica 48")){//Determinar que caracteristica se selecciono
            int idcaracteristicas=tempcaracteristicas.getIDCaracteristicaNombre(caracselect);
            Usuario tempuser=new Usuario(con);
            String temprol=tempuser.getRolById(idusuario);
            if(temprol.equals("Estudiante")){               //En esta parte se determina el rol al momento de abrir el jframe
                AspectosEstudiantes aspectoestujframe = new AspectosEstudiantes(con,idcaracteristicas);
                aspectoestujframe.setVisible(true);              //jframe para el rol estudiante
            } else { 
                AspectosAdministrador adminjframe = new AspectosAdministrador(con,idcaracteristicas);
                adminjframe.setVisible(true);                    //jframe para el rol Administrador
            }
        }else {
            JOptionPane.showMessageDialog(null, "El factor seleccionado no esta implementado");
        }
    }


    //Aunque no parezca importante esto ¡No se borra! o explota todo
    private Aplicacion() {
    }

    //Metodo para cerrar el programa
    void terminar() {
        con.desconectar();
        System.exit(0);
    }
    
    //Metodo para volver al jframe "Principal"
    void volverlogin() throws SQLException {
        con.desconectar();
        Principal principalframe = new Principal();
        principalframe.setVisible(true);
        this.dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mostrarnombre = new javax.swing.JLabel();
        mostrarrol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        seleccionfactor = new javax.swing.JComboBox<>();
        seleccioncarac = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        continuar = new javax.swing.JButton();
        volverlogin = new javax.swing.JButton();
        botonfinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Selección");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Rol:");

        mostrarnombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mostrarnombre.setText("");

        mostrarrol.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mostrarrol.setText("a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostrarrol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mostrarnombre))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mostrarrol))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        seleccionfactor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTOR 1","FACTOR 2","FACTOR 3","FACTOR 4","FACTOR 5","FACTOR 6","FACTOR 7","FACTOR 8","FACTOR 9","FACTOR 10","FACTOR 11","FACTOR 12"}));
        seleccionfactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionfactorActionPerformed(evt);
            }
        });

        seleccioncarac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Caracteristica 47","Caracteristica 48" }));
        seleccioncarac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccioncaracActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Seleccionar Factor");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Seleccionar Característica");

        continuar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        continuar.setText("Seleccionar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(seleccioncarac, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionfactor, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(continuar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionfactor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccioncarac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        volverlogin.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        volverlogin.setText("Volver al Login");
        volverlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverloginActionPerformed(evt);
            }
        });

        botonfinalizar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonfinalizar.setText("Terminar");
        botonfinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonfinalizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Usuario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(botonfinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(volverlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel5))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonfinalizar)
                    .addComponent(volverlogin))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/698151f9-eb9d-445a-9e2d-8388c1a36363.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton que llama al metodo terminar
    private void botonfinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonfinalizarActionPerformed
        terminar();
    }//GEN-LAST:event_botonfinalizarActionPerformed

        //jcombo box con la lista de factores para la seleccion
    private void seleccionfactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionfactorActionPerformed
        //Seleccion factor
        try {
            determinarfactor();
        } catch (SQLException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_seleccionfactorActionPerformed

        //jcombo box con la lista de caracteristicas para la seleccion
    private void seleccioncaracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccioncaracActionPerformed
        //Seleccion carac
        String valorSeleccionado = (String) seleccioncarac.getSelectedItem();
    }//GEN-LAST:event_seleccioncaracActionPerformed

        //Boton de seleccionar que llama al metodo continuar
    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        try {
            //Boton continuar
            continuar();
        } catch (SQLException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_continuarActionPerformed

        //Boton que llama al metodo volverlogin
    private void volverloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverloginActionPerformed
        try {
            volverlogin();
        } catch (SQLException ex) {
            Logger.getLogger(AspectosEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_volverloginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonfinalizar;
    private javax.swing.JButton continuar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel mostrarnombre;
    private javax.swing.JLabel mostrarrol;
    private javax.swing.JComboBox<String> seleccioncarac;
    private javax.swing.JComboBox<String> seleccionfactor;
    private javax.swing.JButton volverlogin;
    // End of variables declaration//GEN-END:variables
}