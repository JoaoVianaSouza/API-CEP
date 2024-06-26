package io.github.JoaoVianaSouza.service;

import com.google.gson.Gson;
import io.github.JoaoVianaSouza.models.Endereco;
import io.github.JoaoVianaSouza.repository.EnderecoRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumoApi {

    // Transformar endereço application.properties (vir direto de lá) ou do banco
    private static final String ENDERECOBASE = "https://brasilapi.com.br/api/cep/v1/";

    private OkHttpClient client;
    private Gson gson;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ConsumoApi() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public Endereco obterRequisicao(String cep) {
        String url = ENDERECOBASE + cep;
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Mudança para controller - exeção
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro: " + response.message());
            }

            String json = response.body().string();
            Endereco endereco = gson.fromJson(json, Endereco.class);
            return enderecoRepository.save(endereco);

        } catch (Exception e) {
            throw new InvalidCepException("Cep inválido: "  + cep, e);
        }
    }
}
