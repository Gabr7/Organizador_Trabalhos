package Interface.Telas;

import Interface.PainelPrincipal;
import Servico.Servico;

import javax.swing.*;
import java.awt.*;


public class TelaDetalhes extends JFrame {
    private Servico servicoDetalhes;
    private JPanel painelDetalhes;
    private PainelPrincipal painelPrincipal;
    private Campos campos;
    public TelaDetalhes(PainelPrincipal painelPrincipal){
        super(painelPrincipal.getServicoSelecionado().getNome());
        this.setSize(new Dimension(300,300));
        this.painelPrincipal = painelPrincipal;
        this.servicoDetalhes = painelPrincipal.getServicoSelecionado();
        mostrarDetalhes();
    }

    private void mostrarDetalhes(){
       painelDetalhes = new JPanel(new GridLayout(7,1));
       Campos campos = new Campos(TelaDetalhes.this);
       campos.camposTelaDetalhes(TelaDetalhes.this);

    }


    public JPanel getPainelDetalhes() {
        return painelDetalhes;
    }

    public Servico getServicoDetalhes() {
        return servicoDetalhes;
    }

    public PainelPrincipal getPainelPrincipal() {
        return painelPrincipal;
    }
}
