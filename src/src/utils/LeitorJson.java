package utils;
import Servico.DadosServicos;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
public class LeitorJson {
    private String arquivoJson;
    public LeitorJson(String arquivoJson){
        this.arquivoJson = arquivoJson;
    }
    public DadosServicos LerArquivo() throws IOException {
        Gson gson = new Gson();
        DadosServicos dados = null;
        try (FileReader leitor = new FileReader(arquivoJson)){
        dados = (gson.fromJson(leitor, DadosServicos.class));
        }
        if(dados == null){
            dados = new DadosServicos();
        }
        return dados;
    }
}
