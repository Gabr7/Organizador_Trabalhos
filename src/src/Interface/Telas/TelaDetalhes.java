package Interface.Telas;

import Servico.Servico;

import javax.swing.*;
import java.awt.*;

public class TelaDetalhes extends JFrame {
    private Servico servico;
    public TelaDetalhes(Servico servico){
        super(servico.getNome());
        this.setSize(new Dimension(300,300));
        this.servico = servico;
        mostrarDetalhes();
    }

    public void mostrarDetalhes(){
        JPanel painelDetalhes = new JPanel(new GridLayout(5,1));

        JLabel nomeLabel = new JLabel("Nome: "+servico.getNome());
        JLabel situacaoLabel = new JLabel("Situação: "+servico.getSituacao());
        JLabel valorLabel = new JLabel("Valor do servico: "+servico.getValor());
        JLabel recebidoLabel = new JLabel("Valor Recebido: "+servico.getRecebido());

        painelDetalhes.add(nomeLabel);
        painelDetalhes.add(situacaoLabel);
        painelDetalhes.add(valorLabel);
        painelDetalhes.add(recebidoLabel);


        JButton modificar = new JButton("Modificar");
        painelDetalhes.add(modificar);


        this.add(painelDetalhes);
        this.setVisible(true);

    }


}
