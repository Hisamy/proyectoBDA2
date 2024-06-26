package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroLicenciasBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroLicenciasBO;

/**
 * Esta clase representa la ventana de la interfaz gráfica para calcular el costo de una licencia. Permite al usuario seleccionar la vigencia de la licencia y muestra el costo correspondiente. Además, permite continuar con el proceso de registro de la licencia.
 */
public final class CostoLicencia extends javax.swing.JFrame {

    /**
     * Costo de la licencia para 1 año para personas sin discapacidad.
     */
    final static Float COSTO1ANIONORMAL = 600f;

    /**
     * Costo de la licencia para 2 años para personas sin discapacidad.
     */
    final static Float COSTO2ANIONORMAL = 900f;

    /**
     * Costo de la licencia para 3 años para personas sin discapacidad.
     */
    final static Float COSTO3ANIONORMAL = 1100f;

    /**
     * Costo de la licencia para 1 año para personas con discapacidad.
     */
    final static Float COSTO1ANIODISCAPACITADO = 200f;

    /**
     * Costo de la licencia para 2 años para personas con discapacidad.
     */
    final static Float COSTO2ANIODISCAPACITADO = 500f;

    /**
     * Costo de la licencia para 3 años para personas con discapacidad.
     */
    final static Float COSTO3ANIODISCAPACITADO = 700f;

    private boolean discapacidad;
    private INavegacion navegacion;
    private IRegistroLicenciasBO registroLicenciasBO;
    private ClienteDTO clienteDTO;
    private LicenciaDTO licenciaDTO;
    private String tipo = "Licencia";

    /**
     * Constructor de la clase CostoLicencia.
     *
     * @param clienteDTO Cliente para el cual se calculará el costo de la licencia.
     */
    public CostoLicencia(ClienteDTO clienteDTO) {
        initComponents();
        this.clienteDTO = clienteDTO;
        this.registroLicenciasBO = new RegistroLicenciasBO();
        discapacidad();
        setearDatosLicencia();
        navegacion = new Navegacion();
    }

    /**
     * Verifica si el cliente tiene alguna discapacidad.
     */
    public void discapacidad() {
        if (clienteDTO.isDiscapacidad() == true) {
            this.discapacidad = true;
        } else {
            this.discapacidad = false;
        }
    }

    /**
     * Establece los datos de la licencia en la interfaz gráfica.
     */
    private void setearDatosLicencia() {
        if (discapacidad == false) {
            lblCosto.setText("Costo normal");
            lblCostoAnio1.setText("$" + String.valueOf(COSTO1ANIONORMAL));
            lblCostoAnio2.setText("$" + String.valueOf(COSTO2ANIONORMAL));
            lblCostoAnio3.setText("$" + String.valueOf(COSTO3ANIONORMAL));
        } else {
            lblCosto.setText("Costo discapacitados");
            lblCostoAnio1.setText("$" + String.valueOf(COSTO1ANIODISCAPACITADO));
            lblCostoAnio2.setText("$" + String.valueOf(COSTO2ANIODISCAPACITADO));
            lblCostoAnio3.setText("$" + String.valueOf(COSTO3ANIODISCAPACITADO));
        }
    }

