/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.api;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JResponse;


/**
 *
 * @author afonso
 */
public interface IApiListener {

    public void onOk(JResponse entity);

    public void onError(int statusCode, String message);

}
