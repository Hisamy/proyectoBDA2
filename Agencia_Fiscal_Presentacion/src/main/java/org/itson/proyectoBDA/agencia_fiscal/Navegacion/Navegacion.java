/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Navegacion;

import javax.swing.JFrame;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.BuscarCliente;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.DatosVehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.HistorialLicencias;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.Index;

/**
 *
 * @author Ramosz
 */
public class Navegacion implements INavegacion {

    @Override
    public void cambiarFrmBuscarAutomovil(JFrame ventana) {
        ventana.dispose();
//        BuscarAutomovil opcionesCliente = new BuscarAutomovil();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmClienteRegistrado(JFrame ventana) {
        ventana.dispose();
        BuscarCliente opcionesCliente = new BuscarCliente();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmCostoLicencia(JFrame ventana) {
        ventana.dispose();
//        CostoLicencia opcionesCliente = new CostoLicencia();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmDatosAutomovil(JFrame ventana) {
        ventana.dispose();
//        DatosVehiculo opcionesCliente = new DatosVehiculo();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmHistorialLicencias(JFrame ventana) {
        ventana.dispose();
        HistorialLicencias opcionesCliente = new HistorialLicencias();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmIndex(JFrame ventana) {
        ventana.dispose();
        Index opcionesCliente = new Index();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmRegistrarCliente(JFrame ventana) {
        ventana.dispose();
//        RegistrarCliente opcionesCliente = new RegistrarCliente();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmSolicitarPlacas(JFrame ventana) {
        ventana.dispose();
//        SolicitarPlacas opcionesCliente = new SolicitarPlacas();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmTramites(JFrame ventana) {
        ventana.dispose();
//        Tramites opcionesCliente = new Tramites();
//        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmExitoLicencia(JFrame ventana) {
//        ventana.dispose();
//        ExitoLicencia exitoLicencia = new ExitoLicencia();
//        exitoLicencia.setVisible(true);
    }
}
