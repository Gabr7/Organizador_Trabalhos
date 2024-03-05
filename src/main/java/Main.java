import Interface.TelaPrincipal;
import Servico.DadosServicos;
import utils.LeitorJson;
import java.io.IOException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  {


        DadosServicos dados = new DadosServicos();

        try {
        LeitorJson leitor = new LeitorJson("Servicos.Json");
        dados = leitor.LerArquivo();
        }
        catch (IOException e){
            System.out.println("Erro de leitura");
        }

        TelaPrincipal tela = new TelaPrincipal(dados);
        tela.mostrarTela();


    }
}