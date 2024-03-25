package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroLicenciasBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroLicenciasBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;

public class ExitoLicencia extends javax.swing.JFrame {

    private IRegistroLicenciasBO registroLicenciasBO;
    private INavegacion navegacion;
    private LicenciaDTO licenciaDTO;

    private String mensajeVigencia;
    private final String mensajeCosto
            = "cobrará %.2f de tu método de pago seleccionado.";

    /**
     * Constructor de la clase ExitoLicencia.
     *
     * @param registroLicenciasBO Objeto que proporciona métodos para la gestión
     * de licencias.
     * @param licenciaDTO Objeto que contiene los datos de la licencia tramitada
     * con éxito.
     */
    public ExitoLicencia(
            IRegistroLicenciasBO registroLicenciasBO,
            LicenciaDTO licenciaDTO) {
        this.registroLicenciasBO = registroLicenciasBO;
        this.licenciaDTO = licenciaDTO;
        initComponents();
        setearLabel();
    }

   

    /**
     * Establece el texto de las etiquetas lblVigencia y lblCosto según los
     * datos de la licencia. Utiliza el formato definido en los mensajes
     * mensajeVigencia y mensajeCosto.
     */
    private void setearLabel() {
        if(licenciaDTO.getVigencia()==1){
             mensajeVigencia
            = "El trámite de licencia con duración de %d año se ha concretado con éxito, se";
        }else{
            mensajeVigencia
            = "El trámite de licencia con duración de %d años se ha concretado con éxito, se";
        }
        Integer vigencia = licenciaDTO.getVigencia();
        Float costo = licenciaDTO.getCosto();
        lblVigencia.setText(String.format(mensajeVigencia, vigencia));
        lblCosto.setText(String.format(mensajeCosto, costo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTramiteExitoso = new javax.swing.JLabel();
        flechaIcon = new javax.swing.JLabel();
        lblVigencia = new javax.swing.JLabel();
        btnContiuar = new javax.swing.JButton();
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
        jPanel2.add(lblTramiteExitoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        jPanel2.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 40, 40));

        lblVigencia.setText("El trámite de licencia con duración de _____ se ha concretado con éxito, se ");
        lblVigencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

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

        lblCosto.setText("cobrará ____ de tu método de pago seleccionado.");
        lblVigencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 350));

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

    private void btnContiuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContiuarActionPerformed
        Index index = new Index();
        index.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnContiuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContiuar;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblTramiteExitoso;
    private javax.swing.JLabel lblVigencia;
    // End of variables declaration//GEN-END:variables
}