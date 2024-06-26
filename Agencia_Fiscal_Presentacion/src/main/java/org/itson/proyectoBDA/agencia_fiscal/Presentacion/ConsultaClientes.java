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

/**
 * La clase `ConsultaClientes` representa una ventana de consulta de clientes. Permite al usuario buscar clientes por nombre, RFC o año de nacimiento, y visualizar su historial de trámites.
 *
 * @author Ramosz
 */
public class ConsultaClientes extends javax.swing.JFrame {

    INavegacion navegacion;
    private IConsultaClientesBO consultaClientesBO;

    List<ClienteDTO> clientes;

    /**
     * Constructor de la clase `ConsultaClientes`. Inicializa los componentes de la interfaz gráfica y llena la tabla con el historial de clientes.
     */
    public ConsultaClientes() {
        navegacion = new Navegacion();
        consultaClientesBO = new ConsultaClientesBO();

        try {
            this.clientes = consultaClientesBO.historialCliente();
        } catch (FindException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        llenarTabla(clientes);

    }

    /**
     * Convierte una instancia de Calendar en una cadena de texto con formato de fecha.
     *
     * @param fecha Objeto Calendar que representa la fecha a formatear.
     * @return Una cadena de texto que representa la fecha en el formato "dd/MM/yyyy".
     */
    private String fechaDateFormat(Calendar fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    /**
     * Llena la tabla con el historial de clientes.
     *
     * @param clientesDTO Lista de objetos ClienteDTO que representan el historial de clientes.
     */
    private void llenarTabla(List<ClienteDTO> clientesDTO) {
        DefaultTableModel clientesEncontrados = new DefaultTableModel();
        clientesEncontrados.addColumn("Nombre");
        clientesEncontrados.addColumn("Apellido paterno");
        clientesEncontrados.addColumn("Apellido materno");
        clientesEncontrados.addColumn("CURP");
        clientesEncontrados.addColumn("RFC");
        clientesEncontrados.addColumn("Fecha nacimiento");
        clientesEncontrados.addColumn("Tramites");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        for (ClienteDTO cliente : clientes) {
            Object[] fila = {
                cliente.getNombre(),
                cliente.getApellido_paterno(),
                cliente.getApellido_materno(),
                cliente.getCURP(),
                cliente.getRFC(),
                dateFormat.format(cliente.getFecha_nacimiento().getTime())
            };
            clientesEncontrados.addRow(fila);
        }
        jTPersonas.setModel(clientesEncontrados);
        jTPersonas.getColumnModel().getColumn(6).setCellRenderer(new JButtonRenderer("Ver"));
        jTPersonas.getColumnModel().getColumn(6).setCellEditor(new JButtonCellEditor("Ver", botonVerReporte()));
    }

    /**
     * Busca clientes por nombre y actualiza la tabla con los resultados de la búsqueda.
     *
     * @param nombre El nombre del cliente a buscar.
     */
    private void buscarPorNombre(String nombre) {
        try {
            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorNombre(nombre);
            if (clientesDTO != null && !clientesDTO.isEmpty()) {
                clientes.clear();
                clientes.addAll(clientesDTO);
                llenarTabla(clientesDTO);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FindException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Busca clientes por año de nacimiento y actualiza la tabla con los resultados de la búsqueda.
     *
     * @param anioNacimiento El año de nacimiento de los clientes a buscar.
     */
    private void buscarPorFechaNacimiento(int anioNacimiento) {
        try {
            List<ClienteDTO> clientesDTO = consultaClientesBO.consultarClientePorFechaNacimiento(anioNacimiento);
            if (clientesDTO != null && !clientesDTO.isEmpty()) {
                clientes.clear();
                clientes.addAll(clientesDTO);
                llenarTabla(clientesDTO);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron clientes nacidos en el año especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FindException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Busca un cliente por su RFC y actualiza la tabla con el resultado de la búsqueda.
     *
     * @param rfc El RFC del cliente a buscar.
     */
    private void buscarPorRFC(String rfc) {
        try {
            ClienteDTO clienteDTO = consultaClientesBO.transporteDatos(rfc);
            if (clienteDTO != null) {
                clientes.clear();
                clientes.add(clienteDTO);
                llenarTabla(clientes);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el RFC especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FindException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblSolicitarLicencia = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
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
                    .addComponent(lblSolicitarLicencia)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(txtBuscador))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblSolicitarLicencia)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 560, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón de búsqueda. Realiza la búsqueda según la opción seleccionada en el combo box.
     *
     * @param evt El evento de acción asociado al clic en el botón de búsqueda.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda = txtBuscador.getText().trim();
        String opcionSeleccionada = (String) jComboBox1.getSelectedItem();

        if (opcionSeleccionada.equalsIgnoreCase("Nombre")) {
            buscarPorNombre(busqueda);
        } else if (opcionSeleccionada.equalsIgnoreCase("RFC")) {
            buscarPorRFC(busqueda);
        } else {
            Calendar fechaNacimiento = convertirAFecha(busqueda);
            if (fechaNacimiento != null) {
                buscarPorFechaNacimiento(fechaNacimiento.get(Calendar.YEAR));
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private Calendar convertirAFecha(String fechaStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            // Validar si la cadena es un número entero
            if (!fechaStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            int year = Integer.parseInt(fechaStr);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return calendar;
        } catch (NumberFormatException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes consultaClientes = new ConsultaClientes();
        dispose();
        consultaClientes.setVisible(true);
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    /**
     * Clase interna que actúa como editor de celda para botones en una tabla.
     */
    private class JButtonCellEditor implements TableCellEditor {

        private final JButton button;
        private int row;
        private ActionListener actionListener;

        /**
         * Constructor de la clase JButtonCellEditor.
         *
         * @param text El texto que se mostrará en el botón.
         * @param actionListener El ActionListener asociado al botón.
         */
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

    /**
     * Clase interna que actúa como renderizador de celda para botones en una tabla.
     */
    private class JButtonRenderer implements TableCellRenderer {

        private final JButton button;

        /**
         * Constructor de la clase JButtonRenderer.
         *
         * @param text El texto que se mostrará en el botón.
         */
        public JButtonRenderer(String text) {
            this.button = new JButton(text);
//        this.button.setFont(new Font("Sans Serif", Font.BOLD, 16));
//        this.button.setBackground(new Color(188, 149, 92));
//        this.button.setForeground(new Color(242, 242, 242));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this.button;
        }
    }

    /**
     * Crea un ActionListener para el botón "Ver" en la tabla.
     *
     * @return El ActionListener creado para el botón "Ver".
     */
    private ActionListener botonVerReporte() {
        ActionListener validarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDTO clienteSelec = clientes.get(jTPersonas.getSelectedRow());
                HistorialTramites historialTramites = null;
                try {
                    historialTramites = new HistorialTramites(clienteSelec);
                } catch (FindException ex) {
                    Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
                historialTramites.setVisible(true);
            }
        };
        return validarListener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
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
