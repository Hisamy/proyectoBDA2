/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.proyectoBDA.agencia_fiscal.Navegacion;

import javax.swing.JFrame;

/**
 *
 * @author Ramosz
 */
public interface INavegacion {

    public void cambiarFrmBuscarAutomovil(JFrame ventana);

    public void cambiarFrmClienteRegistrado(JFrame ventana);

    public void cambiarFrmCostoLicencia(JFrame ventana);

    public void cambiarFrmDatosAutomovil(JFrame ventana);

    public void cambiarFrmHistorialLicencias(JFrame ventana);

    public void cambiarFrmIndex(JFrame ventana);

    public void cambiarFrmRegistrarCliente(JFrame ventana);

    public void cambiarFrmSolicitarPlacas(JFrame ventana);

    public void cambiarFrmTramites(JFrame ventana);
}
