/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author afonso
 */
public class JFileUtil {

    public static void saveFile(InputStream inputStream,
            String filePath) throws FileNotFoundException, IOException {
        OutputStream outpuStream = new FileOutputStream(new File(filePath));
        int read = 0;
        byte[] bytes = new byte[1024]; 
        outpuStream = new FileOutputStream(new File(filePath));
        while ((read = inputStream.read(bytes)) != -1) {
            outpuStream.write(bytes, 0, read);
        }
        outpuStream.flush();
        outpuStream.close();
    }

}
