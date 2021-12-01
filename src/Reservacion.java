import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

import utils.Validaciones;
import controladores.HabitacionController;
import controladores.HorarioController;
import controladores.ReservacionController;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import modelos.Habitacion;
import modelos.Horario;
import modelos.ReservacionCS;

public class Reservacion extends javax.swing.JFrame {
    private HabitacionController cHabitacion = new HabitacionController();
    private Informacion informacion = new Informacion();
    private ArrayList<Habitacion> habitaciones;
    private Double total = 0.0;
    private int idHabitacion = -1;
    
    public Reservacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarHabitaciones();
        String nochesText = informacion.noches.toString() + ((informacion.noches > 1) ? " noches" : " noche" );
        lblNoches.setText(nochesText);
        cmbHabitaciones.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                cambiarInformacion(itemEvent.getItem().toString());
            }
        });
    }
   
    private void cargarHabitaciones() {
        habitaciones = informacion.habitacionesDisponibles;
        String array[] = new String[habitaciones.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = habitaciones.get(i).getNombre();
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(array);
        cmbHabitaciones.setModel(modelo);
        setInformacion(0);
    }
    
    private void cambiarInformacion(String busqueda) { 
        int i=0;
        while(!habitaciones.get(i).getNombre().equals(busqueda)){
            i++;
        }
        setInformacion(i);
        
    }
    
    private void setInformacion(int i) {
        lblTitulo.setText(habitaciones.get(i).getNombre());
        lblCama.setText(habitaciones.get(i).getCantidadCamas()+" "+ habitaciones.get(i).getCama());
        txtDescripcion.setText(habitaciones.get(i).getDescripcion());
        lblTamanio.setText(habitaciones.get(i).getTamanioHabitacion() + " m²");
        Double precio = habitaciones.get(i).getPrecio();
        total = informacion.noches * precio; 
        lblPrecio.setText(habitaciones.get(i).getPrecio().toString());
        lblTotal.setText(total.toString()); 
        int cantidad = habitaciones.get(i).getCapacidad();
        String textCapacidad = cantidad + ((cantidad > 1) ? " Personas" : " Persona" );
        idHabitacion = habitaciones.get(i).getIdHabitacion();
        ImageIcon icono = new ImageIcon(habitaciones.get(i).getImagen());
        Image imgEscalada = icono.getImage().getScaledInstance(lblImagen.getWidth(),
                lblImagen.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lblImagen.setIcon(iconoEscalado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbHabitaciones = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblTamanio = new javax.swing.JLabel();
        lblPersonas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        lblPrecio = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCama = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblNoches = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jButton2.setFont(new java.awt.Font("Ubuntu weight=255", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hotel-regular-36.png"))); // NOI18N
        jButton2.setText("Reservar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservar");
        setBackground(new java.awt.Color(0, 186, 230));
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 186, 230));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cmbHabitaciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHabitacionesItemStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 186, 230));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(1, 1, 1)), "Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(1, 1, 1));

        lblTamanio.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        lblTamanio.setForeground(new java.awt.Color(1, 1, 1));
        lblTamanio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruler-regular-36.png"))); // NOI18N
        lblTamanio.setText("517 ft² / 48 m²");

        lblPersonas.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        lblPersonas.setForeground(new java.awt.Color(1, 1, 1));
        lblPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-regular-36.png"))); // NOI18N
        lblPersonas.setText("4 Personas");

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(0, 186, 230));
        txtDescripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtDescripcion.setForeground(new java.awt.Color(1, 1, 1));
        txtDescripcion.setText("Esta habitación le brinda espacios ergonómicos, diseñados con excelente gusto contemporáneo, donde sus sentidos se avivan y la más alta tecnología lo acompaña en los momentos de estar, trabajo o descanso. - Cama King con feather bed - Sábanas de 400 hilos - Menú de almohadas y kit de aromaterapia - Smart TV de 65\" - Cortinas eléctricas de diseñador - Cafetera Nespresso - Habitación de 48 m2 El baño le ofrece un lugar íntimo, cuenta con una fascinante tina independiente de la ducha y una pantalla de 22 pulgadas. Disfrute plenamente cada detalle y complete su experiencia contemplando la preciosa vista panorámica de la ciudad.");
        txtDescripcion.setMaximumSize(new java.awt.Dimension(122, 18));
        jScrollPane2.setViewportView(txtDescripcion);

        lblPrecio.setFont(new java.awt.Font("Ubuntu weight=255", 0, 36)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(1, 1, 1));
        lblPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dollar-regular-36.png"))); // NOI18N
        lblPrecio.setText("1,400");

        lblTitulo.setFont(new java.awt.Font("Ubuntu weight=255", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(1, 1, 1));
        lblTitulo.setText("Deluxe Room A");

        lblCama.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        lblCama.setForeground(new java.awt.Color(1, 1, 1));
        lblCama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bed-regular-36.png"))); // NOI18N
        lblCama.setText("1 Cama King");

        jLabel14.setFont(new java.awt.Font("Ubuntu weight=255", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Precio x Noche");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrecio)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblTamanio)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblPersonas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                        .addComponent(lblCama)
                                        .addGap(67, 67, 67))))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPersonas)
                            .addComponent(lblCama))
                        .addGap(18, 18, 18)
                        .addComponent(lblTamanio)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecio))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(7, 7, 7))
        );

        lblTotal.setFont(new java.awt.Font("Ubuntu weight=255", 0, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(1, 1, 1));
        lblTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dollar-regular-36.png"))); // NOI18N

        lblNoches.setFont(new java.awt.Font("Ubuntu weight=255", 0, 24)); // NOI18N
        lblNoches.setForeground(new java.awt.Color(1, 1, 1));

        jLabel3.setFont(new java.awt.Font("Ubuntu weight=255", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Condiciones de Alojamiento");

        jLabel12.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("Horarios");

        jLabel4.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log-in-regular-36.png"))); // NOI18N
        jLabel4.setText("Check in: 14:00");

        jLabel17.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 1, 1));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log-out-regular-36.png"))); // NOI18N
        jLabel17.setText("Check out: 12:00");

        jLabel20.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(1, 1, 1));
        jLabel20.setText("¿Cuantos Adultos?");

        btnRegresar.setFont(new java.awt.Font("Ubuntu weight=255", 0, 24)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/arrow-back-regular-36.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnReservar.setFont(new java.awt.Font("Ubuntu weight=255", 0, 24)); // NOI18N
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/check-regular-36.png"))); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu weight=255", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("Habitaciones Disponibles");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel17)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNoches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotal))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(477, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(387, 387, 387)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cmbHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoches, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(737, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Informacion informacion = new Informacion();
        informacion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        
        ReservacionCS nuevaReservacion = new ReservacionCS();
        nuevaReservacion.setNombre(informacion.nombre);
        nuevaReservacion.setApellido(informacion.apellido);
        nuevaReservacion.setAdultos(informacion.adultos);
        nuevaReservacion.setNinios((informacion.ninios));
        nuevaReservacion.setLlegada(informacion.llegada);
        nuevaReservacion.setSalida(informacion.salida);
        nuevaReservacion.setNoches(Integer.parseInt(informacion.noches.toString()));
        nuevaReservacion.setTotal(total);
        nuevaReservacion.setEstado("Pendiente");
        nuevaReservacion.setIdHabitacion(idHabitacion);
        
        Horario nHorario = new Horario();
        nHorario.setLlegada(informacion.llegada);
        nHorario.setSalida(informacion.salida);
        nHorario.setNoches(Integer.parseInt(informacion.noches.toString()));
        nHorario.setEstado("Pendiente");
        nHorario.setIdHabitacion(idHabitacion);
        nHorario.setTotal(total);
        
        ReservacionController reservacion = new ReservacionController();
        HorarioController horario = new HorarioController();
        if(reservacion.crearReservacion(nuevaReservacion) && horario.crearHorarioHabitacion(nHorario)) {
            JOptionPane.showMessageDialog(null, "Su reservacion fue creada correctamente", "Éxito", JOptionPane.PLAIN_MESSAGE);
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error, intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);

        }
                
    }//GEN-LAST:event_btnReservarActionPerformed

    private void cmbHabitacionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHabitacionesItemStateChanged
    }//GEN-LAST:event_cmbHabitacionesItemStateChanged
    
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
            java.util.logging.Logger.getLogger(Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cmbHabitaciones;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCama;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNoches;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTamanio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextPane txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
