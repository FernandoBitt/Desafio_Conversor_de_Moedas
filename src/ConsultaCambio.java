import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaCambio {
    public Cambio buscaCambio(String moeda) {
        String chave = "5739bb6e054a18ffaf2481f0";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + moeda);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cambio.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel obter o valor do câmbio");
        }

    }

}
