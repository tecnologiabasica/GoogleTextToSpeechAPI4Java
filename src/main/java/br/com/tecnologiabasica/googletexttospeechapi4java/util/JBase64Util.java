/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

/**
 *
 * @author afonso
 */
public class JBase64Util {

    public static InputStream convertBase64ToInputStream(String base64) {
        return new ByteArrayInputStream(Base64.getDecoder().decode(base64.getBytes()));
    }

}
