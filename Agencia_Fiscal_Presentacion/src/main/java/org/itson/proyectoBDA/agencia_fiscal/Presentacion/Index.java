package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;

public class Index extends javax.swing.JFrame {

    INavegacion navegacion;

    public Index() {
        navegacion = new Navegacion();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAgenciaFiscal = new javax.swing.JLabel();
        btnHistorialLicenciaPlacas = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Index");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgenciaFiscal.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblAgenciaFiscal.setForeground(new java.awt.Color(65, 34, 52));
        lblAgenciaFiscal.setText("Agencia Fiscal");
        jPanel2.add(lblAgenciaFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        btnHistorialLicenciaPlacas.setBackground(new java.awt.Color(65, 34, 52));
        btnHistorialLicenciaPlacas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistorialLicenciaPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorialLicenciaPlacas.setText("Historial licencias y placas");
        btnHistorialLicenciaPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialLicenciaPlacasActionPerformed(evt);
            }
        });
        jPanel2.add(btnHistorialLicenciaPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 290, 32));

        btnBuscarCliente.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 290, 32));

        lblTexto.setText("texto");
        jPanel2.add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 30, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscarCliente buscarCliente = new BuscarCliente();
        buscarCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnHistorialLicenciaPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialLicenciaPlacasActionPerformed
        HistorialLicencias historialLicencias = new HistorialLicencias();
        historialLicencias.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHistorialLicenciaPlacasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnHistorialLicenciaPlacas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFiscal;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
