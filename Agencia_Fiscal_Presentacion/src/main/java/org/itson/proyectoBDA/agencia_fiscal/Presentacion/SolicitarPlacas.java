package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class SolicitarPlacas extends javax.swing.JFrame {

    INavegacion navegacion;
    private ClienteDTO clienteDTO;
    private VehiculoDTO vehiculoDTO;

    /**
     *
     * Creates new form SolicitarPlacas
     *
     * @param clienteDTO
     */
    public SolicitarPlacas(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
        navegacion = new Navegacion();
        initComponents();
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
        lblVigencia1 = new javax.swing.JLabel();
        lblVigencia2 = new javax.swing.JLabel();
        lblVigencia3 = new javax.swing.JLabel();
        lblVigencia4 = new javax.swing.JLabel();
        lblVigencia5 = new javax.swing.JLabel();
        lblVigencia6 = new javax.swing.JLabel();
        lblVigencia7 = new javax.swing.JLabel();
        lblVigencia8 = new javax.swing.JLabel();
        lblVigencia9 = new javax.swing.JLabel();
        btnSolicitarLicencia = new javax.swing.JButton();
        btnSolicitarLicencia1 = new javax.swing.JButton();
        lblVigencia10 = new javax.swing.JLabel();
        lblVigencia11 = new javax.swing.JLabel();
        lblVigencia12 = new javax.swing.JLabel();
        lblVigencia13 = new javax.swing.JLabel();
        lblVigencia14 = new javax.swing.JLabel();
        lblVigencia15 = new javax.swing.JLabel();
        lblVigencia16 = new javax.swing.JLabel();
        lblVigencia17 = new javax.swing.JLabel();
        lblVigencia18 = new javax.swing.JLabel();
        flechaIcon = new javax.swing.JLabel();
        lblCostoLicencia1 = new javax.swing.JLabel();

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
        lblCosto1.setText("Tipo de automovil");
        jPanel2.add(lblCosto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 130, -1));

        lblSeleccion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSeleccion.setText("Automovil nuevo");
        jPanel2.add(lblSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 130, -1));

        jLabel2.setText("______________________________________________________________________________________________________");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, 20));

        lblVigencia1.setText("•  $1,000");
        jPanel2.add(lblVigencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 320, -1));

        lblVigencia2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVigencia2.setText("Automovil usado");
        jPanel2.add(lblVigencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 130, -1));

        lblVigencia3.setText("Si el automóvil del cual quiere tramitar placas es ");
        jPanel2.add(lblVigencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 350, -1));

        lblVigencia4.setText("usado, es necesario cumplir con los siguientes ");
        jPanel2.add(lblVigencia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 350, -1));

        lblVigencia5.setText("requisitos:");
        jPanel2.add(lblVigencia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 350, -1));

        lblVigencia6.setText("•  Haber sido registrado previamente en el sistema.");
        jPanel2.add(lblVigencia6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 290, -1));

        lblVigencia7.setText("•  Número de placas anteriores.");
        jPanel2.add(lblVigencia7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 350, -1));

        lblVigencia8.setText("•  Licencia vigente.");
        jPanel2.add(lblVigencia8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 280, -1));

        lblVigencia9.setText("Costo: ");
        jPanel2.add(lblVigencia9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 350, -1));

        btnSolicitarLicencia.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia.setText("Continuar");
        btnSolicitarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 140, 32));

        btnSolicitarLicencia1.setBackground(new java.awt.Color(65, 34, 52));
        btnSolicitarLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSolicitarLicencia1.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarLicencia1.setText("Continuar");
        btnSolicitarLicencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarLicencia1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSolicitarLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 140, 32));

        lblVigencia10.setText("•  $1,500");
        jPanel2.add(lblVigencia10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 350, -1));

        lblVigencia11.setText("Si el automóvil del cual quiere tramitar placas es ");
        jPanel2.add(lblVigencia11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 350, -1));

        lblVigencia12.setText("nuevo, es necesario cumplir con los siguientes ");
        jPanel2.add(lblVigencia12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 350, -1));

        lblVigencia13.setText("requisitos:");
        jPanel2.add(lblVigencia13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 350, -1));

        lblVigencia14.setText("•  No haber sido registrado previamente.");
        jPanel2.add(lblVigencia14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 350, -1));

        lblVigencia15.setText("•  Número de serie, marca, linea (año), modelo del");
        jPanel2.add(lblVigencia15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 350, -1));

        lblVigencia16.setText("automóvil.");
        jPanel2.add(lblVigencia16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 350, -1));

        lblVigencia17.setText("•  Licencia vigente.");
        jPanel2.add(lblVigencia17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 350, -1));

        lblVigencia18.setText("Costo:");
        jPanel2.add(lblVigencia18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 350, -1));

        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 40, 40));

        lblCostoLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCostoLicencia1.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia1.setText("Solicitar placas");
        jPanel2.add(lblCostoLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolicitarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicenciaActionPerformed
        BuscarVehiculo buscarCliente = new BuscarVehiculo(clienteDTO);
        buscarCliente.setVisible(true);
    }//GEN-LAST:event_btnSolicitarLicenciaActionPerformed

    private void btnSolicitarLicencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarLicencia1ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JLabel lblCostoLicencia1;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblVigencia1;
    private javax.swing.JLabel lblVigencia10;
    private javax.swing.JLabel lblVigencia11;
    private javax.swing.JLabel lblVigencia12;
    private javax.swing.JLabel lblVigencia13;
    private javax.swing.JLabel lblVigencia14;
    private javax.swing.JLabel lblVigencia15;
    private javax.swing.JLabel lblVigencia16;
    private javax.swing.JLabel lblVigencia17;
    private javax.swing.JLabel lblVigencia18;
    private javax.swing.JLabel lblVigencia2;
    private javax.swing.JLabel lblVigencia3;
    private javax.swing.JLabel lblVigencia4;
    private javax.swing.JLabel lblVigencia5;
    private javax.swing.JLabel lblVigencia6;
    private javax.swing.JLabel lblVigencia7;
    private javax.swing.JLabel lblVigencia8;
    private javax.swing.JLabel lblVigencia9;
    // End of variables declaration//GEN-END:variables
}
