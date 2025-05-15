/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iniciosesion.encriptado;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author darkheaven
 */
public class EncriptacionAES {
   private static final String ALGORITMO = "AES";
    
// Clave AES-256 (32 bytes) en hexadecimal
   private static final String CLAVE_HEX = "1beee3b15e925d699283b263670bb0f5988e629c8db6de5e1d8c331eeff0410e";
    
   public static String encriptar(String texto) throws Exception {
       byte[] claveBytes = hexStringToByteArray(CLAVE_HEX);
       SecretKeySpec key = new SecretKeySpec(claveBytes, ALGORITMO);
       Cipher cipher = Cipher.getInstance(ALGORITMO);
       cipher.init(Cipher.ENCRYPT_MODE, key);
       byte[] encriptado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
       return Base64.getEncoder().encodeToString(encriptado);
    }

    public static String desencriptar(String textoEncriptado) throws Exception {
        byte[] claveBytes = hexStringToByteArray(CLAVE_HEX);
        SecretKeySpec key = new SecretKeySpec(claveBytes, ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] desencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(desencriptado, StandardCharsets.UTF_8);
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}


