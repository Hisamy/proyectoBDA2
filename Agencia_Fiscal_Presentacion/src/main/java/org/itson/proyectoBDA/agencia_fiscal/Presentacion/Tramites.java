package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroLicenciasBO;

/**
 * Clase JFrame para gestionar trámites. Esta clase proporciona funcionalidades para solicitar licencias y placas.
 *
 * @author hisam
 */
public class Tramites extends javax.swing.JFrame {

    INavegacion navegacion;
    ClienteDTO clienteDTO;
    IRegistroLicenciasBO registroLicenciasBO;

    /**
     * Crea una nueva instancia de Tramites.
     *
     * @param clienteDTO el DTO del cliente para el que se realizarán los trámites.
     */
    public Tramites(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
        initComponents();
        lblNombreCliente.setText("Cliente: " + clienteDTO.getNombre() + "" + clienteDTO.getApellido_paterno() + " " + clienteDTO.getApellido_materno());
        navegacion = new Navegacion();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAgenciaFiscal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();
        lblCosto1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Licencia = new javax.swing.JButton();
        btnSolicitarLicencia1 = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgenciaFiscal.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblAgenciaFiscal.setForeground(new java.awt.Color(65, 34, 52));
        lblAgenciaFiscal.setText("Agencia Fiscal");
        lblAgenciaFiscal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgenciaFiscal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgenciaFiscalMouseClicked(evt);
            }
        });
        jPanel2.add(lblAgenciaFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia.setText("Historial licencias y placas");
        lblCostoLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCostoLicencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostoLicenciaMouseClicked(evt);
            }
        });
        jPanel2.add(lblCostoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        lblCosto1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCosto1.setForeground(new java.awt.Color(109, 70, 107));
        lblCosto1.setText("Trámites");
        jPanel2.add(lblCosto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 70, -1));

        jLabel2.setText("______________________________________________________________________________________________________");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, 20));

        Licencia.setBackground(new java.awt.Color(65, 34, 52));
        Licencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Licencia.setForeground(new java.awt.Color(255, 255, 255));
        Licencia.setText("Licencia");
        Licencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LicenciaActionPerformed(evt);
            }
        });
        jPanel2.add(Licencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 140, 32));

        btnSolicitarLicencia1.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia1.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia1.setText("Placa");
        btnSolicitarLicencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicencia1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 140, 32));

        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        flechaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flechaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flechaIconMouseClicked(evt);
            }
        });
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 40, 40));

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(109, 70, 107));
        jPanel2.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LicenciaActionPerformed
        CostoLicencia costoLicencia = new CostoLicencia(clienteDTO);
        this.dispose();
        costoLicencia.setVisible(true);
    }//GEN-LAST:event_LicenciaActionPerformed

    private void btnSolicitarLicencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicencia1ActionPerformed
        SolicitarPlacas solicitarPlacas = new SolicitarPlacas(clienteDTO);
        this.dispose();
        solicitarPlacas.setVisible(true);

    }//GEN-LAST:event_btnSolicitarLicencia1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void flechaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaIconMouseClicked
        DatosCliente datosCliente = new DatosCliente(clienteDTO);
        dispose();
        datosCliente.setVisible(true);
    }//GEN-LAST:event_flechaIconMouseClicked

    private void lblAgenciaFiscalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgenciaFiscalMouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_lblAgenciaFiscalMouseClicked

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Licencia;
    private javax.swing.JButton btnSolicitarLicencia1;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFiscal;
    private javax.swing.JLabel lblCosto1;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblNombreCliente;
    // End of variables declaration//GEN-END:variables
}
