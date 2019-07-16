/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonso
 */
public class JInputJson {

    public static String getOutputEntityToJson(JInput entity) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(entity);
        return output;
    }
    
    public static JInput getOutputJsonToEntity(String json) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        JInput output = gson.fromJson(json, JInput.class);
        return output;
    }

    public static String getOutputListToJson(ArrayList<JInput> list) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(list);
        return output;
    }
    
    public static ArrayList<JInput> getOutputJsonToList(String json) {
        ArrayList<JInput> output = new ArrayList<>((ArrayList<JInput>) new Gson().fromJson(json,new TypeToken<List<JInput>>(){}.getType()));
        return output;
    }

}
