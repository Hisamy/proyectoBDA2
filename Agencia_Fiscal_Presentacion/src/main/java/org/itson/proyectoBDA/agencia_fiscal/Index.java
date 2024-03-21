
package org.itson.proyectoBDA.agencia_fiscal;


public class Index extends javax.swing.JFrame {


    public Index() {
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
        btnSolicitarPlacas = new javax.swing.JButton();
        btnSolicitarLicencia = new javax.swing.JButton();
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

        btnSolicitarPlacas.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarPlacas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarPlacas.setText("Solicitar placas");
        btnSolicitarPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarPlacasActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 135, 32));

        btnSolicitarLicencia.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia.setText("Solicitar licencia");
        btnSolicitarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 140, 32));

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

    private void btnSolicitarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSolicitarLicenciaActionPerformed

    private void btnSolicitarPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarPlacasActionPerformed
        
    }//GEN-LAST:event_btnSolicitarPlacasActionPerformed

    private void btnHistorialLicenciaPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialLicenciaPlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialLicenciaPlacasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorialLicenciaPlacas;
    private javax.swing.JButton btnSolicitarLicencia;
    private javax.swing.JButton btnSolicitarPlacas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFiscal;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
