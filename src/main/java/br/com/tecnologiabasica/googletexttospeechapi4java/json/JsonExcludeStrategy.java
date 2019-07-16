/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
/**
 *
 * @author afonso
 */
public class JsonExcludeStrategy implements ExclusionStrategy {
    public JsonExcludeStrategy() {
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return clazz.getAnnotation(JsonExclude.class) != null;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(JsonExclude.class) != null;
    }
}