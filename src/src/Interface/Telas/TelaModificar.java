package Interface.Telas;

import Interface.PainelPrincipal;
import Servico.Servico;

import javax.swing.*;
import Servico.DadosServicos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaModificar extends JFrame {
    private  JTextField campoNome;
    private  JComboBox<String> campoSituacao;
    private  JTextField campoValor;
    private  JTextField campoRecebido;
    DadosServicos dadosServicos;
    Servico servicoModificar;
    PainelPrincipal painelPrincipal;
    public TelaModificar(PainelPrincipal painelPrincipal){
        super("Modificar");
        this.servicoModificar = painelPrincipal.getServicoSelecionado();
        this.setSize(300,300);
        this.setLayout(new GridLayout(5,1));
        this.dadosServicos = painelPrincipal.getDados();
        this.painelPrincipal = painelPrincipal;

        campoNome = new JTextField(servicoModificar.getNome());
        campoRecebido = new JTextField(String.valueOf(servicoModificar.getRecebido()));
        campoValor = new JTextField(String.valueOf(servicoModificar.getValor()));

        String[] situacoes = {"Orcamento feito", "Servico Confirmado", "Servico Concluido"};
        campoSituacao = new JComboBox<>(situacoes);
        campoSituacao.setSelectedItem(servicoModificar.getSituacao());

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
                dadosServicos.removerServico(servicoModificar);
                servicoModificar = new Servico(campoNome.getText());
                servicoModificar.setSituacao((String)campoSituacao.getSelectedItem());
                try {
                    servicoModificar.setValor(Float.parseFloat(campoValor.getText()));
                    servicoModificar.setRecebido(Float.parseFloat(campoRecebido.getText()));

                    dadosServicos.adicionarServico(servicoModificar);
                    painelPrincipal.atualizarLista();
                    TelaModificar.this.dispose();
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o valor e o valor recebido.");
                }
                painelPrincipal.atualizarLista();
                TelaModificar.this.dispose();

            }
        });
        return salvar;
    }


}

