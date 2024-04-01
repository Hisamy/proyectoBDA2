package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.swing.JOptionPane;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaVehiculosBO;

import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaVehiculosBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class BuscarVehiculo extends javax.swing.JFrame {
    
    INavegacion navegacion;
    private IConsultaVehiculosBO consultaVehiculosBO;
    private ClienteDTO clienteDTO;
    private VehiculoDTO vehiculoDTO;
    
    public BuscarVehiculo(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
        this.consultaVehiculosBO = new ConsultaVehiculosBO();
        navegacion = new Navegacion();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCostoLicencia1 = new javax.swing.JLabel();
        txtNumSerie = new javax.swing.JTextField();
        lbl1anio2 = new javax.swing.JLabel();
        btnRegistrarVehiculoNuevo = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblCostoLicencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCostoLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCostoLicencia1.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia1.setText("Buscar Vehículo");
        jPanel2.add(lblCostoLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtNumSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSerieActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 440, -1));

        lbl1anio2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl1anio2.setText("Numero de serie");
        jPanel2.add(lbl1anio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, -1));

        btnRegistrarVehiculoNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrarVehiculoNuevo.setForeground(new java.awt.Color(65, 34, 52));
        btnRegistrarVehiculoNuevo.setText("Vehiculo nuevo");
        btnRegistrarVehiculoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVehiculoNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarVehiculoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 120, 30));

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        flechaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flechaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flechaIconMouseClicked(evt);
            }
        });
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 40, 40));

        btnBuscar.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 530, 230));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia.setText("Historial licencias y placas");
        lblCostoLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCostoLicencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostoLicenciaMouseClicked(evt);
            }
        });
        jPanel1.add(lblCostoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVehiculoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVehiculoNuevoActionPerformed
        DatosVehiculo datosVehiculo = new DatosVehiculo(clienteDTO);
        datosVehiculo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegistrarVehiculoNuevoActionPerformed

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSerieActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            VehiculoDTO buscarVehiculo = consultaVehiculosBO.transporteDatos(txtNumSerie.getText());
            
            if (buscarVehiculo != null) {
                DatosVehiculo datosAutomovil = new DatosVehiculo(clienteDTO, buscarVehiculo);
                this.dispose();
                datosAutomovil.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "El vehiculo no se ha registrado",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (FindException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_btnBuscarActionPerformed

    private void flechaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaIconMouseClicked
        SolicitarPlacas solicitarPlacas = new SolicitarPlacas(clienteDTO);
        dispose();
        solicitarPlacas.setVisible(true);
    }//GEN-LAST:event_flechaIconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrarVehiculoNuevo;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1anio2;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblCostoLicencia1;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
