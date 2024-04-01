/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Navegacion;

import javax.swing.JFrame;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.BuscarCliente;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.ConsultaClientes;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.Index;

/**
 * Clase que implementa la interfaz INavegacion y proporciona métodos para cambiar entre diferentes ventanas en una aplicación de GUI.
 *
 * @author Ramosz
 */
public class Navegacion implements INavegacion {

    /**
     * Cambia la ventana actual a la ventana de búsqueda de automóviles.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmBuscarAutomovil(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de búsqueda de automóviles
//        BuscarAutomovil opcionesCliente = new BuscarAutomovil();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de cliente registrado.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmClienteRegistrado(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de cliente registrado
        BuscarCliente opcionesCliente = new BuscarCliente();
        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de costo de licencia.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmCostoLicencia(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de costo de licencia
//        CostoLicencia opcionesCliente = new CostoLicencia();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de datos del automóvil.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmDatosAutomovil(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de datos del automóvil
//        DatosVehiculo opcionesCliente = new DatosVehiculo();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de historial de licencias.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmHistorialLicencias(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de historial de licencias
        ConsultaClientes opcionesCliente = new ConsultaClientes();
        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de índice.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmIndex(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de índice
        Index opcionesCliente = new Index();
        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de registro de cliente.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmRegistrarCliente(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de registro de cliente
//        RegistrarCliente opcionesCliente = new RegistrarCliente();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de solicitud de placas.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmSolicitarPlacas(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de solicitud de placas
//        SolicitarPlacas opcionesCliente = new SolicitarPlacas();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de trámites.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmTramites(JFrame ventana) {
        ventana.dispose(); // Cierra la ventana actual
        // Crea y muestra la ventana de trámites
//        Tramites opcionesCliente = new Tramites();
//        opcionesCliente.setVisible(true);
    }

    /**
     * Cambia la ventana actual a la ventana de éxito de licencia.
     *
     * @param ventana La ventana actual.
     */
    @Override
    public void cambiarFrmExitoLicencia(JFrame ventana) {
        // Crea y muestra la ventana de éxito de licencia
//        ventana.dispose();
//        ExitoLicencia exitoLicencia = new ExitoLicencia();
//        exitoLicencia.setVisible(true);
    }
}
