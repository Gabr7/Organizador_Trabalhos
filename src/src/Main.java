import Interface.Tela;
import Servico.DadosServicos;
import Servico.Servico;
import utils.EscritorJson;
import utils.LeitorJson;
import java.io.IOException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  {

        DadosServicos dados = new DadosServicos();

        try {
        LeitorJson leitor = new LeitorJson("Jsons/TesteJson.Json");
        dados = leitor.LerArquivo();
        Servico servico = new Servico("Teste "+(dados.getUltimoID()+1));
        dados.adicionarServico(servico);
        dados.printDados(dados.getUltimoID());
        }
        catch (IOException e){
            System.out.println("Erro de leitura");
        }
       // dados.removerServico(2);
        /*try {
            EscritorJson escritor = new EscritorJson();
            escritor.EscreverArquivo(dados);
        } catch (IOException e) {
            System.out.println("Erro de escrita");
        }*/
        Tela tela = new Tela(dados);
        tela.mostrarTela();


    }
}