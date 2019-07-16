/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.entity;

import java.io.Serializable;

/**
 *
 * @author afonso
 */
public class JInput implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
