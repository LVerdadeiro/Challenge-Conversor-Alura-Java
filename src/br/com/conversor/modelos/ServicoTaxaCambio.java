package src.br.com.conversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;
import src.br.com.conversor.exceptions.ApiException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoTaxaCambio {
    private final String API_KEY = "c125207c06754f1a6fb90a80";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;
    private final Gson gson;

    public ServicoTaxaCambio() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
    }

    public double getTaxaDeCambio(String moedaOrigem, String moedaDestino) throws ApiException {
        String url = BASE_URL + API_KEY + "/pair/" + moedaOrigem + "/" + moedaDestino;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                RespostaAPI exchangeRateResponse = gson.fromJson(response.body(), RespostaAPI.class);

                if ("success".equals(exchangeRateResponse.getResult())) {
                    return exchangeRateResponse.getConversion_rate();
                } else {
                    throw new ApiException("Erro na resposta da API: " + response.body());
                }
            } else {
                throw new ApiException("Erro ao buscar taxa de câmbio. Status: " + response.statusCode() + ", Corpo: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Erro de comunicação com a API de taxas de câmbio.", e);
        }
    }
}