package Interface.Telas;

import Interface.PainelPrincipal;
import Servico.Servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        painelDetalhes = new JPanel(new GridLayout(6,1));

        JLabel nomeLabel = new JLabel("Nome: "+servicoDetalhes.getNome());
        JLabel situacaoLabel = new JLabel("Situação: "+servicoDetalhes.getSituacao());
        JLabel valorLabel = new JLabel("Valor do Detalhes: "+servicoDetalhes.getValor());
        JLabel recebidoLabel = new JLabel("Valor Recebido: "+servicoDetalhes.getRecebido());
        JLabel descricaoLabel = new JLabel("Descrição: "+servicoDetalhes.getDescricao());

        painelDetalhes.add(nomeLabel);
        painelDetalhes.add(descricaoLabel);
        painelDetalhes.add(situacaoLabel);
        painelDetalhes.add(valorLabel);
        painelDetalhes.add(recebidoLabel);

        adicionarBotoes();

        this.add(painelDetalhes);
        this.setVisible(true);

    }
        private void adicionarBotoes(){
        JPanel painelBotoes = new JPanel();
            JButton botaoModificar = new JButton("Modificar");
            painelBotoes.add(botaoModificar);
            botaoModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaModificar telaModificar = new TelaModificar(painelPrincipal);
                    telaModificar.setVisible(true);
                    TelaDetalhes.this.dispose();

                }
            });


            JButton botaoExcluir = new JButton("Excluir");
            botaoExcluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int resposta = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        painelPrincipal.getDados().removerServico(servicoDetalhes);
                        painelPrincipal.atualizarLista();
                        TelaDetalhes.this.dispose();
                    }

                }
            });
            painelBotoes.add(botaoExcluir);

            painelDetalhes.add(painelBotoes);


        }

}
