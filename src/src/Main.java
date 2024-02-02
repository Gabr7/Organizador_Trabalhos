import Servico.DadosServicos;
import utils.LeitorJson;
import java.io.IOException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  {

        try {
        LeitorJson leitor = new LeitorJson("Jsons/TesteJson.Json");
        DadosServicos dados = leitor.LerArquivo();
        dados.printDados(02);
        }
        catch (IOException e){
            System.out.println("Erro");
        }
    }
}