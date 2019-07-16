/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecnologiabasica.googletexttospeechapi4java.api;

import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JRequest;
import br.com.tecnologiabasica.googletexttospeechapi4java.entity.JResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author afonso
 */
public class JApiController {

    private int responseCode = -1;
    private String responseMessage = null;
    private IApiListener responseListener = null;
    private String apiUrl;

    public JApiController(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public JResponse synthesize(Map<String, String> queryParam, JRequest entity, IApiListener listener) {
        responseListener = listener;
        JResponse syncEntity = null;
        JApiInterface.ApiInterface serviceApi = JApiInterface.getGenericApiClient(apiUrl);
        Call<JResponse> call = serviceApi.synthesize(queryParam, entity);
        //Ao chamar a função passando o listener como null, será uma chamada sincrona.
        if (listener != null) {
            call.enqueue(new Callback<JResponse>() {
                @Override
                public void onResponse(Call<JResponse> call, Response<JResponse> response) {
                    JResponse entityResponse = null;
                    switch (response.code()) {
                        //OK
                        case 200:
                            entityResponse = response.body();
                            responseCode = response.code();
                            responseMessage = JApiResponseString.getApiResponse(responseCode);
                            responseListener.onOk(entityResponse);
                            break;
                        default:
                            entityResponse = response.body();
                            responseCode = response.code();
                            responseMessage = JApiResponseString.getApiResponse(responseCode);
                            responseListener.onError(responseCode, responseMessage);
                            break;

                    }
                }

                @Override
                public void onFailure(Call<JResponse> call, Throwable thrwbl) {
                    responseCode = -1;
                    responseMessage = thrwbl.getMessage();
                    responseListener.onError(responseCode, responseMessage);
                }
            });
        } else {
            Response<JResponse> response = null;
            try {
                response = call.execute();
                if (response != null) {
                    switch (response.code()) {
                        //OK
                        case 200:
                            syncEntity = response.body();
                            responseCode = response.code();
                            responseMessage = JApiResponseString.getApiResponse(responseCode);
                            break;
                        default:
                            syncEntity = response.body();
                            responseCode = response.code();
                            responseMessage = JApiResponseString.getApiResponse(responseCode);
                            syncEntity = null;
                            break;
                    }

                }
            } catch (IOException ex) {
                syncEntity = null;
                responseCode = -1;
                responseMessage = ex.getMessage();
            }
        }
        return syncEntity;
    }

}
