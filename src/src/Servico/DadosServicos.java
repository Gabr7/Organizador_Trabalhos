package Servico;

import java.util.List;

public class DadosServicos {
    private List<Servico> servicos;
    public void  printDados(int idDesejado){
        for (Servico servico : this.servicos) {
            if (servico.ID == idDesejado) {
                System.out.println("ID: " + servico.ID);
                System.out.println("Nome: " + servico.nome);
                System.out.println("Situação: " + servico.situacao);
                System.out.println("Valor do Serviço: " + servico.valor);
                System.out.println("Valor Recebido: " + servico.recebido);
                System.out.println();
                break;
            }
        }

    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }
}
