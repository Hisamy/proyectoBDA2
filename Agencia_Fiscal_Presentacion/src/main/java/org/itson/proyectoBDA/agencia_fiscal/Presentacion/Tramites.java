/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroLicenciasBO;

/**
 *
 * @author Ramosz
 */
public class Tramites extends javax.swing.JFrame {

    INavegacion navegacion;
    ClienteDTO clienteDTO;
    IRegistroLicenciasBO registroLicenciasBO;

    /**
     * Creates new form Tramites
     *
     * @param clienteDTO
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
        lblSeleccion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblVigencia2 = new javax.swing.JLabel();
        btnSolicitarLicencia = new javax.swing.JButton();
        btnSolicitarLicencia1 = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgenciaFiscal.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblAgenciaFiscal.setForeground(new java.awt.Color(65, 34, 52));
        lblAgenciaFiscal.setText("Agencia Fiscal");
        jPanel2.add(lblAgenciaFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia.setText("Historial licencias y placas");
        jPanel2.add(lblCostoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        lblCosto1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCosto1.setForeground(new java.awt.Color(109, 70, 107));
        lblCosto1.setText("Trámites");
        jPanel2.add(lblCosto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 70, -1));

        lblSeleccion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSeleccion.setText("Placas");
        jPanel2.add(lblSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 70, -1));

        jLabel2.setText("______________________________________________________________________________________________________");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 20));

        lblVigencia2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVigencia2.setText("Licencia");
        jPanel2.add(lblVigencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 60, -1));

        btnSolicitarLicencia.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia.setText("Continuar");
        btnSolicitarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 140, 32));

        btnSolicitarLicencia1.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia1.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia1.setText("Continuar");
        btnSolicitarLicencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicencia1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 140, 32));

        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 40, 40));

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

    private void btnSolicitarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicenciaActionPerformed
        CostoLicencia costoLicencia = new CostoLicencia(clienteDTO);
        this.dispose();
        costoLicencia.setVisible(true);
    }//GEN-LAST:event_btnSolicitarLicenciaActionPerformed

    private void btnSolicitarLicencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicencia1ActionPerformed
        SolicitarPlacas solicitarPlacas = new SolicitarPlacas(clienteDTO);
        this.dispose();
        solicitarPlacas.setVisible(true);

    }//GEN-LAST:event_btnSolicitarLicencia1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitarLicencia;
    private javax.swing.JButton btnSolicitarLicencia1;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFiscal;
    private javax.swing.JLabel lblCosto1;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblVigencia2;
    // End of variables declaration//GEN-END:variables
}
