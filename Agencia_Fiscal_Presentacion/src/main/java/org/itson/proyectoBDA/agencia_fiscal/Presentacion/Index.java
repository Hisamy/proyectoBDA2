package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Encriptar.EncriptarTelefonos;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.INavegacion;
import org.itson.proyectoBDA.agencia_fiscal.Navegacion.Navegacion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.NuevoClienteDTO;

/**
 * Clase JFrame para la pantalla de inicio de la aplicación. Esta clase proporciona opciones para realizar diferentes operaciones en la agencia fiscal.
 *
 * @author ramosz
 */
public class Index extends javax.swing.JFrame {

    INavegacion navegacion;
    IRegistroClientesBO registroCliente;

    /**
     * Crea una nueva instancia de Index.
     */
    public Index() {
        navegacion = new Navegacion();
        registroCliente = new RegistroClientesBO();
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
        btnHistorialLicenciaPlacas = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnReporteTramites = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Index");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgenciaFiscal.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblAgenciaFiscal.setForeground(new java.awt.Color(65, 34, 52));
        lblAgenciaFiscal.setText("Agencia Fiscal");
        jPanel2.add(lblAgenciaFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        btnHistorialLicenciaPlacas.setBackground(new java.awt.Color(65, 34, 52));
        btnHistorialLicenciaPlacas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHistorialLicenciaPlacas.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorialLicenciaPlacas.setText("Historial licencias y placas");
        btnHistorialLicenciaPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialLicenciaPlacasActionPerformed(evt);
            }
        });
        jPanel2.add(btnHistorialLicenciaPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 180, 32));

        btnBuscarCliente.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 370, 32));

        lblTexto.setText("Agencia Fiscal es una plataforma gubernamental segura y confiable para llevar");
        jPanel2.add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 460, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        btnReporteTramites.setBackground(new java.awt.Color(65, 34, 52));
        btnReporteTramites.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReporteTramites.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteTramites.setText("Reporte de trámites");
        btnReporteTramites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTramitesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReporteTramites, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 32));

        jLabel3.setText("a cabo procedimientos relacionados con el registro de vehículos y la gestión de ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 460, -1));

        jLabel4.setText("trámites vehiculares.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 150, -1));

        btnBuscar.setBackground(new java.awt.Color(65, 34, 52));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Inserción masiva");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 370, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se activa cuando se hace clic en el botón "Buscar cliente". Abre la ventana de búsqueda de cliente y cierra la ventana actual.
     *
     * @param evt Evento de acción que desencadena el método.
     */
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscarCliente buscarCliente = new BuscarCliente();
        buscarCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    /**
     * Método que se activa cuando se hace clic en el botón "Historial licencias y placas". Abre la ventana de consulta de clientes para ver el historial de licencias y placas, luego cierra la ventana actual.
     *
     * @param evt Evento de acción que desencadena el método.
     */
    private void btnHistorialLicenciaPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialLicenciaPlacasActionPerformed
        ConsultaClientes historialLicencias = new ConsultaClientes();
        historialLicencias.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHistorialLicenciaPlacasActionPerformed

    private void btnReporteTramitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTramitesActionPerformed
        ReporteTramites reporteTramites = null;
        try {
            reporteTramites = new ReporteTramites();
        } catch (FindException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        reporteTramites.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnReporteTramitesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        List<NuevoClienteDTO> clientes = new ArrayList<>();

        clientes.add(new NuevoClienteDTO("TARE040818HSRLMDA1", "Juan", "Pérez", "Gómez", true, "Juan040818HSRLMDA1", EncriptarTelefonos.encriptarMD5("6442261760"), new GregorianCalendar(1990, 0, 1)));
        clientes.add(new NuevoClienteDTO("CICH191004HSRLMDA", "María", "Martínez", "Fernández", false, "María191004HSRLMDA", EncriptarTelefonos.encriptarMD5("6871699800"), new GregorianCalendar(1992, 3, 15)));
        clientes.add(new NuevoClienteDTO("CAMG040802", "Pedro", "González", "López", true, "Pedro040802HSRLMDA", EncriptarTelefonos.encriptarMD5("6441699800"), new GregorianCalendar(1985, 5, 25)));
        clientes.add(new NuevoClienteDTO("VEBV040902", "Laura", "Sánchez", "Rodríguez", false, "Laura040902HSRLMDA", EncriptarTelefonos.encriptarMD5("6871741035"), new GregorianCalendar(1987, 8, 10)));
        clientes.add(new NuevoClienteDTO("CICA120412", "Luis", "Díaz", "Fernández", true, "Luis120412HSRLMDA", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1993, 10, 20)));
        clientes.add(new NuevoClienteDTO("CACA120D111", "Ana", "García", "Martínez", false, "Ana120111HSRLMDA", EncriptarTelefonos.encriptarMD5("687211945"), new GregorianCalendar(1988, 2, 8)));
        clientes.add(new NuevoClienteDTO("MAPA12A0412", "Sofía", "Gómez", "Sánchez", true, "Sofía120412HSRLMDA", EncriptarTelefonos.encriptarMD5("6442261555"), new GregorianCalendar(1983, 11, 5)));
        clientes.add(new NuevoClienteDTO("TARE0E40818HSRLMDA1", "Miguel", "López", "González", false, "Miguel040818HSRLMDA1", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1984, 6, 14)));
        clientes.add(new NuevoClienteDTO("CIDCH191004HSRLMDA", "Elena", "Fernández", "Díaz", true, "Elena191004HSRLMDA", EncriptarTelefonos.encriptarMD5("687211945"), new GregorianCalendar(1989, 9, 28)));
        clientes.add(new NuevoClienteDTO("CAMAG040802", "Carlos", "Rodríguez", "Sánchez", false, "Carlos040802HSRLMDA", EncriptarTelefonos.encriptarMD5("6442261555"), new GregorianCalendar(1995, 7, 3)));
        clientes.add(new NuevoClienteDTO("VEABV040902", "Sara", "López", "García", true, "Sara040902HSRLMDA", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1986, 4, 18)));
        clientes.add(new NuevoClienteDTO("CICA1A20412", "Diego", "Martínez", "Gómez", false, "Diego120412HSRLMDA", EncriptarTelefonos.encriptarMD5("687211945"), new GregorianCalendar(1991, 1, 22)));
        clientes.add(new NuevoClienteDTO("CACA12A0111", "Carmen", "Sánchez", "López", true, "Carmen120111HSRLMDA", EncriptarTelefonos.encriptarMD5("6442261555"), new GregorianCalendar(1980, 3, 11)));
        clientes.add(new NuevoClienteDTO("MAPDA120412", "Javier", "Fernández", "Martínez", false, "Javier120412HSRLMDA", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1982, 8, 6)));
        clientes.add(new NuevoClienteDTO("TARE11111111RLMDA1", "Ana", "Gómez", "Rodríguez", true, "Ana040818HSRLMDA1", EncriptarTelefonos.encriptarMD5("687211945"), new GregorianCalendar(1997, 5, 29)));
        clientes.add(new NuevoClienteDTO("DASDASD12312FFDS21", "David", "López", "Fernández", false, "David191004HSRLMDA", EncriptarTelefonos.encriptarMD5("6442261555"), new GregorianCalendar(1981, 11, 15)));
        clientes.add(new NuevoClienteDTO("CASMG04083202", "Natalia", "Martínez", "González", true, "Natalia040802HSRLMDA", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1994, 7, 20)));
        clientes.add(new NuevoClienteDTO("VEBDASV040902", "Pablo", "García", "López", false, "Pablo040902HSRLMDA", EncriptarTelefonos.encriptarMD5("687211945"), new GregorianCalendar(1990, 2, 25)));
        clientes.add(new NuevoClienteDTO("CDSAICA120412", "Silvia", "Sánchez", "Martínez", true, "Silvia120412HSRLMDA", EncriptarTelefonos.encriptarMD5("6442261555"), new GregorianCalendar(1987, 9, 8)));
        clientes.add(new NuevoClienteDTO("CADCA12012311", "Jorge", "Martínez", "Sánchez", false, "Jorge120111HSRLMDA", EncriptarTelefonos.encriptarMD5("687211913"), new GregorianCalendar(1984, 4, 2)));

        // Insertar los clientes en la base de datos
        for (NuevoClienteDTO cliente : clientes) {
            registroCliente.transporteDatos(cliente);
        }

        // Desactivar el botón después de la inserción
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnHistorialLicenciaPlacas;
    private javax.swing.JButton btnReporteTramites;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFiscal;
    private javax.swing.JLabel lblTexto;
    // End of variables declaration//GEN-END:variables
}
