package utils;
import Servico.DadosServicos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class LeitorJson {
    private String arquivoJson;
    public LeitorJson(String arquivoJson){
        this.arquivoJson = arquivoJson;
    }
    public DadosServicos LerArquivo() throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        DadosServicos dados = null;

        try (FileReader leitor = new FileReader(arquivoJson)){
            if (leitor.ready()) {
                dados = gson.fromJson(leitor, DadosServicos.class);
            }
        }

        if (dados == null) {
            dados = new DadosServicos();
        }

        return dados;
    }

}
