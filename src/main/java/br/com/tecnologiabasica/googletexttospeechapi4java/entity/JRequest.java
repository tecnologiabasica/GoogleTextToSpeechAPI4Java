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
public class JRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private JAudioConfig audioConfig = null;
    private JInput input = null;
    private JVoice voice = null;

    public JAudioConfig getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(JAudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public JInput getInput() {
        return input;
    }

    public void setInput(JInput input) {
        this.input = input;
    }

    public JVoice getVoice() {
        return voice;
    }

    public void setVoice(JVoice voice) {
        this.voice = voice;
    }

}
