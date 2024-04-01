package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;

public class ExitoPlacas extends javax.swing.JFrame {

    private INavegacion navegacion;
    private final PlacaDTO placaDTO;

    private final String mensajeNumeroAlfanumerico = "El número alfanumérico asignado será: ";
    private final String mensajeFechas = "Fechas:\nVigencia: %s \nRecepción: %s";
    private final String mensajeCosto = "Se le cobrará $ %f";

    public ExitoPlacas(PlacaDTO placaDTO) {
        this.placaDTO = placaDTO;
        this.navegacion = new Navegacion();
        initComponents();
        setearLabel();
    }

    private void setearLabel() {
        String numeroAlfanumerico = placaDTO.getNumero_alfanumerico();
        Calendar vigencia = placaDTO.getFecha_expedicion();
        Calendar recepcion = placaDTO.getFecha_recepcion();
        Float costo = placaDTO.getCosto();

        String mensajeNumeroAlfanumerico2 = mensajeNumeroAlfanumerico + numeroAlfanumerico;
        lblPlaca.setText(mensajeNumeroAlfanumerico2);

        String fechaVigencia = fechaEnFormato(vigencia);
        String fechaRecepcion = fechaEnFormato(recepcion);

        String mensajeFechasCompleto = String.format(mensajeFechas, fechaVigencia, fechaRecepcion);
        lblFechas.setText(mensajeFechasCompleto);

        lblCosto.setText(String.format(mensajeCosto, costo));
    }

    private String fechaEnFormato(Calendar fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha.getTime());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTramiteExitoso = new javax.swing.JLabel();
        flechaIcon = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        btnContiuar = new javax.swing.JButton();
        lblFechas = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTramiteExitoso.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTramiteExitoso.setForeground(new java.awt.Color(65, 34, 52));
        lblTramiteExitoso.setText("¡Trámite realizado con éxito!");
        lblTramiteExitoso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblTramiteExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        flechaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flechaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flechaIconMouseClicked(evt);
            }
        });
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 60, 40));

        lblPlaca.setText("Texto 1");
        lblPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlaca.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        btnContiuar.setBackground(new java.awt.Color(65, 34, 52));
        btnContiuar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnContiuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContiuar.setText("Salir");
        btnContiuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContiuarActionPerformed(evt);
            }
        });
        jPanel2.add(btnContiuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 123, 31));

        lblFechas.setText("Texto 2");
        lblPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        lblCosto.setText("Texto 2");
        lblPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 350));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnContiuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContiuarActionPerformed
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_btnContiuarActionPerformed

    private void flechaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaIconMouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_flechaIconMouseClicked

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContiuar;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblFechas;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTramiteExitoso;
    // End of variables declaration//GEN-END:variables
}
