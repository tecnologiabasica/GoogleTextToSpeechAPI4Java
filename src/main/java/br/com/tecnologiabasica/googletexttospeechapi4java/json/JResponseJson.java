/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonso
 */
public class JResponseJson {

    public static String getOutputEntityToJson(JResponse entity) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(entity);
        return output;
    }
    
    public static JResponse getOutputJsonToEntity(String json) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        JResponse output = gson.fromJson(json, JResponse.class);
        return output;
    }

    public static String getOutputListToJson(ArrayList<JResponse> list) {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExcludeStrategy()).create();
        String output = gson.toJson(list);
        return output;
    }
    
    public static ArrayList<JResponse> getOutputJsonToList(String json) {
        ArrayList<JResponse> output = new ArrayList<>((ArrayList<JResponse>) new Gson().fromJson(json,new TypeToken<List<JResponse>>(){}.getType()));
        return output;
    }

}
