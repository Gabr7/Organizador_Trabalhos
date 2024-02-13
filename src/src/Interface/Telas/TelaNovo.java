package Interface.Telas;

import Interface.PainelPrincipal;
import Servico.Servico;
import Servico.DadosServicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaNovo extends JFrame {
    private  JTextField campoNome;
    private JTextArea campoDescricao;
    private  JComboBox<String> campoSituacao;
    private  JTextField campoValor;
    private  JTextField campoRecebido;
    private Campos campos;

    DadosServicos dadosServicos;
    Servico novoServico;
    PainelPrincipal painelPrincipal;

    public TelaNovo(PainelPrincipal painelPrincipal){
        super("Novo servico");
        this.setSize(300,300);
        this.setLayout(new GridLayout(6,1));
        this.dadosServicos = painelPrincipal.getDados();
        this.painelPrincipal = painelPrincipal;
        this.campos =new Campos(TelaNovo.this);
        campos.camposTelaNovo();
        JButton salvar = campos.criarBotaoSalvar(painelPrincipal);
        this.add(salvar);

    }




}
