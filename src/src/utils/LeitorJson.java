package utils;
import Servico.DadosServicos;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
public class LeitorJson {
    String arquivoJson;
    public LeitorJson(String arquivoJson){
        this.arquivoJson = arquivoJson;
    }
 public DadosServicos LerArquivo() throws IOException {
        Gson gson = new Gson();
        DadosServicos dados = new DadosServicos();
        try (FileReader leitor = new FileReader(arquivoJson)){
        dados.setServicos(gson.fromJson(leitor, DadosServicos.class).getServicos());
        }
        return dados;
 }
}
