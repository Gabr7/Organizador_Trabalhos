package Interface.Telas;

import Interface.Painel;
import Servico.Servico;
import Servico.DadosServicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaNovo extends JFrame {
    private  JTextField campoNome;
    private  JComboBox<String> campoSituacao;
    private  JTextField campoValor;
    private  JTextField campoRecebido;

    DadosServicos dadosServicos;
    Servico novoServico;
    Painel painelPrincipal;

    public TelaNovo(Painel painelPrincipal){
        super("Novo servico");
        this.setSize(300,300);
        this.setLayout(new GridLayout(5,1));
        this.dadosServicos = painelPrincipal.getDados();
        this.painelPrincipal = painelPrincipal;

        campoNome = new JTextField();
        campoRecebido = new JTextField();
        campoValor = new JTextField();

        String[] situacoes = {"Orcamento feito", "Servico Confirmado", "Servico Concluido"};
        campoSituacao = new JComboBox<>(situacoes);

        this.add(new JLabel("Nome: "));
        this.add(campoNome);

        this.add(new JLabel("Situação: "));
        this.add(campoSituacao);

        this.add(new JLabel("Valor: "));
        this.add(campoValor);

        this.add(new JLabel("Recebido: "));
        this.add(campoRecebido);

        JButton salvar = Salvar(dadosServicos);
        this.add(salvar);

    }

    private JButton Salvar(DadosServicos dadosServicos) {
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                novoServico = new Servico(campoNome.getText());
                novoServico.setSituacao((String)campoSituacao.getSelectedItem());
                try {
                    novoServico.setValor(Float.parseFloat(campoValor.getText()));
                    novoServico.setRecebido(Float.parseFloat(campoRecebido.getText()));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o valor e o valor recebido.");
                }
                dadosServicos.adicionarServico(novoServico);
                painelPrincipal.atualizarLista();
                TelaNovo.this.dispose();

            }
        });
        return salvar;
    }


}
