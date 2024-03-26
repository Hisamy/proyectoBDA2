package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.swing.JOptionPane;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaClientesBO;

public class BuscarCliente extends javax.swing.JFrame {

    INavegacion navegacion;
    private IConsultaClientesBO consultaClientes;

    public BuscarCliente() {
        this.consultaClientes = new ConsultaClientesBO();
        navegacion = new Navegacion();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCostoLicencia1 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        lbl1anio2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
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
        lblCostoLicencia1.setText("Buscar cliente");
        jPanel2.add(lblCostoLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        jPanel2.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 440, -1));

        lbl1anio2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl1anio2.setText("RFC");
        jPanel2.add(lbl1anio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, -1));

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

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 40, 40));

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ClienteDTO clienteDTO;
        try {
            clienteDTO = consultaClientes.transporteDatos(txtRFC.getText());
            MostrarDatos mostrarDatos = new MostrarDatos(clienteDTO);
            this.dispose();
            mostrarDatos.setVisible(true);
        } catch (FindException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        navegacion.cambiarFrmHistorialLicencias(this);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        txtRFC.getText();

    }//GEN-LAST:event_txtRFCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1anio2;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblCostoLicencia1;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
