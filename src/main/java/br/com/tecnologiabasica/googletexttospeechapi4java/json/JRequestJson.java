/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonso
 */
public class JRequestJson {

    public static String getOutputEntityToJson(JRequest entity) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(entity);
        return output;
    }
    
    public static JRequest getOutputJsonToEntity(String json) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        JRequest output = gson.fromJson(json, JRequest.class);
        return output;
    }

    public static String getOutputListToJson(ArrayList<JRequest> list) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(list);
        return output;
    }
    
    public static ArrayList<JRequest> getOutputJsonToList(String json) {
        ArrayList<JRequest> output = new ArrayList<>((ArrayList<JRequest>) new Gson().fromJson(json,new TypeToken<List<JRequest>>(){}.getType()));
        return output;
    }

}
