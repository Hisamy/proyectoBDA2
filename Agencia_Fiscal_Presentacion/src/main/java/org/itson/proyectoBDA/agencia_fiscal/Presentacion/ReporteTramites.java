/*
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java para editar esta plantilla
 */
package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaTramitesBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;

/**
 * Clase JFrame para mostrar un informe de trámites. Esta clase proporciona métodos para buscar trámites, mostrarlos en una tabla y exportar el informe a PDF.
 *
 * Autor: hisam
 */
public class ReporteTramites extends javax.swing.JFrame {

    /**
     * Interfaz para la capa de negocio que proporciona métodos para consultar clientes.
     */
    private IConsultaClientesBO consultaClientesBO;

    /**
     * Lista de trámites.
     */
    List<TramiteDTO> tramites;

    INavegacion navegacion;

    /**
     * Interfaz para la capa de negocio que proporciona métodos para consultar trámites.
     */
    IConsultaTramitesBO consultaTramites;

    /**
     * Lista de clientes.
     */
    List<ClienteDTO> clientes;

    /**
     * Trámite.
     */
    TramiteDTO tramite;

    /**
     * Lista de trámites filtrados.
     */
    List<TramiteDTO> tramitesFiltrados = new ArrayList<>();

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
        navegacion = new Navegacion();
        initComponents();
        llenarTabla(tramites);

