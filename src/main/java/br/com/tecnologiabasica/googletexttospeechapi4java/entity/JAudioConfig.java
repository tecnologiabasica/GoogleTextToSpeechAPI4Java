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
public class JAudioConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private String audioEncoding;
    private double pitch = 0;
    private double speakingRate = 1;

    public String getAudioEncoding() {
        return audioEncoding;
    }

    public void setAudioEncoding(String audioEncoding) {
        this.audioEncoding = audioEncoding;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getSpeakingRate() {
        return speakingRate;
    }

    public void setSpeakingRate(double speakingRate) {
        this.speakingRate = speakingRate;
    }

}
