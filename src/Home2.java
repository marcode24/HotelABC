
import java.awt.Dimension;

public class Home2 extends javax.swing.JFrame {
    HabitacionesGrafico hg = new HabitacionesGrafico();
    public Home2() {
        initComponents();
        this.setLocationRelativeTo(null);
        Login login = new Login();
        boolean visible = login.role.equals("Administrador");
        jMenuUsuarios.setVisible(visible);
        jMenuHabitaciones.setVisible(visible);
        mostrarOcupabilidad();
    }
    
    private void mostrarOcupabilidad() {
        hg.repaint();
        Dimension desktopSize = Escritorio.getSize();
        Dimension IJFReservaciones = hg.getSize();
        hg.setLocation(calcularX(desktopSize, IJFReservaciones), calcularY(desktopSize, IJFReservaciones));
        Escritorio.removeAll();
        Escritorio.add(hg);
        hg.show();
    }
    
    public int calcularX(Dimension desktopSize, Dimension jIFrameSize) {
        return (desktopSize.width - jIFrameSize.width) / 2;
    }
    
    public int calcularY(Dimension desktopSize, Dimension jIFrameSize) {
        return (desktopSize.height - jIFrameSize.height) / 2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItemLogOut = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mItemReservaciones = new javax.swing.JMenuItem();
        mItemNewReservacion = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        mItemUsuarios = new javax.swing.JMenuItem();
        jMenuHabitaciones = new javax.swing.JMenu();
        mItemHabitaciones = new javax.swing.JMenuItem();
        jMOcupabilidad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Home");
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home-regular-36 (1).png"))); // NOI18N
        jMenu1.setText("Inicio");

        mItemLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/log-out-regular-36 (1).png"))); // NOI18N
        mItemLogOut.setText("Cerrar Sesión");
        mItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(mItemLogOut);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/book-content-regular-36 (1).png"))); // NOI18N
        jMenu2.setText("Reservaciones");

        mItemReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/book-content-regular-36 (1).png"))); // NOI18N
        mItemReservaciones.setText("Reservaciones");
        mItemReservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemReservacionesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemReservaciones);

        mItemNewReservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/plus-medical-regular-36.png"))); // NOI18N
        mItemNewReservacion.setText("Crear Reservacion");
        mItemNewReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNewReservacionActionPerformed(evt);
            }
        });
        jMenu2.add(mItemNewReservacion);

        jMenuBar1.add(jMenu2);

        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user-regular-36 (1).png"))); // NOI18N
        jMenuUsuarios.setText("Usuarios");

        mItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user-regular-36 (1).png"))); // NOI18N
        mItemUsuarios.setText("Usuarios");
        mItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(mItemUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        jMenuHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bed-regular-36 (1).png"))); // NOI18N
        jMenuHabitaciones.setText("Habitaciones");

        mItemHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bed-regular-36 (1).png"))); // NOI18N
        mItemHabitaciones.setText("Habitaciones");
        mItemHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemHabitacionesActionPerformed(evt);
            }
        });
        jMenuHabitaciones.add(mItemHabitaciones);

        jMOcupabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/book-content-regular-36 (1).png"))); // NOI18N
        jMOcupabilidad.setText("Ocupabilidad");
        jMOcupabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMOcupabilidadActionPerformed(evt);
            }
        });
        jMenuHabitaciones.add(jMOcupabilidad);

        jMenuBar1.add(jMenuHabitaciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItemReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemReservacionesActionPerformed
        // TODO add your handling code here:
        Escritorio.removeAll();
        Reservaciones reservaciones = new Reservaciones();
        Dimension desktopSize = Escritorio.getSize();
        Dimension IJFReservaciones = reservaciones.getSize();
        reservaciones.setLocation(calcularX(desktopSize, IJFReservaciones), calcularY(desktopSize, IJFReservaciones));
        Escritorio.add(reservaciones);
        reservaciones.show();
    }//GEN-LAST:event_mItemReservacionesActionPerformed

    private void mItemHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemHabitacionesActionPerformed
        Escritorio.removeAll();
        Habitaciones habitaciones = new Habitaciones();
        Dimension desktopSize = Escritorio.getSize();
        Dimension IJFrameHabitaciones = habitaciones.getSize();
        habitaciones.setLocation(calcularX(desktopSize, IJFrameHabitaciones), calcularY(desktopSize, IJFrameHabitaciones));
        Escritorio.add(habitaciones);
        habitaciones.show();
    }//GEN-LAST:event_mItemHabitacionesActionPerformed

    private void mItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemLogOutActionPerformed
        Escritorio.removeAll();
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mItemLogOutActionPerformed

    private void mItemNewReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNewReservacionActionPerformed
        Escritorio.removeAll();
        NuevaReservacion nReservacion = new NuevaReservacion();
        Dimension desktopSize = Escritorio.getSize();
        Dimension IJFrameNReservacion = nReservacion.getSize();
        nReservacion.setLocation(calcularX(desktopSize, IJFrameNReservacion), calcularY(desktopSize, IJFrameNReservacion));
        Escritorio.add(nReservacion);
        nReservacion.show();
    }//GEN-LAST:event_mItemNewReservacionActionPerformed

    private void mItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemUsuariosActionPerformed
        Escritorio.removeAll();
        Usuarios usuarios = new Usuarios();
        Dimension desktopSize = Escritorio.getSize();
        Dimension IJFrameUsuarios = usuarios.getSize();
        usuarios.setLocation(calcularX(desktopSize, IJFrameUsuarios), calcularY(desktopSize, IJFrameUsuarios));
        Escritorio.add(usuarios);
        usuarios.show();
    }//GEN-LAST:event_mItemUsuariosActionPerformed

    private void jMOcupabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMOcupabilidadActionPerformed
        mostrarOcupabilidad();
    }//GEN-LAST:event_jMOcupabilidadActionPerformed

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
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem jMOcupabilidad;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHabitaciones;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JMenuItem mItemHabitaciones;
    private javax.swing.JMenuItem mItemLogOut;
    private javax.swing.JMenuItem mItemNewReservacion;
    private javax.swing.JMenuItem mItemReservaciones;
    private javax.swing.JMenuItem mItemUsuarios;
    // End of variables declaration//GEN-END:variables
}