        txtBuscador.setEnabled(false);
        txtBuscador.setEditable(false);
        jdchFechaInicio.setEnabled(false);
        jdchFechaFin.setEnabled(false);
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
     * Limpia la tabla.
     */
    private void limpiarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Tramite", "Fecha emision", "Fecha expedición", "Costo"});
        jTPersonas.setModel(modeloTabla);
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
        clientesEncontrados.addColumn("Tramite");
        clientesEncontrados.addColumn("Fecha emision");
        clientesEncontrados.addColumn("Fecha expedición");
        clientesEncontrados.addColumn("Costo");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        for (TramiteDTO tramite : tramites) {
            Object[] fila = {
                tramite.getClienteDTO().getNombre() + " " + tramite.getClienteDTO().getApellido_paterno() + " " + tramite.getClienteDTO().getApellido_materno(),
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
     * Exporta los trámites a un archivo PDF.
     *
     * @param tramites la lista de trámites a exportar.
     */
    public void exportar(List<TramiteDTO> tramites) {
        Document doc = new Document();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("reporte.pdf"));

            // Agregar evento para manejar el número de página
            writer.setPageEvent(new PageNumberEvent());

            doc.open();
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Trámites", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);

            Font fechaFont = new Font(Font.FontFamily.HELVETICA, 12);
            Paragraph fecha = new Paragraph("Fecha de solicitud: " + dateFormat.format(new Date()), fechaFont);
            fecha.setAlignment(Element.ALIGN_RIGHT);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Nombre");
            tabla.addCell("Tramite");
            tabla.addCell("Fecha emision");
            tabla.addCell("Fecha expedición");
            tabla.addCell("Costo");

            for (TramiteDTO tramite : tramites) {
                tabla.addCell(tramite.getClienteDTO().getNombre() + " " + tramite.getClienteDTO().getApellido_paterno() + " " + tramite.getClienteDTO().getApellido_materno());
                tabla.addCell(tramite.getTipo());
                tabla.addCell(dateFormat.format(tramite.getFecha_emision().getTime()));
                tabla.addCell(dateFormat.format(tramite.getFecha_expedicion().getTime()));
                tabla.addCell(String.valueOf(tramite.getCosto()));
            }

            doc.add(titulo);
            doc.add(fecha);
            doc.add(Chunk.SPACETABBING);
            doc.add(tabla);

            System.out.println("Reporte generado");

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }

    // Clase interna para manejar el evento de número de página
    private static class PageNumberEvent extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase("Página " + writer.getPageNumber(), new Font(Font.FontFamily.HELVETICA, 12));
            ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,
                    footer,
                    document.right() - 50,
                    document.bottom() - 10, 0); // Ajusta la posición según sea necesario
        }
    }

    /**
     * Busca trámites por nombre.
     *
     * @param nombre el nombre a buscar.
     */
    private void buscarPorNombre(String nombre) {
        tramitesFiltrados = new ArrayList<>();

        for (TramiteDTO tramiteDTO : tramites) {
            // Acceder al ClienteDTO dentro de TramiteDTO
            ClienteDTO clienteDTO = tramiteDTO.getClienteDTO();
            // Obtener el nombre del cliente
            String nombreCliente = clienteDTO.getNombre();
            if (nombreCliente.equalsIgnoreCase(nombre)) {
                TramiteDTO tramiteBuscado = new TramiteDTO(
                        tramiteDTO.getFecha_expedicion(),
                        tramiteDTO.getCosto(),
                        clienteDTO,
                        tramiteDTO.getEstado(),
                        tramiteDTO.getTipo(),
                        tramiteDTO.getFecha_emision()
                );
                tramitesFiltrados.add(tramiteBuscado);
            }
        }
    }

    /**
     * Busca trámites por período.
     */
    private void buscarPorPeriodo(Date fechaInicio, Date fechaFin) {
        tramitesFiltrados = new ArrayList<>();
        for (TramiteDTO tramiteDTO : tramites) {
            // Obtener la fecha de emisión del tramiteDTO
            Date fechaEmision = tramiteDTO.getFecha_emision().getTime();

            // Verificar si la fecha de emisión está dentro del rango especificado
            if (fechaEmision.after(fechaInicio) && fechaEmision.before(fechaFin)) {
                // Si está dentro del rango, agregar el tramiteDTO a la lista de tramitesFiltrados
                tramitesFiltrados.add(tramiteDTO);
            }
        }
    }

    /**
     * Busca trámites por tipo.
     */
    private void buscarPorTipo(String tipo) {
        tramitesFiltrados = new ArrayList<>();

        for (TramiteDTO tramiteDTO : tramites) {
            // Obtener el tipo de trámite del tramiteDTO
            String tipoTramite = tramiteDTO.getTipo();

            // Verificar si el tipo de trámite coincide con el tipo especificado
            if (tipoTramite.equalsIgnoreCase(tipo)) {
                // Si coincide, agregar el tramiteDTO a la lista de tramitesFiltrados
                tramitesFiltrados.add(tramiteDTO);
            }
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
        lblTitulo = new javax.swing.JLabel();
        flechaIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPersonas = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        cmbOpcionesFiltrado = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jdchFechaFin = new com.toedter.calendar.JDateChooser();
        btnExportar = new javax.swing.JButton();
        jdchFechaInicio = new com.toedter.calendar.JDateChooser();
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
        flechaIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flechaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flechaIconMouseClicked(evt);
            }
        });

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

        cmbOpcionesFiltrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Periodo", "Tipo de trámite" }));
        cmbOpcionesFiltrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpcionesFiltradoActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbOpcionesFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jdchFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jdchFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(cmbOpcionesFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdchFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdchFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String opcionSeleccionada = cmbOpcionesFiltrado.getSelectedItem().toString().trim();

        if (opcionSeleccionada.equals("Nombre")) {
            try {
                String nombre = txtBuscador.getText().trim();
                if (!nombre.isEmpty()) {
                    buscarPorNombre(nombre);
                    if (tramitesFiltrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontraron resultados para el nombre proporcionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        limpiarTabla();
                        llenarTabla(tramitesFiltrados);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre en el campo de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FindException ex) {
                Logger.getLogger(ReporteTramites.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar por nombre. Por favor, verifique el nombre del buscador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (opcionSeleccionada.equals("Periodo")) {
            Date fechaInicio = jdchFechaInicio.getDate();
            Date fechaFin = jdchFechaFin.getDate();

            if (fechaInicio != null && fechaFin != null) {
                try {
                    buscarPorPeriodo(fechaInicio, fechaFin);
                    if (tramitesFiltrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontraron resultados para el período seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        limpiarTabla();
                        llenarTabla(tramitesFiltrados);
                    }
                } catch (FindException ex) {
                    Logger.getLogger(ReporteTramites.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar por período.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione ambas fechas de inicio y fin del período.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (opcionSeleccionada.equals("Tipo de trámite")) {
            String tipoTramite = txtBuscador.getText().trim();
            if (!tipoTramite.isEmpty()) {
                try {
                    buscarPorTipo(tipoTramite);
                    if (tramitesFiltrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontraron resultados para el tipo de trámite proporcionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        limpiarTabla();
                        llenarTabla(tramitesFiltrados);
                    }
                } catch (FindException ex) {
                    Logger.getLogger(ReporteTramites.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar por tipo de trámite.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un tipo de trámite en el campo de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (opcionSeleccionada.equals("Todos")) {
            try {
                limpiarTabla();
                llenarTabla(tramites);
            } catch (FindException ex) {
                Logger.getLogger(ReporteTramites.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar todos los trámites.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbOpcionesFiltradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOpcionesFiltradoActionPerformed
        String opcionSeleccionada = cmbOpcionesFiltrado.getSelectedItem().toString();
        if (opcionSeleccionada.equals("Nombre")) {
            txtBuscador.setEnabled(true);
            txtBuscador.setEditable(true);
            jdchFechaInicio.setEnabled(false);
            jdchFechaFin.setEnabled(false);
            txtBuscador.setText("");
            jdchFechaInicio.setDate(null);
            jdchFechaFin.setDate(null);
        } else if (opcionSeleccionada.equals("Periodo")) {
            txtBuscador.setEnabled(false);
            txtBuscador.setEditable(false);
            jdchFechaInicio.setEnabled(true);
            jdchFechaFin.setEnabled(true);
            txtBuscador.setText("");
        } else if (opcionSeleccionada.equals("Tipo de trámite")) {
            txtBuscador.setEnabled(true);
            txtBuscador.setEditable(true);
            jdchFechaInicio.setEnabled(false);
            jdchFechaFin.setEnabled(false);
            txtBuscador.setText("");
            jdchFechaInicio.setDate(null);
            jdchFechaFin.setDate(null);
        } else if (opcionSeleccionada.equals("Todos")) {
            txtBuscador.setEnabled(false);
            txtBuscador.setEditable(false);
            jdchFechaInicio.setEnabled(false);
            jdchFechaFin.setEnabled(false);
            txtBuscador.setText("");
            jdchFechaInicio.setDate(null);
            jdchFechaFin.setDate(null);
        }
    }//GEN-LAST:event_cmbOpcionesFiltradoActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        exportar(tramites);
    }//GEN-LAST:event_btnExportarActionPerformed

    private void lblCostoLicenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostoLicenciaMouseClicked
        ConsultaClientes historialLicencias = new ConsultaClientes();
        historialLicencias.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblCostoLicenciaMouseClicked

    private void flechaIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flechaIconMouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_flechaIconMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        navegacion.cambiarFrmIndex(this);
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JComboBox<String> cmbOpcionesFiltrado;
    private javax.swing.JLabel flechaIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPersonas;
    private com.toedter.calendar.JDateChooser jdchFechaFin;
    private com.toedter.calendar.JDateChooser jdchFechaInicio;
    private javax.swing.JLabel lblCostoLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
