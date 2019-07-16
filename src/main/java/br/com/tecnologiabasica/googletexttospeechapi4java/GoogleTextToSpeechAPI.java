/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java;

import br.com.tecnologiabasica.googletexttospeechapi4java.api.JApiController;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JAudioConfig;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JInput;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JRequest;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JResponse;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JVoice;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author afonso
 */
public class GoogleTextToSpeechAPI {

    private int statusCode = -1;
    private String message = null;

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String synthesize(String audioEncoding, double pitch, double speakingRate, String text, String languageCode, String name) {
        String returnValue = null;
        JResponse response = null;
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("key", JCommons.getInstance().getApiKey());

        JRequest request = new JRequest();

        JAudioConfig audioConfig = new JAudioConfig();
        audioConfig.setAudioEncoding(audioEncoding);
        audioConfig.setPitch(pitch);
        audioConfig.setSpeakingRate(speakingRate);

        JInput input = new JInput();
        input.setText(text);

        JVoice voice = new JVoice();
        voice.setLanguageCode(languageCode);
        voice.setName(name);
        
        request.setAudioConfig(audioConfig);
        request.setInput(input);
        request.setVoice(voice);

        JApiController apiController = new JApiController(JCommons.getInstance().getApiUrl());
        response = apiController.synthesize(queryParam, request, null);
        statusCode = apiController.getResponseCode();
        message = apiController.getResponseMessage();
        if (response != null) {
            returnValue = response.getAudioContent();            
        }
        return returnValue;
    }
}
