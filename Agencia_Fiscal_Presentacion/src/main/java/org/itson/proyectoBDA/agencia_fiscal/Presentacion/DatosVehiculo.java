package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroPlacasBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroVehiculosBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroPlacasBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroVehiculosBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 * Esta clase proporciona una interfaz gráfica de usuario (GUI) para ingresar y
 * procesar datos de vehículos.
 */
public class DatosVehiculo extends javax.swing.JFrame {

    INavegacion navegacion;
    private boolean vehiculoEncontrado;
    private ClienteDTO clienteDTO;
    private PlacaDTO placaDTO;
    private VehiculoDTO vehiculoDTO;
    private IRegistroPlacasBO registroPlacasBO;
    private IRegistroVehiculosBO registroVehiculosBO;
    private IConsultaTramitesBO consultaTramitesBO;
    Logger logger = Logger.getLogger(getClass().getName());

    private static Float costo = 0f;
    private String tipo = "Placas";

    /**
     * Crea una nueva instancia de DatosVehiculo con el clienteDTO
     * proporcionado.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del
     * cliente.
     */
    public DatosVehiculo(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
        this.registroPlacasBO = new RegistroPlacasBO();
        this.consultaTramitesBO = new ConsultaTramitesBO();
        this.registroVehiculosBO = new RegistroVehiculosBO();

        navegacion = new Navegacion();
        this.costo = 1500f;
        initComponents();
        vehiculoEncontrado = false;
    }

    /**
     * Crea una nueva instancia de DatosVehiculo con el clienteDTO y vehiculoDTO
     * proporcionados.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del
     * cliente.
     * @param vehiculoDTO El objeto VehiculoDTO que contiene los datos del
     * vehículo.
     */
    public DatosVehiculo(ClienteDTO clienteDTO, VehiculoDTO vehiculoDTO) {
        this.clienteDTO = clienteDTO;
        this.vehiculoDTO = vehiculoDTO;
        this.registroPlacasBO = new RegistroPlacasBO();
        this.consultaTramitesBO = new ConsultaTramitesBO();
        this.registroVehiculosBO = new RegistroVehiculosBO();
        navegacion = new Navegacion();
        this.costo = 1000f;
        initComponents();
        vehiculoEncontrado = true;
        setearDatos();
    }

    /**
     * Establece los datos del vehículo en los campos de la interfaz gráfica.
     * Este método se llama automáticamente después de la inicialización del
     * objeto para mostrar los datos del vehículo en la interfaz.
     */
    public final void setearDatos() {
        txtNumSerie.setText(vehiculoDTO.getNumero_serie());
        txtNumSerie.setEditable(false);
        jcbTipoVehiculo.setSelectedItem(vehiculoDTO.getTipo());
        jcbTipoVehiculo.setEditable(false);
        txtLinea.setText(vehiculoDTO.getLinea());
        txtLinea.setEditable(false);
        txtModelo.setText(vehiculoDTO.getModelo().toString());
        txtModelo.setEditable(false);
        txtMarca.setText(vehiculoDTO.getMarca());
        txtMarca.setEditable(false);
        txtColor.setText(vehiculoDTO.getColor());
        txtColor.setEditable(false);

    }

    /**
     * Transporta los datos del vehículo ingresados por el usuario al sistema.
     *
     * @return El objeto VehiculoDTO transportado que contiene los datos del
     * vehículo.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * transporte de datos.
     */
    public VehiculoDTO transporteDatosVehiculo() throws PersistenciaException {

        Integer modelo = Integer.valueOf(txtModelo.getText());
        VehiculoDTO nuevoVehiculo = vehiculoDTO;

        Boolean licenciaVigente = consultaTramitesBO.transporteDatos(clienteDTO);
        System.out.println(licenciaVigente);

        if (vehiculoEncontrado == false) {
            String tipoVehiculo = (String) jcbTipoVehiculo.getSelectedItem();
            nuevoVehiculo = registroVehiculosBO.transporteDatos(
                    new VehiculoDTO(
                            txtNumSerie.getText(),
                            modelo,
                            txtColor.getText(),
                            txtMarca.getText(),
                            txtLinea.getText(),
                            tipoVehiculo,
                            licenciaVigente,
                            clienteDTO)
            );
        }
        return nuevoVehiculo;

    }

