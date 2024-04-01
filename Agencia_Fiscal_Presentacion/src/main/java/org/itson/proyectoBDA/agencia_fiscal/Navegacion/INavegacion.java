package org.itson.proyectoBDA.agencia_fiscal.Navegacion;

import javax.swing.JFrame;

/**
 * Interfaz que define métodos para cambiar entre diferentes ventanas en una aplicación de GUI. Implementada por clases que proporcionan la navegación entre ventanas.
 *
 * @author Ramosz
 */
public interface INavegacion {

    /**
     * Cambia la ventana actual a la ventana de búsqueda de automóviles.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmBuscarAutomovil(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de cliente registrado.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmClienteRegistrado(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de costo de licencia.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmCostoLicencia(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de datos del automóvil.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmDatosAutomovil(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de historial de licencias.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmHistorialLicencias(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de índice.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmIndex(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de registro de cliente.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmRegistrarCliente(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de solicitud de placas.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmSolicitarPlacas(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de trámites.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmTramites(JFrame ventana);

    /**
     * Cambia la ventana actual a la ventana de éxito de licencia.
     *
     * @param ventana La ventana actual.
     */
    public void cambiarFrmExitoLicencia(JFrame ventana);
}
