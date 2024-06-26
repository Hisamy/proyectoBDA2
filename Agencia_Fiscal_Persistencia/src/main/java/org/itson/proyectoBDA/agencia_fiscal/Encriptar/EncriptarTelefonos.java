package org.itson.proyectoBDA.agencia_fiscal.Encriptar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ramosz
 */
public class EncriptarTelefonos {

    /**
     * Genera el hash MD5 de una cadena de texto.
     *
     * @param telefono
     * @return El hash MD5 del texto proporcionado.
     */
    public static String encriptarMD5(String telefono) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(telefono.getBytes());

            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;
        }
    }
}