    /**
     * Transporta los datos de la licencia a la siguiente ventana y realiza el registro de la licencia.
     *
     * @return Los datos de la licencia.
     * @throws ParseException Si ocurre un error al parsear la fecha.
     * @throws PersistenciaException Si ocurre un error en la persistencia de los datos.
     */
    public LicenciaDTO transporteDatos() throws java.text.ParseException, PersistenciaException {
        // Obtener la fecha actual como Calendar
        Calendar fechaActual = Calendar.getInstance();

        // Definir el formato de la fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Seleccionar el costo según las condiciones
        float costo = 0;
        int vigencia = 0;

        if (!discapacidad) {
            if (jbtn1anio.isSelected()) {
                vigencia = 1;
                costo = COSTO1ANIONORMAL;
            } else if (jbtn2anio.isSelected()) {
                vigencia = 2;
                costo = COSTO2ANIONORMAL;
            } else if (jbtn3anio.isSelected()) {
                vigencia = 3;
                costo = COSTO3ANIONORMAL;
            }
        } else {
            if (jbtn1anio.isSelected()) {
                vigencia = 1;
                costo = COSTO1ANIODISCAPACITADO;
            } else if (jbtn2anio.isSelected()) {
                vigencia = 2;
                costo = COSTO2ANIODISCAPACITADO;
            } else if (jbtn3anio.isSelected()) {
                vigencia = 3;
                costo = COSTO3ANIODISCAPACITADO;
            }
        }

        // Crear la licencia con la fecha actual y el costo
        // Convertir fechaActual a Date
        Date fechaActualDate = fechaActual.getTime();

        // Crear un nuevo objeto Calendar y establecer la fecha actual
        Calendar fechaActualCalendar = Calendar.getInstance();
        fechaActualCalendar.setTime(fechaActualDate);

        // Crear la licencia con la fecha actual y el costo
        licenciaDTO = registroLicenciasBO.transporteDatos(
                new LicenciaDTO(
                        vigencia,
                        fechaActualCalendar,
                        costo,
                        clienteDTO,
                        true,
                        tipo,
                        fechaActualCalendar));
        return licenciaDTO;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();
        lblVigencia = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        lblCostoAnio3 = new javax.swing.JLabel();
        lbl2anios = new javax.swing.JLabel();
        lbl3anios = new javax.swing.JLabel();
        jbtn1anio = new javax.swing.JRadioButton();
        lbl1anio = new javax.swing.JLabel();
        lblCostoAnio1 = new javax.swing.JLabel();
        lblCostoAnio2 = new javax.swing.JLabel();
        jbtn2anio = new javax.swing.JRadioButton();
        jbtn3anio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCostoLicencia1 = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Costo de licencias");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("____________________________________________________________________________________________");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(65, 34, 52));
        lblCostoLicencia.setText("Costo de licencias");
        jPanel1.add(lblCostoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        lblVigencia.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVigencia.setForeground(new java.awt.Color(109, 70, 107));
        lblVigencia.setText("Vigencia");
        jPanel1.add(lblVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 70, -1));

        lblCosto.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(109, 70, 107));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, 20));

        lblSeleccion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSeleccion.setForeground(new java.awt.Color(109, 70, 107));
        lblSeleccion.setText("Seleccion");
        jPanel1.add(lblSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, -1));

        lblCostoAnio3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoAnio3.setText("$1,100");
        jPanel1.add(lblCostoAnio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        lbl2anios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl2anios.setText("2 años");
        jPanel1.add(lbl2anios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 50, -1));

        lbl3anios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl3anios.setText("3 años");
        jPanel1.add(lbl3anios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, -1));

        buttonGroup1.add(jbtn1anio);
        jbtn1anio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtn1anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1anioActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn1anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        lbl1anio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl1anio.setText("1 año");
        jPanel1.add(lbl1anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 40, -1));

        lblCostoAnio1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoAnio1.setText("$600");
        jPanel1.add(lblCostoAnio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        lblCostoAnio2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoAnio2.setText("$900");
        jPanel1.add(lblCostoAnio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        buttonGroup1.add(jbtn2anio);
        jbtn2anio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(jbtn2anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        buttonGroup1.add(jbtn3anio);
        jbtn3anio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(jbtn3anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel2.setText("____________________________________________________________________________________________");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        btnContinuar.setBackground(new java.awt.Color(65, 34, 52));
        btnContinuar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 123, 31));

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        flechaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flechaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flechaIconMouseClicked(evt);
            }
        });
        jPanel1.add(flechaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 40, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 550, 330));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        lblCostoLicencia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia1.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia1.setText("Historial licencias y placas");
        lblCostoLicencia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCostoLicencia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostoLicencia1MouseClicked(evt);
            }
        });
        jPanel2.add(lblCostoLicencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(109, 70, 107));
        jPanel2.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        try {
            transporteDatos();
            ExitoLicencia exitoLicencia = new ExitoLicencia(licenciaDTO);
            exitoLicencia.setVisible(true);
            dispose();
        } catch (ParseException | PersistenciaException ex) {
            Logger.getLogger(CostoLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnContinuarActionPerformed

    private void jbtn1anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1anioActionPerformed

    }//GEN-LAST:event_jbtn1anioActionPerformed

    private void flechaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaIconMouseClicked
        Tramites tramites = new Tramites(clienteDTO);
        dispose();
        tramites.setVisible(true);
    }//GEN-LAST:event_flechaIconMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void lblCostoLicencia1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicencia1MouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicencia1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jbtn1anio;
    private javax.swing.JRadioButton jbtn2anio;
    private javax.swing.JRadioButton jbtn3anio;
    private javax.swing.JLabel lbl1anio;
    private javax.swing.JLabel lbl2anios;
    private javax.swing.JLabel lbl3anios;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCostoAnio1;
    private javax.swing.JLabel lblCostoAnio2;
    private javax.swing.JLabel lblCostoAnio3;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblCostoLicencia1;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblVigencia;
    // End of variables declaration//GEN-END:variables
}
