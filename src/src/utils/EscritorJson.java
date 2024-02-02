package utils;

import Servico.DadosServicos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class EscritorJson {
    private String caminhoArquivo = "Jsons/TesteJson.Json";
    private DadosServicos dados;

    public void EscreverArquivo(DadosServicos dados) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dados);

        try (FileWriter escritor = new FileWriter(caminhoArquivo)){
            escritor.write(json);
        }

    }
}
