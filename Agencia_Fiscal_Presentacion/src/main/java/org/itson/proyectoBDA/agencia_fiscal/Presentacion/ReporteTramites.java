/*
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java para editar esta plantilla
 */
package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

/**
 * Clase JFrame para mostrar un informe de trámites. Esta clase proporciona métodos para buscar trámites, mostrarlos en una tabla y exportar el informe a PDF.
 *
 * @author hisam
 */
public class ReporteTramites extends javax.swing.JFrame {

    private IConsultaClientesBO consultaClientesBO;
    List<TramiteDTO> tramites;
    IConsultaTramitesBO consultaTramites;
    List<ClienteDTO> clientes;

    /**
     * Crea una nueva instancia de ReporteTramites.
     *
     * @throws org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException si ocurre un error al obtener los datos.
     */
    public ReporteTramites() throws FindException {
        this.consultaClientesBO = new ConsultaClientesBO();
        this.clientes = consultaClientesBO.historialCliente();

        this.consultaTramites = new ConsultaTramitesBO();
        this.tramites = consultaTramites.historialTramite();

        initComponents();
        llenarTabla(tramites);
    }

    /**
     * Formatea el objeto de calendario dado a una cadena de fecha en formato "dd/MM/yyyy".
     *
     * @param fecha el objeto de calendario para formatear.
     * @return la cadena de fecha formateada.
     */
    private String fechaDateFormat(Calendar fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    /**
     * Llena la tabla con la lista de trámites proporcionada.
     *
     * @param tramites la lista de trámites para poblar la tabla.
     * @throws FindException si ocurre un error al obtener los datos.
     */
    private void llenarTabla(List<TramiteDTO> tramites) throws FindException {
        DefaultTableModel clientesEncontrados = new DefaultTableModel();
        clientesEncontrados.addColumn("Nombre");
        clientesEncontrados.addColumn("Apellido Paterno");
        clientesEncontrados.addColumn("Apellido Materno");
        clientesEncontrados.addColumn("Tramite");
        clientesEncontrados.addColumn("Fecha emision");
        clientesEncontrados.addColumn("Fecha expedición");
        clientesEncontrados.addColumn("Costo");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        for (TramiteDTO tramite : tramites) {
            Object[] fila = {
                tramite.getClienteDTO().getNombre(),
                tramite.getClienteDTO().getApellido_paterno(),
                tramite.getClienteDTO().getApellido_materno(),
                tramite.getTipo(),
                dateFormat.format(tramite.getFecha_emision().getTime()),
                dateFormat.format(tramite.getFecha_expedicion().getTime()),
                tramite.getCosto()
            };
            clientesEncontrados.addRow(fila);
        }
        jTPersonas.setModel(clientesEncontrados);
    }

    /**
     * Busca trámites por nombre.
     *
     * @param nombre el nombre a buscar.
     */
    private void buscarPorNombre(String nombre) {
//        try {
//            consultaClientesBO.consultarClientePorNombre(nombre);
//            List<TramiteDTO> tramitesDTO = consultaTramites.consultarTramitesPorCliente();
//            if (tramitesDTO != null && !tramitesDTO.isEmpty()) {
//                tramites.clear();
//                tramites.addAll(tramitesDTO);
//
//                llenarTabla(tramites);
//            }
//
//        } catch (FindException ex) {
//            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
    }

    /**
     * Busca trámites por período.
     */
    private void buscarPorPeriodo() {
//        try {
//            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorFechaNacimiento(anioNacimiento);
//            if (clientesDTO != null && !clientesDTO.isEmpty()) {
//                clientes.clear();
//                clientes.addAll(clientesDTO);
//                llenarTabla(tramites);
//            }
//        } catch (FindException ex) {
//            Logger.getLogger(ConsultaClientes.class
//                    .getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
    }

    /**
     * Busca trámites por tipo.
     */
    private void buscarPorTipo() {
//        try {
//            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorFechaNacimiento(anioNacimiento);
//            if (clientesDTO != null && !clientesDTO.isEmpty()) {
//                clientes.clear();
//                clientes.addAll(clientesDTO);
//                llenarTabla(tramites);
//            }
//        } catch (FindException ex) {
//            Logger.getLogger(ConsultaClientes.class
//                    .getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        flechaIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPersonas = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        txtBuscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(65, 34, 52));
        lblTitulo.setText("Reporte de trámites");

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N

        jTPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Trámite", "Fecha emisión", "Fecha expedición", "Costo"
            }
        ));
        jScrollPane1.setViewportView(jTPersonas);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblNombre.setText("Buscar por:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Periodo", "Tipo de trámite" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(65, 34, 52));
        btnExportar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("Exportar a PDF");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(288, 288, 288)
                        .addComponent(flechaIcon))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo)
                    .addComponent(flechaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblCostoLicencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCostoLicencia.setForeground(new java.awt.Color(109, 70, 107));
        lblCostoLicencia.setText("Historial licencias y placas");
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda = txtBuscador.getText().trim();
        String opcionSeleccionada = (String) jComboBox1.getSelectedItem();

        if (opcionSeleccionada.equalsIgnoreCase("Nombre")) {
            buscarPorNombre(busqueda);
        } else if (opcionSeleccionada.equalsIgnoreCase("Periodo")) {
            buscarPorPeriodo();
        } else if (opcionSeleccionada.equalsIgnoreCase("Tipo de trámite")) {
            buscarPorTipo();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarActionPerformed

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPersonas;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
