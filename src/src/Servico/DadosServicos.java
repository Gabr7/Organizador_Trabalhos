package Servico;

import java.util.List;

public class DadosServicos {
    private List<Servico> servicos;

    public void  printDados(int idDesejado){
        for (Servico servico : this.servicos) {
            if (servico.getID() == idDesejado ||idDesejado == 0) {
                System.out.println("ID: " + servico.getID());
                System.out.println("Nome: " + servico.getNome());
                System.out.println("Situação: " + servico.getSituacao());
                System.out.println("Valor do Serviço: " + servico.getValor());
                System.out.println("Valor Recebido: " + servico.getRecebido());
                System.out.println();
               if(servico.getID() == idDesejado) {break;}
            }
        }
    }

    public void adicionarServico(Servico servico){
        int proxId =this.servicos.getLast().getID()+1;
        this.servicos.add(servico);
        servico.setID(proxId);
    }
    public void removerServico(int IDRemover){
      // adionar escolha se deseja realmente remover
        for(Servico servicoRemover : this.servicos) {
            if(servicoRemover.getID() == IDRemover){
                servicos.remove(servicoRemover);
                System.out.println(IDRemover+" Removido");
                break;
            }
        }
    }
    public int getUltimoID() {
        return this.servicos.getLast().getID();
    }
    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    public List<Servico> getServicos() {
        return servicos;
    }
}
