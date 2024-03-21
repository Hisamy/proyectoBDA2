/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Navegacion;

import javax.swing.JFrame;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.BuscarAutomovil;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.ClienteRegistrado;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.CostoLicencia;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.DatosAutomovil;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.HistorialLicencias;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.Index;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.RegistrarCliente;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.SolicitarPlacas;
import org.itson.proyectoBDA.agencia_fiscal.Presentacion.Tramites;

/**
 *
 * @author Ramosz
 */
public class Navegacion implements INavegacion {

    @Override
    public void cambiarFrmBuscarAutomovil(JFrame ventana) {
        ventana.dispose();
        BuscarAutomovil opcionesCliente = new BuscarAutomovil();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmClienteRegistrado(JFrame ventana) {
        ventana.dispose();
        ClienteRegistrado opcionesCliente = new ClienteRegistrado();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmCostoLicencia(JFrame ventana) {
        ventana.dispose();
        CostoLicencia opcionesCliente = new CostoLicencia();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmDatosAutomovil(JFrame ventana) {
        ventana.dispose();
        DatosAutomovil opcionesCliente = new DatosAutomovil();
        opcionesCliente.setVisible(true);
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
        SolicitarPlacas opcionesCliente = new SolicitarPlacas();
        opcionesCliente.setVisible(true);
    }

    @Override
    public void cambiarFrmTramites(JFrame ventana) {
        ventana.dispose();
        Tramites opcionesCliente = new Tramites();
        opcionesCliente.setVisible(true);
    }
}
