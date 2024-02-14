package Servico;

import java.util.ArrayList;
import java.util.List;

public class DadosServicos {
    private List<Servico> servicos;

    public void adicionarServico(Servico servico){
        if(this.servicos == null){
            this.servicos = new ArrayList<>();
        }
        this.servicos.add(servico);
    }
    public void removerServico(Servico remover){

        for(Servico servicoRemover : this.servicos) {
            if(servicoRemover == remover){
                servicos.remove(servicoRemover);
                System.out.println(remover.getNome()+" Removido");
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
