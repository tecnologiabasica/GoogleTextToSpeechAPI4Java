/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JVoice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonso
 */
public class JVoiceJson {

    public static String getOutputEntityToJson(JVoice entity) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(entity);
        return output;
    }
    
    public static JVoice getOutputJsonToEntity(String json) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        JVoice output = gson.fromJson(json, JVoice.class);
        return output;
    }

    public static String getOutputListToJson(ArrayList<JVoice> list) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(list);
        return output;
    }
    
    public static ArrayList<JVoice> getOutputJsonToList(String json) {
        ArrayList<JVoice> output = new ArrayList<>((ArrayList<JVoice>) new Gson().fromJson(json,new TypeToken<List<JVoice>>(){}.getType()));
        return output;
    }

}
