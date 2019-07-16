/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JAudioConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonso
 */
public class JAudioConfigJson {

    public static String getOutputEntityToJson(JAudioConfig entity) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(entity);
        return output;
    }
    
    public static JAudioConfig getOutputJsonToEntity(String json) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        JAudioConfig output = gson.fromJson(json, JAudioConfig.class);
        return output;
    }

    public static String getOutputListToJson(ArrayList<JAudioConfig> list) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(list);
        return output;
    }
    
    public static ArrayList<JAudioConfig> getOutputJsonToList(String json) {
        ArrayList<JAudioConfig> output = new ArrayList<>((ArrayList<JAudioConfig>) new Gson().fromJson(json,new TypeToken<List<JAudioConfig>>(){}.getType()));
        return output;
    }

}