    /**
     * Transporta los datos de la placa al sistema y devuelve el objeto PlacaDTO
     * resultante.
     *
     * @return El objeto PlacaDTO transportado que contiene los datos de la
     * placa.
     * @throws ParseException Si ocurre un error durante el análisis de la fecha
     * de expedición.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * transporte de datos.
     */
    public PlacaDTO transporteDatosPlaca() throws java.text.ParseException, PersistenciaException {
        //Se calcula la fecha de expedicion la cual es de 5 años
        Calendar fechaEmision = Calendar.getInstance();
        Calendar fechaExpedicion = fechaEmision;
        fechaExpedicion.add(Calendar.YEAR, 5);

        VehiculoDTO vehiculoDTO = transporteDatosVehiculo();

        placaDTO = registroPlacasBO.transporteDatos(
                new PlacaDTO(
                        vehiculoDTO,
                        fechaExpedicion,
                        costo,
                        clienteDTO,
                        true,
                        tipo,
                        fechaEmision));
        return placaDTO;
    }

    public Boolean validarDatos() {
        if (txtNumSerie.getText().isEmpty() || txtColor.getText().isEmpty() || txtModelo.getText().isEmpty() || txtLinea.getText().isEmpty() || txtMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                // Intenta convertir el texto del campo de modelo a un número entero
                Integer.valueOf(txtModelo.getText());
                return true;
            } catch (NumberFormatException e) {
                // El texto no es un número entero válido
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un año válido en el campo de modelo.", "Modelo Inválido", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
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
        lblTitulo = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        txtNumSerie = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnAtras = new javax.swing.JLabel();
        lblMarca1 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jcbTipoVehiculo = new javax.swing.JComboBox<>();
        btnLogo = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 34, 52));
        lblTitulo.setText("Datos del vehiculo");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 33, -1, -1));

        lblNumeroSerie.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblNumeroSerie.setText("Número de serie");
        jPanel2.add(lblNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 91, -1, -1));

        txtNumSerie.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtNumSerie.setForeground(new java.awt.Color(109, 70, 107));
        txtNumSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSerieActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 111, 230, -1));

        txtColor.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtColor.setForeground(new java.awt.Color(109, 70, 107));
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        jPanel2.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 212, -1));

        lblColor.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblColor.setText("Color");
        jPanel2.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        txtModelo.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(109, 70, 107));
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        jPanel2.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 107, -1));

        lblLinea.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblLinea.setText("Línea");
        jPanel2.add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblMarca.setText("Tipo");
        jPanel2.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        txtLinea.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtLinea.setForeground(new java.awt.Color(109, 70, 107));
        txtLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaActionPerformed(evt);
            }
        });
        jPanel2.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 210, -1));

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblModelo.setText("Modelo (año)");
        jPanel2.add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        btnContinuar.setBackground(new java.awt.Color(65, 34, 52));
        btnContinuar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel2.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 209, 123, 30));

        btnAtras.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        jPanel2.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 33, -1, 40));

        lblMarca1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblMarca1.setText("Marca");
        jPanel2.add(lblMarca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtMarca.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(109, 70, 107));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel2.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 108, -1));

        jcbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automovil" }));
        jcbTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoVehiculoActionPerformed(evt);
            }
        });
        jPanel2.add(jcbTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 560, 290));

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        btnLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoMouseClicked(evt);
            }
        });
        jPanel1.add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

    private void txtNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSerieActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        try {
            if (validarDatos() && consultaTramitesBO.validarLicencia(clienteDTO ) && registroVehiculosBO.validarVehiculo(txtNumSerie.getText())) {
                transporteDatosPlaca();
                ExitoPlacas exitoPlacas = new ExitoPlacas(placaDTO);
                this.dispose();
                exitoPlacas.setVisible(true);
            }
        } catch (FindException | ParseException | PersistenciaException ex) {
            Logger.getLogger(DatosVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void jcbTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoVehiculoActionPerformed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        BuscarVehiculo buscarVehiculo = new BuscarVehiculo(clienteDTO);
        dispose();
        buscarVehiculo.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoMouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_btnLogoMouseClicked

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel btnLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcbTipoVehiculo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarca1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
