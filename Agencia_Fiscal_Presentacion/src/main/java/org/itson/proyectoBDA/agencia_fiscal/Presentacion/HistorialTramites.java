package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

public class HistorialTramites extends javax.swing.JFrame {

    INavegacion navegacion;
    private IConsultaClientesBO consultaClientesBO;
    List<ClienteDTO> clientes;
    private ClienteDTO clienteDTO;


    /**
     * Constructor de la clase HistorialTramites. Inicializa los componentes de
     * la interfaz gráfica y llena la tabla con el historial de clientes.
     */
    public HistorialTramites(ClienteDTO clienteDTO) {
        navegacion = new Navegacion();
        consultaClientesBO = new ConsultaClientesBO();
        this.clienteDTO = clienteDTO;
  
        try {
            this.clientes = consultaClientesBO.historialCliente();
        } catch (FindException ex) {
            Logger.getLogger(HistorialTramites.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        llenarTabla(clientes);

    }

    /**
     * Llena la tabla con el historial de clientes.
     *
     * @param clientesDTO Lista de objetos ClienteDTO que representan el
     * historial de clientes.
     */
    private void llenarTabla(List<ClienteDTO> clientesDTO) {
        DefaultTableModel clientesEncontrados = new DefaultTableModel();
        clientesEncontrados.addColumn("Nombre");
        clientesEncontrados.addColumn("Apellido paterno");
        clientesEncontrados.addColumn("Apellido materno");
        clientesEncontrados.addColumn("CURP");
        clientesEncontrados.addColumn("RFC");
        clientesEncontrados.addColumn("Fecha nacimiento");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()); // Define el formato de fecha deseado

        for (ClienteDTO cliente : clientes) {
            Object[] fila = {
                cliente.getNombre(),
                cliente.getApellido_paterno(),
                cliente.getApellido_materno(),
                cliente.getCURP(),
                cliente.getRFC(),
                dateFormat.format(cliente.getFecha_nacimiento().getTime()) // Formatea la fecha y la agrega a la tabla
            };
            clientesEncontrados.addRow(fila);
        }
        jTPersonas.setModel(clientesEncontrados);
    }

    private void buscarPorNombre(String nombre) {
        try {
            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorNombre(nombre);
            if (clientesDTO != null && !clientesDTO.isEmpty()) {
                clientes.clear();
                clientes.addAll(clientesDTO);

                llenarTabla(clientesDTO);
            }

        } catch (FindException ex) {
            Logger.getLogger(HistorialTramites.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void buscarPorFechaNacimiento(int anioNacimiento) {
        try {

            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorFechaNacimiento(anioNacimiento);
            if (clientesDTO != null && !clientesDTO.isEmpty()) {
                clientes.clear();
                clientes.addAll(clientesDTO);
                llenarTabla(clientesDTO);
            }
        } catch (FindException ex) {
            Logger.getLogger(HistorialTramites.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void buscarPorRFC(String rfc) {
        try {
            ClienteDTO clienteDTO = consultaClientesBO.transporteDatos(rfc);
            if (clienteDTO != null) {
                clientes.clear();
                clientes.add(clienteDTO);
                llenarTabla(clientes);

            }
        } catch (FindException ex) {
            Logger.getLogger(HistorialTramites.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

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
        lblSolicitarLicencia = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        flechaIcon = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPersonas = new javax.swing.JTable();
        txtBuscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCostoLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSolicitarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSolicitarLicencia.setForeground(new java.awt.Color(65, 34, 52));
        lblSolicitarLicencia.setText("Historial de clientes");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblNombre.setText("Buscar por:");

        btnBuscar.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        flechaIcon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        flechaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.jpg"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "RFC", "Año de nacimiento" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "CURP"
            }
        ));
        jScrollPane1.setViewportView(jTPersonas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSolicitarLicencia)
                        .addGap(211, 211, 211)
                        .addComponent(flechaIcon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSolicitarLicencia)
                    .addComponent(flechaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 640));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda = txtBuscador.getText().trim();
        String opcionSeleccionada = (String) jComboBox1.getSelectedItem();

        if (opcionSeleccionada.equalsIgnoreCase("Nombre")) {
            buscarPorNombre(busqueda);
        } else if (opcionSeleccionada.equalsIgnoreCase("RFC")) {
            buscarPorRFC(busqueda);
        } else {
            Calendar fechaNacimiento = convertirAFecha(busqueda);
            buscarPorFechaNacimiento(fechaNacimiento.get(Calendar.YEAR));
        }


    }//GEN-LAST:event_btnBuscarActionPerformed
    private Calendar convertirAFecha(String fechaStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            int year = Integer.parseInt(fechaStr);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

        } catch (NumberFormatException ex) {
            Logger.getLogger(HistorialTramites.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return calendar;
    }


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private class JButtonCellEditor implements TableCellEditor {

        private final JButton button;
        private int row;
        private ActionListener actionListener;

        public JButtonCellEditor(String text, ActionListener actionListener) {
            this.button = new JButton(text);
            this.button.setBackground(new Color(65, 6, 36));
            this.button.setForeground(new Color(242, 242, 242));
            this.actionListener = actionListener;
            this.button.addActionListener((ActionEvent evt) -> {
                this.actionListener.actionPerformed(
                        new ActionEvent(this.button, ActionEvent.ACTION_PERFORMED, this.row + "")
                );
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return this.button;
        }

        @Override
        public Object getCellEditorValue() {
            return true;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return true;
        }

        @Override
        public void cancelCellEditing() {
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
        }
    }

    private class JButtonRenderer implements TableCellRenderer {

        private final JButton button;

        public JButtonRenderer(String text) {
            this.button = new JButton(text);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this.button;
        }
//DUDAS
        private ActionListener botonVerReporte() {
        ActionListener validarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TramiteDTO tramiteSelec = clienteDTO.getTramitesDTO().get(tablaTramites.getSelectedRow()) ;
                if (tramiteSelec instanceof PlacaDTO) {
                    PlacaDTO placaSelec = (PlacaDTO)tramiteSelec ;
                    dispose() ;
                    ExitoPlacas frmPlaca = new ExitoPlacas (placaSelec.getCosto());
                } else if (tramiteSelec instanceof LicenciaDTO) {
                    LicenciaDTO licenciaSelec = (LicenciaDTO) tramiteSelec ;
                    dispose() ;
                    ExitoLicencia frmLicencia = new ExitoLicencia(licenciaSelec);
                }
            }
        } ;
        
        return validarListener ;
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPersonas;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSolicitarLicencia;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
