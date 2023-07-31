package Vista;

import Config.Conexion;
import Entidades.Aspectos;
import Entidades.Notas;
import Entidades.Preguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class AspectosEstudiantes extends javax.swing.JFrame {
    int idusuario = 0;
    int idcaracteristica = 0;
    Set<String> preguntasGuardadas = new HashSet<>();
    Conexion con = new Conexion();

    //Constructor - iniciar componentes
    public AspectosEstudiantes(Conexion conexion, int idcaracteristica) throws SQLException {
        this.idcaracteristica = idcaracteristica;
        setTitle("Encuestas");
        con = conexion;
        initComponents();
        agrupacion();
        locacionventana();
        llenaraspectos(idcaracteristica);
        seleccion();
    }

    //Lugar de la ventana
    void locacionventana() {
        setLocationRelativeTo(null);
    }

    //Llenar preguntas
    void llenarpreguntas(int idencuesta) throws SQLException {
        Preguntas listapre = new Preguntas(con, "");
        ArrayList<Preguntas> lista = listapre.getPreguntas(idencuesta);
        seleccionpre.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            seleccionpre.addItem(lista.get(i).toString());
        }
    }

    //Llenar aspectos
    void llenaraspectos(int id) throws SQLException {
        Aspectos listaas = new Aspectos(con, 1, "");
        ArrayList<Aspectos> lista = listaas.getAspectos(id);
        seleccionaspecto.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            seleccionaspecto.addItem(lista.get(i).toString());
        }
    }

    //Determinar el aspecto
    void determinaraspec() {
        seleccionpre.removeAllItems();
        String selecaspect = (String) seleccionaspecto.getSelectedItem();   //Aspecto seleccionado
        try {
            switch (selecaspect) {
                case "Aspecto 101":
                    llenarpreguntas(1);
                    break;
                case "Aspecto 102":
                    llenarpreguntas(2);
                    break;
                case "Aspecto 103":
                    llenarpreguntas(3);
                    break;
                case "Aspecto 104":
                    llenarpreguntas(4);
                    break;
            }
        } catch (Exception e) {
        }
    }

    private AspectosEstudiantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Determinar las respuestas de las preguntas
    void preguntasres() {
        int cantidad = preguntasGuardadas.size();
        if (cantidad == 6) {
            JOptionPane.showMessageDialog(null, "Todas las preguntas han sido respondidas");
            cerrar();
        }
    }

    //Agrupacion de botones
    void agrupacion() {
        ButtonGroup primeraagrupacion = new ButtonGroup();

        primeraagrupacion.add(totaldesacuerdo);
        primeraagrupacion.add(endesacuerdo);
        primeraagrupacion.add(neutral);
        primeraagrupacion.add(deacuerdo);
        primeraagrupacion.add(totalacuerdo);
    }

    //SEleccion ed la respuesta
    void seleccion() {
        final int[] numeroRespuesta = new int[1];

        ActionListener siguiente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                numeroRespuesta[0] = Integer.parseInt(selectedRadioButton.getActionCommand());
            }
        };

        totaldesacuerdo.setActionCommand("1");
        endesacuerdo.setActionCommand("2");
        neutral.setActionCommand("3");
        deacuerdo.setActionCommand("4");
        totalacuerdo.setActionCommand("5");

        totaldesacuerdo.addActionListener(siguiente);
        endesacuerdo.addActionListener(siguiente);
        neutral.addActionListener(siguiente);
        deacuerdo.addActionListener(siguiente);
        totalacuerdo.addActionListener(siguiente);

        ActionListener guardarRespuesta = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Notas nota = new Notas(con);
                String pre = (String) seleccionpre.getSelectedItem();
                if (preguntasGuardadas.contains(pre)) {
                    JOptionPane.showMessageDialog(null, "La pregunta ya fue guardada");
                } else {
                    preguntasGuardadas.add(pre);
                    try {
                        nota.guardarnota(numeroRespuesta[0], pre);
                    } catch (SQLException ex) {
                        Logger.getLogger(AspectosEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    preguntasres();
                }
            }
        };

        Siguiente.addActionListener(guardarRespuesta);
    }

    //Cerrar la ventana
    void cerrar() {
        this.dispose();;
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        totaldesacuerdo = new javax.swing.JRadioButton();
        endesacuerdo = new javax.swing.JRadioButton();
        neutral = new javax.swing.JRadioButton();
        deacuerdo = new javax.swing.JRadioButton();
        totalacuerdo = new javax.swing.JRadioButton();
        seleccionpre = new javax.swing.JComboBox<>();
        seleccionaspecto = new javax.swing.JComboBox<>();
        Siguiente = new javax.swing.JButton();
        volver1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        totaldesacuerdo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totaldesacuerdo.setText("Totalmente en desacuerdo");
        totaldesacuerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaldesacuerdoActionPerformed(evt);
            }
        });

        endesacuerdo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        endesacuerdo.setText("En desacuerdo");
        endesacuerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endesacuerdoActionPerformed(evt);
            }
        });

        neutral.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        neutral.setText("Neutral");

        deacuerdo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deacuerdo.setText("De acuerdo");
        deacuerdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deacuerdoActionPerformed(evt);
            }
        });

        totalacuerdo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalacuerdo.setText("Totalmente de acuerdo");

        seleccionpre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        seleccionpre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionpreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(seleccionpre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(totaldesacuerdo)
                        .addGap(126, 126, 126)
                        .addComponent(endesacuerdo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(neutral)
                        .addGap(71, 71, 71)
                        .addComponent(deacuerdo)
                        .addGap(100, 100, 100)
                        .addComponent(totalacuerdo)
                        .addGap(22, 22, 22))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(seleccionpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totaldesacuerdo)
                    .addComponent(endesacuerdo)
                    .addComponent(neutral)
                    .addComponent(deacuerdo)
                    .addComponent(totalacuerdo))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        seleccionaspecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionaspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionaspectoActionPerformed(evt);
            }
        });

        Siguiente.setText("Guardar Respuesta");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        volver1.setText("Volver a la Seleccion");
        volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar Aspecto");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Seleccionar la Pregunta");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoUNIAJC.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(seleccionaspecto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(442, 442, 442)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(seleccionaspecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Siguiente)
                .addGap(37, 37, 37)
                .addComponent(volver1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totaldesacuerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaldesacuerdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totaldesacuerdoActionPerformed

    private void endesacuerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endesacuerdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endesacuerdoActionPerformed

    private void deacuerdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deacuerdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deacuerdoActionPerformed

    private void seleccionpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionpreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionpreActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        //Siguiente

    }//GEN-LAST:event_SiguienteActionPerformed

    private void volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver1ActionPerformed
        cerrar();

    }//GEN-LAST:event_volver1ActionPerformed

    private void seleccionaspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionaspectoActionPerformed
        determinaraspec();
    }//GEN-LAST:event_seleccionaspectoActionPerformed

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
            java.util.logging.Logger.getLogger(AspectosEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AspectosEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AspectosEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AspectosEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AspectosEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Siguiente;
    private javax.swing.JRadioButton deacuerdo;
    private javax.swing.JRadioButton endesacuerdo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton neutral;
    private javax.swing.JComboBox<String> seleccionaspecto;
    private javax.swing.JComboBox<String> seleccionpre;
    private javax.swing.JRadioButton totalacuerdo;
    private javax.swing.JRadioButton totaldesacuerdo;
    private javax.swing.JButton volver1;
    // End of variables declaration//GEN-END:variables
}
