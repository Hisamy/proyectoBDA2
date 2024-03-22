/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.DTO.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;

/**
 *
 * @author Ramosz
 */
public class MostrarDatos extends javax.swing.JFrame {

    INavegacion navegacion;
    ClienteDTO clienteDTO;

    public MostrarDatos(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
        initComponents();
        setearDatos();
        navegacion = new Navegacion();
    }

    public void setearDatos() {
        txtNombre.setText(clienteDTO.getNombre());
        txtApellidoMaterno.setText(clienteDTO.getApellido_materno());
        txtApellidoPaterno.setText(clienteDTO.getApellido_paterno());
        txtCURP.setText(clienteDTO.getCURP());
        txtRFC.setText(clienteDTO.getRFC());
        txtTelefono.setText(clienteDTO.getTelefono());
        rbtnSi.setSelected(clienteDTO.isDiscapacidad());
        rbtnNo.setSelected(!clienteDTO.isDiscapacidad());

        // Convertir Calendar a Date
        Calendar fechaNacimientoCalendar = clienteDTO.getFecha_nacimiento();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimientoString = dateFormat.format(fechaNacimientoCalendar.getTime());
        txtFechaNacimiento.setText(fechaNacimientoString);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblSolicitarLicencia = new javax.swing.JLabel();
        lblDatosPersonales = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        lblCURP = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblCuentaConAlgunaDiscapacidad = new javax.swing.JLabel();
        rbtnSi = new javax.swing.JRadioButton();
        rbtnNo = new javax.swing.JRadioButton();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblRFC = new javax.swing.JLabel();
        btnContiuar = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        lblCURP1 = new javax.swing.JLabel();
        lblCURP2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setRequestFocusEnabled(false);

        lblSolicitarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSolicitarLicencia.setForeground(new java.awt.Color(65, 34, 52));
        lblSolicitarLicencia.setText("Mostrar Datos");

        lblDatosPersonales.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDatosPersonales.setText("Datos personales");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(109, 70, 107));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCURP.setEditable(false);
        txtCURP.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCURP.setForeground(new java.awt.Color(109, 70, 107));
        txtCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPActionPerformed(evt);
            }
        });

        txtRFC.setEditable(false);
        txtRFC.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtRFC.setForeground(new java.awt.Color(109, 70, 107));
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        lblCURP.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCURP.setText("CURP");

        txtApellidoMaterno.setEditable(false);
        txtApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtApellidoMaterno.setForeground(new java.awt.Color(109, 70, 107));
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        lblApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblApellidoMaterno.setText("Apellido materno");

        txtApellidoPaterno.setEditable(false);
        txtApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtApellidoPaterno.setForeground(new java.awt.Color(109, 70, 107));
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        lblApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblApellidoPaterno.setText("Apellido paterno");

        lblCuentaConAlgunaDiscapacidad.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCuentaConAlgunaDiscapacidad.setText("¿Cuenta con alguna discapacidad?");

        buttonGroup1.add(rbtnSi);
        rbtnSi.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rbtnSi.setEnabled(false);
        rbtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSiActionPerformed(evt);
            }
        });

        rbtnNo.setEnabled(false);
        buttonGroup1.add(rbtnNo);
        rbtnNo.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(109, 70, 107));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtFechaNacimiento.setEditable(false);
        txtFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtFechaNacimiento.setForeground(new java.awt.Color(109, 70, 107));
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblTelefono.setText("Teléfono");

        lblRFC.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblRFC.setText("RFC");

        btnContiuar.setBackground(new java.awt.Color(65, 34, 52));
        btnContiuar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnContiuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContiuar.setText("Continuar");
        btnContiuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContiuarActionPerformed(evt);
            }
        });

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N

        lblCURP1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCURP1.setText("Si");

        lblCURP2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCURP2.setText("No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefono)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCURP1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(flechaIcon)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(lblCURP2)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(86, 86, 86)
                                                    .addComponent(btnContiuar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(rbtnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rbtnNo)))))))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(lblCuentaConAlgunaDiscapacidad)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblApellidoMaterno)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtApellidoMaterno)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoPaterno)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDatosPersonales)
                                        .addComponent(lblSolicitarLicencia)))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCURP)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRFC))
                        .addGap(50, 50, 50))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSolicitarLicencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDatosPersonales))
                    .addComponent(flechaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblRFC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(lblCURP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblTelefono)
                    .addComponent(lblCuentaConAlgunaDiscapacidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCURP1))
                        .addGap(25, 25, 25)
                        .addComponent(btnContiuar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtnSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCURP2)
                            .addComponent(rbtnNo))))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia.setText("Historial licencias y placas");
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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtNombre.getText();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPActionPerformed
        txtCURP.getText();
    }//GEN-LAST:event_txtCURPActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed

    }//GEN-LAST:event_txtRFCActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        txtApellidoMaterno.getText();
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        txtApellidoPaterno.getText();
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void rbtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSiActionPerformed

    }//GEN-LAST:event_rbtnSiActionPerformed

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnNoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.getText();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        txtFechaNacimiento.getText();
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnContiuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContiuarActionPerformed
        Tramites mostrarDatos = new Tramites(clienteDTO);
        this.dispose();
        mostrarDatos.setVisible(true);
    }//GEN-LAST:event_btnContiuarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContiuar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCURP;
    private javax.swing.JLabel lblCURP1;
    private javax.swing.JLabel lblCURP2;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblCuentaConAlgunaDiscapacidad;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblSolicitarLicencia;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnSi;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
