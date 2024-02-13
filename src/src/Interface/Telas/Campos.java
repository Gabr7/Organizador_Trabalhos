package Interface.Telas;

import Interface.PainelPrincipal;
import Servico.Servico;
import Servico.DadosServicos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Campos {
    private JTextField campoNome;
    private JTextArea campoDescricao;
    private JComboBox<String> campoSituacao;
    private JTextField campoValor;
    private JTextField campoRecebido;
    private JFrame tela;
    private JButton salvar;

    public Campos(JFrame tela) {
        this.tela = tela;
        campoNome = new JTextField();
        campoRecebido = new JTextField();
        campoValor = new JTextField();
        campoDescricao = new JTextArea();
        campoDescricao.setColumns(20);
        campoDescricao.setRows(3);
        campoDescricao.setLineWrap(true);

        String[] situacoes = {"Orcamento feito", "Servico Confirmado", "Servico Concluido"};
        campoSituacao = new JComboBox<>(situacoes);
    }

    public void camposTelaNovo() {
        adicionarCampos();
    }

    public void camposTelaModificar(Servico servicoModificar) {
        campoNome = new JTextField(servicoModificar.getNome());
        campoRecebido = new JTextField(String.valueOf(servicoModificar.getRecebido()));
        campoValor = new JTextField(String.valueOf(servicoModificar.getValor()));
        campoDescricao = new JTextArea(servicoModificar.getDescricao());

        String[] situacoes = {"Orcamento feito", "Servico Confirmado", "Servico Concluido"};
        campoSituacao = new JComboBox<>(situacoes);
        campoSituacao.setSelectedItem(servicoModificar.getSituacao());

        adicionarCampos();


    }

    private void adicionarCampos() {
        this.tela.add(new JLabel("Nome: "));
        this.tela.add(campoNome);

        this.tela.add(new JLabel("Descrição: "));
        this.tela.add(campoDescricao);

        this.tela.add(new JLabel("Situação: "));
        this.tela.add(campoSituacao);

        this.tela.add(new JLabel("Valor: "));
        this.tela.add(campoValor);

        this.tela.add(new JLabel("Recebido: "));
        this.tela.add(campoRecebido);
    }

    ;

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextArea getCampoDescricao() {
        return campoDescricao;
    }

    public JComboBox<String> getCampoSituacao() {
        return campoSituacao;
    }

    public JTextField getCampoValor() {
        return campoValor;
    }

    public JTextField getCampoRecebido() {
        return campoRecebido;
    }

    public JFrame getTela() {
        return tela;
    }

    public JButton criarBotaoSalvar(PainelPrincipal painelPrincipal) {
        DadosServicos dadosServicos = painelPrincipal.getDados();
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servico novoServico = new Servico(campoNome.getText());
                novoServico.setSituacao((String) campoSituacao.getSelectedItem());
                try {
                    novoServico.setValor(Float.parseFloat(campoValor.getText()));
                    novoServico.setRecebido(Float.parseFloat(campoRecebido.getText()));
                    dadosServicos.adicionarServico(novoServico);
                    painelPrincipal.atualizarLista();
                    tela.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o valor e o valor recebido.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        return salvar;
    }
}

